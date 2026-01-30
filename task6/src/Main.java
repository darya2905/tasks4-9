import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите x (в интервале (-R, R)): ");
        double x = scanner.nextDouble();
        System.out.print("Введите количество слагаемых n: ");
        int n = scanner.nextInt();
        System.out.print("Введите точность e: ");
        double e = scanner.nextDouble();
        double sumSlagN = 0;
        double sumSlagBolsheE = 0;
        double sumSlagBolsheE10 = 0;
        double N = 1;
        int NumberN = 0;
        while (NumberN < n) {
            sumSlagN += N;
            double absTerm = Math.abs(N);
            if (absTerm > e) {
                sumSlagBolsheE += N;
            }
            if (absTerm > e/10) {//Взять только те слагаемые, модуль которых больше чем e/10:absTerm-модуль значения текущего ряда
                sumSlagBolsheE10 += N;
            }
            N = -N * x * x / ((2 * NumberN + 1) * (2 * NumberN + 2));
            NumberN++;
        }
        double mathValue = Math.cos(x);//Точное значение cos для x
        System.out.println("Результаты:");
        System.out.printf("1) Сумма %d слагаемых: %.10f%n", n, sumSlagN);
        System.out.printf("2) Сумма слагаемых > e %.10f%n", e, sumSlagBolsheE);
        System.out.printf("3) Сумма слагаемых > e/10 %.10f%n", e/10, sumSlagBolsheE10);
        System.out.printf("4) Значение Math.cos(x): %.10f%n", mathValue);
        System.out.printf("Погрешность: %.2e%n", Math.abs(sumSlagN - mathValue));// Модуль числа: Math.abs
    }
}
