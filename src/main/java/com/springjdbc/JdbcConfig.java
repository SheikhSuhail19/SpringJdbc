package com.springjdbc;

import dao.StudentDao;
import dao.StudentDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


@Configuration
@ComponentScan(basePackages = {"dao"})
public class JdbcConfig {

	@Bean("datasrc")
	public DriverManagerDataSource getDataSource() {
		DriverManagerDataSource datasrc = new DriverManagerDataSource();
		datasrc.setDriverClassName("com.mysql.cj.jdbc.Driver");
		datasrc.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		datasrc.setUsername("root");
		datasrc.setPassword("password");
		return datasrc;
	}

	@Bean("jdbcTemplate")
	public JdbcTemplate getTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
	}


//	@Bean("studentDao")
//	public StudentDao getStudentDao() {
//		StudentDaoImpl studentDao = new StudentDaoImpl();
//		studentDao.setJdbcTemplate(getTemplate());
//		return studentDao;
//	}

}
