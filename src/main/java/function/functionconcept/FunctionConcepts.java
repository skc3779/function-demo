package function.functionconcept;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by seokangchun on 15. 4. 18..
 */
public class FunctionConcepts {

    private FunctionConcepts() {}

    /**
     * Map
     * @param inList 리스트 객체
     * @param func Function 인터페이스
     * @param <A1> Function 객체
     * @param <B> Function 결과객체
     * @return 변형 리스트 객체
     */
    public static <A1, B> List<B> map(List<A1> inList, Function1<A1, B> func) {
        ArrayList<B> outList = new ArrayList<B>();
        for(A1 obj: inList) {
            outList.add(func.call(obj));
        }
        return outList;
    }

    /**
     * Foreach
     * @param inList
     * @param func
     * @param <A>
     */
    public static <A> void foreach(ArrayList<A> inList, Foreach1<A> func) {
        for(A obj : inList) {
            func.call(obj);
        }
    }

    /**
     * filter
     * @param inList
     * @param test
     * @param <A>
     * @return
     */
    public static <A> ArrayList<A> filter(ArrayList<A> inList, Function1<A, Boolean> test) {
        ArrayList<A> outList = new ArrayList<A>();

        for(A obj : inList) {
            if(test.call(obj)) {
                outList.add(obj);
            }
        }
        return outList;
    }
}
