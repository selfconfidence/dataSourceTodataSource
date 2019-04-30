package com.bdsoft.sourcereversal.sourcereversal;

import com.bdsoft.sourcereversal.constant.SourceReversalConstant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import javax.xml.transform.Source;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SourcereversalApplicationTests {

    @Qualifier("mysqlTemplate")
    @Resource
    private JdbcTemplate mysqlJdbcTemplate;

    @Qualifier("kingBaseTemplate")
    @Resource
    private JdbcTemplate kingBaseJdbcTemplate;

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    DataSourceProperties dataSourceProperties;




    @Test
    public void contextLoads() {
        String replace = SourceReversalConstant.Constant.SQL;
        List<Map<String, Object>> mapList = mysqlJdbcTemplate.queryForList(replace);
        System.out.println(mapList);
    }

}
