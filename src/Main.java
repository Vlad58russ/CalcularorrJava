import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("Введите два числа до 10 и знак операции: " + "\nInput: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        calc(input);
    }

    public static String calc(String input) throws Exception {
        String[] actionSign = new String[]{"+", "-", "/", "*"};
        String[] regexActions = {"\\+", "-", "/", "\\*"};
        int actionIndex = -1;
        for (int i = 0; i < actionSign.length; i++) {
            if (input.contains(actionSign[i])) {
                actionIndex = i;
                break;
            }
        }

        if (actionIndex == -1) {
            throw new Exception("Не найден знак операции");
        }

        String[] arrStr = input.split(regexActions[actionIndex]);
        if (arrStr.length != 2) {
            throw new Exception("Вы ввели не 2 числа");
        }

        int num1;
        int num2;

        num1 = Integer.parseInt(arrStr[0]);
        num2 = Integer.parseInt(arrStr[1]);

        if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
            throw new Exception("Числа должны быть от 1 до 10");
        }

        int result = 0;
        switch (actionSign[actionIndex]) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 == 0) {
                    throw new Exception("На ноль делить нельзя");
                }
                result = num1 / num2;
                break;
        }
        System.out.println("Output:\n" + result);
        return input;
    }
}