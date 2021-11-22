import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/*
Посчитайте количество символов-цифр в файле asciitable.txt из папки files, содержащем разные символы.

Путь к файлу в тестирующей системе: src/files/asciitable.txt.
 */
public class Solution9_2_3 {
    public static void main(String[] args) throws IOException {

        FileInputStream fin = new FileInputStream("src/files/asciitable.txt");
        int c;
        int s = 0;
        while((c = fin.read()) != -1){
            if (c >='0' && c <= '9')
                s++;
        }
        System.out.println(s);
        fin.close();

    }
}
