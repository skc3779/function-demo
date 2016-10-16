package functionthinks.higherorder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.util.Map;

/**
 * Created by seokangchun on 2016. 10. 16..
 */
public class WordsTest {


    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void words() throws IOException {
        URL url = Resources.getResource("words.txt");
        String strSentence = Resources.toString(url, Charsets.UTF_8);

        Words words = new Words();
        Map map = words.wordFreq(strSentence);

        ObjectMapper objectMapper = new ObjectMapper();

        System.out.printf("%s%n", objectMapper.writeValueAsString(map));

    }
}