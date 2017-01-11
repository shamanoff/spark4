package countWords;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.broadcast.Broadcast;
import org.springframework.stereotype.Service;
import scala.Tuple2;

import java.io.Serializable;
import java.util.List;


@Service
public class PopularWordCounter implements Serializable {


    @AutowiredBroadcast
    private Broadcast<UserConfig> userConfig;

    public List<String> topX(JavaRDD<String> rdd, int x) {
        return rdd.map(String::toLowerCase).
                flatMap(WordsUtil::getWords)
                .filter(word -> !userConfig.value().garbage.contains(word))
                .mapToPair(word -> new Tuple2<>(word, 1))
                .reduceByKey(Integer::sum)
                .mapToPair(Tuple2::swap)
                .sortByKey(false)
                .map(Tuple2::_2).take(x);

    }
}
