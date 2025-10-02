package ch.heigvd.project1;

import ch.heigvd.project1.commands.Root;
import picocli.CommandLine;


public class Main {
    public static void main (String[] args){
        Root Sup = new Root();

        int exitCode =
                new CommandLine(Sup)
                        .execute(args);


        System.exit(exitCode);

    }
}
