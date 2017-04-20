package org.projectX.config;

import org.projectX.event.model.Event;
import org.projectX.user.model.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import javax.sql.DataSource;


@Configuration
public class GeneralConfig {


    @Autowired
    DataSource dataSource;

    @Bean(name = "sessionFactory")
    public LocalSessionFactoryBean hibernate5SessionFactoryBean() {
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(dataSource);
        localSessionFactoryBean.setAnnotatedClasses(
                UserAccount.class

        );


        /** Porperties dla mysql. Wszystekie są zawarte w application.properties ale niech narazie bd bo nie wiem czy
         * na pewno są wszystkie
         **/
        /*
        Properties properties = new Properties();
        properties.put("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
        //properties.put("hibernate.current_session_context_class","thread");
        properties.put("hibernate.hbm2ddl.auto","update");

        localSessionFactoryBean.setHibernateProperties(properties);

        */
        return localSessionFactoryBean;
    }
}
