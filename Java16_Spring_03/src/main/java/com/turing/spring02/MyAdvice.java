package com.turing.spring02;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 自己定义的通知
 * @author fred
 *
 */

@Component
@Aspect //<aop:aspect ref="myAdvice">
public class MyAdvice {

//	/**
//	 * 方法执行前
//	 */
//	public void begin() {
//		System.out.println("开启事务");
//	}
//	
//	/**
//	 * 方法执行后
//	 */
//	public void commit() {
//		System.out.println("提交事务");
//	}
	
	//<aop:pointcut expression="execution(* com.turing.spring02.*Service.*(..))" id="pc"/>
	@Pointcut("execution(* com.turing.spring02.*Service.*(..))")
	public void pc() {}//仅作为注解的载体
	
	//<aop:before method="before" pointcut-ref="pc"/>
	@Before("pc()")
	public void before() {
		System.out.println("before...");
	}
	
	@After("pc()")
	public void after() {
		System.out.println("after...");
	}
	
	@AfterReturning("pc()")
	public void afterreturning() {
		System.out.println("afterreturning...");
	}
	
	@AfterThrowing(value = "pc()",throwing = "tw")
	public void throwing(Throwable tw) {
		System.out.println("throwing..."+tw.getMessage());
	}
	
	/**
	 * around可以实现上述四个效果：
	 * 	1、必须要设置参数：ProceedingJoinPoint
	 *  2、必须要返回Object
	 */
	
	public Object around(ProceedingJoinPoint pjp) {
		try {
			System.out.println("before");
			//要执行的方法
			Object proceed = pjp.proceed();
			System.out.println("afterreturning");
			return proceed;
		}catch (Throwable e) {
			System.out.println("throwing");
			e.printStackTrace();
		}finally {
			System.out.println("after");
		}
		return null;
	}
	
	
	
	
	
	
}
