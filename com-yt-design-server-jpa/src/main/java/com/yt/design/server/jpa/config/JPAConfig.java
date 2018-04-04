package com.yt.design.server.jpa.config;


import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.Properties;

//启动时注入全局参数
@Configuration
//指定服务包
//@ComponentScan(basePackages={"com.yt.design.server.jpa.entity"})
@EnableJpaRepositories(basePackages = "com.yt.design.server.jpa.repository")
@EntityScan(basePackages={"com.yt.design.server.jpa.entity"})
//指定启动事务管理
@EnableTransactionManagement
public class JPAConfig {

    @Autowired
    private Environment env;

    private String enviromentKey;
    private String enviromentUrl = null;
    private String enviromentUsername = null;
    private String enviromentPassword = null;


    private String geActivieProfiles() {
        String[] profiles = env.getActiveProfiles();
        if (profiles.length != 0)
            return profiles[0];
        else
            return null;
    }

    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory
            (DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean em = new
                LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("com.leyeah.server.api.entity");

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(additionalProperties());

        return em;
    }

    private Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
//        properties.setProperty("hibernate.physical_naming_strategy", "org" +
//                ".springframework.boot.orm.jpa.hibernate" +
//                ".SpringPhysicalNamingStrategy");

        properties.setProperty("spring.jpa.hibernate.naming-strategy", env
                .getProperty("spring.jpa.hibernate.naming-strategy"));
        properties.setProperty("spring.jpa.show-sql", env
                .getProperty("spring.jpa.show-sql"));
        return properties;
    }

    @Bean(name = "transactionManager")
    public JpaTransactionManager transactionManager
            (LocalContainerEntityManagerFactoryBean entityManagerFactory) {
        JpaTransactionManager manager = new JpaTransactionManager();
        manager.setEntityManagerFactory(entityManagerFactory.getObject());
        return manager;
    }


    @Bean(name = "hcDataSource", initMethod = "init", destroyMethod = "close")
    @Profile("!build-test")
    public DataSource dataSource() throws PropertyVetoException {
        initEnviromentPropertys();
        System.out.println(enviromentKey);
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl(enviromentUrl);
        dataSource.setUsername(enviromentUsername);
        dataSource.setPassword(enviromentPassword);
        dataSource.setInitialSize(10);
        dataSource.setMinIdle(1);
        dataSource.setMaxActive(2000);
        dataSource.setMaxWait(60000L);
        dataSource.setTimeBetweenEvictionRunsMillis(60000L);
        dataSource.setMinEvictableIdleTimeMillis(300000L);
        dataSource.setValidationQuery("SELECT 1");
        dataSource.setTestWhileIdle(true);
        dataSource.setTestOnBorrow(true);
        dataSource.setTestOnReturn(false);
        try {
            dataSource.setFilters("wall");
        } catch (SQLException ex) {
            //ignore
        }
        return dataSource;
    }

    @Bean(name = "dataSource")
    @Profile("build-test")
    public DataSource unitTestDataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        return builder.setType(EmbeddedDatabaseType.H2).addScript("db/init" +
                ".sql").build();
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }


    private void initEnviromentPropertys() {

//        enviromentKey = env.getProperty("sys.environment.key");
        enviromentUrl = env.getProperty("mysql.connection.url");
        enviromentUsername = env.getProperty("mysql.connection.username");
        enviromentPassword = env.getProperty("mysql.connection.password");

    }
}
