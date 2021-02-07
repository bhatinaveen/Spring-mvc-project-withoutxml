package com.java.securitytest.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.java")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig {
	@Autowired
	private Environment envirment;
	private Logger logger = Logger.getLogger(getClass().getName());

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Bean
	public DataSource securityDataSource() {
		// create Connection Pool
		ComboPooledDataSource securityDataSource = new ComboPooledDataSource();
		// set the jdbc class
		try {
			securityDataSource.setDriverClass(envirment.getProperty("jdbc.driver"));
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}

		logger.info("-->Driver " + envirment.getProperty("jdbc.url"));
		logger.info("-->Driver " + envirment.getProperty("jdbc.user"));
		logger.info("-->Driver " + envirment.getProperty("jdbc.password"));

		securityDataSource.setJdbcUrl(envirment.getProperty("jdbc.url"));
		securityDataSource.setUser(envirment.getProperty("jdbc.user"));
		securityDataSource.setPassword(envirment.getProperty("jdbc.password"));
		
		securityDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
		securityDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
		securityDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
		securityDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
		return securityDataSource;

	}

	private int getIntProperty(String proName) {
		String propValue = envirment.getProperty(proName);

		int intPropValue = Integer.parseInt(propValue);
		return intPropValue;
	}
}
