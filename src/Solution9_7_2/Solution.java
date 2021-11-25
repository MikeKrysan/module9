package Solution9_7_2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
/*
Вам дан файл text.txt. Ваша задача — реализовать метод getCountWords(), возвращающий количество слов в тексте (словом считается все, что отделено пробелами с двух сторон).

Пример

Файл text.txt:

Hello world,
It’s me!
Метод getCountWords() должен вернуть число 4.
 */
public class Solution {
    public int getCountWords() throws FileNotFoundException {
        // write your code
        Scanner scanner = new Scanner(new FileInputStream("src/Solution9_7_2/text.txt"));
        int countWords = 0;

        while (scanner.hasNextLine()) {
            String[] words = scanner.nextLine().split(" ");
            countWords += words.length;
        }

        return countWords;
    }
}

