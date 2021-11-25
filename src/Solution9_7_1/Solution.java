package Solution9_7_1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;
/*
В файле receipt.txt хранится информация о покупках. Каждая новая строка — новый продукт. В строке информация записана через ;
и выглядит следующим образом: <Продукт>;<Количество>;<Цена за 1 шт>.

Ваша задача — реализовать метод getReceipt(), который должен посчитать суммарную стоимость чека и вернуть её в виде строки.

Сумма с точностью до копеек, например: 125.90
 */
public class Solution {
        //from here
        public String getRecept() throws FileNotFoundException {                                //FileNotFoundException - 1
            Scanner scanner = new Scanner(new FileInputStream("src/recept.txt"));
            double result = 0;

            while (scanner.hasNextLine()) {                                                     //hasNextLine() - 2
                String[] productInfo = scanner.nextLine().split(";");                       //split - разделяем массив элементом ";"
                result += Integer.parseInt(productInfo[1]) * Double.parseDouble(productInfo[2]);//parseInt - 3, Double.parseDouble() - 4
            }

            return String.format(Locale.US, "%.2f", result);
        }
        //to there
}

/*
1.
Сигнализирует, что попытка открыть файл, обозначенный указанным путем, не удалась.
Это исключение будет выдано конструкторами FileInputStream, FileOutputStream и RandomAccessFile,
если файл с указанным именем пути не существует. Он также будет выдан этими конструкторами, если файл существует, но по какой-то причине недоступен,
например, когда делается попытка открыть файл, доступный только для чтения, для записи.

2.
данный метод читает продолжение строки, учитывая пробел, в отличии от nextLine

3.
в Java используется для получения примитивного типа данных определенной строки, другими словами — преобразует строку в число.
Метод parseXxx() — это статический метод и может иметь один аргумент или два.

Integer.valueOf() vs Integer.parseInt() with Examples

Integer.parseInt():

While operating upon strings, there are times when we need to convert a number represented as a string into an integer type.
The method generally used to convert String to Integer in Java is parseInt(). This method belongs to Integer class in java.lang package.
It takes a valid string as a parameter and parses it into primitive data type int. It only accepts String as a parameter and on passing values of any other data type,
it produces an error due to incompatible types.

There are two variants of this method:
Syntax:

public static int parseInt(String s) throws NumberFormatException
public static int parseInt(String s, int radix) throws NumberFormatException
Example:


// Java program to demonstrate working parseInt()

public class GFG {
    public static void main(String args[])
    {
        int decimalExample = Integer.parseInt("20");
        int signedPositiveExample = Integer.parseInt("+20");
        int signedNegativeExample = Integer.parseInt("-20");
        int radixExample = Integer.parseInt("20", 16);
        int stringExample = Integer.parseInt("geeks", 29);

        System.out.println(decimalExample);
        System.out.println(signedPositiveExample);
        System.out.println(signedNegativeExample);
        System.out.println(radixExample);
        System.out.println(stringExample);
    }
}
Output:
20
20
-20
32
11670324

Integer.valueOf():

This method is a static method belonging to the java.lang package which returns the relevant Integer Object holding the value of the argument passed.
This method can take an integer or a String as a parameter. But when the given String is invalid, it provides an error. This method can also take in
a character as a parameter but the output will be its corresponding Unicode value. This method will always cache values in the range -128 to 127, inclusive,
and may cache other values outside of this range.

Syntax:

public static Integer valueOf(int a)
public static Integer valueOf(String str)
public static Integer valueOf(String str, int base)
Example:


// Java program to illustrate the
// java.lang.Integer.valueOf(int a)
import java.lang.*;

public class Geeks {

    public static void main(String[] args)
    {

        Integer obj = new Integer(10);

        // Returns an Integer instance
        // representing the specified int value
        System.out.println("Output Value = "
                           + obj.valueOf(85));
    }
}
Output:
Output Value = 85

4.
parseDouble возвращает примитивный двойник, содержащий значение строки:

Возвращает новый двойной инициализированный значение, представленное указанной строкой, которое выполняется методом valueOf класса Double.



valueOf возвращает экземпляр Double, если он уже кэширован, вы получите тот же кешированный экземпляр.

Возвращает двойной экземпляр, представляющий указанное двойное значение. Если новый экземпляр Double не требуется, этот метод обычно должен быть используется
в качестве альтернативы конструктору Double (double), так как этот метод вероятно, обеспечит значительно лучшую производительность пространства и времени
за счет кэширование часто запрашиваемых значений.

Чтобы избежать накладных расходов на создание нового экземпляра Double object, вы обычно должны использовать valueOf
 */