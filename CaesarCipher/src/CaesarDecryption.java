import java.io.*;
import java.util.stream.Collectors;

public class CaesarDecryption extends Caesar {
    private String wordDecryption(int key, String word) {
        return splittedWord(word).stream()
                .map(letter -> getAlphabet().get(shiftedAlphabet(key).indexOf(letter)))
                .collect(Collectors.joining());
    }

    private String lineDecryption(int key, String text) {
        return splittedText(text).stream()
                .map(word -> wordDecryption(key, word))
                .collect(Collectors.joining(" "));
    }

    public static void doCaesarCipherDecryption(int key, String input, String output) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(input));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(output))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                CaesarDecryption caesarDecryption = new CaesarDecryption();
                bufferedWriter.write(caesarDecryption.lineDecryption(key, line));
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
