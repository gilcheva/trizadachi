package com.company;

import java.util.Scanner;

public class PrintPatterns {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        System.out.print("Въведете размер на фигурата: ");
        int size = 0;
        try {
            size = Integer.parseInt(scanner.nextLine());
            if (size <= 0 || size % 2 == 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Размерът трябва да въведете цяло положително нечетно число.");
        }
        System.out.print("Изберете a, b или c желаете да е вида на фигурата: ");
        char figureType = 'x';
        try {
            figureType = scanner.nextLine().toLowerCase().charAt(0);
            if (figureType == 'a') {
                printA(sb, size);
            } else if (figureType == 'b') {
                printB(sb, size);
            } else if (figureType == 'c') {
                printB(sb,size-1);
                printA(sb,size);
            } else {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException iae) {
        System.out.println("Възможностите са само a/b/c.");
    }
        System.out.println(sb.toString());
}


    private static void printA(StringBuilder sb, int size) {
        int start = 0;
        int end = size;
        while (start<=size/2) {
            formFigure(sb,start,end);
            end--;
            start++;
        }
    }

    private static void printB(StringBuilder sb, int size) {
        int start = size/2;
        int end = size/2+1;
        while (end<=size) {
            formFigure(sb,start,end);
            start--;
            end++;
        }
    }

    private static void formFigure (StringBuilder sb, int start, int end) {
            for (int i = 0; i < start; i++) {
                sb.append(" ");
            }
            for (int i = start; i < end; i++) {
                sb.append("#");
            }
            sb.append(System.lineSeparator());
    }
}
