

public class Car implements Cloneable{

	// Attributes
	private int numOfDoors;
	private double price;
	private long serialNum;
	private static long serialNumCtr = 3000;
	
	// Constructors
	public Car()	// default constructor 
	{
		numOfDoors = 4;
		price = 10000;
		serialNum = serialNumCtr++;
	}
	
	public Car(int nd, double pr)	
	{
		numOfDoors = nd;
		price = pr;
	
		serialNum = serialNumCtr++;
	}
	
	public Car(Car c)	
	{
		setNumOfDoors(c.numOfDoors);
		setPrice(c.price);

		serialNum = serialNumCtr++;
	}
	
	public int getNumOfDoors()
	{
		return numOfDoors;
	}
	
	public void setNumOfDoors(int nd)
	{
		numOfDoors = nd;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	public long getserialNumber()
	{
		return serialNum;
	}
	
	public void setPrice(double pr)
	{
		price = pr;
	}
	//-----------------
	//---------ATTENTION------------------------------
	////--/////////////////////////////
	public Car clone() {
		Car a=null;
		try {
			a = (Car) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}


	public String toString()
	{
return ("Car with serial number: " + serialNum + " has " + numOfDoors + "         doors and its price is: " + price + "$."); 
	}
			
	
	/*public Car clone()
	{
		return new Car(this);	
	}*/
  // end of Car class


	public static void main(String[] args) {
		
		Car c1 = new Car(4, 12000), c2 = new Car(5, 43000), c3 = new Car(), 
		    c4 = new Car(2, 19000), c5 = new Car(3, 37000), c6 = new Car(2, 52000);

		long sn;
		// Create two lists
		CarList crlst1 = new CarList(), crlst2 = null;
		
		
		System.out.println("A list has been created. Its current size is: " +
                                crlst1.size());
		
		System.out.println("Will add few cars to the list.");
		crlst1.addToStart(c2);
		crlst1.addToStart(c5);
		crlst1.addToStart(c3);
		crlst1.addToStart(c1);
		crlst1.addToStart(c4);
		crlst1.addToStart(c6);		
		
		System.out.println("\nThe list current size is: " + crlst1.size());	
		crlst1.showListContents();

		// Now clone crlst1 to crlst2
		crlst2 = crlst1.clone();
		System.out.println("\nList has been cloned to another. Here are the                                 contents of the cloned list: ");	
		crlst2.showListContents();

	}

}

