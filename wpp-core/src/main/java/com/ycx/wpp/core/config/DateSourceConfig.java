package com.ycx.wpp.core.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.sql.SQLException;


/**
 * Created by apple on 2018/4/12.
 */
@Configuration
public class DateSourceConfig {
        /*@Value("${jdbc.ref}")
        private String jdbcRef;

        @Value("HikariCP")
//        @Value("tomcat-jdbc")
        private String poolType;*/

        @Bean(destroyMethod = "close")
        @Primary
        public DruidDataSource dataSource() {
            DruidDataSource dataSource = new DruidDataSource();
            dataSource.setUrl("jdbc:mysql://127.0.0.1:3307/test?autoReconnect=true&useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true");
//        <!-- 选配。指定底层使用的连接池类型，支持"c3p0","tomcat-jdbc","druid","hikaricp","dbcp2"和"dbcp"，推荐使用"tomcat-jdbc"，默认值为"c3p0" -->
            dataSource.setUsername("root");
            dataSource.setPassword("root");
            //dataSource.setPoolType(poolType);
//        <!-- 选配。指定连接池的最小连接数，默认值是5。 -->
            dataSource.setInitialSize(5);
//        <!-- 选配。指定连接池的最大连接数，默认值是20。 -->
            dataSource.setMaxActive(20);
//            dataSource.setRouterType("master-only");
//        <!-- 选配。指定连接池的获取连接的超时时间，默认值是1000。 -->
//            dataSource.setIdleConnectionTestPeriod(60);
            try {
                dataSource.init();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return dataSource;
        }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:mapper/*.xml"));
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
        //sqlSessionFactoryBean.setTypeAliasesPackage("com.ycx.wpp.core.dao");
        //sqlSessionFactoryBean.setTypeHandlersPackage("com.sankuai.meituan.banma.rider.opp.core.dao.typeHandler");
        //sqlSessionFactoryBean.setVfs(SpringBootVFS.class);
        return sqlSessionFactoryBean.getObject();
    }


        /*@Bean(name = "sqlSessionFactory")
        public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
            SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
            sqlSessionFactoryBean.setDataSource(dataSource());
            PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:mapper*//*.xml"));
            sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
            sqlSessionFactoryBean.setTypeHandlersPackage("com.sankuai.meituan.banma.rider.opp.core.dao.typeHandler");
            sqlSessionFactoryBean.setVfs(SpringBootVFS.class);
            return sqlSessionFactoryBean.getObject();
        }

        @Bean(name = "transactionManager")
        public DataSourceTransactionManager transactionManagerBean() {
            return new DataSourceTransactionManager(dataSource());
        }

        @Bean
        public SqlSessionTemplate sqlSessionTemplateBean() throws Exception {
            SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactoryBean());
            return sqlSessionTemplate;
        }

        @Bean
        public TransactionTemplate transactionTemplateBean() {
            TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManagerBean());
            return transactionTemplate;
        }


    }*/
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.ycx.wpp.core.dao");
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        return mapperScannerConfigurer;
    }


}
