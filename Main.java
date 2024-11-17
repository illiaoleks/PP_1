// src/main/Main.java

package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Головний клас для генерації чисел Люка і перевірки їх властивостей.
 */
public class Main {

    /**
     * Генерує перші N чисел Люка.
     *
     * @param n Кількість чисел Люка для генерації.
     * @return Список об'єктів LucasNumber.
     */
    public static List<LucasNumber> generateLucasNumbers(int n) {
        List<LucasNumber> lucasNumbers = new ArrayList<>();

        // Перевірка на коректність введеного значення
        if (n <= 0) {
            return lucasNumbers; // Повертаємо порожній список
        }

        // Перші два числа Люка
        int prev = 2; // L(1) = 2
        int current = 1; // L(2) = 1

        lucasNumbers.add(new LucasNumber(1, prev)); // Додаємо L(1)
        if (n > 1) {
            lucasNumbers.add(new LucasNumber(2, current)); // Додаємо L(2)
        }

        // Генерація наступних чисел Люка
        for (int i = 3; i <= n; i++) {
            int next = prev + current; // L(n) = L(n-1) + L(n-2)
            lucasNumbers.add(new LucasNumber(i, next)); // Додаємо число до списку
            prev = current; // Оновлюємо значення
            current = next; // Оновлюємо значення
        }

        return lucasNumbers;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Введення кількості чисел Люка
        System.out.print("Введіть кількість чисел Люка (N): ");
        int n = scanner.nextInt();

        // Введення цифри для перевірки
        System.out.print("Введіть цифру для перевірки (0-9): ");
        int digit = scanner.nextInt();

        // Перевірка на коректність введеної цифри
        if (digit < 0 || digit > 9) {
            System.out.println("Помилка: введіть цифру від 0 до 9.");
            return;
        }

        // Генеруємо числа Люка
        List<LucasNumber> lucasNumbers = generateLucasNumbers(n);

        // Виводимо згенеровані числа Люка
        System.out.println("\nЗгенеровані числа Люка:");
        for (LucasNumber lucasNumber : lucasNumbers) {
            System.out.printf("Індекс: %d, Значення: %d%n", lucasNumber.getNumberIndex(), lucasNumber.getValue());
        }

        // Перевіряємо, які числа закінчуються на вказану цифру
        System.out.println("\nЧисла Люка, які закінчуються на " + digit + ":");
        for (LucasNumber lucasNumber : lucasNumbers) {
            if (lucasNumber.endsWithDigit(digit)) {
                System.out.printf("Індекс: %d, Значення: %d%n", lucasNumber.getNumberIndex(), lucasNumber.getValue());
            }
        }

        // Закриваємо сканер
        scanner.close();
    }
}
