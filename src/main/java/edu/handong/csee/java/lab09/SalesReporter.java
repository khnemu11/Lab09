package edu.handong.csee.java.lab09;

import java.util.Scanner;

public class SalesReporter {
	private double highestSales;
	private double averageSales;
	private SalesAssociate[] team;
	private int numberOfAssociates;
	
	public void getData(){
		Scanner myScanner = new Scanner(System.in);
		
		System.out.print("Enter number of sales associate: ");
		numberOfAssociates=myScanner.nextInt();
		
		team= new SalesAssociate[numberOfAssociates] ;
		
		for(int i=0; i<numberOfAssociates;i++) {
			team[i]=new SalesAssociate();

			System.out.println("Enter data for associate number "+(i+1));
			System.out.print("Enter name of sales associate: ");
			team[i].setName(myScanner.nextLine());
			team[i].setName(myScanner.nextLine());
			
			System.out.print("Enter associate's sales: $");
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
		System.out.println("Average sales per associate is $"+averageSales);
		System.out.println("The highest sales figure is $"+highestSales);
		for(int i=0; i<numberOfAssociates;i++) {
			if(team[i].sales==highestSales) {
				System.out.println("The following had the highest sales:");
				System.out.println("name: "+team[i].name);
				System.out.println("Sales: $"+team[i].sales);
				System.out.println("$"+Math.round(team[i].sales-averageSales)+" above the average.");
				break;
			}
		}
		System.out.println("The rest performed as follows");
		for(int i=0;i<numberOfAssociates;i++) {
			if(team[i].sales==highestSales) continue;
			else {
			System.out.println("name: "+team[i].name);
			System.out.println("Sales: $"+team[i].sales);
			
			if(team[i].sales>averageSales)	System.out.println("$"+Math.round(team[i].sales-averageSales)+" above the average.");
			else System.out.println("$"+Math.round(averageSales-team[i].sales)+" below the average.");
			}
		}
	
		
	}
}
