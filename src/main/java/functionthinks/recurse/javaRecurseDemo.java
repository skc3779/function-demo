package functionthinks.recurse;

import functionthinks.recursion.Recurse;

import java.util.Arrays;
import java.util.List;

/**
 * Created by seokangchun on 2016. 10. 30..
 */
public class javaRecurseDemo {
    public static void main(String[] args) throws Exception {

        // groovy를 이용한 재귀 사용
        List<Integer> numbs = Arrays.asList(6, 28, 4, 9, 12, 4, 8, 8, 11, 45, 99, 2);
        Recurse rec = new Recurse();
        List<Integer> filterList = (List<Integer>) rec.filter(numbs, rec.predicate(2));
        System.out.println("recurse filter -------------------------------");
        System.out.println(filterList);

    }
}
