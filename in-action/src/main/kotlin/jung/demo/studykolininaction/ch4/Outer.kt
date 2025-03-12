package jung.demo.studykolininaction.ch4


class Outer(
    var outerValue: Int,
) {

    inner class Inner {
        fun printOuterValue(inputValue:Int): Int {

            this@Outer.outerValue = inputValue

            return outerValue
        }
    }
}