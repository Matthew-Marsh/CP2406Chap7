import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;

public class Exercise1 {

    private static ArrayList<Integer> generateNumbers(int count, int maximum) {
        boolean numberFound = false;
        if (count > maximum) {
            throw new IllegalArgumentException("Can't have more different numbers than the maximum");
        }
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        while (numbers.size() < count) {
            int number = (int) ((Math.random()* maximum) + 1);
            for (int index = 0; index < numbers.size(); index++) {
                if (numbers.get(index) == number) {
                    numberFound = true;
                    break;
                }
            }
            if (!numberFound) {
                numbers.add(number);
            }
            numberFound = false;
        }
        return numbers;
    }

    private static void printNumbers(ArrayList<Integer> numbers) {
        System.out.print("[");
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.size() > 1 && i != (numbers.size() - 1)) {
                System.out.print(numbers.get(i) + ", ");
            } else {
                System.out.print(numbers.get(i));
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        ArrayList<Integer> numbersList;
        numbersList = generateNumbers(50, 100);
        printNumbers(numbersList);
        numbersList = generateNumbers(48, 500);
        printNumbers(numbersList);
    }
}
