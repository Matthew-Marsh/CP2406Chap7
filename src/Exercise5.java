import textio.TextIO;

public class Exercise5 {

    private static double[] sortNumberList(double[] numbers, int numberCount) {
        for ( int lastPlace = numberCount - 1; lastPlace > 0; lastPlace-- ) {
            int maxLoc = 0;
            for (int i = 1; i <= lastPlace; i++) {
                if (numbers[i] > numbers[maxLoc]) {
                    maxLoc = i;
                }
            }
            double temp = numbers[maxLoc];
            numbers[maxLoc] = numbers[lastPlace];
            numbers[lastPlace] = temp;
        }
        return numbers;
    }

    private static void printNumbers( double[] numbers, int numberCount) {
        System.out.print("[");
        for (int i = 0; i < numberCount; i++) {
            System.out.print(" " + numbers[i]);
        }
        System.out.println(" ]");
    }

    public static void main(String[] args) {
        double[] numbers = new double[100];
        double inputNumber;
        int numberOfNumbers = 0;

        System.out.print("Enter a number (or 0 if finished): ");
        inputNumber = TextIO.getlnDouble();
        while (inputNumber != 0) {
            numbers[numberOfNumbers] = inputNumber;
            numberOfNumbers++;
            System.out.print("Enter a number (or 0 if finished): ");
            inputNumber = TextIO.getlnDouble();
        }

        System.out.println("Number input:");
        printNumbers(numbers, numberOfNumbers);
        System.out.println("Sorted Number List:");
        sortNumberList(numbers, numberOfNumbers);
        printNumbers(numbers, numberOfNumbers);
    }
}
