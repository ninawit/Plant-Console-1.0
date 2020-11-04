package org.my.plant.console.main

import org.my.plant.console.app.MyApp
import org.my.plant.console.controllers.PlantController
import tornadofx.launch

fun main(args: Array<String>){

    PlantController().start()
//    launch<MyApp>()
}
