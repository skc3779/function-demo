package functionthinks.higherorder;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 텍스트 파일을 읽고, 가장 많이 사용된 단어들을 찾고 그 단어드로가 빈도를 정렬된 목록으로 출력하라
 */
public class Words {
    /**
     * 전치사 제외
     */
    private Set<String> NON_WORDS = new HashSet<String>() {{
        add("the"); add("and"); add("of"); add("to"); add("a"); add("i"); add("it"); add("in");
        add("or"); add("is"); add("s"); add("d"); add("as"); add("so"); add("but"); add("be");
        }
    };

    /**
     * 문장을 단어 배열로 돌려준다
     * @param words
     * @param regex
     * @return
     */
    private List<String> regexToList(String words, String regex) {
        List wordList = new ArrayList<>();
        Matcher m = Pattern.compile(regex).matcher(words);
        while(m.find()) {
            wordList.add(m.group());
        }
        return wordList;
    }

    /**
     * 고차함수 샘플 메소드
     * @param words
     * @return
     */
    public Map<String, Integer> wordFreq(String words) {
        TreeMap<String, Integer> wordMap = new TreeMap<>();
        regexToList(words, "\\w+").stream()
                .map(String::toLowerCase)
                .filter(w-> !NON_WORDS.contains(w))
                .forEach(w->wordMap.put(w, wordMap.getOrDefault(w, 0)+1));
        return wordMap;
    }
}
