import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class mE2 {

	public void mE(){
		System.out.println(3);
	}
	public static void main(String[] args)  {
		Scanner sc=new Scanner(System.in);
		 File r=new File("IEEE5.json");
		    
	     System.out.println(r.delete());
	     try {
		        if (!r.exists())
		            System.out.println("It doesn't exist in the first place."); 
		        else if (r.isDirectory() && r.list().length > 0)
		        	System.out.println("It's a directory and it's not empty.");
		        else
		        	System.out.println("Somebody else has it open, we don't have write permissions, or somebody stole my disk.");
		    } catch (SecurityException e2) {
		       System.out.println("We're sandboxed and don't have filesystem access.");
		    }
	     
		}
}}
