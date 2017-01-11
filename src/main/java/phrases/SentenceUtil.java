package phrases;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SentenceUtil {

    @org.jetbrains.annotations.NotNull
    public static List<String> getSentence(String text){
            return Arrays.asList(text.split("[.!?]"));
    }
}
