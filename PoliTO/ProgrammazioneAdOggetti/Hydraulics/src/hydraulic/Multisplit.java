package hydraulic;

/**
 * Represents a multisplit element, an extension of the Split that allows many outputs
 * 
 * During the simulation each downstream element will
 * receive a stream that is determined by the proportions.
 */

public class Multisplit extends Split {
	
	protected double proportions[];

	/**
	 * Constructor
	 * @param name the name of the multi-split element
	 * @param numOutput the number of outputs
	 */
	public Multisplit(String name, int numOutput) {
		super(name);
		this.maxConnectedElements = numOutput;
		this.connectedElements = new Element[this.maxConnectedElements];
		this.outputFlow = new double[this.maxConnectedElements];
		this.proportions = new double[this.maxConnectedElements];
	}
	
	@Override
	public void connect(Element elem, int index) {
		this.connectedElements[index] = elem;
	}
	
	@Override
	public Element[] getOutputs() {
		return this.connectedElements;
	}
	
	/**
	 * Define the proportion of the output flows w.r.t. the input flow.
	 * 
	 * The sum of the proportions should be 1.0 and 
	 * the number of proportions should be equals to the number of outputs.
	 * Otherwise a check would detect an error.
	 * 
	 * @param proportions the proportions of flow for each output
	 */
	public void setProportions(double... proportions) {
		this.proportions = proportions;
	}
	
	public void computeFlow(double flow) {
		int i;
		this.inputFlow = flow;
		for(i = 0; i < this.maxConnectedElements; i++) {
			this.outputFlow[i] = this.proportions[i] * this.inputFlow;
		}
	}
	
	@Override
	public String printInfo() {
		return "[" + this.name + "]Multisplit ";
	}
	
	@Override
	public int getConnectedElements() {
		int i, n = 0;
		for(i = 0; i < this.maxConnectedElements; i++) {
			if(this.connectedElements[i] != null) {
				n++;
			}
		}
		return n;
	}
	
	@Override
	public void setMaxFlow(double maxFlow) {
		this.maxFlow = maxFlow;
	}
	
}


//=================================================================
//=================================================================
//=================================================================

// package hydraulic;

// /**
//  * Represents a multisplit element, an extension of the Split that allows many outputs
//  * 
//  * During the simulation each downstream element will
//  * receive a stream that is determined by the proportions.
//  */

// public class Multisplit extends Split {

// 	/**
// 	 * Constructor
// 	 * @param name the name of the multi-split element
// 	 * @param numOutput the number of outputs
// 	 */
// 	public Multisplit(String name, int numOutput) {
// 		super(name);
// 	}
	
// 	/**
// 	 * Define the proportion of the output flows w.r.t. the input flow.
// 	 * 
// 	 * The sum of the proportions should be 1.0 and 
// 	 * the number of proportions should be equals to the number of outputs.
// 	 * Otherwise a check would detect an error.
// 	 * 
// 	 * @param proportions the proportions of flow for each output
// 	 */
// 	public void setProportions(double... proportions) {
// 		// TODO: to be implemented
// 	}
	
// }
