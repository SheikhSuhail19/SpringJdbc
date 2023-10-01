package com.springjdbc;

import dao.StudentDao;
import entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

//		ApplicationContext context = new ClassPathXmlApplicationContext("jdbcconfig.xml");

		ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);

		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

		Student student = new Student(676, "Raj Kumar Rao", "Lucknow");

//		int result = studentDao.insert(student);
//		int result = studentDao.change(student);
//		int result = studentDao.delete(666);

//		Student result = studentDao.getStudent(222);
		List<Student> result = studentDao.getAllStudents();

		System.out.println(result);
	}
}
