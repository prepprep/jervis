package com.kai;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;

import com.kai.service.dbinit.IDBinitialiserService;

@SpringBootApplication
public class JervisApplication {

    public static void main(String[] args) {
	SpringApplication.run(JervisApplication.class, args);
    }
    
    @Bean
    public HibernateJpaSessionFactoryBean SessionFactory() {
	return new HibernateJpaSessionFactoryBean();
    }
    
    @Bean
    public ModelMapper modelMapper() {
	ModelMapper modelMapper = new ModelMapper();
	return modelMapper;
    }
    
    @Bean
    public InitializingBean initBean(IDBinitialiserService initService) {
	return () -> {
	  initService.initDb();  
	};
    }
    
}
