package com.example.helloworld.repository;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * This is to create a process that searches the database for an employee,
 * and should use JDBC to execute the select statement for sql
 */
@Repository
public class HelloRepository {

    @Autowired
    private JdbcTemplate jdbctemplate;

    /*
    queryForMap will only return one result, if you expect to get multiple results, then use queryForList which
    will return List<Map<String, Object>>.

    If the database if mysql or mybatis, for single result, use queryForObject instead of queryForMap. Remember to handle
    "notFound" exception.
     */
    public Map<String, Object> findPerson(String id) {
        try {
            String query = "SELECT * FROM employee WHERE id = ?";
            Map<String, Object> result = jdbctemplate.queryForMap(query, id);
            return result;
        }
        catch (Exception e) {
            //e.printStackTrace();
            return null;
        }
    }
}
