import java.io.*;
import java.nio.charset.StandardCharsets;

/*
Напишите программу, которая в функции main() пишет в файл request.txt из директории files (директория в тестирующей системе скрыта) текст:

GIVE ME THE CODE, PLEASE

Запустите тестирование кнопкой Test.

Путь к файлу в тестирующей системе: Root/files/request.txt.
 */
public class Solution9_3_1 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fout = new FileOutputStream("src/files/request.txt");
        fout.write("GIVE ME THE CODE, PLEASE".getBytes());
        fout.close();
    }
}
