package org.my.plant.console.controllers

import mu.KotlinLogging
import org.my.plant.console.models.PlantJSONStore
import org.my.plant.console.models.PlantModel
import org.my.plant.console.views.PlantView

class PlantController {

    val plants = PlantJSONStore() //consistent storage
    val plantView = PlantView()
    val logger = KotlinLogging.logger {}

    init{
        logger.info { "Launching Plant Console App" }
    }

    fun start() {
        var input: Int

        do {
            input = menu()
            when (input) {
                1 -> add()
                2 -> update()
                3 -> list()
                4 -> search()
                5 -> delete()
                6 -> filter()
                7 -> calendar()
                -1 -> println("Exiting App")
                else -> println("Invalid Option")
            }
            println()
        } while (input != -1)
        logger.info { "Shutting Down Plant Console App" }
    }

    fun menu() :Int { return plantView.menu()}

    fun add(){

        var aPlant = PlantModel()

        if (plantView.addPlantData(aPlant))
            plants.create(aPlant)
        else
            logger.info("Plant Not Added")
    }

    fun update() {

        plantView.listPlants(plants)
        var searchId = plantView.getId()
        val aPlant = search(searchId)

        if(aPlant != null) {
            if(plantView.updatePlantData(aPlant)) {
                plants.update(aPlant)
                plantView.showPlant(aPlant)
                logger.info("Plant Updated : [ $aPlant ]")
            }
            else
                logger.info("Plant Not Updated")
        }
        else
            println("Plant Not Updated...")
    }

    fun list() {

        plantView.listPlants(plants)
    }

    fun search() {

        val aPlant = search(plantView.getId())!!
        plantView.showPlant(aPlant)
    }

    fun search(id: Long) : PlantModel? {

        var foundPlacemark = plants.findOne(id)
        return foundPlacemark
    }

    fun delete() {

        plantView.listPlants(plants)
        var searchId = plantView.getId()
        val aPlant = search(searchId)

        if(aPlant != null) {
            plants.delete(aPlant)
            //add plant ID in to the println
            println("Plant with ID: " + aPlant.id + " has now been deleted...")
            plantView.listPlants(plants)
        }
        else
            println("Plant Not Deleted...")
    }

    // TO DO... (filter plants by type, season, colour, HZ, light requirements and so on)
    fun filter() {
    }
    //TO DO... ( adding watering and fertilizing schedule for each plant type/category)
    fun calendar() {
    }
}