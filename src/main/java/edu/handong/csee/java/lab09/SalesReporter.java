package edu.handong.csee.java.lab09; // package edu.handong.csee.java.lab09
 
import java.util.Scanner; // import java.util.Scanner to use scanner

/**
 * do get data and compute average and the highest sales and display the values
 * @author khnemu11
 *
 */
public class SalesReporter {
	private double highestSales; //declare private, double highestSales
	private double averageSales; //declare private, double averageSales
	private SalesAssociate[] team; //declare private array, team in SalesAssociate
	private int numberOfAssociates; //declare private the maximum size of team
	/**
	 * get data,name and sales, and save in array team of SalesAssociate
	 */
	public void getData(){
		Scanner myScanner = new Scanner(System.in); //make object of Scanner
		
		System.out.print("Enter number of sales associate: "); //ask the maximum size of team;
		numberOfAssociates=myScanner.nextInt(); //save in numberOfAssociates to Scanner
		
		team= new SalesAssociate[numberOfAssociates] ; //make array which size is numberOfAssociates
		
		for(int i=0; i<numberOfAssociates;i++) { //repeat under until i is bigger than numberOfAssociates
			team[i]=new SalesAssociate(); //make object, team[i], in SalesAssociate

			System.out.println("Enter data for associate number "+(i+1)); //show the count of associate number
			System.out.print("Enter name of sales associate: "); //ask name
			team[i].setName(myScanner.nextLine()); //buffer of Scanner. because nextLine is response upper enter.
			team[i].setName(myScanner.nextLine()); //save name in team[i].name
			
			System.out.print("Enter associate's sales: $"); //ask sales
			team[i].setSales(myScanner.nextDouble()); //save sales in team[i].Sales
		}
	}
	/**
	 * calculate average and the highest sales
	 */
	public void computeStats(){
		int total=0; //declare and initialize total
		 
		for(int i=0;i<numberOfAssociates;i++) total+=team[i].sales; //repeat to sum all sales
		
		averageSales=(double)total/numberOfAssociates; //divide total to numberOfAssociates
		
		highestSales=team[0].sales; //initialize the highest sales value
		
		for(int i=1;i<numberOfAssociates;i++) { 
			if(highestSales<team[i].sales)	highestSales=team[i].sales; //find the highest sales 
		}
	}
	/**
	 * display result of all values
	 */
	public void displayResults() {
		System.out.println("Average sales per associate is $"+averageSales); //show average
		System.out.println("The highest sales figure is $"+highestSales); //show the highest sales
		for(int i=0; i<numberOfAssociates;i++) { //repeat to show the highest salesman
			if(team[i].sales==highestSales) { //find until the highest sales
				System.out.println("The following had the highest sales:"); //show that sentence
				System.out.println("name: "+team[i].name); //show the highest salesman's name
				System.out.println("Sales: $"+team[i].sales); //show the highest salesman's sales 
				System.out.println("$"+Math.round(team[i].sales-averageSales)+" above the average."); //show sales compare with average
				break; //break
			}
		}
		System.out.println("The rest performed as follows"); //show rest value
		for(int i=0;i<numberOfAssociates;i++) { //repeat until show all rests
			if(team[i].sales==highestSales) continue; //if the value is the highest, ignore
			else { //if not
			System.out.println("name: "+team[i].name); //show name
			System.out.println("Sales: $"+team[i].sales);//show sales
			
			if(team[i].sales>averageSales)	System.out.println("$"+Math.round(team[i].sales-averageSales)+" above the average."); //if his sales is upper than average, show average to sales-average
			else System.out.println("$"+Math.round(averageSales-team[i].sales)+" below the average."); ////if his sales is under than average, show average to average-sales
			}
		}		
	}
}
