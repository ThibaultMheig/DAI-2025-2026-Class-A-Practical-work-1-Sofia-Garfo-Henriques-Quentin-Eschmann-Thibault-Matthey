package ch.heigvd.project1.commands;

import ch.heigvd.project1.ios.Read;
import ch.heigvd.project1.ios.Write;
import picocli.CommandLine;

import java.io.BufferedWriter;
import java.io.IOException;

/**
 * implementation of stats subcommand
 */
@CommandLine.Command(name = "stats", description = "Gives some statistics about the letters in a text file.")
public class Stats implements Runnable {

    @CommandLine.ParentCommand protected Root parent;

    /**
     * subcommand core
     */
    public void run(){
        String input = Read.readFile(parent.getIFileName());

        try {
            BufferedWriter bw = Write.open(parent.getOFileName());
            getChar(input, bw);
            getWords(input, bw);
            getLines(input, bw);
            Write.close(bw);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(-1);
        }

    }

    /**
     * gets the ammount of lines in a text file
     * @param String input, input file content,
     * @param BufferedWriter bw, buffer to write to the output file
     * @throws IOException
     */
    private void getLines(String input, BufferedWriter bw) throws IOException {
        //source: https://www.w3schools.com/java/java_howto_count_words.asp
        String[] lines = input.split(System.lineSeparator());

        bw.write("Your text contains  "+ lines.length + " lines.\n");
    }

    /**
     * finds the ammount of each letter in the text
     * @param String input, input file content,
     * @param BufferedWriter bw, buffer to write to the output file
     * @throws IOException
     */
    private void getChar(String input, BufferedWriter bw) throws IOException {
        String inputLower = input.toLowerCase();

        int[] stats = new int[26];
        int charNum = 0;
        for(int i = 0; i < inputLower.length(); i++){
            int index = getIndex(inputLower.charAt(i));

            if(index != -1){
                if(index < 0) bw.write(index + " " + inputLower.charAt(i) + "\n");
                stats[index]++;
                charNum++;
            }

        }

        bw.write("Your text contains "+charNum+" char : \n Here is the number of occurrences for each letter\n");
        for(int i = 0; i < stats.length; i++){
            if(stats[i] > 0){
                bw.write(stats[i] + " " + toChar(i) + "\n");
            }
        }
    }

    /**
     * gets the ammount of words in the input text
     * @param String input, input file content,
     * @param BufferedWriter bw, buffer to write to the output file
     * @throws IOException
     */
    private void getWords(String input, BufferedWriter bw) throws IOException {
        //source: https://www.w3schools.com/java/java_howto_count_words.asp
        String[] words = input.split("[\\s]");
        bw.write("Your text contains "+ words.length+ " words.\n");
    }

    /**
     * gets the number of a letter in the alphabet
     * @param char c, letter of the alphabet
     * @return int, number of the letter, -1 if not in the alphabet
     */
    private int getIndex(char c)  {
        int index = (int) c - 97;

        if(index >= 26 || index < 0) index = -1;

        return index;
    }


    /**
     * find the i th letter of the alphabet 
     * @param int i, number of a letter in the alphabet
     * @return char, i th letter of the alphabet
     */
    private char toChar(int i){
        int unicode = i + 97;
        return (char) unicode;
    }
}
