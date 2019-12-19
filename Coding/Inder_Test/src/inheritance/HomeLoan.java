package inheritance;

public class HomeLoan extends Loan implements Indentifiable {

	public int calculateInterst()
	{
		int a1= super.value;
		int a=10;
		return a;
	}

	/**
	 * gst shud be added to interest.Dont make anyone use function that does not add gst
	 */
	 protected int calculateInterst(int pr){
		 int gst=25;
		 int interest = super.calculateInterst(pr);
		 return interest+gst;
	 }

	 /**
	  * linking adhar made mandatory
	  */
	@Override
	protected int linkAdhar() {
		int adharNumber=200323;
		return adharNumber;
	}

	@Override
	public String address() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int adhaar(int add) {
		// TODO Auto-generated method stub
		return 0;
	}


}
