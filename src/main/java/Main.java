import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        try {
            String result = calc(input);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("throws Exception // " + e.getMessage());
        }
    }

    public static String calc(String input) throws Exception {
        String[] parts = input.split(" ");

        if (parts.length != 3) {
            throw new Exception("Некорректный ввод. Ожидается формат 'число операция число'.");
        }

        int num1;
        int num2;
        try {
            num1 = Integer.parseInt(parts[0]);
            num2 = Integer.parseInt(parts[2]);
            if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            throw new Exception("Числа должны быть от 1 до 10 включительно.");
        }

        String operation = parts[1];

        // Выполнение арифметической операции
        int result;
        switch (operation) {
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
                    throw new Exception("Деление на ноль!");
                }
                result = num1 / num2;
                break;
            default:
                throw new Exception("Неподдерживаемая операция: " + operation);
        }

        return String.valueOf(result);
    }
}
