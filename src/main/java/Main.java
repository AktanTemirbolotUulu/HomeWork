import java.util.Scanner;

public class Main {
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // Пример ввода
    String input = sc.nextLine();

    try {
        int result = calculate(input);
        System.out.println(result);
    } catch (IllegalArgumentException e) {
        System.out.println("Ошибка: " + e.getMessage());
    }
}

public static int calculate(String input) {
    String[] parts = input.split(" ");

    if (parts.length != 3 ) {
        throw new IllegalArgumentException("Некорректный ввод. Ожидается формат 'число операция число'.");
    }

    int num1;
    int num2;
    try {
        num1 = Integer.parseInt(parts[0]);
        num2 = Integer.parseInt(parts[2]);
        if (num1 > 10 && num2 > 10) {
            throw new NumberFormatException();
        }

    } catch (NumberFormatException e) {
        throw new IllegalArgumentException("Некорректный формат числа.", e);
    }

    String operation = parts[1];

    switch (operation) {
        case "+":
            return num1 + num2;
        case "-":
            return num1 - num2;
        case "*":
            return num1 * num2;
        case "/":
            if (num2 == 0) {
                throw new IllegalArgumentException("Деление на ноль!");
            }
            return num1 / num2;
        default:
            throw new IllegalArgumentException("Неподдерживаемая операция: " + operation);
    }
}
}