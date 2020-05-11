package hydraulic;

/**
 * Main class that act as a container of the elements for
 * the simulation of an hydraulics system 
 * 
 */
public class HSystemExt extends HSystem{
	
	/**
	 * Prints the layout of the system starting at each Source
	 */
	public String layout(){
		StringBuffer sb = new StringBuffer("");
		
		for(Element e: getElements()) {
			if(e instanceof Sink) {
				return sb.toString();
			}
			sb.append(e.layout());
		}
		return sb.toString();
	}
	
	/**
	 * Deletes a previously added element with the given name from the system
	 */
	public void deleteElement(String name) {
		Element[] result = super.getElements();
		
		int i, j, k;
		
		for(i = 0, j = 0; i < result.length; i++) {
			if(!name.equals(result[i].getName())) {
				result[j++] = result[i];
			}
			
		}
		result[i - 1] = null;
		for(k = 0; k < result.length; k++) {
			if(result[k] != null) {
				
			}
		}
		
		
	}

	/**
	 * starts the simulation of the system; if enableMaxFlowCheck is true,
	 * checks also the elements maximum flows against the input flow
	 */
	public void simulate(SimulationObserverExt observer, boolean enableMaxFlowCheck) {
		for(Element e: getElements()) {
			if(enableMaxFlowCheck) {
				if(e instanceof Source) {
					e.simulate(-1, observer);;
				}
			}
			else {
				if(e instanceof Source) {
					e.simulate(-1, observer);
				}
			}
		}
	}
	
}
