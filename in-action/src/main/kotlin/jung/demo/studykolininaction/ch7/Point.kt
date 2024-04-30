package jung.demo.studykolininaction.ch7

data class Point (
    val x: Int,
    val y: Int
) {
    operator fun plus(p: Point):Point  {
        println("현제 포인트 값 : $p")
        return Point(x + p.x, y + p.y)
    }
}