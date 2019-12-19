package behavioral.Visitor;

public class ComputerVisitor implements Visitor{

	int priceOfComputer =0;


	public int getPriceOfComputer() {
		return priceOfComputer;
	}

	@Override
	public void visit(Keyboard k) {
		// //assume we have a calculation here related to weight and price
	    //language configure in keyboard

		priceOfComputer = priceOfComputer + 400;

	}

	@Override
	public void visit(Mouse cd) {
		// TODO Auto-generated method stub
		priceOfComputer = priceOfComputer + 200;
	}



}
