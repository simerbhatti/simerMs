package sum;

import num.Number;

public class fbn {


	public static void main(String[] args) {
		for(int i=1; i<=10; i++){ System.out.print(printFibonacci1(i) +" "); }

		int p=0,n=1,res,i,count=10;
		 System.out.print(p+" "+n);//printing 0 and 1

		 for(i=2;i<count;++i)//loop starts from 2 because 0 and 1 are already printed
		 {
		  res=p+n;
		  System.out.print(" "+res);
		  p=n;
		  n=res;
		 }
	}

	static int n1=0,n2=1,n3=0;
	 static void printFibonacci(int count){
	    if(count>0){
	         n3 = n1 + n2;
	         n1 = n2;
	         n2 = n3;
	         System.out.print(" "+n3);
	         printFibonacci(count-1);
	     }
	 }
	 static int printFibonacci1(int count){
		 if(count==0)return 0;
		 if(count==1)return 1;
		         return printFibonacci1(count-1) +printFibonacci1(count-2);
		         //palindrome 
		         //for ( int i = length - 1; i >= 0; i-- ){
		         //reverse = reverse + original.charAt(i);} original.equals(reverse){return true;}

		 }


	 public static void printfbn(){
	  int count=10;
	  System.out.print(n1+" "+n2);//printing 0 and 1
	  printFibonacci(count-2);//n-2 because 2 numbers are already printed
	 }


}
