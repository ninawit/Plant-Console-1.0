package org.my.plant.console.models

import mu.KotlinLogging

//we still storing PlantStore in memory

/*bringing in an extra layer of separation between
how our data is stored and the functions the
the user would call to add, update, search... */

private val logger = KotlinLogging.logger {}
var lastId = 0L

internal fun getId(): Long {
    return lastId++
}

class PlantMemStore : PlantStore {

    val plants = ArrayList<PlantModel>()

    override fun findAll(): List<PlantModel> {
        return plants
    }

    override fun findOne(id: Long) : PlantModel? {
        var foundPlant: PlantModel? = plants.find { p -> p.id == id }
        return foundPlant
    }

    override fun create(plant: PlantModel) {
        plant.id = getId()
        plants.add(plant)
        logAll()
    }

    override fun update(plant: PlantModel) {
        var foundPlant = findOne(plant.id!!)
        if (foundPlant != null) {
            foundPlant.name = plant.name
            foundPlant.type = plant.type
            foundPlant.zone = plant.zone
            foundPlant.light = plant.light
        }
    }

    internal fun logAll() {
        plants.forEach { logger.info("${it}") }
    }
}