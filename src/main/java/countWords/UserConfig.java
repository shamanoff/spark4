package countWords;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


@Component
public class UserConfig implements Serializable{
    public Set<String> garbage;

    @Value("${garbage}")
    private void setGarbage(String[] garbage) {
        this.garbage = new HashSet<>(Arrays.asList(garbage));
    }
}
