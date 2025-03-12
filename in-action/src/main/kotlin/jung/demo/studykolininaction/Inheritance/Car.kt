package jung.demo.studykolininaction.Inheritance

open class Car {
    protected open var make: String = ""
    private var model: String = ""
    private var year: Int = 0

    constructor(make: String, model: String, year: Int) {
        this.make = make
        this.model = model
        this.year = year
    }


    fun findModel(searchModel: String): String {
        return if (searchModel == this.model) {
            model
        } else {
            "찾지 못했습니다."
        }
    }

    fun getYear(): Int {
        return this.year
    }

    override fun toString(): String {
        return "Car(make='$make', model='$model', year=$year)"
    }
}