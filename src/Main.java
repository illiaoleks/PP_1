import java.util.Scanner;

/**
 * The main class that runs the program.
 * Allows users to input a number of Lucas numbers and find which end with a specific digit.
 */
public class Main {

    /**
     * The main method where the program execution starts.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("Введіть кількість перших чисел Люка (N): ");
            int N = scan.nextInt();
            if (N == 0) {
                break;
            }

            System.out.println("Введіть цифру, на яку повинні закінчуватись числа Люка: ");
            int lastDigit = scan.nextInt();

            LucasNumber[] lucasNumbers = new LucasNumber[N];

            for (int i = 0; i < N; i++) {
                long lucasValue = LucasNumber.calculateLucasNumber(i);
                lucasNumbers[i] = new LucasNumber(i, lucasValue);
            }

            int count = 0;
            System.out.println("Числа люка, що закінчуються на " + lastDigit + ":");
            for (LucasNumber lucas : lucasNumbers) {
                if (lucas.lastNumber(lastDigit)) {
                    System.out.println("L(" + lucas.getIndex() + ") = " + lucas.getValue());
                    count++;
                }
            }

            if (count == 0) {
                System.out.println("Таких чисел немає на цьому проміжку");
            }
        }

        scan.close();
    }
}