import java.util.*;

public class S2v{
    static void printFilteredWordFrequency(String feedback) {
        Set<String> stopWords = new HashSet<>(Arrays.asList(
            "the","was","and","a","is","of","in"
        ));

        String cleaned = feedback.toLowerCase()
                                 .replace(".","")
                                 .replace(",","");
        String[] words = cleaned.split("\\s+");

        Map<String,Integer> freq = new HashMap<>();
        for(String w:words) {
            if(!stopWords.contains(w)) {
                freq.put(w,freq.getOrDefault(w,0)+1);
            }
        }

        freq.entrySet().stream()
            .sorted((a,b)->b.getValue()-a.getValue())
            .forEach(e->System.out.println(e.getKey()+": "+e.getValue()));
    }

    public static void main(String[] args) {
        String text = "The mentor was great, the session was great and clear.";
        printFilteredWordFrequency(text);
    }
}
