package filo_io;

import java.io.*;

public class ReverseContent {
    public static void main(String[] args) {
        try(BufferedReader bufferedReader=new BufferedReader(new FileReader("src/filo_io/nonreversed.txt"));
            BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter("src/filo_io/reversed.txt"))){
            String string;
            StringBuilder stringBuilder;
            while((string=bufferedReader.readLine())!=null){
                stringBuilder=new StringBuilder(string);
                string=stringBuilder.reverse().toString();
                System.out.println(string);
                bufferedWriter.write(string+"\n");
            }
        }catch (IOException e){
            System.out.println(e);
        }
    }
}
