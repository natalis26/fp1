object HigherOrder extends App {
val plus: (Int, Int) => Int = _ + _
val multiply: (Int, Int) => Int = _ * _
def nTimes(f: (Int, Int) => Int, a: Int, b: Int, n: Int): Int = n * f(a, b)
def testNTimes(f: (Int, Int) => Int, a: Int, b: Int, n: Int): Int = nTimes(f, a, b, n)
def testAnonymousNTimes(a: Int, b: Int, n: Int): Int = nTimes((a: Int,b: Int) => { 
    if (a > b) a else b },  a: Int, b: Int, n: Int)
    println("testNTimes:\t" + testNTimes(plus,  1, 12, 5))
    println("testAnonymousNTimes:\t" + testAnonymousNTimes(2, 30, 2))
    }