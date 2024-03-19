package vv;


import java.util.Scanner;

public class chatrobot
{
    public static void main(String[] args) 
	{
		String temp="";
		Scanner sc = new Scanner (System.in);
		System.out.println("我是聊天機器人，你可以跟我說話");
        while(true)
        {
        	System.out.println("你說 : ");
        	temp = sc.nextLine();
        	
        	if (temp.equals("0"))
        	{
        		System.out.println("exit system");
        		break;
        	}
        	
        	System.out.println("我說 : ");
        	String resultString = temp.replace("嗎","").replace("?","!").replace("你","我").replace("你能","我能").replace("你會","我會");
        	System.out.println(resultString);

        }
	}
}

