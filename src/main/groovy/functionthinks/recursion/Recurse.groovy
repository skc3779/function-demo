package functionthinks.recursion

/**
 * Created by seokangchun on 2016. 10. 30..
 */
class Recurse {
    def predicate(num) {
        return { n -> n%num == 0 }
    }

    def filter(list, predicate) {
        if(list.size() == 0) return list
        if(predicate(list.head()))
            [] + list.head() + filter(list.tail(), predicate)
        else filter(list.tail(), predicate)
    }
}
