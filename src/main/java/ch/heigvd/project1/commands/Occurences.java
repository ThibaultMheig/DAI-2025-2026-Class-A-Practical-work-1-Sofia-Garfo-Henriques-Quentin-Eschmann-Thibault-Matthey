package ch.heigvd.project1.commands;

import picocli.CommandLine;
import java.util.ArrayList;
import java.util.List;

@CommandLine.Command(name = "occurences", description = "Find all the words occurences in a text file")
public class Occurences implements Runnable {

    @CommandLine.Option(
        names = {"-w", "--word"},
        description = "The word that you want to look for in the text. (Only compatible with occurences command)",
        required = true
    )
    protected String word;

    public void run(){
        String input = "bonjour la suisse bonjourtest la bonjour labonjourbonjour";
        List<Integer> indexes = new ArrayList<>();
        String originalInput = input;
        int offset = 0;

        while(input.indexOf(word) != -1){
            int foundIndex = input.indexOf(word);
            indexes.add(offset + foundIndex);
            
            offset += foundIndex + word.length();
            input = input.substring(foundIndex + word.length());
        }

        System.out.println("There are " + indexes.size() + " occurences of the word \"" + word + "\". They are at positions: " + indexes);
    }    
}
