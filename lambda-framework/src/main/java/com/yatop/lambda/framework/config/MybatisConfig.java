package com.yatop.lambda.framework.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageInterceptor;
import net.sf.log4jdbc.sql.jdbcapi.DataSourceSpy;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
/*@MapperScan(
        basePackages = {"com.yatop.lambda.framework.mapper"},
        sqlSessionFactoryRef = "frameworkSqlSessionFactory"
)*/
public class MybatisConfig {

    @Bean("frameworkDataSource")
    @Qualifier("frameworkDataSource")
    @Primary
    public DataSource frameworkDataSource(@Qualifier("orignalFrameworkDataSource") DataSource orignalFrameworkDataSource) {
        return new DataSourceSpy(orignalFrameworkDataSource);
    }

    @Bean("orignalFrameworkDataSource")
    @Qualifier("orignalFrameworkDataSource")
    @ConfigurationProperties(prefix = "lambda.mls.datasource")
    public DataSource orignalFrameworkDataSource(){
        return DataSourceBuilder.create().type(DruidDataSource.class).build();
    }

    @Bean("frameworkJdbcTemplate")
    @Qualifier("frameworkJdbcTemplate")
    public JdbcTemplate frameworkJdbcTemplate(@Qualifier("frameworkDataSource") DataSource frameworkDataSource) {
        return new JdbcTemplate(frameworkDataSource);
    }

/*
    @Bean("frameworkSqlSessionFactory")
    @Qualifier("frameworkSqlSessionFactory")
    public SqlSessionFactory frameworkSqlSessionFactory(@Qualifier("frameworkDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("com/yatop/lambda/framework/sqlmapper/*.xml"));
        return bean.getObject();
    }

    @Bean("frameworkSqlSessionTemplate")
    @Qualifier("frameworkSqlSessionTemplate")
    public SqlSessionTemplate frameworkSqlSessionTemplate(@Qualifier("frameworkSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
*/

    @Bean("platformTransactionManager")
    public PlatformTransactionManager platformTransactionManager(@Qualifier("frameworkDataSource") DataSource frameworkDataSource) {
        return new DataSourceTransactionManager(frameworkDataSource);
    }

    //PageHelper: https://github.com/pagehelper/Mybatis-PageHelper/blob/v5.1.6/wikis/zh/HowToUse.md
    static public PageInterceptor getPageInterceptor() {
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("helperDialect", "mysql");
        properties.setProperty("pageSizeZero", "true");
        pageInterceptor.setProperties(properties);
        return pageInterceptor;
    }
}
