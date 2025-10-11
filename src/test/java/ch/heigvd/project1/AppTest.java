package ch.heigvd.project1;

import ch.heigvd.project1.ios.Read;
import ch.heigvd.project1.ios.Write;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Unit test for simple App.
 */
public class AppTest {

    /**
     * Rigorous Test :-)
     */
    @Test
    public void readAndWrite() throws IOException {
        String string = Read.readFile("src/test/java/ch/heigvd/project1/Input.txt");
        System.out.println(string);

        try{
            BufferedWriter bw = Write.open("src/test/java/ch/heigvd/project1/Output.txt");
            bw.write(string);
            Write.close(bw);
        } catch ( IOException e){
            throw new IOException(e);
        }
    }
}
