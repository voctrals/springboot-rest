package cn.voctrals.boot.api.config;

import cn.voctrals.boot.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by liulei on 05/11/2016.
 */
@Configuration
public class ApiServiceConfig {
    @Bean
    public BookService bookService(){
        return new BookService();
    }

}
