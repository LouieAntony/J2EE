package missed;

import java.util.*;
import java.util.Scanner;

public class missed {
	
	public static void main(String args[])
	{
		int a;String b;
		HashMap<String,Integer> m=new HashMap<>();
		Scanner sc=new Scanner(System.in); 
		System.out.println("Enter number of numbers");
		int n=sc.nextInt();
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter number ");
			a=sc.nextInt();
			Scanner sc1=new Scanner(System.in);
			System.out.println("Enter name ");
			b=sc1.nextLine();
			m.put(b,a);
		}
		System.out.println("Enter number of missed calls");
		n=sc.nextInt();
		ArrayList<Integer> d=new ArrayList<Integer>();
		for(int i=0;i<n;i++)
		{
			if(i>10)
			{
				d.remove(0);
			}
			System.out.println("Enter number ");
			a=sc.nextInt();
			d.add(a);	
		}
		System.out.println(d);
		while(true)
		{
			System.out.println("Enter option ");
			System.out.println("1. Delete missed call ");
			System.out.println("2. Display missed call");
			System.out.println("3. Exit ");
	        int c=sc.nextInt();
	        switch(c)
	        {
	        case 1:
	        	System.out.println("Enter number ");
	        	int v=sc.nextInt();
	        	for(int i=0;i<d.size();i++)
	        		if(v==d.get(i))
	        			d.remove(i);
	        	break;
	        case 2:
	        	System.out.println(d);
	        	break;
	        default :
	        	System.exit(0);	
	        	break;
	        }
		}	 
	}
}
