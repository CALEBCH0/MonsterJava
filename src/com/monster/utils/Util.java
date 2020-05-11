package utils;

import java.util.Scanner;

public class Util {
    
    public static void print(Object... words) {
        String content = "";
        for (int i = 0; i < words.length; i++) {
            content = content + words[i].toString() + " ";
        }
        System.out.print(content);
    }

    public static void println(Object... words) {
        String content = "";
        for (int i = 0; i < words.length; i++) {
            content = content + words[i].toString() + " ";
        }
        System.out.println(content);
    }

    public String wrap(Object... words) {
        String sum = "";
        for (int i = 0; i < words.length; i++) {
            sum = words[i].toString();
        }
        return sum;
    }

    public static String trueInput() {
        Scanner scanner = new Scanner(System.in);
        boolean trueInput = false;
        String input = "";
        while (!trueInput) {
            char[] numbers = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
            
            input = scanner.nextLine();
            char[] inputs = input.toCharArray();
            for (char piece : inputs) {
                for (int i = 0; i < numbers.length; i++) {
                    if (piece == numbers[i]) {
                        trueInput = true;
                        break;
                    } else {
                        trueInput = false;
                    }
                }
            }
            if (!trueInput) {
                Util.println("Invalid input. Please enter a number.");
            }
        }
        return input;
    }

    public static String trueInput(char[] target) {
        Scanner scanner = new Scanner(System.in);
        boolean trueInput = false;
        String input = "";

        while (!trueInput) {            
            input = scanner.nextLine();
            char[] inputs = input.toCharArray();
            for (char piece : inputs) {
                for (int i = 0; i < target.length; i++) {
                    if (piece == target[i]) {
                        trueInput = true;
                        break;
                    } else {
                        trueInput = false;
                    }
                }
            }
            if (!trueInput) {
                String text = "";
                for (int i = 0; i < target.length-1; i++) {
                    text = text + target[i] + ", ";
                }
                text = text + target[target.length-1];
                Util.println("Invalid input. Please enter " + text + ".");
            }
        }
        return input;
    }
}