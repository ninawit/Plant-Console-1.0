package org.my.plant.console.main

import mu.KotlinLogging
import org.my.plant.console.controllers.PlantController
import org.my.plant.console.models.PlantMemStore
import org.my.plant.console.models.PlantModel
import org.my.plant.console.views.PlantView

//an instance of the logger, using it only once
//private val logger = KotlinLogging.logger {}

//val plants = ArrayList<PlantModel>()
//val plants = PlantMemStore()
//val plantView = PlantView()
//val controller = PlantController()

fun main(args: Array<String>){

//    logger.info { "Launching Plant Console App" }
//    println("Plant Kotlin App Version 1.0")

//    var input: Int

//    do {
//        input = plantView.menu()
//        when(input) {
//            1 -> addPlant()
//            2 -> updatePlant()
//            3 -> plantView.listPlants(plants)
//            4 -> searchPlant()

//        //updated code
//        input = controller.menu()
//        when(input) {
//            1 -> controller.add()
//            2 -> controller.update()
//            3 -> controller.list()
//            4 -> controller.search()
//            -99 -> controller.dummyData()
//            -1 -> println("Exiting App")
//            else -> println("Invalid Option")
//        }
//        println()
//    } while (input != -1)
//    logger.info { "Shutting Down Plant Console App" }

    //another update
//    controller.start()

    //final update
    PlantController().start()
}

//menu function with int return type
//fun menu() : Int {
//
//    var option : Int
//    var input: String?
//
//    println("MAIN MENU")
//    println(" 1. Add Plant")
//    println(" 2. Update Plant")
//    println(" 3. List All Plants")
//    println(" 4. Search Plants")
//    println("-1. Exit")
//    println()
//    print("Please enter menu option: ")
//    input = readLine()!!
//    option = if (input.toIntOrNull() != null && !input.isEmpty())
//        input.toInt()
//    else
//        -9
//    return option
//}

//fun addPlant(){
//    var aPlant = PlantModel()
//    println("Add Plant")
//    println()
//    print("Enter a Plant Name : ")
//    aPlant.name = readLine()!!
//    print("Enter a Plant Type : ")
//    aPlant.type = readLine()!!
//    print("Enter Hardiness zone : ")
//    aPlant.zone = readLine()!!
//    print("Enter Light requirements : ")
//    aPlant.light = readLine()!!
//
//    if (aPlant.name.isNotEmpty() && aPlant.type.isNotEmpty() && aPlant.zone.isNotEmpty() && aPlant.light.isNotEmpty()) {
////        aPlant.id = plants.size.toLong()
////        plants.add(aPlant.copy())
//        plants.create(aPlant.copy())
//        logger.info("Plant Added : [ $aPlant ]")
//    }
//    else
//        logger.info("Plant Not Added")

//    //updated code
//    var aPlant = PlantModel() //declare the object
//
//    if (plantView.addPlantData(aPlant)) //call plantView to get all the data
//        plants.create(aPlant) //create
//    else
//        logger.info("Plant Not Added")
//}

//fun updatePlant(){
//    println("Update Plant")
//    println()
//    listPlants()
//    var searchId = getId() //getting the id
////    val aPlant = search(searchId)
//    val aPlant = plants.findOne(searchId) //search for the plant (found aPlant)
//    var tempName : String?
//    var tempType : String?
//    var tempZone : String?
//    var tempLight : String?
//
//    if(aPlant != null) { //get data from the user
//        print("Enter a new Plant name for [ " + aPlant.name + " ] : ")
//        tempName = readLine()!!
//        print("Enter a new Plant type for [ " + aPlant.type + " ] : ")
//        tempType = readLine()!!
//        print("Enter a new Hardiness zone for [ " + aPlant.zone + " ] : ")
//        tempZone = readLine()!!
//        print("Enter a new Light requirements for [ " + aPlant.light + " ] : ")
//        tempLight = readLine()!!
//
//        if (!tempName.isNullOrEmpty() && !tempType.isNullOrEmpty() && !tempZone.isNullOrEmpty() && !tempLight.isNullOrEmpty()) {
//            //update aPlant
//            aPlant.name = tempName
//            aPlant.type = tempType
//            aPlant.zone = tempZone
//            aPlant.light = tempLight
//            plants.update(aPlant)
//            println(
//                "You updated [ " + aPlant.name + " ] for plant name, "
//                        + "[ " + aPlant.type + " ] for plant type, "
//                        + "[ " + aPlant.zone + " ] for HZ, "
//                        + "and [ " + aPlant.light + " ] for light requirements"
//            )
//        } else
//            logger.info("Plant Not Updated")
//    }
//    else {
//        println("Plant Not Updated...")
//    }

    //updated code
//    plantView.listPlants(plants)
//    var searchId = plantView.getId()
//    val aPlant = search(searchId)
//
//    if(aPlant != null) {
//        if(plantView.updatePlantData(aPlant)) {
//            plants.update(aPlant)
//            plantView.showPlant(aPlant)
//            logger.info("Plant Updated : [ $aPlant ]")
//        }
//        else
//            logger.info("Plant Not Updated")
//    }
//    else
//        println("Plant Not Updated...")
//}

//fun listPlants(){
//    println("List All Plants")
//    println()
////    plants.forEach { logger.info("${it}") }
//    plants.logAll()
//    println()
//}

//fun searchPlant() {
//    var searchId = getId()
////    val aPlant = search(searchId)
//    val aPlant = plants.findOne(searchId)
//
//    if(aPlant != null)
//        println("Plant Details [ $aPlant ]")
//    else
//        println("Plant Not Found...")

//    //updated code
//    val aPlant = search(plantView.getId())!!
//    plantView.showPlant(aPlant)
//}

//fun getId() : Long {
//    var strId : String? // String to hold user input
//    var searchId : Long // Long to hold converted id
//    print("Enter id to Search/Update : ")
//    strId = readLine()!!
//    searchId = if (strId.toLongOrNull() != null && !strId.isEmpty())
//        strId.toLong()
//    else
//        -9
//    return searchId
//}

//fun search(id: Long) : PlantModel? {
//    var foundPlant: PlantModel? = plants.find { p -> p.id == id }
//    return foundPlant

//    //updated code
//    var foundPlant = plants.findOne(id)
//    return foundPlant
//}

//fun dummyData() {
//    plants.create(PlantModel(1, "Tulip", "Outdoor", "6a", "part sun"))
//    plants.create(PlantModel(2, "Rose", "Outdoor", "6a", "full sun"))
//    plants.create(PlantModel(3, "Cherry", "Outdoor", "9a", "full sun"))
//}

//Testing commit