package hello;

import java.lang.Math;
import java.util.Scanner;

public class hello{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner (System.in);
		double fv;
		int pv;
		double interest=0.05;
		int interval;
		
		System.out.print("enter your PV");
		pv=sc.nextInt();
		
		/*System.out.println("enter your interest");
		interest=sc.nextDouble();*/
		
		System.out.print("enter your interval");
		interval=sc.nextInt();
		
		fv=pv*Math.pow((1+interest), interval);
		
		System.out.println("My PV is " +pv+ " and after "+interval+" year it would be "+fv);
		
		sc.close();
		
	}
}
