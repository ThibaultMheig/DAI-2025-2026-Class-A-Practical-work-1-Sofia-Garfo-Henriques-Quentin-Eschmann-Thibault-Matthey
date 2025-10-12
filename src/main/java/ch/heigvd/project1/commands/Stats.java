package ch.heigvd.project1.commands;

import picocli.CommandLine;

@CommandLine.Command(name = "stats", description = "Gives some statistics about the letters in a text file.")
public class Stats implements Runnable {
    public void run(){
        String input = "abdehhha";
        String input2 = "Ceci est un test qui est concluant évidemment";
        getChar(input);
        getWords(input2);
    }
    private void getLines(){
        int lines = 0;
        //while (reader.readLine() != null) lines++;
        System.out.println("Votre string contient "+ lines + " lignes.");

    }
    private void getChar(String input){
        String inputLower = input.toLowerCase();

        int[] stats = new int[26];
        int charNum = 0;
        for(int i = 0; i < inputLower.length(); i++){
            int index = getIndex(inputLower.charAt(i));

            if(index != -1){
                if(index < 0) System.out.println(index + " " + inputLower.charAt(i));
                stats[index]++;
                charNum++;
            }
        }

        System.out.println("In your text, there was "+charNum+" char : ");
        for(int i = 0; i < stats.length; i++){
            if(stats[i] > 0){
                System.out.println(stats[i] + " " + toChar(i));
            }
        }
    }

    private void getWords(String input){
        String[] words = input.split("[,\\.\\s]");
        System.out.println("In your text there was "+ words.length+ " words.");

           /*for (String s : words) {
            System.out.println(s);
        }*/

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
