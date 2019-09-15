package DataStructure;

import java.util.Scanner;
import java.util.Stack;

public class yingyong_02_09 {
    public static void cal() {
        Scanner input = new Scanner(System.in);
        Stack<Integer> value = new Stack<>();
        Stack<String> operation = new Stack<>();

        System.out.print("请输入中缀表达式: ");
        String[] expression = formatInput(input.nextLine());
        for (String s: expression) {
            if (s.length() == 0) {
            }else if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                while (!operation.isEmpty() && priorityIsBiggerOrTheSame(operation.peek(), s)) {
                    compute(value, operation);
                }
                operation.push(s);
            }else if (s.equals("(")) {
                operation.push("(");
            }else if (s.equals(")")) {
                while (!operation.peek().equals("(")) {
                    compute(value, operation);
                }
                operation.pop();
            }else {
                value.push(Integer.parseInt(s));
            }
        }
        while (!operation.isEmpty()) {
            compute(value, operation);
        }
        System.out.println(value.pop().toString());
    }

    public static String[] formatInput(String s) {
        String temp = "";

        for (int i = 0; i < s.length(); i++) {
            char c= s.charAt(i);
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                temp += "" + c + "";
            }else {
                temp += c;
            }
        }
        return temp.split("");
    }

    public static void compute(Stack<Integer> value, Stack<String> operation){
        int v1 = value.pop();
        int v2 = value.pop();

        String op = operation.pop();
        switch(op) {
            case "+":
                value.push(v2 + v1);
                break;
            case "-":
                value.push(v2 - v1);
                break;
            case "*":
                value.push(v2 * v1);
                break;
            case "/":
                value.push(v2 / v1);
                break;
        }
    }

    public static boolean priorityIsBiggerOrTheSame(String a, String b){
        String s = "+-*/";
        return (s.indexOf(a) - s.indexOf(b)) >= 2;
    }

    public static void main(String[] args) {
        cal();
    }
}
