package letterFrequency;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FrequencyOfTheLetters {
    public static final String PATH_BEGINNING = "/textsForLetterFrequency/";
    private static final String ENGLISH_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public Map<Character, Integer> generateFrequencyVocabulary(String nameOfTheFile) throws IOException, URISyntaxException {

        Map<Integer, Integer> frequencyByLetter = ENGLISH_LETTERS.chars().boxed().collect(Collectors.toMap(c -> c, c -> 0));

        Path fullPath = Paths.get(FrequencyOfTheLetters.class.getResource(PATH_BEGINNING + nameOfTheFile).toURI());
        BufferedReader in = new BufferedReader(new FileReader(fullPath.toFile()));

        String line;
        while ((line = in.readLine()) != null) {
            line.toUpperCase().chars().forEach(c -> {
                if (frequencyByLetter.containsKey(c)) {
                    frequencyByLetter.replace(c, frequencyByLetter.get(c) + 1);
                }
            });
        }

        in.close();

        Map<Character, Integer> frequencyByCharacter = frequencyByLetter.entrySet()
                .stream()
                .collect(Collectors.toMap(c -> (char)c.getKey().byteValue(), Map.Entry::getValue));

        return frequencyByCharacter;

    }
}



