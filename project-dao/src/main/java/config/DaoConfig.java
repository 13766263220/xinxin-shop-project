package config;


import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@MapperScan("com.nf.dao")
@PropertySource("classpath:properties/db.properties")
public class DaoConfig {
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;
    @Value("${jdbc.filters}")
    private String filters;
    @Value("${jdbc.maxActive}")
    private Integer maxActive;
    @Value("${jdbc.initialSize}")
    private Integer initialSize;
    @Value("${jdbc.maxWait}")
    private Integer maxWait;
    @Value("${jdbc.minIdle}")
    private Integer minIdle;
    @Value("${jdbc.timeBetweenEvictionRunsMillis}")
    private Integer timeBetweenEvictionRunsMillis;
    @Value("${jdbc.minEvictableIdleTimeMillis}")
    private Integer minEvictableIdleTimeMillis;
    @Value("${jdbc.testWhileIdle}")
    private Boolean testWhileIdle;
    @Value("${jdbc.testOnBorrow}")
    private Boolean testOnBorrow;
    @Value("${jdbc.testOnReturn}")
    private Boolean testOnReturn;
    @Value("${jdbc.poolPreparedStatements}")
    private Boolean poolPreparedStatements;
    @Value("${jdbc.maxOpenPreparedStatements}")
    private Integer maxOpenPreparedStatements;
    @Value("${jdbc.asyncInit}")
    private Boolean asyncInit;


    /**
     * 连接池
     * @return
     * @throws Exception
     */
    @Bean
    public DataSource dataSource() throws Exception {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(url);
        druidDataSource.setDriverClassName(driver);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        druidDataSource.setFilters(filters);

        druidDataSource.setMaxActive(maxActive);
        druidDataSource.setInitialSize(initialSize);
        druidDataSource.setMaxWait(maxWait);
        druidDataSource.setMinIdle(minIdle);

        druidDataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        druidDataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);

        druidDataSource.setTestWhileIdle(testWhileIdle);
        druidDataSource.setTestOnBorrow(testOnBorrow);
        druidDataSource.setTestOnReturn(testOnReturn);

        druidDataSource.setPoolPreparedStatements(poolPreparedStatements);
        druidDataSource.setMaxOpenPreparedStatements(maxOpenPreparedStatements);
        druidDataSource.setAsyncInit(asyncInit);
        return druidDataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());

        //设置Mapper文件
        PathMatchingResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = patternResolver.getResources("classpath:mappers/**/*.xml");
        sqlSessionFactoryBean.setMapperLocations(resources);

        //配置分页
        sqlSessionFactoryBean.setPlugins(getPageInterceptor());

        //配置输出日志
        sqlSessionFactoryBean.setConfiguration(getConfiguration());

        return sqlSessionFactoryBean.getObject();

    }

    /**
     * 分页插件
     * @return
     */
    private PageInterceptor getPageInterceptor(){
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.put("supportMethodsArguments", "true");
        properties.put("reasonable", "true");
        pageInterceptor.setProperties(properties);
        return pageInterceptor;
    }

    /**
     * 输出日志
     * @return
     */
    private org.apache.ibatis.session.Configuration getConfiguration(){
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setLogImpl(StdOutImpl.class);
        return configuration;
    }
}
