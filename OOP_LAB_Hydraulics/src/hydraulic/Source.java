package hydraulic;

/**
 * Represents a source of water, i.e. the initial element for the simulation.
 *
 * The status of the source is defined through the method
 * {@link #setFlow(double) setFlow()}.
 */
public class Source extends ElementExt {

	private double flow;
	double maxFlow;

	public Source(String name) {
		super(name);
		this.flow = 0;
	}

	/**
	 * defines the flow produced by the source
	 * 
	 * @param flow
	 */
	public void setFlow(double flow) {
		this.flow = flow;
	}

	@Override
	public void simulate(double inflow, SimulationObserver observer) {
		observer.notifyFlow("Source", super.getName(), SimulationObserver.NO_FLOW, flow);
		getOutput().simulate(flow, observer);
	}

	@Override
	String layout() {

		return "[" + this.getName() + "]" + "Source";
	}

	@Override
	public void setMaxFlow(double maxFlow) {
	}

	@Override
	public void simulate(double inFlow, SimulationObserverExt observer) {
		observer.notifyFlow("Source", super.getName(), SimulationObserver.NO_FLOW, flow);
		getOutput().simulate(flow, observer);
	}

}
