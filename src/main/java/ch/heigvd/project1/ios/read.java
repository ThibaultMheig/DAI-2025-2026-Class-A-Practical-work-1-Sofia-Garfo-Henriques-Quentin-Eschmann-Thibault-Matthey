package ch.heigvd.project1.ios;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public class read {

    public String readFile (String fileName){
        /*InputStream fis = new FileInputStream(fileName);
        BufferedInputStream bis = new BufferedInputStream(fis);

        int b;
        String out = "test";
        while((b = bis.read()) != -1){
            out.concat(b);
        }

        bis.close();

        return out;*/
        return "readFile";
    }    
}
