package hydraulic;

/**
 * Represents a tap that can interrupt the flow.
 * 
 * The status of the tap is defined by the method {@link #setOpen(boolean)
 * setOpen()}.
 */

public class Tap extends ElementExt {

	private boolean open;
	double maxFlow;

	public Tap(String name) {
		super(name);
		this.open = false;
	}

	/**
	 * Defines whether the tap is open or closed.
	 * 
	 * @param open opening level
	 */
	public void setOpen(boolean open) {
		this.open = open;
	}

	@Override
	public void simulate(double inflow, SimulationObserver observer) {
		double outflow = (this.open ? inflow : 0);

		observer.notifyFlow("Tap", this.getName(), inflow, outflow);
		this.getOutput().simulate(outflow, observer);
	}

	@Override
	String layout() {
		return "-->[" + this.getName() + "]" + "Tap";
	}

	@Override
	public void setMaxFlow(double maxFlow) {
		this.maxFlow = maxFlow;
	}

	@Override
	public void simulate(double inFlow, SimulationObserverExt observer) {
		double outflow = (this.open ? inFlow : 0);

		if (inFlow > this.maxFlow) {
			observer.notifyFlowError("Tap", this.getName(), inFlow, this.maxFlow);
		}
		observer.notifyFlow("Tap", this.getName(), inFlow, outflow);
		this.getOutput().simulate(outflow, observer);
	}

}
