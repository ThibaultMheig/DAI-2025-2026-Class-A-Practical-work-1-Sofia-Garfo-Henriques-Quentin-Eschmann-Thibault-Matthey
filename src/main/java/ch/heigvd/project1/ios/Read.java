package ch.heigvd.project1.ios;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Read {

    //source : https://stackoverflow.com/questions/4716503/reading-a-plain-text-file-in-java
    public static String readFile(String fileName){
        StringBuilder sb = new StringBuilder();

        try ( BufferedReader br = new BufferedReader(new FileReader(fileName, StandardCharsets.UTF_8)) ){
            String line = br.readLine();

            while (  line != null ){
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }

            return sb.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
