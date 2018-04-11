package edu.handong.csee.java.lab09; //package edu.handong.csee.java.lab09 

/**
 *main class that can show and get data of names and sales
 * @author khnemu11
 *
 */
public class main {
	/**
	 * main function 
	 * @param args that can show and get data of names and sales
	 */
	public static void main(String[] args) {
		SalesReporter myReporter = new SalesReporter(); //make object of SalesReporter
		myReporter.getData();		//imply getData
		myReporter.computeStats(); //imply computeStats
		myReporter.displayResults(); //imply displayResults
	}	
}