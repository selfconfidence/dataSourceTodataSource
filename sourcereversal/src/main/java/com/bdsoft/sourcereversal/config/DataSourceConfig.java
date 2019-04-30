package com.bdsoft.sourcereversal.config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import javax.sql.DataSource;
/**
 * @author mister_wei
 * @version 1.1.1
 * @title web_service
 * @package com.bdsoft.sourcereversal.config
 * @date 2019/4/25 20:21
 */
@Configuration
@PropertySource("classpath:datasource.properties")
public class DataSourceConfig {
    private Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);

    @Bean(name = "primaryDataSource")
    @Primary
    @Qualifier("primaryDataSource")
    @ConfigurationProperties(prefix="spring.datasource.primary" )
    public DataSource getMysqlDataSource(){
        logger.info("mysql数据源建立! \r\n"+"不确定因素,是否连接通过!");
        return DataSourceBuilder.create().build();
    }
    @Bean(name = "secondaryDataSource")
    @Qualifier("secondaryDataSource")
    @ConfigurationProperties(prefix="spring.datasource.secondary")
    public DataSource getKingBaseSource(){
        logger.info("kingBase数据源建立! \r\n"+"不确定因素,是否连接通过!");
        return DataSourceBuilder.create().build();
    }

}
