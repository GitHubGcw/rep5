package com.turing.spring01;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 自己定义的通知
 * @author fred
 *
 */
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
	
	public void before() {
		System.out.println("before...");
	}
	public void after() {
		System.out.println("after...");
	}
	public void afterreturning() {
		System.out.println("afterreturning...");
	}
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
