package filo_io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadLineExample {
    public static void main(String[] args) {
        File file=new File("src/filo_io/input.txt");
        try(BufferedReader bufferedReader=new BufferedReader(new FileReader(file));){
            String string;
            while((string=bufferedReader.readLine())!=null){
                System.out.println(string);
            }
        }catch (IOException e){
            System.out.println(e);
        }

    }
}
