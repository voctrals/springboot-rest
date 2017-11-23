package cn.voctrals.boot.core.config;

import cn.voctrals.boot.core.interceptor.PaginationInterceptor;
import com.github.miemiedev.mybatis.paginator.dialect.MySQLDialect;
import com.github.miemiedev.mybatis.paginator.dialect.OracleDialect;
import com.github.miemiedev.mybatis.paginator.dialect.PostgreSQLDialect;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.HashMap;
import java.util.Map;

public abstract class DataSourceBaseConfig {

	public static String DB_MYSQL = "mysql";
	public static String DB_POSTGRESQL = "postgresql";
	public static String DB_ORACLE = "oracle";
	
	public abstract DataSourceParam dataSourceParam();
	
	@Bean
	public javax.sql.DataSource dataSource() {
		DataSourceParam param = dataSourceParam();
		System.out.println("dataSource:" + param);
		DataSource dataSource;
		if (param.dataSource == null) {
			dataSource = new DataSource();
			dataSource.setUrl(param.url);
			if (StringUtils.isEmpty(param.driverClass)) {
			    dataSource.setDriverClassName(dialectMap().get(param.dbName).driverClass);
			} else {
			    dataSource.setDriverClassName(param.driverClass);
			}
			dataSource.setUsername(param.username);
			dataSource.setPassword(param.password);
			dataSource.setInitialSize(5);
			dataSource.setMaxActive(50);
			dataSource.setMinIdle(5);
			dataSource.setMaxIdle(20);
			dataSource.setMaxWait(30000);

			dataSource.setTestWhileIdle(true);
			dataSource.setValidationInterval(60000);
			dataSource.setValidationQuery("SELECT 1");
			dataSource.setTestOnBorrow(true);
			dataSource.setRemoveAbandoned(true);
			dataSource.setJdbcInterceptors(
					"org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;"+
							"org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer");

		} else {
			dataSource = (DataSource)param.dataSource;
		}
		
		if (param.printSql) {
			dataSource.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
			dataSource.setUrl(StringUtils.replace(dataSource.getUrl(), ":" + param.dbName + ":", ":log4jdbc:" + param.dbName + ":"));
		}
		
		return dataSource;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}
	
	@Bean
	public SqlSessionFactoryBean sqlSessionFactory() throws Exception {
		
		DataSourceParam param = dataSourceParam();
		System.out.println("sqlSessionFactory:" + param);
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		ResourcePatternResolver resolver = ResourcePatternUtils.getResourcePatternResolver(new DefaultResourceLoader());
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setMapperLocations(resolver.getResources("classpath:sql/*.xml"));
		sessionFactory.setTypeAliasesPackage(param.packageName + ".dao.entity");
		sessionFactory.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
		PaginationInterceptor pageInterceptor = new PaginationInterceptor();
		
		Map<String, DbModel> dialectMap = this.dialectMap();
		pageInterceptor.setDialectClass(dialectMap.get(param.dbName).dialect.getName());
		
		sessionFactory.setPlugins(new Interceptor[] {pageInterceptor });
		return sessionFactory;
	}

	@Bean
	public Map<String, DbModel> dialectMap() {
		 Map<String, DbModel> map = new HashMap<String, DbModel>();
		 map.put(DB_MYSQL, new DbModel(MySQLDialect.class, "com.mysql.jdbc.Driver"));
		 map.put(DB_POSTGRESQL, new DbModel(PostgreSQLDialect.class, "org.postgresql.Driver"));
		 map.put(DB_ORACLE, new DbModel(OracleDialect.class, "oracle.jdbc.driver.OracleDriver"));
		 return map;
	}
	
	public class DbModel {
	    public Class<?> dialect;
	    public String driverClass;
	    public DbModel(Class<?> dialect, String driverClass) {
	        this.dialect = dialect;
	        this.driverClass = driverClass;
	    }
	}

	public class DataSourceParam {
		public javax.sql.DataSource dataSource;
		public String url;
		public String username;
		public String password;
		public String driverClass;
		public boolean printSql;
		public String packageName;
		public String dbName;
	}
}
