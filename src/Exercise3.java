import java.util.Arrays;

public class Exercise3 {
    final static int COUNT = 100000;
    private static int[] generateNumbers(int count, int maximum) {
        int[] numbers = new int[count];
        for (int i = 0; i < count; i++) {
            numbers[i] = (int) (Math.random() * maximum) + 1;
        }
        return numbers;
    }

    private static String[] generateStrings(int count) {
        String[] strings = new String[count];
        for (int i = 0; i < count; i++) {
            strings[i] = randomString();
        }
        return strings;
    }

    private static String randomString() {
        int length = 8;
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char ch = (char)('A' + (int)(26*Math.random()));
            str.append(ch);
        }
        return str.toString();
    }

    static void selectionSort(int[] A) {
          for (int lastPlace = A.length-1; lastPlace > 0; lastPlace--) {

            int maxLoc = 0;
            for (int j = 1; j <= lastPlace; j++) {
                if (A[j] > A[maxLoc]) {
                    maxLoc = j;
                }
            }
            int temp = A[maxLoc];
            A[maxLoc] = A[lastPlace];
            A[lastPlace] = temp;
        }
    }

    static void selectionSort(String[] A) {
        for (int lastPlace = A.length-1; lastPlace > 0; lastPlace--) {

            int maxLoc = 0;
            for (int j = 1; j <= lastPlace; j++) {
                if (A[j].compareTo(A[maxLoc]) > 0) {
                    maxLoc = j;
                }
            }
            String temp = A[maxLoc];
            A[maxLoc] = A[lastPlace];
            A[lastPlace] = temp;
        }
    }

    private static void printArray( int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(" " + array[i]);
        }
        System.out.println(" ]");
    }

    private static void printArray( String[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(" " + array[i]);
        }
        System.out.println(" ]");
    }

    public static void main(String[] args) {
        long startTime;
        long endTime;
        double time;
        int[] numberList;
        String[] stringList;
        numberList = generateNumbers(COUNT, 10000000);
        int[] sortedNumberList = Arrays.copyOf(numberList, COUNT);
        stringList = generateStrings(COUNT);
        String[] sortedStringList = Arrays.copyOf(stringList, COUNT);

        System.out.println("Beginning tests.");

        startTime = System.nanoTime();
        selectionSort(numberList);
        endTime = System.nanoTime();
        time = ((endTime - startTime) / 1e9);
        System.out.printf("It took %1.6f seconds to sort numbers using SelectionSort.%n", time);

        startTime = System.nanoTime();
        Arrays.sort(sortedNumberList);
        endTime = System.nanoTime();
        time = ((endTime - startTime) / 1e9);
        System.out.printf("It took %1.6f seconds to sort numbers using Arrays.sort().%n", time);

        startTime = System.nanoTime();
        selectionSort(stringList);
        endTime = System.nanoTime();
        time = ((endTime - startTime) / 1e9);
        System.out.printf("It took %1.6f seconds to sort strings using SelectionSort.%n", time);

        startTime = System.nanoTime();
        Arrays.sort(sortedStringList);
        endTime = System.nanoTime();
        time = ((endTime - startTime) / 1e9);
        System.out.printf("It took %1.6f seconds to sort strings using Arrays.sort().%n", time);
    }
}
