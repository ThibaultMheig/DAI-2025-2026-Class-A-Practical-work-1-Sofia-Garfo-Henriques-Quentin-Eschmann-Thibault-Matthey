package ch.heigvd.project1.commands;

import picocli.CommandLine;

@CommandLine.Command(name = "occurences", description = "Find all the words occurences in a text file")
public class Occurences implements Runnable {

    @CommandLine.Option(
        names = {"-w", "--word"},
        description = "The word that you want to look for in the text. (Only compatible with occurences command)",
        required = true
    )
    protected String word;

    public void run(){
        System.out.println("Occurences of " + word);
    }    
}
