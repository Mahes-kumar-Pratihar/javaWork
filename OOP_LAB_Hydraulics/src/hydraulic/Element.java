package hydraulic;

/**
 * Represents the generic abstract element of an hydraulics system. It is the
 * base class for all elements.
 *
 * Any element can be connect to a downstream element using the method
 * {@link #connect(Element) connect()}.
 */
public abstract class Element {

	/**
	 * Constructor
	 * 
	 * @param name the name of the element
	 */
	private Element[] outputs;
	private String name;

	public Element(String name) {
		this.name = name;
		outputs = new Element[1];
	}

	public Element(String name, int nOutput) {
		this.name = name;
		outputs = new Element[nOutput];
	}

	/**
	 * getter method
	 * 
	 * @return the name of the element
	 */
	public String getName() {
		// TODO: to be implemented
		return this.name;
	}

	/**
	 * Connects this element to a given element. The given element will be connected
	 * downstream of this element
	 * 
	 * @param elem the element that will be placed downstream
	 */
	public void connect(Element elem) {
		outputs[0] = elem;
	}

	public void connect(Element elem, int noutput) {
		outputs[noutput] = elem;
	}

	/**
	 * Retrieves the element connected downstream of this
	 * 
	 * @return downstream element
	 */

	public Element getOutput() {
		return outputs[0];
	}

	public Element[] getOutputs() {
		return outputs;
	}

	abstract public void simulate(double inflow, SimulationObserver observer);

	abstract String layout();

	abstract public void simulate(double inFlow, SimulationObserverExt observer);
}
