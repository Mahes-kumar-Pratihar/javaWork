package hydraulic;

/**
 * Represents the sink, i.e. the terminal element of a system
 *
 */
public class Sink extends ElementExt {

	/**
	 * Constructor
	 * 
	 * @param name
	 */
	double maxFlow;

	public Sink(String name) {
		super(name);

	}

	@Override
	public Element getOutput() {
		return null;
	}

	@Override
	public void simulate(double inflow, SimulationObserver observer) {
		observer.notifyFlow("Sink", this.getName(), inflow, SimulationObserver.NO_FLOW);
	}

	public String layout() {
		return "-->[" + this.getName() + "]" + "Sink*";
	}

	@Override
	public void setMaxFlow(double maxFlow) {
		this.maxFlow = maxFlow;

	}

	@Override
	public void simulate(double inFlow, SimulationObserverExt observer) {
		if(inFlow > this.maxFlow) {
			observer.notifyFlowError("Sink", super.getName(), inFlow, this.maxFlow);
		}
		this.simulate(inFlow, (SimulationObserver) observer);
	}

}
