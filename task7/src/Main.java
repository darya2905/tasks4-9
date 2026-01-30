import java.util.*;

public class Main {

    // Возвращает индекс последнего элемента, который является вторым по величине минимума
    public static int solution(int[] arr) {
        if (arr.length == 0) return -1;

        int min = arr[0];
        for (int x : arr) {
            if (x < min) min = x;
        }

        // Ищем второй минимум — минимальный из элементов, > min
        int secondMin = Integer.MAX_VALUE;
        boolean foundSecond = false;

        for (int x : arr) {
            if (x > min && x < secondMin) {
                secondMin = x;
                foundSecond = true;
            }
        }

        if (!foundSecond) return -1; // второго минимума нет

        // Последняя позиция secondMin
        int lastPos = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == secondMin) lastPos = i;
        }

        return lastPos;
    }

    // ВЫВОД МАССИВА
    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    //ВВОД МАССИВА
    public static int[] readArray(Scanner sc) {
        System.out.print("Введите количество элементов: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Введите " + n + " чисел:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    // ТЕСТОВЫЕ МАССИВЫ
    public static void runTests() {
        int[][] tests = {
                {5, 1, 3, 1, 3, 7, 3},
                {1, 2, 3, 4, 5},
                {5, 4, 3, 2, 1},
                {1, 1, 1, 1},
                {2},
                {2, 2},
                {1, 2},
                {-5, -5, -3, -4},
                {0, 0, 1, 0, 1, 0},
                {100, 50, 50, 50, 100}
        };

        System.out.println("АВТОТЕСТЫ");
        for (int i = 0; i < tests.length; i++) {
            System.out.print("Тест " + (i+1) + ": ");
            printArray(tests[i]);
            int result = solution(tests[i]);
            System.out.println("→ результат: " + result);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        runTests();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите свой массив");
        int[] userArr = readArray(scanner);

        System.out.println("Ваш массив:");
        printArray(userArr);

        System.out.println("Результат: " + solution(userArr));
    }
}
