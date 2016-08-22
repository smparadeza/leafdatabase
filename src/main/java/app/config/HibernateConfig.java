package app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

//import org.springframework.orm.hibernate4.annotation.AnnotationSessionFactoryBean;

@Configuration
@Import({DataSourceConfig.class})
public class HibernateConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sf = new LocalSessionFactoryBean();
        Properties properties = new Properties();
        properties.put("hibernate.show_sql", "false");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.put("hibernate.hbm2ddl.auto", "update");
        sf.setHibernateProperties(properties);
        sf.setPackagesToScan(new String[] {"app.domain"});
//        sf.setSchemaUpdate(true);
        sf.setDataSource(dataSource);
        return sf;
    }

}
