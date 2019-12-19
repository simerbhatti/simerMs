package behavioral.Visitor;

import java.util.ArrayList;
import java.util.List;

public class AssembleComputer {
	List<ComputerPart> list = new ArrayList<ComputerPart>();
	public int assembleAndPriceIt(){
	ComputerVisitor cv= new ComputerVisitor();
	for (ComputerPart cp : list) {
		cp.accept(cv);
	}
	return cv.getPriceOfComputer();
	}
}
