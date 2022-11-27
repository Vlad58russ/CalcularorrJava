import java.util.HashMap;

public class Converter {
    HashMap<Character, Integer> romanKey = new HashMap<>();

    public Converter() {
        romanKey.put('I', 1);
        romanKey.put('V', 5);
        romanKey.put('X', 10);
        romanKey.put('L', 50);
        romanKey.put('C', 100);
    }
    public boolean isRoman(String number) {
        return romanKey.containsKey(number.charAt(0));
    }
    public String arabToRoman(int number) {
        StringBuilder stringBuilder = new StringBuilder();
        while (number > 0) {
            if (number >= 100) {
                stringBuilder.append("C");
                number -= 100;
            } else if (number >= 90) {
                stringBuilder.append("XC");
                number -= 90;
            } else if (number >= 50) {
                stringBuilder.append("L");
                number -= 50;
            } else if (number >= 40) {
                stringBuilder.append("XL");
                number -= 40;
            } else if (number >= 10) {
                stringBuilder.append("X");
                number -= 10;
            } else if (number >= 9) {
                stringBuilder.append("IX");
                number -= 9;
            } else if (number >= 5) {
                stringBuilder.append("V");
                number -= 5;
            } else if (number >= 4) {
                stringBuilder.append("IV");
                number -= 4;
            } else {
                stringBuilder.append("I");
                number -= 1;
            }
        }
        return stringBuilder.toString();
    }

    public int romanToArab(String string) {
        int end = string.length() - 1;
        char[] array = string.toCharArray();
        int arabian;
        int result = romanKey.get(array[end]);
        for (int i = end - 1; i >= 0; i--) {
            arabian = romanKey.get(array[i]);

            if (arabian < romanKey.get(array[i + 1])) {
                result -= arabian;
            } else {
                result += arabian;
            }


        }
        return result;

    }
}