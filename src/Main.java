import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("Введите два числа до 10 и знак операции: " + "\nInput: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        calc(input);
    }

    public static String calc(String input) throws Exception {
        Converter converter = new Converter();
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
        if (converter.isRoman(arrStr[0]) == converter.isRoman(arrStr[1])) {
            int num1;
            int num2;
            boolean isRoman = converter.isRoman(arrStr[0]);
            if (isRoman) {

                num1 = converter.romanToArab(arrStr[0]);
                num2 = converter.romanToArab(arrStr[1]);

            } else {

                num1 = Integer.parseInt(arrStr[0]);
                num2 = Integer.parseInt(arrStr[1]);
            }
            if (num1 > 10 || num2 > 10) {
                throw new Exception("Числа должны быть до 10");
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
            if (isRoman) {
                if (result < 1) {
                    throw new Exception("Римские числа не могут быть отрицательными или '0' ");
                }
                System.out.println("Output:\n" + converter.arabToRoman(result));
            } else {
                System.out.println("Output:\n" + result);
            }

        } else {
            throw new Exception("Числа должны быть в одном формате");
        }
        return input;
    }
}