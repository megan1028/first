

public class CarList
{
	private class Node
	{
		private Car cr;
		private Node next;	// A link to the next node, which is of type Node1
		
		// Default constructors 
		public Node()
		{
			cr = null;
			next = null;
		}
		
		
		// Parameterized constructor 
		public Node(Car c, Node xt)
		{
			cr = c;	// Notice the "=" here. Is there any privacy leak? 
// Why not use cr = c.clone();
			next = xt;	// Will that insert the right object in the node? 
// Will more Cars be created in such case?
		}
		
		// A copy constructor 
		public Node(Node cn)
		{
			cr = cn.cr.clone();	// Deep copy the Car contents of the node
			next = cn.next;		// Is that okay? Would next = null; 
// conform to a copy constructor operation?
			
		}
		

		
	} // end of inner class Node

	private Node head;
	
	public CarList()
	{
		head = null;
	}
	
	
	// copy constructor
	public CarList(CarList lst)
	{
		
		if(lst.head == null)
			head = null;
		else
		{
			head = null;	
			Node t1, t2, t3;	// create 3 temporary pointers
			
			t1 = lst.head;
			t2 = t3 = null;
			
			while(t1 != null)				
{
				
				if (head == null)	// this happens only once
				{
					t2 = new Node(t1.cr.clone(),null); 
						head = t2;
// can we use t2 = new Node(t1.cr.clone(), null) for   Instance as an alternative?
				}
				else 
				{
					t3 = new Node(t1);											t2.next = t3;					
					t2 = t3;												}
				t1 = t1.next;
			}
			
			t2 = t3 = null; 	// t1 is already null by now
					
		}
			
	}
	
	
	public CarList clone()
	{
		return new CarList(this);
	}
	
	
	// A method that adds an node to the start of the list 	
	public void addToStart(Car c)
	{
		Node n = new Node((Car)c.clone(), head);	     
		head = n; 						
		n = null;						
	}
	
	
	
	public Node find(long sn)
	{
		Node t = head;
		while(t != null)
		{
			if (t.cr.getserialNumber() == sn)
				return t;		// Is that dangerous ?????? 
			t = t.next;
		}
		return null;			// value was not found in the list
	}

	
	// A method to return the size of the list
		public int size()
		{
			int ctr = 0;
			Node temp = head;	// Point to the start of the list
			while( temp!= null)
			{
				ctr++;
				temp = temp.next;
			}
			return ctr;
		}

		// A method that indicates whether or not a value is in the list
		public boolean contains(long sn)
		{
			if(find(sn) != null)
				return true;
			else 
				return false;
		}

		

		public void showListContents()
		{
			Node temp = head;
			if (temp == null)
				System.out.println("\nThere is nothing to display; list is                                             empty." );
			else
				System.out.println("\nHere are the contents of the list." );
			while(temp != null)
			{
				System.out.println(temp.cr + " ---> ");
				temp = temp.next;		
			}
			System.out.println("X");			}
}