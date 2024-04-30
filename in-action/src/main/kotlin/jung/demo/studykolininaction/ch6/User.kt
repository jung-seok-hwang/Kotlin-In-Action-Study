package jung.demo.studykolininaction.ch6

class User (
    val name: String,
    val age: Int
){
    override fun toString(): String {
        return "User(name='$name', age=$age)"
    }
}