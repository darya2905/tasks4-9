import java.io.PrintStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите h >= 1: ");
        int h = scanner.nextInt();
        for (int i = 1; i <= h; i++) { //кол-во строк
            for (int j = 1; j < i; j++) { //кол-во пробелов
                System.out.print(" ");
            }
            int s = h - i + 1; //символов в строке
            for (int k = 1; k <= s; k++) {
                if (i==1) {
                    System.out.print("*");
                } else if (i <= h - 2) {
                    if (k==1 || k==s) {
                        System.out.print("*");
                    } else {
                        System.out.print("$");
                    }
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}
