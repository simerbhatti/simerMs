package num;

import inheritance.Loan;

 public class Number {

	 private int value ;

	Number(int val) {
		val = val+10;
     value = val;
	}


	public static void main(String[] args) {
		Object o1= new Object();
		Object o2= new Object();
//		Loan l = new Loan();
		System.out.println(o1==o2);
		System.out.println(o1.equals(o2));
		o1=o2;
		System.out.println(o1.equals(o2));
	}

}