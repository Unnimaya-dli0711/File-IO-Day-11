package filo_io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WriteToFile {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the string to write in file");
        String string=scanner.next();
        try(BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter("src/filo_io/user_input.txt"));){
            bufferedWriter.write(string);
        }catch (IOException e){
            System.out.println(e);
        }
    }
}
