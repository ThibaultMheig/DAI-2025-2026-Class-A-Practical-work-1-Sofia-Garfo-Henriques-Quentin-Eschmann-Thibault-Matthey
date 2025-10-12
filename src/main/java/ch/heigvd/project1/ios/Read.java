package ch.heigvd.project1.ios;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Read {

    //source : https://stackoverflow.com/questions/4716503/reading-a-plain-text-file-in-java
    public static String readFile(String fileName){
        StringBuilder sb = new StringBuilder();
        String text = null;

        try ( BufferedReader br = new BufferedReader(new FileReader(fileName, StandardCharsets.UTF_8)) ){
            String line = br.readLine();

            while (  line != null ){
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }

            text =  sb.toString();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(-1);
        }

        return text;
    }

}
