// src/main/LucasNumber.java

package main;

/**
 * Представляє число Люка з індексом і значенням.
 */
public class LucasNumber {
    private final int numberIndex; // Індекс числа Люка
    private final int value;       // Значення числа Люка

    /**
     * Конструктор для створення числа Люка.
     *
     * @param numberIndex Індекс числа.
     * @param value       Значення числа.
     */
    public LucasNumber(int numberIndex, int value) {
        this.numberIndex = numberIndex;
        this.value = value;
    }

    /**
     * Отримує індекс числа Люка.
     *
     * @return Індекс числа Люка.
     */
    public int getNumberIndex() {
        return numberIndex;
    }

    /**
     * Отримує значення числа Люка.
     *
     * @return Значення числа Люка.
     */
    public int getValue() {
        return value;
    }

    /**
     * Перевіряє, чи закінчується значення числа Люка на вказану цифру.
     *
     * @param digit Цифра для перевірки (0-9).
     * @return true, якщо значення закінчується на цифру, інакше false.
     */
    public boolean endsWithDigit(int digit) {
        return value % 10 == digit;
    }
}
