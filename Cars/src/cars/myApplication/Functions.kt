package cars.myApplication

import java.util.*
import kotlin.system.exitProcess


fun takeInput():String{                       //takes input from the user about the type of car they would like to prefer.
    val typeOfCar = Scanner(System.`in`)
    print("Enter Type Of car(Hatchback/Sedan/SUV)")

    return typeOfCar.next()
}




fun carAllottedDetails(car:String){          //Defines the common characteristics of the car that has been allotted to the customer.
    when (car) {
        "Hatchback" -> {
            HatchBack().rate()
            HatchBack().color()
        }
        "Sedan" -> {
            Sedan().rate()
            Sedan().color()
        }
        "SUV" -> {
            SUV().rate()
            SUV().color()
        }

    }
}

fun verification(capacity: Int,car:String){                 //this fucntion verifies that the number of passengers does not exceed the capacity of the car
    if((car=="Hatchback"||car=="Sedan") && capacity>5){
        println("Error..Since the capacity has exceeded the Car Type capacity")
        exitProcess(0)
    }
}

