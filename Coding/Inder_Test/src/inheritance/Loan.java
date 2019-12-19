package inheritance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

 public abstract class Loan {

	 protected int value ;

	 protected abstract int linkAdhar();

	 protected int calculateInterst(int pr){
		 return  pr*10*1/100;
	 }

	 // we can declare final in abstract class
	 protected final int calculateInterst1(int pr){
		 return  pr*10*1/100;
	 }
}