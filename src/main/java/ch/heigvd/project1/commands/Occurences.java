package ch.heigvd.project1.commands;

import ch.heigvd.project1.ios.Read;
import ch.heigvd.project1.ios.Write;
import picocli.CommandLine;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@CommandLine.Command(name = "occurences", description = "Find all the words occurences in a text file")
public class Occurences implements Runnable {

    @CommandLine.ParentCommand protected Root parent;

    @CommandLine.Option(
        names = {"-w", "--word"},
        description = "The word that you want to look for in the text. (Only compatible with occurences command)",
        required = true
    )
    protected String word;

    public void run(){
            String input = Read.readFile(parent.getIFileName());
            List<Integer> indexes = new ArrayList<>();
            int offset = 0;

            while (input.contains(word)) {
                int foundIndex = input.indexOf(word);
                indexes.add(offset + foundIndex);

                offset += foundIndex + word.length();
                input = input.substring(foundIndex + word.length());
            }

            try{
                BufferedWriter br = Write.open(parent.getOFileName());
                br.write("There are " + indexes.size() + " occurences of the word \"" + word + "\". They are at positions: " + indexes);
                br.close();
            } catch (IOException e) {
                System.err.println("Error: " + e.getMessage());
                System.exit(-1);
            }

    }    
}
