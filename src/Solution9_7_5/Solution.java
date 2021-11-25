package Solution9_7_5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
В файле strings.txt лежат строки, которые, возможно, являются палиндромами. Реализуйте метод arePalindromes(): этот метод должен вернуть true,
если каждая строка в данном файле — палиндром, или false, если это не так. Пробелы и большие буквы в строках не учитываются, также гарантируется, что знаков препинания не будет.

Пример

Файл strings.txt:

Коту тащат уток
шалаш
Метод arePalindromes(), должен вернуть true.
 */
public class Solution {
    public boolean arePalindromes() throws FileNotFoundException {
        // write your code here
        Scanner scanner = new Scanner(new FileInputStream("src/Solution9_7_5/strings.txt"));

        while (scanner.hasNextLine()) {
            String string = scanner.nextLine(); // read new string
            string = string.toLowerCase().replace(" ", "");                                 //1
            if (!string.equals(new StringBuilder(string.toLowerCase()).reverse().toString())) return false; //2
        }

        return true;
    }
}

/*
1. Переводим все буквы в нижний регистр и убираем пробелы(replace)
2. Вызиваем метод toString(), потому что*?

 */