        package calcRA;

        import java.util.InputMismatchException;
        import java.util.Scanner;


public class RomanArabianCalc {
    static Scanner scanner = new Scanner(System.in);
    static int num1, num2;
    static char operation;
    static int result;

    public static void main (String[] args) {
        System.out.println("Введите выражение,содержащее знак операции, два арабских или два римских числа до десяти. Затем Enter ");
        String userInput = scanner.nextLine();
        char[] charUber = new char[10];
        for (int i = 0; i < userInput.length(); i++) {
            charUber[i] = userInput.charAt(i);
            if (charUber[i] == '+') {
                operation = '+';
            }
            if (charUber[i] == '-') {
                operation = '-';
            }
            if (charUber[i] == '*') {
                operation = '*';
            }
            if (charUber[i] == '/') {
                operation = '/';
            }
        }
        String uberCharString = String.valueOf(charUber);
        String[] block = uberCharString.split("[+-/*]");
        String stable00 = block[0];
        String stable01 = block[1];
        String string03 = stable01.trim();
        num1 = romanToNumber(stable00);
        num2 = romanToNumber(string03);
        if (num1 < 0 && num2 < 0) {
            result = 0;
        } else {
            result = calculated(num1, num2, operation);
            System.out.println("Результат для римских цифр");
            String resultRoman = convertNumToRoman(result);
            System.out.println(stable00 + " " + operation + " " + string03 + " = " + resultRoman);
        }
        num1 = Integer.parseInt(stable00);
        num2 = Integer.parseInt(string03);
        result = calculated(num1, num2, operation);
        System.out.println("Результат для арабских цифр");
        System.out.println(num1 + " " + operation + " " + num2 + " = " + result);
    }

    private static String convertNumToRoman (int numArabian) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        final String s = roman[numArabian];
        return s;
    }


    private static int romanToNumber (String roman) {
        try {
            switch (roman) {
                case "I":
                    return 1;
                case "II":
                    return 2;
                case "III":
                    return 3;
                case "IV":
                    return 4;
                case "V":
                    return 5;
                case "VI":
                    return 6;
                case "VII":
                    return 7;
                case "VIII":
                    return 8;
                case "IX":
                    return 9;
                case "X":
                    return 10;
            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Неверный формат данных");
        }
        return -1;
    }

    public static int calculated (int num1, int num2, char op) {
        int result = 0;
        switch (op) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                try {
                    result = num1 / num2;
                } catch (ArithmeticException | InputMismatchException e) {
                    System.out.println("Exception : " + e);
                    System.out.println("разрешены только целые ненулевые параметры");

                    break;
                }
                break;
            default:
                throw new IllegalArgumentException("Неверный знак операции");
        }
        return result;
    }
}

