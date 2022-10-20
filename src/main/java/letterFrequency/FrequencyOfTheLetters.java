package letterFrequency;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class FrequencyOfTheLetters {
    public static final String PATH_BEGINNING = "/textsForLetterFrequency/";
    private static final String ENGLISH_LETTERS = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z";

    public static Map<String, Integer> generateFrequencyVocabulary(String nameOfTheFile) throws IOException, URISyntaxException {
        String[] letterArray = ENGLISH_LETTERS.split(" ");

        Map<String, Integer> frequencyByLetter = new HashMap<>();
        for (String letter : letterArray) {
            frequencyByLetter.put(letter, 0);
        }

        Path fullPath = Paths.get(FrequencyOfTheLetters.class.getResource(PATH_BEGINNING + nameOfTheFile).toURI());
        BufferedReader in = new BufferedReader(new FileReader(fullPath.toFile()));

        String line;
        while ((line = in.readLine()) != null) {
            String[] characters = line.toUpperCase().split("");
            for (String character : characters) {
                if (frequencyByLetter.containsKey(character)) {
                    frequencyByLetter.replace(character, frequencyByLetter.get(character) + 1);
                }
            }
        }

        in.close();

        return frequencyByLetter;

    }
}

//    Izmantojot kādu no programmēšanas valodām, izveido angļu alfabēta burtu frekvences vārdnīcu.
//    Analīzei izvēlies tekstu vismaz 1000 zīmju garumā.
//
//    Risinājumā jābūt iekļautam analizētajam tekstam TXT formātā, automatizētam testam un izpildes instrukcijai.


