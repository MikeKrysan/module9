package Solution9_2_1;

import java.util.Scanner;
/*
В этом модуле мы в основном будем использовать стандартные потоки, а почему бы не создать свой поток?!

Сoздайте свой байтовый поток ввода OneZeroStream, который выдает цифры 0 и 1, разделяя их пробелами.

Так, чтобы программа:

public static void main(String[] args) {
    Scanner scanner = new Scanner(new OneZeroStream());
    for (int i = 0; i < 10; i++) {
        System.out.print(scanner.nextInt());
    }
}
Вывела:

1 0 1 0 1 0 1 0 1 0

 */
public class Main {
    public static void main(String[] args) {
/*

Make byte InputStream OneZeroStream, which gives
1 0 1 0 .....

*/

        Scanner scanner = new Scanner(new OneZeroStream());
        for (int i = 0; i < 10; i++){
            System.out.print(scanner.nextInt());    //метод сканера nextInt() отвечает за то, чтобы считать введенное пользователем  целое число с консоли
        }

/*

The code above has to output

1010101010

*/
    }
}

/*
Подсказка (1 из 2): Нужно пронаследоваться от InputStream и переопределить метод int read().
Подсказка (2 из 2): Нужно выдавать не числа 0 и 1, а коды символов '0' и '1'. Можно использовать значения 48 и 49,
а можно и цифры в апострофах, из-за того, что цифры имеют коды в пределах типа byte, всё будет работать.
 */
// Метод Scanner.nextInt() - считывает только числа, пробелы он не читает (' ')