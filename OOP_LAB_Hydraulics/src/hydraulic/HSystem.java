package hydraulic;

/**
 * Main class that act as a container of the elements for the simulation of an
 * hydraulics system
 * 
 */
public class HSystem {

	/**
	 * Adds a new element to the system
	 * 
	 * @param elem
	 */
	private static final int MAX_NUM_ELEMENTS = 50;

	private Element[] elements = new Element[MAX_NUM_ELEMENTS];

	private int count = 0;

	public void addElement(Element elem) {
		elements[count++] = elem;
	}

	/**
	 * returns the element added so far to the system. If no element is present in
	 * the system an empty array (length==0) is returned.
	 * 
	 * @return an array of the elements added to the hydraulic system
	 */
	public Element[] getElements(){
		Element[] result = new Element[count];
		//Element[] result=null;
		for(int i =0; i<result.length; i++){
			result[i] = elements[i];
		}
		return result;
	}
	

	/**
	 * Prints the layout of the system starting at each Source
	 */
	public String layout() {
		return null;
	}

	/**
	 * starts the simulation of the system
	 */
	public void simulate(SimulationObserver observer) {
		for(Element e: elements) {
			if(e != null && e instanceof Source) {
				e.simulate(-1, observer);
			}
		}
	}

}
