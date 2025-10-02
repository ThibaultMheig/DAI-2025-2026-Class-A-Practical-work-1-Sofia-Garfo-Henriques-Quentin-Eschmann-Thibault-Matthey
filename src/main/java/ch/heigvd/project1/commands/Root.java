package ch.heigvd.project1.commands;

import picocli.CommandLine;

@CommandLine.Command(
        description = "A small CLI to experiment with Java IOs.",
        version = "1.0.0",
        subcommands = {
        },
        scope = CommandLine.ScopeType.INHERIT,
        mixinStandardHelpOptions = true)
public class Root implements Runnable{
    @CommandLine.Parameters(index = "0", description = "The name of the file.")
    public String filename;

    public void run() {
        System.out.println(filename);
    }
}
