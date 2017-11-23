package cn.voctrals.boot.core.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by liulei on 31/10/2016.
 */
@Configuration
@MapperScan("cn.voctrals.boot.dao")
@EnableTransactionManagement
public class CustomDataSourceConfig extends cn.voctrals.boot.core.config.DataSourceBaseConfig {
    public static final String PROJECT_PACKAGE = "cn.voctrals.boot";

    @Bean
    @Override
    public DataSourceBaseConfig.DataSourceParam dataSourceParam() {
        DataSourceBaseConfig.DataSourceParam param = new DataSourceBaseConfig.DataSourceParam();
        param.url = "jdbc:mysql://localhost:3306/boot?autoReconnect=true&amp;characterEncoding=utf-8";
        param.username = "root";
        param.password = "voctrals";
        //param.printSql = true;
        param.packageName = PROJECT_PACKAGE;
        param.dbName = DB_MYSQL;
        return param;

    }
}
