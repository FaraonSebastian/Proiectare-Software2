import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomGenerator {
    public static void generateRandomWordsFile(String outputFile) throws IOException {
        Path outputPath = Paths.get(outputFile);
        Random random = new Random();
        List<String> lines = new ArrayList<>();

        for (int i = 0; i < 5; i++) { // 5 linii
            List<String> words = new ArrayList<>();
            for (int j = 0; j < 10; j++) { // 10 cuvinte pe linie
                words.add(generateRandomWord(4, random));
            }
            Collections.sort(words); // Sortare crescătoare
            lines.add(String.join(" ", words));
        }

        Files.write(outputPath, lines);
    }

    public static String generateRandomWord(int length, Random random) {
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < length; i++) {
            word.append((char) ('a' + random.nextInt(26))); // Litere din [a..z]
        }
        return word.toString();
    }
}
