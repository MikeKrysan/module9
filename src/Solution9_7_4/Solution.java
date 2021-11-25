package Solution9_7_4;

import java.io.*;
import java.util.Scanner;

/*
мы рандомно заносим числа в файл numbers.txt в следующем виде:
1
2
4
4
8
 Давайте посчитаем, сколько чисел, нами созданных,
совпали со своим порядковым номером (у числа 1 порядковый номер 1, у числа 5 — 5). Для этого предлагаем вам реализовать метод writeOrder(),
этот метод должен анализировать файл numbers.txt и все числа, которые совпали со своим номером, должен записать в файл output.txt (если таких чисел нет,
то в файл нужно записать одно число — 0).

Пример 1

Файл numbers.txt:
1
2
4
4
8
Файл output.txt после вызова метода writeOrder():

1 2 4
Пример 2

Файл numbers.txt:

7
6
7
Файл output.txt после вызова метода writeOrder():

0
 */
public class Solution {
    public boolean writeOrder() throws IOException {
        // write your code
        Scanner scanner = new Scanner(new FileInputStream("src/Solution9_7_4/numbers.txt"));
        int index = 1;
        String resString = "";

        while (scanner.hasNextLine()) {                 //пока сканер видит числа
            String nowNumber = scanner.nextLine();      //создаем переменную, которая будет содержать текущее значение считываемого числа
            if (Integer.parseInt(nowNumber) == index) { //если данное число (строка, приведенная к числу) совпадает с индексом, то
                resString += nowNumber + " ";           //в переменную результата добавляем это считанное число
            }
            index++;                                    //и увеличиваем индекс на 1
        }

        if (resString.equals("")) {                     //Если совпадений не обнаружено, возвращаем результат "0"
            resString = "0";
        }

        // write string in file
        FileWriter writer = new FileWriter("src/Solution9_7_4/output.txt", false);
        writer.write(resString.trim()); //1
        writer.flush();                 //2
        return false;
    }
}

/*
1.
FileWriter.write - Класс FileWriter наследуется от класса OutputStreamWriter. Класс используется для записи потоков символов.
Метод write класса FileWriter записывает один символ: public void write(int c) throws IOException

Метод trim() в Java позволяет удалить пробелы в начале и конце строки. Как будто "подрезает" пробелы.

Синтаксис: public String trim()

Пример:

class Test {

	public static void main(String[] args) {
		String sentence1 ="    Java - очень крутой язык программирования.    ";
		String sentence2 ="    Java - очень крутой язык программирования.    ";
		System.out.println(sentence1);
		System.out.println(sentence2.trim());
	}
}
Если Вы запустите данный код на своем компьютере, то в консоли Вы увидите следующее:

    Java - очень крутой язык программирования.

Java - очень крутой язык программирования.

2.
flush() просто гарантирует, что все буферизованные данные будут записаны на диск (в данном случае - в более общем плане, сброшены через любой канал IO, который вы используете).
Вы все еще можете писать в поток (или писатель) после этого.

close() сбрасывает данные и указывает, что данных больше нет . Он закрывает любые дескрипторы файлов, сокеты или что-то еще. Тогда вы больше не сможете писать в поток
(или писатель).

Обратите внимание, что без вызовов flush() данные все еще могут быть записаны в рассматриваемый канал IO - просто некоторые данные могут быть буферизованы.

close() обычно также вызывает flush() , но недавно мне было указано, что в некоторых реализациях JDK любые исключения, вызванные сбросом как часть закрытия, проглатываются :(


 */