package aa;

import java.util.Scanner;

public class HW5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StoreValueCard card = new StoreValueCard("ntunhs001", 1000, 0);

        int choice = -1;
        while (choice != 0) {

            System.out.print("which function you need 1.addValue 2.charge 3.exchange Bouns 4.Card Deatils 0.exit:");
            choice = sc.nextInt();
            if (choice==1) {
                //System.out.println("You have chosen to top up your EasyCard.");
                card.addValue(sc);
            } else if (choice==2) {
                //System.out.println("You have chosen to use your EasyCard to pay for something.");
                card.charge(sc);
            } else if (choice==3) {
                //System.out.println("You have chosen to exchange your EasyCard points for bonuses.");
                card.exchangeBonus(sc);
            } else if (choice==4) {
                //System.out.println("You have chosen to view your EasyCard details.");
                System.out.printf("(EasyCard ID: %s , Balance: %d , Bonus Points: %d)\n", card.getCardID(), card.getBalance(), card.getBonus());
            } else if (choice==0) {
                System.out.println("Thank you for using EasyCard. Goodbye!");
                System.exit(0);
            } else {
                System.out.println("Invalid choice. Please enter a valid command from the list.");
            }
        }
        sc.close();
    }
}

class StoreValueCard {

	static int totalCardNum=0;
    private String cardID;
    private int balance;
    private int bonus;

    public StoreValueCard(String cardID, int balance, int bonus) {
        this.cardID = cardID;
        this.balance = balance;
        this.bonus = bonus;
        totalCardNum++;
    }

    public Scanner getScanner() { // Not recommended (explained below)
        return new Scanner(System.in);
    }

    public void addValue(Scanner sc) {
        System.out.print("enter addValue:");
        int amount = sc.nextInt();
        if(amount >0)
        {
        	this.balance += amount;
	        if(amount>=1000)
	        {
	        	this.bonus++;
	        }
        }
        else 
        {
        	System.out.printf("enter + number");
        }
        System.out.printf("Your new balance is: %d\n", this.balance);
    }


    public void charge(Scanner sc) {
        System.out.print("enter charge:");
        int amount = sc.nextInt();
        if (amount > 0)
        {
        	if (amount < this.balance) 
        	{
        		this.balance -=amount;
        	}
        	else 
        	{
        		System.out.println("You don't have enough balance");
        	}
        } 
        else 
        {
        	System.out.println("enter +num");
        }
        System.out.printf("Your new balance is: %d\n", this.balance);
    }

    public void exchangeBonus(Scanner sc) {
    	System.out.print("Type your excharge bonus amount:");
        int amount = sc.nextInt();
        if (amount > this.bonus) {
            System.out.println("You don't have enough bonus");
        } else if(amount < 0){
            	System.out.printf("Amount can't be minus.");
        }else 
        {
        	System.out.printf("sucessful change");
           this.bonus -= amount;
        }
    }
    
    public void printDetalis()
    {
		System.out.printf("(%s, %d, %d)%n",this.cardID, this.balance, this.bonus);
    }

    public String getCardID() {
        return cardID;
    }

    public int getBalance() {
        return balance;
    }

    public int getBonus() {
        return bonus;
    }
}
