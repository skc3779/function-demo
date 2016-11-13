package functionthinks.recursion


// 색인을 사용한 목록 순회

def numbers = [6, 28, 4 ,9, 12, 4, 8, 8, 11, 45, 99, 2]

def iterateList(listOfNumbs) {
    listOfNumbs.each { n -> println "${n}" }
}

println "Iterate List ------------------------------"
iterateList(numbers)

// 재귀를 사용한 목록 순회

def recurseList(listOfNumbs) {
    if(listOfNumbs.size == 0) return

    println "${listOfNumbs.head()}"
    recurseList(listOfNumbs.tail())
}

println "Recurse List ----------------------------------"
recurseList(numbers)

// 명령형 필터

def filter(list, predicate) {
    def new_list = []
    list.each {
        if(predicate(it)) {
            new_list << it
        }
    }

    return new_list;
}

modBy2 = { n -> n % 2 == 0 }

modList = filter(numbers, modBy2)

println "filter List on mod by 2 -----------------------------------"
println "${modList}"


// 재귀적 필터

def filterRecurse(list, predicate) {
    if(list.size() == 0) return list
    if(predicate(list.head()))
        [] + list.head() + filterRecurse(list.tail(), predicate)
    else filter(list.tail(), predicate)
}

println "recurse filter -------------------------------------------"

println "${filterRecurse(numbers, {n-> n%2 == 0})}"