import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.nio.file.Paths;
import java.util.*;
/*Przechowuje tekst wczytany z pliku na odpowiednich zmiennych lokalnych*/

public class MyText {
    private Map<String, Integer> wordCountMap;

    public void readMyFile(String fileName) {
        wordCountMap = new HashMap<>();

        try {
            URL resourceUrl = MyText.class.getResource(fileName);
            if (resourceUrl != null) {
                File file = Paths.get(resourceUrl.toURI()).toFile();
                String filePath = file.getAbsolutePath();

                try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        String[] words = line.split(" ");
                        for (String word : words) {
                            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                        }
                    }
                }
            } else {
                System.out.println("Nie znaleziono pliku: " + fileName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Map<String, Integer> getEncodedWords(Cipher c) {
        Map<String, Integer> encodedWords = new HashMap<>();
        for (String word : wordCountMap.keySet()) {
            String encodedWord = c.encode(word);
            encodedWords.put(encodedWord, wordCountMap.get(word));
        }
        return encodedWords;
    }

    public Set<String> getWords(int n) {
        Set<String> mostFrequentWords = new HashSet<>();
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(wordCountMap.entrySet());
        entries.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        for (int i = 0; i < Math.min(n, entries.size()); i++) {
            mostFrequentWords.add(entries.get(i).getKey());
        }
        return mostFrequentWords;
    }

    public String getEncoding(String s) {
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            if (entry.getKey().equals(s)) {
                return entry.getKey();
            }
        }
        return "Word not found in encoded words.";
    }
}
