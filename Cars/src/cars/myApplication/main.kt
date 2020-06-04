package cars.myApplication

fun main() {

    val car1 = Car()                //creates an instance of the class Car

    val capacity:Int= Car.capacity(car1)               //calling the member function capacity() of the class Car

    car1.airCondRequired()        //calling the member function airCondRequired() of the class Car

    val typeOfCar: String = takeInput()

    verification(car=typeOfCar,capacity = capacity)

    //from here onwards the processing oh the input data starts taking place
    println("\nPlease Wait Your Car Is Being Initialized........\n")

    RandomCar(car = typeOfCar).randomCarGenerator().also {
        println(it)
    } //calls the member function randomCarGenerator from the RandomCar class and also prints the acquired value

    car1.printDetails()           //prints the details of the car
    carAllottedDetails(typeOfCar) //provides the information of the car type,car colour etc.

    println("....  Happy Journey :-) ...")


}