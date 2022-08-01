package com.korea.domain;

import static org.junit.Assert.*;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.korea.mapper.TestMapper;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MybatisTests {


    @Autowired
    private DataSource dataSource;

    @Autowired 
    private SqlSessionFactory sqlSessionFactory;

    @Autowired
    private TestMapper tm;
    
    @Test
    public void testConnection() {

        try(
                Connection con = dataSource.getConnection();
                SqlSession session = sqlSessionFactory.openSession();

        ){

            log.info("con = " + con);
            log.info("session = " + session);

        } catch(Exception e) {

            e.printStackTrace();

        }

    }
    
    @Test
    public void test() {
       
       log.info(tm.getClass().getName());
       log.info("ANNO : !!!!!!!!!!!!!!!" + tm.getTime());
    }

}
