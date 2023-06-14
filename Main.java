import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        int n = 10;
        CipherCaesar caesar = new CipherCaesar();
        CipherMorse morse = new CipherMorse();

        MyText textRead = new MyText();
        textRead.readMyFile("text_to_encode.txt");
        Set<String> s = textRead.getWords(n);
        for (String word : s) System.out.println(word);
        Map<String, Integer> encoded = textRead.getEncodedWords(caesar);
        for (String str : encoded.keySet()) System.out.println(str);

    }
}
