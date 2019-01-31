package com.yatop.lambda.portal.common.config;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@MapperScan(
        basePackages = {"com.yatop.lambda.portal.dao"},
        sqlSessionFactoryRef = "portalSqlSessionFactory"
)
public class MyBatisConfig {

/*
    @Bean("coreDataSource")
    @Qualifier("coreDataSource")
    @Primary
    public DataSource coreDataSource(@Qualifier("orignalCoreDataSource") DataSource orignalFrameworkDataSource) {
        return new DataSourceSpy(orignalFrameworkDataSource);
    }

    @Bean("orignalCoreDataSource")
    @Qualifier("orignalCoreDataSource")
    @ConfigurationProperties(prefix = "lambda.mls.datasource")
    public DataSource orignalCoreDataSource(){
        return DataSourceBuilder.create().type(DruidDataSource.class).build();
    }
*/

    @Bean("portalJdbcTemplate")
    @Qualifier("portalJdbcTemplate")
    public JdbcTemplate portalJdbcTemplate(@Qualifier("frameworkDataSource") DataSource frameworkDataSource) {
        return new JdbcTemplate(frameworkDataSource);
    }

    @Bean("portalSqlSessionTemplate")
    @Qualifier("portalSqlSessionTemplate")
    public SqlSessionTemplate portalSqlSessionTemplate(@Qualifier("portalSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean("portalSqlSessionFactory")
    @Qualifier("portalSqlSessionFactory")
    public SqlSessionFactory portalSqlSessionFactory(@Qualifier("frameworkDataSource") DataSource coreDataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(coreDataSource);
        bean.setTypeAliasesPackage("com.yatop.lambda.portal.model");
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("mapper/*.xml"));
        bean.setPlugins(new Interceptor[]{ com.yatop.lambda.framework.config.MybatisConfig.getPageInterceptor()} );
        return bean.getObject();
    }

/*
    @Bean("portalTransactionManager")
    public PlatformTransactionManager portalTransactionManager(@Qualifier("portalDataSource") DataSource portalDataSource) {
        return new DataSourceTransactionManager(portalDataSource);
    }
*/
}
