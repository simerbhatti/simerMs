package behavioral.Visitor;


public interface Visitor{
  public void visit(Keyboard book);

  public void visit(Mouse m);

  //simlarly other methods
//  public void visit(DVD dvd);
}