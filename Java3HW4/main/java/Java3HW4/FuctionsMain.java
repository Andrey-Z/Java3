package Java3HW4;

import java.util.Scanner;

//Площадь треугольника по формуле Герона - S=sqrt {p * (p-a) * (p-b) * (p-c) }
//Периметр – это сумма длин всех сторон треугольника. Соответственно полупериметр –
// это сумма длин всех сторон разделенная на 2. Получаем - p = (a + b + c )/2

public class FuctionsMain {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите длину стороны a: ");
        int a = scanner.nextInt();

        System.out.println("Введите длину стороны b: ");
        int b = scanner.nextInt();

        System.out.println("Введите длину стороны c: ");
        int c = scanner.nextInt();

        int p = (a + b + c) / 2;
        float s = (float) Math.sqrt(p * (p - a) * (p - b) * (p - c));

        if ((a > 0) && (b > 0) && (c > 0) && ((a + b > c) && (b + c > a) && (a + c > b))) {
            System.out.println("Треугольник существует.");
        } else {
            System.out.println("Треугольник не существует");
        }
        System.out.println("Площадь треугольника с выбранными сторонами = " + s);
    }

    public boolean isNumberPositive(Integer number) {
        return number > 0;
    }

    public boolean isPrime(Integer number) {
        if (number < 1) {
            return false;
        }
        return true;
    }
}
