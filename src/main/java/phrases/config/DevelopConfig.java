package phrases.config;

import org.apache.spark.SparkConf;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DevelopConfig {
    @Bean
    public SparkConf sparkConf(){
        return new SparkConf().setAppName("my finder").setMaster("local");
    }


}
