package ch.heigvd.project1;

import ch.heigvd.project1.ios.Read;
import ch.heigvd.project1.ios.Write;

import java.io.BufferedWriter;
import java.io.IOException;

public class Test {

    public static void main(String[] args) throws IOException {
        String string = Read.readFile("src/test/java/ch/heigvd/project1/Input.txt");
        System.out.println(string);

        try{
            BufferedWriter bw = Write.open("src/test/java/ch/heigvd/project1/Output.txt");
            bw.write(string);
            Write.close(bw);
        } catch ( IOException e){
            throw new IOException(e);
        }

        System.out.println("Success writing to output file");

    }
}
