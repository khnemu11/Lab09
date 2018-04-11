package edu.handong.csee.java.lab09; //package edu.handong.csee.java.lab09

/**
 * basic form of SalesAssociate and do set and get salesassociate
 * 
 * @author khnemu11
 *
 */
public class SalesAssociate {
	String name=null; //declare and initialize name;
	double sales=0; //declare and initialize sales

	/**
	 * set name value
	 * @param name
	 */
	void setName(String name) {
		this.name=name; //save input value in this.name
	}
	/**
	 * set sales value
	 * @param sales
	 */
	void setSales(double sales) {
		this.sales=sales; ///save input value in this.sales
	}
	/**
	 * return this.name
	 * @return this.name
	 */
	String getName() {
		return this.name; //return this.name
	}
	/**
	 * return this.sales
	 * @return this.sales
	 */
	double getSales() {
		return this.sales; //return this.sales
	}
}