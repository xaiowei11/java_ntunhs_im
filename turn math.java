package mm;

import java.util.Scanner;

public class bb {
	public static void main(String[] args) {
	      Scanner sc = new Scanner(System.in);
	        int idx=0;
	        int num ;
	        
	        System.out.println("Enter array");
	        num = sc.nextInt();
	        
	        int arr[] = new int [num];
	        
	        System.out.println("Enter math");
	        
	        for (int i = 0; i < num; i++) {
	            arr[i] = sc.nextInt();
	        }

	        idx = num-1;
	        
	        while (idx >= 0 && idx < num) {
	            System.out.printf("%d ",  arr[idx]);
	            idx--;
	        }

	        // 關閉掃描器以避免資源洩漏
	        sc.close();
	    }
	}