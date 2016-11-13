/**
 * 커링(Curring) : 커링은 다인수(muti-argument)함수를 일인수(single-argument)함수들의 체인으로 바꿔주는 방법
 * 부부 적용(partical application) : 주어진 다인수 함수를 생략될 인수의 값을 미리 정해서 더 적은 수의 인수를 받는 하나의함수로 변형하는
 * 방법
 */


// BEGIN groovy_adder_factory

println("groovy_adder_factory--------------------")

def adder = { x, y -> x + y}
def incrementer = adder.curry(1)

println "increment 7: ${incrementer(7)}"
// END groovy_adder_factory

// BEGIN groovy_currying

println ("groovy_currying-----------------------")
def product = { x, y -> x * y }

def quadrate = product.curry(4)     // <1>
def octate = product.curry(8)       // <2>

println "4x4: ${quadrate.call(4)}"  // <3>
println "8x5: ${octate(5)}"         // <4>
// END groovy_currying

// BEGIN currying_partial

println("currying_partial-------------------------")
def volume = {h, w, l -> h * w * l}
def area = volume.curry(1)
def lengthPA = volume.curry(1, 1)         // <1>
def lengthC = volume.curry(1).curry(1)    // <2>

println "The volume of the 2x3x4 rectangular solid is ${volume(2, 3, 4)}"
println "The area of the 3x4 rectangle is ${area(3, 4)}"
println "The length of the 6 line is ${lengthPA(6)}"
println "The length of the 6 line via curried function is ${lengthC(6)}"
// END currying_partial


// BEGIN groovy_composite

println("groovy_composite-------------------------")

def composite = { f, g, x -> return f(g(x)) }
def thirtyTwoer = composite.curry(quadrate, octate)

println "composition of curried functions yields ${thirtyTwoer(2)}"
// END groovy_composite