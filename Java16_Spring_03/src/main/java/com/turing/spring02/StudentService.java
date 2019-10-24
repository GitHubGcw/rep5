package com.turing.spring02;

import org.springframework.stereotype.Service;

/**
 * 学生业务层
 * @author fred
 *
 */

@Service
public class StudentService {

	//方法执行前：开启事务
	public void add() {
		System.out.println("添加一条学生记录...");
		int a = 1/0;
	}
	//方法执行后，提交事务
}
