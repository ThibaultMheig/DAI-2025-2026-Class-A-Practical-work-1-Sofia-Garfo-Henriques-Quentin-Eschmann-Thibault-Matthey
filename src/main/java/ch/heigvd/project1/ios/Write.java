package ch.heigvd.project1.ios;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Write {
    public static BufferedWriter open(String fileName) throws IOException{
        return new  BufferedWriter(new FileWriter((fileName), StandardCharsets.UTF_8));
    }

    public static void close(BufferedWriter br) throws IOException{
        if ( br != null){
            br.flush();
            br.close();
        }

    }
}