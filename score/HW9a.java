package score;

import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class HW9a {

public static void main(String[] args) {
	int sum = 0;
	String line;
	boolean isLoop = true;
	Set<String> set = new HashSet<>();
	
	while(isLoop) {
		line = input("請輸入手機號碼，如果結束操作請按0:");
		if (line.equals("0"))isLoop = false;
		else {
			set.add(line);
		}
	}
	System.out.println("您輸入的手機號碼數量有:"+set.size()+"個");
	System.out.println(set);
}
 	/*static int input(String prompt) {
    System.out.print(prompt);
    Scanner scanner = new Scanner(System.in);
    int line = scanner.nextInt();
    return line;
    }*/
    static String input(String prompt){
    System.out.print(prompt);
    Scanner scanner = new Scanner(System.in);
    String line = scanner.nextLine();
    return line;
    }
}
