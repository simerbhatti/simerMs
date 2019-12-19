package behavioral.Visitor;

public class Keyboard implements ComputerPart{

	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		v.visit(this);

	}

}
