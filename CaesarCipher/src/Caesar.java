import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class Caesar {
    private static final String characters = "abcdefghijklmnopqrstuvwxyz";
    private final List<String> alphabet = Arrays.asList(characters.split(""));

    public List<String> splittedText(String text) {
        return List.of(text.toLowerCase().split(" "));
    }

    public List<String> splittedWord(String word) throws IllegalArgumentException {
        for (char c : word.toCharArray()) {
            if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
                throw new IllegalArgumentException("The text contains illegal characters.");
            }
        }
        return List.of(word.split(""));
    }

    public List<String> shiftedAlphabet(int key) {
        return Stream.concat(alphabet.stream().skip(key), alphabet.stream().limit(key))
                .collect(Collectors.toList());
    }

    public List<String> getAlphabet() {
        return alphabet;
    }
}
