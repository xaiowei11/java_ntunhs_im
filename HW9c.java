package score;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HW9c {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> grades = new HashMap<>();

        boolean running = true;
        while (running) {
            System.out.println("請選擇操作：");
            System.out.println("1. 新增學生成績");
            System.out.println("2. 查詢學生成績");
            System.out.println("3. 修改學生成績");
            System.out.println("4. 刪除學生成績");
            System.out.println("5. 列出所有學生成績");
            System.out.println("0. 退出程式");

            int choice = scanner.nextInt();
            scanner.nextLine(); // 消耗換行符

            switch (choice) {
                case 1:
                    System.out.print("輸入學生姓名：");
                    String newStudentName = scanner.nextLine();
                    System.out.print("輸入學生成績：");
                    int newGrade = scanner.nextInt();
                    grades.put(newStudentName, newGrade);
                    System.out.println("學生成績已新增。");
                    break;
                case 2:
                    System.out.print("輸入要查詢的學生姓名：");
                    String queryName = scanner.nextLine();
                    if (grades.containsKey(queryName)) {
                        System.out.println(queryName + "的成績是：" + grades.get(queryName));
                    } else {
                        System.out.println("未找到" + queryName + "的成績。");
                    }
                    break;
                case 3:
                    System.out.print("輸入要修改的學生姓名：");
                    String modifyName = scanner.nextLine();
                    if (grades.containsKey(modifyName)) {
                        System.out.print("輸入新的成績：");
                        int modifiedGrade = scanner.nextInt();
                        grades.put(modifyName, modifiedGrade);
                        System.out.println(modifyName + "的成績已更新。");
                    } else {
                        System.out.println("未找到" + modifyName + "的成績，無法修改。");
                    }
                    break;
                case 4:
                    System.out.print("輸入要刪除的學生姓名：");
                    String deleteName = scanner.nextLine();
                    if (grades.containsKey(deleteName)) {
                        grades.remove(deleteName);
                        System.out.println(deleteName + "的成績已刪除。");
                    } else {
                        System.out.println("未找到" + deleteName + "的成績，無法刪除。");
                    }
                    break;
                case 5:
                    System.out.println("所有學生成績如下：");
                    grades.forEach((name, grade) -> System.out.println(name + ": " + grade));
                    break;
                case 0:
                    running = false;
                    System.out.println("程式已退出。");
                    break;
                default:
                    System.out.println("輸入無效，請重新輸入。");
                    break;
            }
        }

        scanner.close();
    }
}
