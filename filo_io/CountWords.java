package filo_io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountWords {
    public static void main(String[] args) {
        try(BufferedReader bufferedReader=new BufferedReader(new FileReader("src/filo_io/text_file.txt"));){
            String string;
            int word=0;
            while((string=bufferedReader.readLine())!=null){
                System.out.println(string);
                String[] charArray=string.split(" ");
                word+=charArray.length; 
            }
            System.out.println(word);
        }catch (IOException e){
            System.out.println(e);
        }
    }
}
