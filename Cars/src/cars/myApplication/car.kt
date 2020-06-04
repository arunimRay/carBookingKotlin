package cars.myApplication

import java.util.*
import kotlin.system.exitProcess

interface CarDetails{                             //the interface is containing various functions which get overriden
                                                  // in the subsequent classes as per requirement
    fun rate(){}
    fun color(){ println("The Color Of Your Car:Silver") }
    fun randomCarGenerator():String=""

}

abstract class CarTypeCapacity{                    //There can be only one abstract class and it has got a property
                                                   // which defines the maximum capacity of the car
    open val carTypeCapacity:Int=0
}



class RandomCar(val car:String):CarDetails{         //This class contains different types of cars and gives a random car
                                                    // on calling a particular member function


     private val  availableHatchbackCar= arrayOf<String>("Alto","Tata Indica","Baleno","Swift")
     private val  availableSedanCar= arrayOf<String>("Maruti Suzuki Ciaz","Honda City","Skoda Rapid","Swift Desire")
     private val  availableSuvCar= arrayOf<String> ("Renault Duster","Mahindra Bolero","Xylo","Tata Sumo")

    override fun randomCarGenerator(): String {
        return when(car){
                "Hatchback" -> availableHatchbackCar[Random().nextInt(4)]
                "Sedan" -> availableSedanCar[Random().nextInt(4)]
                "SUV" -> availableSuvCar[Random().nextInt(4)]
                 else ->"Error"
        }
    }
}

open class Car(open var needAc:String = "No" ,open var capacity:Int = 0) {

    init {
       println(".......Welcome To The Car Booking Portal.......")
    }


    open fun airCondRequired() {
        val getResponse = Scanner(System.`in`)
        print("Air Conditioning Required(Yes/No)")
        val ac: String = getResponse.next()
        if (ac == "Yes") needAc = "Yes"
    }



    fun printDetails() {
        println("The Maximum Capacity Of The Car: $capacity")
        println("Air Conditioning Requirement Status:$needAc")

    }

    companion object {                          //Since capacity has to be used for Verification it is defined
                                                // in a companion object inside the class Car

        fun capacity(car: Car): Int {
            val noOfPassenger = Scanner(System.`in`)
            print("Please Enter The No. Of Passengers: ")
            car.capacity = noOfPassenger.nextInt()

            when (car.capacity) {
                in 1..4 -> car.capacity = 5
                in 5..7 -> car.capacity = 8
                else -> {
                    println("You can have at max 7 Passengers in a particular booking")
                    exitProcess(0)}
            }

            return car.capacity
        }
    }
}

open class Sedan:CarDetails,CarTypeCapacity(){                        //Details for the type of car Sedan
    override val carTypeCapacity=5
    override fun rate(){ println("Your Rate will be:Rs 12 /Km")}
}


open class HatchBack:CarDetails,CarTypeCapacity(){                    //Details for the type of car Hatchback
    override val carTypeCapacity=5
    override fun color(){ println("The Color Of Your Car: Black")}
    override fun rate(){ println("Your Rate will be:Rs 10 /Km")}
}


open class SUV:CarDetails,CarTypeCapacity(){                          //Details for the type of car SUV
    override val carTypeCapacity=8
    override fun color(){ println("The Color Of Your Car: Brown")}
    override fun rate(){ println("Your Rate will be:Rs 13 /Km")}
}








