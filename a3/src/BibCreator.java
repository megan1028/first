
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.util.Scanner;
import java.util.StringTokenizer;
/**
 * Mengyi Yang 
 * <p>ID 40048192
 * <p> Section COMP 249 U
 * <p> Assignment 3
 * <p> Due date March 19, 2018
 */
//------------------------------------------------------- 
//Assignment 3
//Written by: (Mengyi Yang, 40048192) 
//For COMP 249 Section (U) ¨C Winter 2018
//by one student
//-------------------------------------------------------
public class BibCreator {
	static Scanner sc=null;
/**
 * 	
 * @param args
 */
	public static void main(String[] args)   {
		Scanner sc=null;
		PrintWriter pw=null,pwI=null,pwA=null;
	    int i=0;
		System.out.println("Welcome to BibCreator!");
		
		//open the file, if it doesn't exist, then close and exit.------------------------
		try {
			//for(i=1;i<11;i++)  // total 10 files
				sc=new Scanner(new FileInputStream("Syllabus.txt"));
	         }	  
			catch(FileNotFoundException e) {
				System.out.println("¡°Could not open input file Latex"+i+ " for reading. "+"\nPlease check if file exists!"
						+ " Program will terminate"+"after closing any opened files.¡±");
				sc.close();
				System.exit(0);
           	} 
		  catch (IOException e) {
				System.out.println("Error: An error has occurred while reading from the file. ");
				System.out.println("Program will terminate.");
				sc.close();
				System.exit(0);
		    	}
		
		//Create IEEE output files-----------------------------------
		int a=0;
		
	   try {
		   
			for(a=1;a<11;a++)
			 {
				 pwI=new PrintWriter(new FileOutputStream("IEEE"+a+".json"));
				 
				 try { 
				     pwA=new PrintWriter(new FileOutputStream("ACM"+a+".json"));
				     
				     try {
				    	pw=new PrintWriter(new FileOutputStream("NJ"+a+".json"));
				    	
				     }
				     catch(FileNotFoundException e) {
				    	  pw.close();
				    	  pwI.close();
				    	  pwA.close();
							System.out.println("Error: NJ"+a+".json can't be opened/created.");
							for(int b=1;b<a;b++) {//deleter the files
								File file1=new File("IEEE"+b+".json");
								File file2=new File("ACM"+b+".json");
								File file3=new File("NJ"+b+".json");
								if(file1.exists())
									file1.delete();
									if(file2.exists())
									file2.delete();
									if(file3.exists())
									file3.delete();
								sc.close();
								System.exit(0);
				          }
							
				        }
				     pw.close();
			    	  pwI.close();
			    	  pwA.close();
				    
				 }
				 catch(FileNotFoundException e) {
					 pw.close();
			    	  pwI.close();
			    	  pwA.close();
						System.out.println("Error: NJ"+a+".json can't be opened/created.");
						for(int b=1;b<a;b++) {//deleter the files
							File file1=new File("IEEE"+b+".json");
							File file2=new File("ACM"+b+".json");
							File file3=new File("NJ"+b+".json");
							if(file1.exists())
								file1.delete();
								if(file2.exists())
								file2.delete();
								if(file3.exists())
								file3.delete();
							sc.close();
							System.exit(0);
			          }
			 }
	   }
			
	   }
		catch(FileNotFoundException e) {
			 pw.close();
	    	  pwI.close();
	    	  pwA.close();
			System.out.println("Error: IEEE"+a+".json can't be opened/created.");
			for(int b=1;b<a;b++) {//deleter the files
				File file1=new File("IEEE"+b+".json");
				File file2=new File("ACM"+b+".json");
				File file3=new File("NJ"+b+".json");
				if(file1.exists())
				file1.delete();
				if(file2.exists())
				file2.delete();
				if(file3.exists())
				file3.delete();
				sc.close();
				System.exit(0);
          }
		}
		catch(IOException e) {
			System.out.println("Error");
			sc.close();
			System.exit(0);
			}
	   pw.close();
 	  pwI.close();
 	  pwA.close();
	   
	   
	   
	//For task 4----------------
		int d=0;
		int fail=0;
		for(d=1;d<11;d++) {     //catch exception cannot stop the program
		try {
				processFilesForValidation(d);
				  
				}
		catch(FileInvalidException e) {//delete-------------------------------
			
				fail++;
			File outFile=new File("IEEE"+d+".json");
		if(!outFile.delete())
				System.out.println("Can't be deleted.");
			File outFile1=new File("ACM"+d+".json");
		if(!outFile1.delete())
			System.out.println("Can't be deleted.");
			File outFile2=new File("NJ"+d+".json");
			if(!outFile2.delete())
				System.out.println("Can't be deleted.");
		
            			
			System.out.println( "\n\nError: Detected Empty Field!\n"+
			           "----------------------------\n"	 );
			System.out.println("Problem detected with input file: Latex"+d+".bib");
			System.out.println(e.getMessage());
			} catch (FileNotFoundException e) {
				System.out.println("Can't find the file.");
		}
		}
		
		System.out.println("\n\nA total of "+fail+" were invalid, and could not be processed. All other "+(10-fail)+" \"valid\" files have been created.\n\n");
		
		
		//For task 5------------------------
		int enter=0;
		boolean r=true;
		while(enter<2&&r) {
		System.out.print("Please enter the name of one of the files that you want to review:");
		sc=new Scanner(System.in);
		String review=sc.nextLine();
		try {
			sc=new Scanner(new FileInputStream(review));
			r=!r;
			System.out.println("Here are the contents of the successfully created Jason File:"+review);
			while(sc.hasNextLine())
			System.out.println(sc.nextLine());
			
			System.out.println("\nGoodbye! Hope you enjoyed creating the needed files using BibCreater.");
		}
		catch(FileNotFoundException e) {
			enter++;
			if(enter<2)
		     {
				System.out.println("Could not open input file. File does not exist; possibly it could not be created!");
				System.out.println("\n\nHowever, you will give another chance to enter another file name.");
		     }
			else
			{
				System.out.println("Could not open input file again! Eithier file does not exist or could not be created!");	
				System.out.println("Sorry! I am unable to display your desired files! Program will exit!");
				System.exit(0);
			}	
		}
		}}
		
