package ch.heigvd.project1.commands;

import picocli.CommandLine;

@CommandLine.Command(name = "stats", description = "Gives some statistics about the letters in a text file.")
public class Stats implements Runnable {
    public void run(){
        String input = "abdehhha";

        String inputLower = input.toLowerCase();

        int[] stats = new int[26];

        for(int i = 0; i < inputLower.length(); i++){
            int index = getIndex(inputLower.charAt(i));

            if(index != -1){
                if(index < 0) System.out.println(index + " " + inputLower.charAt(i));
                stats[index]++;
            }
        }

        System.out.println("In your text, there was: ");
        for(int i = 0; i < stats.length; i++){
            if(stats[i] > 0){
                System.out.println(stats[i] + " " + toChar(i));
            }
        }
    }

    private int getIndex(char c){
        int index = (int) c - 97;

        if(index >= 26 || index < 0) index = -1;

        return index;
    }

    private char toChar(int i){
        int unicode = i + 97;
        return (char) unicode;
    }
}
