package Solution9_2_1;

import java.io.InputStream;

public class OneZeroStream extends InputStream {
    //write your code here
    private byte[] bytes = {'1', ' ', '0', ' '};
    int k = 0;

    public int read() {
        if(k >= bytes.length) //{
            k = 0;
        //}
            return bytes[k++];  //Зацикливаем до "бесконечности"
    }
    //to here
}
