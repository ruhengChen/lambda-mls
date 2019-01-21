package com.yatop.lambda.core.config;

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
import org.apache.ibatis.plugin.Interceptor;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@MapperScan(
        basePackages = {"com.yatop.lambda.base.mapper"},
        sqlSessionFactoryRef = "coreSqlSessionFactory"
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

    @Bean("coreJdbcTemplate")
    @Qualifier("coreJdbcTemplate")
    public JdbcTemplate coreJdbcTemplate(@Qualifier("frameworkDataSource") DataSource frameworkDataSource) {
        return new JdbcTemplate(frameworkDataSource);
    }

    @Bean("coreSqlSessionTemplate")
    @Qualifier("coreSqlSessionTemplate")
    public SqlSessionTemplate coreSqlSessionTemplate(@Qualifier("coreSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean("coreSqlSessionFactory")
    @Qualifier("coreSqlSessionFactory")
    public SqlSessionFactory coreSqlSessionFactory(@Qualifier("frameworkDataSource") DataSource coreDataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(coreDataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("com/yatop/lambda/base/sqlmapper/*.xml"));
        bean.setPlugins(new Interceptor[]{ com.yatop.lambda.framework.config.MybatisConfig.getPageInterceptor()} );
        return bean.getObject();
    }

/*
    @Bean("coreTransactionManager")
    public PlatformTransactionManager coreTransactionManager(@Qualifier("coreDataSource") DataSource portalDataSource) {
        return new DataSourceTransactionManager(portalDataSource);
    }
*/
}
