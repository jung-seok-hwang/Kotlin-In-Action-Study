package jung.demo.studykolininaction.Inheritance

class NCar(
    override var make: String,
    model: String,
    year: Int
) : Car(make,model, year) {

}