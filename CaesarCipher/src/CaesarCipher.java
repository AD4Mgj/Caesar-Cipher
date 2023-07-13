import java.io.*;
import java.util.stream.Collectors;

public class CaesarCipher extends Caesar {
    private String wordCipher(int key, String word) {
        return splittedWord(word).stream()
                .map(letter -> shiftedAlphabet(key).get(getAlphabet().indexOf(letter)))
                .collect(Collectors.joining());
    }

    private String textCipher(int key, String text) {
        return splittedText(text).stream()
                .map(word -> wordCipher(key, word))
                .collect(Collectors.joining(" "));
    }

    public static void doCaesarCipher(int key, String input, String output) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(input));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(output))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                CaesarCipher caesarCipher = new CaesarCipher();
                bufferedWriter.write(caesarCipher.textCipher(key, line));
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
