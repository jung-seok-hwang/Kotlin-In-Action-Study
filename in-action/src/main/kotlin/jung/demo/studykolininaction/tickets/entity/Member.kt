package jung.demo.studykolininaction.tickets.entity

class Member(
    var name: String,
    var age: Int,
    var city: String
) {

    fun moveTo(newCity: String) {
        this.city = newCity
    }

    fun incrementAge() {
        this.age += 1
    }

    override fun toString(): String {
        return "Member(name='$name', age=$age, city='$city')"
    }


}