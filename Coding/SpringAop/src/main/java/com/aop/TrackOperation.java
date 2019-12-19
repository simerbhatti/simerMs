package com.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class TrackOperation{


	@Pointcut("execution(* Operation.method*(..))")
    public void k(){}//pointcut name



	@Before("k()")//applying pointcut on before advice
    public void myadvice(JoinPoint jp)//it is advice (before advice)
    {
        System.out.println("additional concern");
        //System.out.println("Method Signature: "  + jp.getSignature());
    }



    @Pointcut("execution(* Operation.a*(..))")
    public void m(){}//pointcut name

    @Around("m()")//applying pointcut on before advice
    public void myRoundadvice(ProceedingJoinPoint jp)//it is advice (before advice)
    {
        System.out.println("before around concern");
        try {
        	Signature s= jp.getSignature();
        	System.out.println("Simmm::>  "+s.getModifiers());
			jp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        System.out.println("Method Signature: "  + jp.getSignature());
    }


        @AfterReturning(
                  pointcut = "execution(* Operation.*(..))",
                  returning= "result")

        public void myadvice(JoinPoint jp,Object result)//it is advice (after returning advice)
        {
            System.out.println("additional concern");
            System.out.println("Method Signature: "  + jp.getSignature());
            System.out.println("Result in advice: "+result);
            System.out.println("end of after returning advice...");
        }


        @AfterThrowing(
                pointcut = "execution(* Operation.*(..))",
                throwing= "error")

      public void myadvice1(JoinPoint jp,Throwable error)//it is advice
      {
          System.out.println("additional concern");
          System.out.println("Method Signature: "  + jp.getSignature());
          System.out.println("Exception is: "+error);
          System.out.println("end of after throwing advice...");
      }

}