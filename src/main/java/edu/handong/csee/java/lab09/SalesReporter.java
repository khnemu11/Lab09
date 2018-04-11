package edu.handong.csee.java.lab09;

import java.util.Scanner;

public class SalesReporter {
	private double highestSales;
	private double averageSales;
	private SalesAssociate[] team;
	private int numberOfAssociates;
	
	public void getData(){
		Scanner myScanner = new Scanner(System.in);
		team = new SalesAssociate[numberOfAssociates];
		
		System.out.print("Enter number of sales associate: ");
		numberOfAssociates=myScanner.nextInt();

		for(int i=0; i<numberOfAssociates;i++) {
			System.out.println("Enter data for associate number "+(i+1));
			System.out.println("Enter name of sales associate: ");
			team[i].setName(myScanner.nextLine());
			
			System.out.println("Enter associate's sales: $");
			team[i].setSales(myScanner.nextDouble());
		}
	}
	public void computeStats(){
		int total=0;
		
		for(int i=0;i<numberOfAssociates;i++) {
			total+=team[i].sales;
		}
		
		averageSales=(double)total/numberOfAssociates;
		
		highestSales=team[0].sales;
		
		for(int i=1;i<numberOfAssociates;i++) {
			if(highestSales<team[i].sales)	highestSales=team[i].sales;
		}
	}
	public void displayResults() {
		System.out.print("Average sales per associate is $"+averageSales);
		System.out.print("The highest sales figure is $"+highestSales);
		for(int i=0; i<numberOfAssociates;i++) {
			if(team[i].sales==highestSales) {
				System.out.println("The following had the highest sales:");
				System.out.println("name:"+team[i].name);
				System.out.println("Sales: $"+team[i].sales);
				System.out.println("$"+(team[i].sales-averageSales)+"above the average.");
				break;
			}
		}
		System.out.println("The rest performed as follows");
		for(int i=0;i<numberOfAssociates;i++) {
			if(team[i].sales==highestSales) continue;
			else {
			System.out.println("name:"+team[i].name);
			System.out.println("Sales: $"+team[i].sales);
			
			if(team[i].sales>averageSales)	System.out.println("$"+(team[i].sales-averageSales)+"above the average.");
			else System.out.println("$"+(averageSales-team[i].sales)+"below the average.");
			}
		}
	
		
	}
}
