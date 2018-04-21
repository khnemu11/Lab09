package edu.handong.csee.java.lab09; // package edu.handong.csee.java.lab09
import java.util.ArrayList; //import that for using arraylist
import java.util.Scanner; // import java.util.Scanner to use scanner

/**
 * do get data and compute average and the highest sales and display the values
 * @author khnemu11
 *
 */
public class SalesReporter {
	private double highestSales; //declare private, double highestSales
	private double averageSales; //declare private, double averageSales
	private ArrayList<SalesAssociate> team; //declare private array, team in SalesAssociate
	/**
	 * get data,name and sales, and save in array team of SalesAssociate
	 */
	public void getData(){
		Scanner myScanner = new Scanner(System.in); //make object of Scanner
		team= new ArrayList<SalesAssociate>(); //make arraylist
		
		System.out.println("Enter items for the list, when prompted");
		//ask the maximum size of team;
		
		while(true) {
			SalesAssociate information = new SalesAssociate(); //instantiation information following by SalesAssociate
			
			System.out.print("Enter name of sales associate: "); //ask name
			information.setName(myScanner.nextLine()); //save name in information.name
			
			System.out.print("Enter associate's sales: $"); //ask sales
			information.setSales(myScanner.nextDouble()); //save sales in information.sales
			String stop=myScanner.nextLine(); //buffter of stop that is variable for stop or continue this loop.
			
			team.add(information); //add information to team
			
			while(true) {
				System.out.print("More items for the list? "); //ask more inputing item
				stop=myScanner.nextLine(); //variable for stop or continue
				
				if("yes".equals(stop)==true)	break; //if it is yes, break and repeat upper loop
				else if("no".equals(stop)==true)	return;// if it is no, finish method, getdata()
				else {
					System.out.println("you can input only yes or no"); //if stop is neither yes nor no, print this.
					continue; //ask one more
				}
			}
		}
	}
	/**
	 * calculate average and the highest sales
	 */
	public void computeStats(){
		int total=0; //declare and initialize total
		 
		for(SalesAssociate sales:team) total+=sales.getSales(); //calculate total sales until end of team
		
		averageSales=(double)total/team.size(); //calculate averagesales
		highestSales=0; //initialize the highest sales value
		
		for(SalesAssociate sales:team) { //loop for find highest sales in team
			if(highestSales<sales.getSales())	highestSales=sales.getSales(); //save the highest sales 
		}
	}
	/**
	 * display result of all values
	 */
	public void displayResults() {
		System.out.println("Average sales per associate is $"+averageSales); //show average
		System.out.println("The highest sales figure is $"+highestSales); //show the highest sales
		for(SalesAssociate information:team) { //repeat to show the highest salesman
			if(information.getSales()==highestSales) { //find until the highest sales
				System.out.println("The following had the highest sales:"); //show that sentence
				System.out.println("name: "+information.getName()); //show the highest salesman's name
				System.out.println("Sales: $"+information.getSales()); //show the highest salesman's sales 
				System.out.println("$"+Math.round(information.getSales()-averageSales)+" above the average."); //show sales compare with average
				break; //break
			}
		}
		System.out.println("The rest performed as follows"); //show rest value
		for(SalesAssociate information:team) { //repeat until show all rests
			if(information.getSales()==highestSales) continue; //if the value is the highest, ignore
			else { //if not
			System.out.println("name: "+information.getName()); //show name
			System.out.println("Sales: $"+information.getSales());//show sales
			
			if(information.getSales()>averageSales)	System.out.println("$"+Math.round(information.getSales()-averageSales)+" above the average."); //if his sales is upper than average, show average to sales-average
			else System.out.println("$"+Math.round(averageSales-information.getSales())+" below the average."); ////if his sales is under than average, show average to average-sales
			}
		}		
	}
}
