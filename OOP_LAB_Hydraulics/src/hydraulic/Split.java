package hydraulic;

/**
 * Represents a split element, a.k.a. T element
 * 
 * During the simulation each downstream element will receive a stream that is
 * half the input stream of the split.
 */

public class Split extends ElementExt {

	/**
	 * Constructor
	 * 
	 * @param name
	 */
	double maxFlow;

	public Split(String name) {
		super(name, 2);
		maxFlow = 0;
	}

	public Split(String name, int nOutput) {
		super(name, nOutput);

	}

	@Override
	public void simulate(double inflow, SimulationObserver observer) {
		double outflow = inflow / 2;

		observer.notifyFlow("Split", this.getName(), inflow, outflow, outflow);

		for (Element e : this.getOutputs()) {
			e.simulate(outflow, observer);
		}
	}

	@Override
	String layout() {
		StringBuilder sb = new StringBuilder("");
		if (this instanceof Multisplit)
			sb.append("-->[" + this.getName() + "]" + "MultiSplit");
		else
			sb.append("-->[" + this.getName() + "]" + "Split");
        int count = 0;
		for (Element e : getOutputs()) {
			if(count != this.getOutputs().length-1)
			sb.append("+" + e.layout() + '\n' + "|" + '\n');
			else
				sb.append("+" + e.layout());
			count++;
		}
		return sb.toString();
	}

	@Override
	public void setMaxFlow(double maxFlow) {
           this.maxFlow = maxFlow;
	}
    
	@Override
	public void simulate(double inFlow, SimulationObserverExt observer) {
		double outflow = inFlow / 2;
		if(inFlow > this.maxFlow) {
			observer.notifyFlowError("Split", this.getName(), inFlow, this.maxFlow);
		}
		observer.notifyFlow("Split", this.getName(), inFlow, outflow, outflow);
	    
		for(Element e: getOutputs()) {
	    	e.simulate(outflow, observer);
	    }
	}

		

	

	
	

	/**
	 * returns the downstream elements
	 * 
	 * @return array containing the two downstream element
	 */

	/**
	 * connect one of the outputs of this split to a downstream component.
	 * 
	 * @param elem    the element to be connected downstream
	 * @param noutput the output number to be used to connect the element
	 */

}
