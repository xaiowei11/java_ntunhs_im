package mm;

import java.util.Random;
import java.util.Scanner;

public class nn
{
	public static void main(String[] args)
	{
		Random rand = new Random();
		int big=100;
		int small=1;
		int ans= rand.nextInt(100)+1;
		int guess = 0;
		Scanner sc=new Scanner (System.in);
		while(true) {
			System.out.println("guess number(ansewr is " + small+"-"+big+")");
			guess=sc.nextInt();
			if (guess < small || guess > big) {
                System.out.println("Error: Number out of range. Please guess a number between " + small + " and " + big);
            }
			else {
			int validate_num=ans-guess;
			if(validate_num>0) {
				System.out.println("too small");
				small=guess;
			}else if (validate_num<0) {
				System.out.println("too big");
				big=guess;
			}else {
				System.out.println("bingo");
				break;
			}
		}	
	}
}
}
