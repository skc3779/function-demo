package functionthinks.closure
/**
 * Created by seokangchun on 2016. 10. 29..
 */
import spock.lang.Specification

class EmployeeTest extends Specification {

    def paidMore(amount) {
        return {Employee e -> e.salary > amount }
    }

    def isHighPaid = paidMore(10000)

    def closureTest() {

        when:
        def one = new Employee(name:"one name", salary: 12000);
        def two = new Employee(name:"two name", salary: 8000);

        then:
        isHighPaid(one) == true
        isHighPaid(two) == false

    }
}
