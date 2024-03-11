package org.example.jdbc;

import org.example.config.DataSourceDemo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

@Component
public class JDBCTemplateDemo {
    private JdbcTemplate jdbcTemplate;

    public JDBCTemplateDemo(DataSourceDemo dataSourceDemo){
        this.jdbcTemplate = new JdbcTemplate(dataSourceDemo);
    }

    public void createTable(String sql){
        jdbcTemplate.update(sql);
    }

    public void insertTable(String sql){
        jdbcTemplate.update(sql);
    }

    public void deleteTable(String sql){
        jdbcTemplate.update(sql);
    }

    public List<Map<String, Object>> readTable(String sql){
         return jdbcTemplate.queryForList(sql);
    }
}
