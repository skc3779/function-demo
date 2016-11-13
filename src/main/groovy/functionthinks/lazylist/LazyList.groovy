package functionthinks.lazylist

/**
 * Created by seokangchun on 2016. 10. 30..
 */
class LazyList {
    private head, tail

    LazyList(head, tail) {
        this.head = head;
        this.tail = tail;

    }

    def LazyList getTail() { tail ? tail() : null }

    def List getHead(n) {
        def harvestedValues = []
        def current = this

        n.times {
            harvestedValues << current.head
            current = current.tail
        }
        harvestedValues
    }

    def LazyList filter(Closure p) {
        if(p(head))
            p.owner.prepend(head, {getTail().filter(p)})
        else
            getTail().filter(p)

    }
}
