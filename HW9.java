package score;

import java.util.Scanner;
import java.util.Arrays;

public class HW9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 提示用户输入
        System.out.println("Type numbers:");
        String input = scanner.nextLine();

        // 将输入内容拆分成字符串数组
        String[] inputs = input.split(" ");

        // 创建一个整数数组来存储用户输入的数字
        int[] numbers = new int[inputs.length];

        // 将字符串数组转换为整数数组
        for (int i = 0; i < inputs.length; i++) {
            numbers[i] = Integer.parseInt(inputs[i]);
        }

        // 使用 Arrays 类中的 sort 方法对数组进行排序
        Arrays.sort(numbers);

        // 打印排序后的数组
        System.out.println("The number array:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();

        // 计算最大值、最小值和平均值
        int maxValue = numbers[numbers.length - 1];
        int minValue = numbers[0];
        double sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        double averageValue = sum / numbers.length;

        // 打印结果
        System.out.println("MAX:" + maxValue);
        System.out.println("MIN:" + minValue);
        System.out.println("AVERAGE:" + averageValue);

        scanner.close();
    }
}