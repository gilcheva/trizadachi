package com.company;

import java.util.Scanner;

public class SumOfPositives {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double sum = 0;
        double min = Double.MAX_VALUE;
        double max = -1;
        while (true) {
            System.out.print("Въведете положително число: ");
            double positiveNumber;
            try {
                positiveNumber = Integer.parseInt(scanner.nextLine());
                if (positiveNumber > 0) {
                    sum += positiveNumber;
                    min = Math.min(min, positiveNumber);
                    max = Math.max(max, positiveNumber);
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Не сте въвели число.");
            }
        }
        if (sum == 0) {
            System.out.println("Не е въвеждано положително число.");
        } else {
            System.out.println(String.format("Сумата на въведените числа е: %.2f", sum));
            System.out.println(String.format("Най-голямото въведено число е: %.2f", max));
            System.out.println(String.format("Най-малкото въведено число е: %.2f", min));

        }

    }
}
