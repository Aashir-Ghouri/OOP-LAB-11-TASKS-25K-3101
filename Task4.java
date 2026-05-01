import java.util.*;

public class Task4 {

    // sort using ComparablE cuz it works with Integer, Double, etc.
    public static <T extends Comparable<T>> void sortList(List<T> list) {
        // simple bubble sort
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).compareTo(list.get(j + 1)) > 0) {
                    T temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }

    // sum using wildcard as Number is parent of Integer and Double
    public static double calculateSum(List<? extends Number> list) {
        double total = 0;
        for (Number n : list) {
            total += n.doubleValue();
        }
        return total;
    }

    // findingg max item using Comparable
    public static <T extends Comparable<T>> T findMax(List<T> list) {
        T max = list.get(0);
        for (T item : list) {
            if (item.compareTo(max) > 0) {
                max = item;
            }
        }
        return max;
    }

    public static void main(String[] args) {

        // list with mix of Integer and Double using Number as common type
        List<Number> mixedList = new ArrayList<>();
        mixedList.add(15);
        mixedList.add(3.7);
        mixedList.add(42);
        mixedList.add(8.2);
        mixedList.add(100);
        mixedList.add(0.5);
        mixedList.add(27);

        System.out.println("Original List: " + mixedList);

        // to sort and find max, we need Comparable so we convert to Double for uniform comparison
        List<Double> doubleList = new ArrayList<>();
        for (Number n : mixedList) {
            doubleList.add(n.doubleValue());
        }

        sortList(doubleList);
        System.out.println("Sorted List (ascending): " + doubleList);

        double sum = calculateSum(doubleList);
        System.out.println("Sum of all elements: " + sum);

        Double maxVal = findMax(doubleList);
        System.out.println("Maximum value: " + maxVal);
    }
}