	/**
	 * If the file is valid, write it into files.
	 * @param f
	 * @throws FileNotFoundException
	 * @throws FileInvalidException
	 */
	//For task 4--------------------Write a method called processFilesForValidation(). 
	public static void  processFilesForValidation(int f) throws FileNotFoundException, FileInvalidException {
		Scanner sc=null;
		String arr,word=null,IEEE=null,ACM=null,NJ=null, first=null;
		String IA="null", AA=null, NA=null; //author
		String journal=null,title=null,year=null,volume=null,number=null,pages=null,keywords=null;
		String doi=null,ISSN=null,month=null;
		int i=0;
		int count=0;
		int num=0;
		boolean valid=true,stop=true;
		PrintWriter pw=null,pw1=null,pw2=null;
		String arr_content,name;
		
		// The file is invalid----------------------------------
		sc=new Scanner(new FileInputStream("Latex"+f+".bib"));
		 
		for(;valid&&stop;)  {    //determine whether this file has another content or not
			if(sc.hasNextLine()) {
			arr=sc.nextLine();
		 if(arr.indexOf('=')!=-1)// For the total 11 lines
			{   
					name=new String(arr.substring(0,arr.indexOf('='))); //word before =
					arr_content=new String(arr.substring(arr.indexOf('{')+1,arr.lastIndexOf('}')));
					//  System.out.println(arr_content+name);
					if(arr_content.length()<=0||arr_content.equals(" "))
					{  valid=false;
					   sc.close();
					   throw new FileInvalidException(name);
			    }
				
			}
			 }
			else
				stop=false;
		}
		 sc.close();
		 int m=0; 
		if(valid) {
			   pw=new PrintWriter(new FileOutputStream("IEEE"+f+".json"));
			   pw1=new PrintWriter(new FileOutputStream("ACM"+f+".json"));
				pw2=new PrintWriter(new FileOutputStream("NJ"+f+".json"));
			sc=new Scanner(new FileInputStream("Latex"+f+".bib"));
			while(sc.hasNextLine())  {    //determine whether this file has another content or not
				arr=sc.nextLine();
			 if(arr.indexOf('=')!=-1)// For the total 11 lines
				{      
						num++;		
						name=new String(arr.substring(0,arr.indexOf('='))); //word before =
						arr_content=new String(arr.substring(arr.indexOf('{')+1,arr.lastIndexOf('}')));
				switch(name)
							{case "author": if( arr_content.contains("and")) {
							  		        arr_content=arr_content.replace(" and","#");							  		       
								            StringTokenizer stknz1 = new StringTokenizer(arr_content,"#"); 
								               count = stknz1.countTokens();
								              first=stknz1.nextToken();
								                 AA=first+" et al.";
							            	    IA=NA=first+",";
								            	   for(int j=2;j<count;j++)
								            	{ 
								            	   word=stknz1.nextToken()+",";
					                               IA+=word;
					                               NA+=word+"&";
								                }
								               word=stknz1.nextToken()+".";//the last author
								               IA+=word;//author content of IEEE
								               NA+=word;//author content of NJ
								               }
							                 else {
							                	NA= IA= arr_content+".";
							                	 AA= arr_content+" et al.";
							                	 
							                 }
								               break;
							  	case "journal": journal=arr_content;
							  	                break;
							  	case "title":title=arr_content;
							                  	break;
							  	case "year":year=arr_content;
							  	            break;
							  	case "volume":volume=arr_content;
							  	           break;
							  	case "number":number=arr_content;
							  	               break;
							  	case "pages":pages=arr_content;
							  	             break;
							  	case "keywords":keywords=arr_content;
							  	                break;
							  	case "doi":doi=arr_content;
							  	           break;
							  	case "ISSN":ISSN=arr_content;
							  	              break;
							  	case "month":month=arr_content;
								}
                             }
			     if(num==11) {
			    	 num=0;
			    	 m++;
					pw.println(IA+" \""+title+"\", "+journal+", vol. "+volume+", no. "+number+", p. "+pages+", "+month+" "+year+".");
					
					pw1.println("["+m+"]  "+AA+" "+year+". "+title+". "+journal+". "+volume+", "+month+" ("+year+") , "+pages+". DOI:https://doi.org/"+doi+".");
				
					pw2.println(NA+" "+title+". "+journal+". "+volume+", "+pages+" ("+year+").");
					
					}
					
			}
		
	}
		pw.close();
		pw1.close();
		pw2.close();
		sc.close();
		} 
    }



