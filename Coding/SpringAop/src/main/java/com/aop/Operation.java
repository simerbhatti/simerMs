package com.aop;

public class Operation {

	public void method1() {
		System.out.println("msg method invoked");
	}

	public int method2() {
		System.out.println("m method invoked");
		return 2;
	}

	public int method3() {
		System.out.println("k method invoked");
		return 3;
	}

	public int a1() {
		System.out.println("k method invoked");
		return 9;
	}


	 public void validate(int age)throws Exception{
		    if(age<18){
		        throw new ArithmeticException("Not valid age");
		    }
		    else{
		        System.out.println("Thanks for vote");
		    }
		    }

}
