package filo_io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadWriteSample {
    public static void main(String[] args) {
        String filename="src/filo_io/source.txt";
        File file=new File(filename);

        try(FileReader fileReader=new FileReader(file);){
            int i;
            while((i=fileReader.read())!=-1){
                System.out.print((char)i);
                try(FileWriter fileWriter=new FileWriter(new File("src/filo_io/destination.txt"),true);){
                    fileWriter.write((char)i);
                }catch (IOException e){
                    System.out.println(e);
                }
            }
        }catch (IOException e){
            System.out.println(e);
        }
    }
}
