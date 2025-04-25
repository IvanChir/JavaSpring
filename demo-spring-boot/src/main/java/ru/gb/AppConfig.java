package ru.gb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class AppConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver"); // Укажите драйвер вашей базы данных
        dataSource.setUrl("jdbc:mysql://localhost:3306/your_database"); // Укажите URL вашей базы данных
        dataSource.setUsername("your_username"); // Укажите имя пользователя
        dataSource.setPassword("your_password"); // Укажите пароль
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}