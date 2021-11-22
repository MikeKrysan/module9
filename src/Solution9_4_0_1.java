import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/*
Вот так можно сложить два числа, которые расположены в текстовом формате. Расширение .txt тут значения не имеет.
Главное, что они записаны символами-цифрами. А вот, кстати, потоки DataInputStream и DataOutputStream позволяют работать с данными, записанными в бинарном формате,
что значительно компактнее.
 */

public class Solution9_4_0_1 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new FileInputStream("src/numbers.txt"));
        System.out.println(in.nextInt() + in.nextInt());
    }
}
