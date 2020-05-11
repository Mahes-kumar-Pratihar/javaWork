package hydraulic;

public abstract class ElementExt extends Element{

	
	public ElementExt(String name) {
		super(name);
	}
	
	public ElementExt(String name, int nOutputs) {
		super(name, nOutputs);
	}

	public abstract void setMaxFlow(double maxFlow) ;

	
}
