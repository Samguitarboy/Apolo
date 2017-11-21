package readfileexample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author 阿賢賢
 */
public class ReadFileExample {
    public static void main(String[] args) throws IOException{

        FileReader fr = new FileReader("D:\\testfile.txt");
        BufferedReader br = new BufferedReader(fr);
        while(br.ready()){
            System.out.println(br.readLine());
        }
        br.close();
        fr.close();
    }
    
}
