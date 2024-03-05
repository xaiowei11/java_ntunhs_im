package mm;

import java.util.InputMismatchException;
import java.util.Scanner;

public class cc
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner (System.in);
		System.out.println("Welcome to use health system");
		System.out.println("Do you have fever");
		String fever = sc.next();
		if (fever.equals("y"))
		{
			System.out.println("What about sick");
			String sick = sc.next();
			if(sick.equals("y"))
			{
				System.out.println("What about tired");
				String tired = sc.next();
				if(tired.equals("y"))
				{
					System.out.println("You gety cold");
				}
				else 
				{
					System.out.println("You have other problem");
				}
			}
			else
			{
				System.out.println("What about high blood");
				String highblood = sc.next();
				if(highblood.equals("y"))
				{
					System.out.println("What about drinkwater");
					String drinkwater = sc.next();
					if(drinkwater.equals("y"))
					{
						System.out.println("You have Liver disease");
					}
					else
					{
						System.out.println("You have other problem");
					}
				}
				else 
				{
					System.out.println("What about water out");
					String waterout = sc.next();
					if(waterout.equals("y"))
					{
						System.out.println("You have lung disease");
					}
					else 
					{
						System.out.print("You have other problem");
					}
					
				}
				
			}
			
		}
		else 
		{
			System.out.print("You are health");
		}
		
	}
}	