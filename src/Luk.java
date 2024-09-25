/**
 * This class represents a Lucas number with its index and value.
 */
class LucasNumber {

    private int index;
    private long value;

    /**
     * Constructor to initialize a LucasNumber object.
     *
     * @param index the index of the Lucas number in the sequence
     * @param value the value of the Lucas number
     */
    public LucasNumber(int index, long value) {
        this.index = index;
        this.value = value;
    }

    /**
     * Gets the index of the Lucas number.
     *
     * @return the index of the Lucas number
     */
    public int getIndex() {
        return index;
    }

    /**
     * Gets the value of the Lucas number.
     *
     * @return the value of the Lucas number
     */
    public long getValue() {
        return value;
    }

    /**
     * Checks if the last digit of the Lucas number matches a given digit.
     *
     * @param digit the digit to check against the last digit of the Lucas number
     * @return true if the last digit matches the given digit, otherwise false
     */
    public Boolean lastNumber(int digit) {
        return Math.abs(value) % 10 == digit;
    }

    /**
     * Calculates the Lucas number at the specified position in the sequence.
     *
     * @param n the index in the Lucas sequence
     * @return the Lucas number at index n
     */
    public static long calculateLucasNumber(int n) {
        if (n == 0) {
            return 2;
        } else if (n == 1) {
            return 1;
        } else {
            long a = 2;
            long b = 1;
            long lucas = 0;
            for (int i = 2; i <= n; i++) {
                lucas = a + b;
                a = b;
                b = lucas;
            }
            return lucas;
        }
    }
}