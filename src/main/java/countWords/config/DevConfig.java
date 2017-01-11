package countWords.config;

import org.apache.spark.SparkConf;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DevConfig {
    @Bean
    public SparkConf sparkConf(){
        return new SparkConf().setAppName("my app").setMaster("local");
    }
}
