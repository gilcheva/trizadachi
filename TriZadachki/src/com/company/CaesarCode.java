package com.company;

import java.util.Scanner;


public class CaesarCode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        System.out.print("Моля напишете C за криптиране, D за декриптиране: ");
        try {
            char choice = scanner.nextLine().toLowerCase().charAt(0);
            if (choice != 'c' && choice != 'd') {
                throw new IllegalArgumentException("Допустимите символи са само 'c' и 'd' на латиница.");
            }
            System.out.println("Въведете кода: ");
            int n = Integer.parseInt(scanner.nextLine());
            System.out.println("Въведете текста за обработка на латиница: ");
            String text = scanner.nextLine();
            if (choice == 'c') {
                crypt(alphabet, n, text);
            } else {
                decrypt(alphabet, n, text);
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Кодът трябва да е цяло положително число.");
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }

    }

    public static void crypt(char[] alphabet, int n, String text) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            int index = -1;
            for (int j = 0; j < alphabet.length; j++) {
                if (text.toUpperCase().charAt(i) == alphabet[j]) {
                    index = j;
                    break;
                }
            }
            if (index < 0) {
                throw new IllegalArgumentException("Допустими за криптиране са само символи от азбуката на латиница.");
            }
            if (index + n < alphabet.length) {
                sb.append(alphabet[index + n]);
            } else {
                sb.append(alphabet[(index + n) % alphabet.length]);
            }
        }
        System.out.printf("Криптирания текст е: %s", sb);
    }

    public static void decrypt(char[] alphabet, int n, String text) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            int index = -1;
            for (int j = 0; j < alphabet.length; j++) {
                if (text.toUpperCase().charAt(i) == alphabet[j]) {
                    index = j;
                    break;
                }
            }
            if (index < 0) {
                throw new IllegalArgumentException("Допустими за декриптиране са само символи от азбуката на латиница.");
            }
            if ((index - n) >= 0) {
                sb.append(alphabet[index - n]);
            } else if (Math.abs(index-n)<alphabet.length){
                sb.append(alphabet[alphabet.length + index - n]);
            } else {
                sb.append(alphabet[alphabet.length+((index - n) % alphabet.length)]);
            }
        }
        System.out.printf("Декриптирания текст е: %s", sb);
    }
}
