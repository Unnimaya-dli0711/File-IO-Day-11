package file_io_2;

import java.io.*;
import java.util.ArrayList;

public class MergeFiles {
    public static void main(String[] args) {
        ArrayList<String> filepaths=new ArrayList<>();
        filepaths.add("src/file_io_2/file1.txt");
        filepaths.add("src/file_io_2/file2.txt");
        filepaths.add("src/file_io_2/file3.txt");
        for(String file:filepaths){
            try(BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
                BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter("src/file_io_2/mergedfile.txt",true));){
                    String string;
                    while((string=bufferedReader.readLine())!=null){
                        bufferedWriter.write(string+"\n");
                    }
            }catch (IOException e){
                System.out.println(e);
            }
        }

    }
}
