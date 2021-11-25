package Solution9_7_3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
Возьмём первые 10 натуральных чисел. Если из них взять только те, что делятся на 4 или на 5, то это будут 4, 5, 8, 10. Их произведение будет равно 1600.
Ваша задача реализовать метод getMul(), который будет считывать файл data.txt, в первой строке которого записано число N, до которого (включая его) нужно считать произведение.
В следующей строке файла через пробел записаны числа, на которые должны делиться перебираемые числа. Метод должен вернуть произведение таких чисел.

Пример

Файл data.txt:

10
4 5
Метод getMul() должен вернуть число 1600.
 */
public class Solution {
    public int getMul() throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream("src/Solution9_7_3/data.txt"));

        int limit = Integer.parseInt(scanner.nextLine());   //сканируем первое число, в нашем случае это 10
        String[] strings = scanner.nextLine().split(" ");   // Создаем массив, в который мы положим числа второй строки, разделенные пробелом
        int[] delimiters = new int[strings.length];             //создаем второй массив, который будет равен длине количества чисел первого массива (такого же размера)

        for (int i = 0; i < strings.length; i++) {  //наполняем ячейки второго массива содержимым из ячеек первого массива
            delimiters[i] = Integer.parseInt(strings[i]);   //и переводим их из строкового значения в целочисленное
        }

        int mul = 1;

        for (int i = 1; i <= limit; i++) {
            for (int delimiter : delimiters) {  //цикл for each-проходим по каждому елементу массива delimiters
                if (i % delimiter == 0) {       //если остаток от деления будет равен нулю(число делится без остатка), то выполняем условие:
                    mul *= i;
                    break;
                }
            }
        }

        return mul;
    }
}
