package phrases;

import org.apache.spark.api.java.JavaRDD;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
@Qualifier("PhraseFinder")
public class PhraseFinder implements Serializable {

    public List<String> phraseList(JavaRDD<String> rdd, String word){
       return (List<String>) rdd.map(String::toLowerCase)
                .flatMap(SentenceUtil::getSentence)
                .filter(s -> s.contains(word));

    }
}
