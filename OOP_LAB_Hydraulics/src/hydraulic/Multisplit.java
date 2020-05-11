package hydraulic;

/**
 * Represents a multisplit element, an extension of the Split that allows many
 * outputs
 * 
 * During the simulation each downstream element will receive a stream that is
 * determined by the proportions.
 */

public class Multisplit extends Split {

	/**
	 * Constructor
	 * 
	 * @param name
	 * @param numOutput
	 */
	private int numOutput;
	private double[] outflows;

	public Multisplit(String name, int numOutput) {
		super(name, numOutput); // you can edit also this line
		outflows = new double[numOutput];
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

	/**
	 * Define the proportion of the output flows w.r.t. the input flow.
	 * 
	 * The sum of the proportions should be 1.0 and the number of proportions should
	 * be equals to the number of outputs. Otherwise a check would detect an error.
	 * 
	 * @param proportions the proportions of flow for each output
	 */
	@Override
	public void simulate(double inflow, SimulationObserver observer) {
		int i;
		for (i = 0; i < outflows.length; i++) {
			outflows[i] = inflow * outflows[i];
			System.out.println(outflows[i]);
		}
		observer.notifyFlow("MultiSplit", this.getName(), inflow, outflows);

		i = 0;
		for (Element e : this.getOutputs()) {
			e.simulate(outflows[i++], observer);
		}

	}

	public void setProportions(double... proportions) {
		double sum = 0;
		for (int i = 0; i < proportions.length; i++) {
			sum += proportions[i];
		}
		if (sum > 1.0) {
			System.err.println("Proportions are not correct");
		}
		outflows = proportions;
	}

	@Override
	public void simulate(double inFlow, SimulationObserverExt observer) {
		if (inFlow > this.maxFlow) {
			observer.notifyFlowError("MultiSplit", this.getName(), inFlow, this.maxFlow);
		}
		observer.notifyFlow("MultiSplit", this.getName(), inFlow, outflows);
		int i = 0;
		for (Element e : this.getOutputs()) {
			e.simulate( outflows[i++], observer);
		}
	}

}
