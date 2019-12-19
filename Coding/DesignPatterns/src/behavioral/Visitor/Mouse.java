package behavioral.Visitor;

public class Mouse implements ComputerPart{

	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		v.visit(this);

	}
}
