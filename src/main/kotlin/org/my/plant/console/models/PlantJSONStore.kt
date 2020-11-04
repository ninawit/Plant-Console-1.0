package org.my.plant.console.models

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import mu.KotlinLogging

import org.my.plant.console.helpers.*
import java.util.*

private val logger = KotlinLogging.logger {}

//declarations:
val JSON_FILE = "plants.json" //this is where data is stored
val gsonBuilder = GsonBuilder().setPrettyPrinting().create() //from google libraries
val listType = object : TypeToken<ArrayList<PlantModel>>() {}.type //telling google library what we want it convert it to and from

fun generateRandomId(): Long {
    return Random().nextLong()
}

class PlantJSONStore : PlantStore {

    var plants = mutableListOf<PlantModel>()

    init {
        if (exists(JSON_FILE)) {
            deserialize()
        }
    }

    override fun findAll(): MutableList<PlantModel> {
        return plants
    }

    override fun findOne(id: Long) : PlantModel? {
        var foundPlant: PlantModel? = plants.find { p -> p.id == id }
        return foundPlant
    }

    override fun create(plant: PlantModel) {
        plant.id = generateRandomId()
        plants.add(plant)
        serialize()
    }

    override fun update(plant: PlantModel) {
        var foundPlant = findOne(plant.id!!)
        if (foundPlant != null) {
            foundPlant.name = plant.name
            foundPlant.type = plant.type
            foundPlant.fragrant = plant.fragrant
            foundPlant.colour = plant.colour
            foundPlant.height = plant.height
            foundPlant.category = plant.category
            foundPlant.zone = plant.zone
            foundPlant.light = plant.light
            foundPlant.season = plant.season
        }
        serialize()
    }

    override fun delete(plant: PlantModel) {
        plants.remove(plant)
        serialize()
    }
    // TO DO....
    override fun filter(plant: PlantModel){
        plants.filter { PlantModel -> true }
        serialize()
    }

    internal fun logAll() {
        plants.forEach { logger.info("${it}") }
    }

    //responsible for writing out
    private fun serialize() {
        val jsonString = gsonBuilder.toJson(plants, listType)
        write(JSON_FILE, jsonString)
    }

    //responsible for reading back in
    private fun deserialize() {
        val jsonString = read(JSON_FILE)
        plants = Gson().fromJson(jsonString, listType)
    }
}