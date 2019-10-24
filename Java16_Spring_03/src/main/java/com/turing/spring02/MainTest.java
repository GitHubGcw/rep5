package com.turing.spring02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration  //配置项
@ComponentScan	//扫描组件
@EnableAspectJAutoProxy //开启AOP
public class MainTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(MainTest.class);
		StudentService studentService = ctx.getBean("studentService",StudentService.class);
		studentService.add();
	}

}
