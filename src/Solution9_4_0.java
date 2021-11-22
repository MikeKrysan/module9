import java.io.*;
import java.nio.charset.Charset;

/*
Давайте для примера напишем перекодировщик, который копирует файл и при этом меняет кодировку. Мы будем работать с двумя кодировками:
Windows -1251 (это была родная кодировка в Windows до некоторого времени, в ней каждый символ представлялся в виде одного байта) и UTF-8
(фактически современным стандартом, в этой кодировке символ может представляться разным количеством байт).
 */

public class Solution9_4_0 {
    public static void main(String[] args) throws IOException {
        copyFileUsingStream(new File("src/win1251.txt"),
                Charset.forName("windows-1251"),
                new File("src/utf8.txt"),
                Charset.forName("utf-8"));
    }

    private static void copyFileUsingStream(File source, Charset sourceEnc, File dest, Charset descEnc) throws IOException {
        Reader fis = new FileReader(source, sourceEnc);
        Writer fos = new FileWriter(dest, descEnc);
        char[] buffer = new char[1024];
        int length;
        while ((length = fis.read(buffer)) > 0) {
            fos.write(buffer, 0, length);
        }
        fis.close();
        fos.close();
    }
}

/*
К сожалению, такой код работает только на Java 11 версии. До этого конструкторов FileReader и FileWriter, принимающих кодировку, не существовало.
Эти классы работали только в дефолтной кодировке системы. И приходилось писать так:

Reader fis = new InputStreamReader(new FileInputStream(source), sourceEnc);
Writer fos = new OutputStreamWriter(new FileOutputStream(dest), descEnc);

Если у вас старая версия Java или вы пишете под Android, и поэтому не можете использовать Java последних версий, то вам тоже нужно написать так,
чтобы код скомпилировался.
 */