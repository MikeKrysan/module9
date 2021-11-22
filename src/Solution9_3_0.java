import java.io.*;

public class Solution9_3_0 {
    public static void main(String[] args) throws IOException {
        // fos = new FileOutputStream("src/files/test1.txt");
        //fos.write("Hello FileOutputStream world".getBytes());
        //fos.write("Привет FileOutputStream мир".getBytes("UTF-8"));
        //System.out.println(System.getProperty("file.encoding"));
        //fos.close();
        copyFileUsingStream("src/files/read/Бхаргава А. - Грокаем Алгоритмы. Иллюстрированное пособие для программистов и любопытствущих - 2017.PDF",
                "src/files/output/Бхаргава А. - Грокаем Алгоритмы. Иллюстрированное пособие для программистов и любопытствущих - 2017-1.PDF");
    }

    private static void copyFileUsingStream(String source, String dest) throws IOException {

        InputStream fis = new FileInputStream(source);
        OutputStream fos = new FileOutputStream(dest);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = fis.read(buffer)) > 0) {
            fos.write(buffer, 0, length);
        }
        fis.close();
        fos.close();
    }

}
