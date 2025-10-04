package ch.heigvd.project1.commands;

import picocli.CommandLine;

@CommandLine.Command(name = "stats", description = "Gives some statistics about the letters in a text file.")
public class Stats implements Runnable {
    public void run(){
        System.out.println("Stats");
    }
}
