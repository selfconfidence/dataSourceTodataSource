package com.bdsoft.sourcereversal.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @author mister_wei
 * @version 1.1.1
 * @title web_service
 * @package com.bdsoft.sourcereversal.config
 * @date 2019/4/25 20:24
 */
@Configuration
public class JdbcTemplateConfig {
    @Bean("mysqlTemplate")
    public JdbcTemplate getMysqlJdbcTemplate(@Qualifier("primaryDataSource")DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    @Bean("kingBaseTemplate")
    public JdbcTemplate getKingBaseJdbcTemplate(@Qualifier("secondaryDataSource")DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}
