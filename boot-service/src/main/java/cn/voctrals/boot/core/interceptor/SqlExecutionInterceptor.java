package cn.voctrals.boot.core.interceptor;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.*;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.ReflectorFactory;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.property.PropertyTokenizer;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;
import org.apache.ibatis.scripting.xmltags.ForEachSqlNode;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

@Intercepts(value = {
        @Signature(args = { MappedStatement.class, Object.class, RowBounds.class,
                ResultHandler.class }, method = "query", type = Executor.class),
        @Signature(type = Executor.class, method = "update", args = { MappedStatement.class, Object.class }) })
public class SqlExecutionInterceptor implements Interceptor {

    private static final ObjectFactory FACTORY = new DefaultObjectFactory();
    private static final ObjectWrapperFactory WRAPPER_FACTORY = new DefaultObjectWrapperFactory();
    private static final ReflectorFactory REFLECTOR_FACTORY = new DefaultReflectorFactory();
    
    private Properties properties;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        try {
            Object[] args = invocation.getArgs();
            
            MappedStatement mappedStatement = (MappedStatement) args[0];
            Object parameter = args[1];
            
            MyBatisSql<Object> myBatisSql = new MyBatisSql<Object>();
            
            BoundSql boundSql = mappedStatement.getBoundSql(parameter);
            List<ResultMap> resultMapList = mappedStatement.getResultMaps();
            if (resultMapList != null && resultMapList.size() > 0) {
                ResultMap resultMap = resultMapList.get(0);
                myBatisSql.setResultClass(resultMap.getType());
            }
            myBatisSql.setSql(boundSql.getSql());
            List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
            if (parameterMappings != null) {
                Object[] parameterArray = new Object[parameterMappings.size()];
                MetaObject metaParameter = parameter == null ? null : MetaObject.forObject(parameter, FACTORY, WRAPPER_FACTORY, REFLECTOR_FACTORY);
                for (int i = 0; i < parameterMappings.size(); i++) {
                    ParameterMapping parameterMapping = parameterMappings.get(i);
                    if (parameterMapping.getMode() != ParameterMode.OUT) {
                        Object value;
                        String propertyName = parameterMapping.getProperty();
                        PropertyTokenizer prop = new PropertyTokenizer(propertyName);
                        if (parameter == null) {
                            value = null;
                        } else if (mappedStatement.getConfiguration().getTypeHandlerRegistry().hasTypeHandler(parameter.getClass())) {
                            value = parameter;
                        } else if (boundSql.hasAdditionalParameter(propertyName)) {
                            value = boundSql.getAdditionalParameter(propertyName);
                        } else if (propertyName.startsWith(ForEachSqlNode.ITEM_PREFIX) && boundSql.hasAdditionalParameter(prop.getName())) {
                            value = boundSql.getAdditionalParameter(prop.getName());
                            if (value != null) {
                                MetaObject metaValue = MetaObject.forObject(value, FACTORY, WRAPPER_FACTORY, REFLECTOR_FACTORY);
                                value = metaValue.getValue(propertyName.substring(prop.getName().length()));
                            }
                        } else {
                            value = metaParameter == null ? null : metaParameter.getValue(propertyName);
                        }
                        parameterArray[i] = value;
                    }
                }
                myBatisSql.setParameters(parameterArray);
            }
            System.out.println("=======================SQL=========================");
            System.out.println("SQL ID:" + mappedStatement.getId());
            System.out.println(myBatisSql.toString());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("=======================analyze SQL error===========");
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Properties getProperties() {
        return properties;
    }
}

class MyBatisSql<T> {
    private String sql;
    private Object[] parameters;
    private Class<?> resultClass;

    public Class<?> getResultClass() {
        return resultClass;
    }

    public void setResultClass(Class<?> resultClass) {
        this.resultClass = resultClass;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public String getSql() {
        return sql;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }

    public Object[] getParameters() {
        return parameters;
    }

    @Override
    public String toString() {
        if (parameters == null || sql == null) {
            return "";
        }
        List<Object> parametersArray = Arrays.asList(parameters);
        List<Object> list = new ArrayList<Object>(parametersArray);
        while (sql.indexOf("?") != -1 && list.size() > 0 && parameters.length > 0) {
            String str = "";
            if (list.get(0) != null) {
                str = list.get(0).toString();
            }
            sql = sql.replaceFirst("\\?", "'" + str + "'");
            list.remove(0);
        }
        return "        " + sql.replaceAll("(\r?\n(\\s*\r?\n)+)", "\r\n");
    }
}