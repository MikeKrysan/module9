package Solution9_7_6;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/*В файле data.txt записано число, а затем строки. Число — это то, на сколько символов может отличаться длина строки от средней длины строк (то есть это длина всех строк,
нацело деленная на количество строк).

Ваша задача — реализовать метод realization(), который должен записать в файл output.txt среднюю длину строк, а затем все строки, которые отличаются от средней длины не более
чем на данное число в файле data.txt.

P.S. Если таких строк нет, то в файл output.txt следует записать только среднюю длину строк.

Пример

Файл data.txt:

1
Hello world,
It’s me,
Mario!
Файл output.txt после вызова метода solution():

13
Hello world,

 */
public class Solution {
    public boolean realization() throws IOException {
        Scanner scanner = new Scanner(new FileInputStream("src/Solution9_7_6/data.txt"));
        int length = 0, k = 0;
        StringBuilder allStrings = new StringBuilder();

        int limit = Integer.parseInt(scanner.nextLine());   //Число — это то, на сколько символов может отличаться длина строки от средней длины строк (число записанно первым в файле)
        while (scanner.hasNextLine()) {
            String string = scanner.nextLine(); // read new string
            allStrings.append(string).append("\n");        // build a big string with all strings   //1.
            length += string.length();          // search a median
            k++;
        }

        StringBuilder result = new StringBuilder(length / k + "\n");      // take median
        String[] strings = allStrings.toString().trim().split("\n");   // build array with all strings  //Собрали все строки в один массив, и занесли каждую строку в отдельную ячейку массива
        for (String string : strings) {     //перебор: проводим действие для каждой ячейки массива strings[]
            if (Math.abs(string.length() - length / k) <= limit) result.append(string).append("\n"); // selecting strings (вносим в переменную result все строки, которые отличаются от средней длины не более
                                                                                                        //чем на данное число в файле data.txt.). Если таких строк несколько, то каждую строку мы выводим с новой строки
        }

        // write result in file
        FileWriter writer = new FileWriter("src/Solution9_7_6/output.txt", false);
        writer.write(result.toString().trim());     //печатаем наш результат, обрезав пробелы в начале и в конце строки.ёёёёёёёёёёёё
        writer.flush();
        return false;
    }
}

/*
1. StringBuilder.append() - Метод соединяет представление любого другого типа данных. Есть несколько перегруженных версий.
 */