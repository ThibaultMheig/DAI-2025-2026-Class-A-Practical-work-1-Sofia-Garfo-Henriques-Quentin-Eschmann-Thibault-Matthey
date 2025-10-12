package ch.heigvd.project1.commands;

import picocli.CommandLine;

@CommandLine.Command(
        description = "DAI project01",
        version = "1.0.0",
        subcommands = {
            Occurences.class,
            Stats.class
        },
        scope = CommandLine.ScopeType.INHERIT,
        mixinStandardHelpOptions = true)
public class Root implements Runnable{
    @CommandLine.Parameters(index = "0", description = "The name of the input file.")
    protected  String  ifname;

    @CommandLine.Parameters(index = "1", description = "The name of the output file.")
    protected  String  ofname;

    public  String getIFileName(){
        return ifname;
    }

    public  String getOFileName(){
        return ofname;
    }
    public void run() {
        System.out.println(ifname + " " + ofname);
    }
}
