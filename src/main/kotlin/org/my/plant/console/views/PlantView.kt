package org.my.plant.console.views

import org.my.plant.console.models.PlantJSONStore
import org.my.plant.console.models.PlantModel

class PlantView {

    fun menu() : Int {

        var option : Int
        var input: String?

        println("MAIN MENU")
        println(" 1. Add Plant")
        println(" 2. Update Plant")
        println(" 3. List All Plants")
        println(" 4. Search Plants")
        println(" 5. Delete Plant")
        println("-1. Exit")
        println()
        print("Please enter menu option: ")
        input = readLine()!!
        option = if (input.toIntOrNull() != null && !input.isEmpty())
            input.toInt()
        else
            -9
        return option

    }

    fun listPlants(plants: PlantJSONStore) {
        println("List All Plants")
        println()
        plants.logAll()
        println()
    }

    fun showPlant(plant : PlantModel) {
        if(plant != null)
            println("Plant Details [ $plant ]")
        else
            println("Plant Not Found...")
    }

    fun addPlantData(plant : PlantModel) : Boolean {

        println()
        print("Enter a Plant Name : ")
        plant.name = readLine()!!
        print("Enter a Plant Type : ")
        plant.type = readLine()!!
        print("Enter Hardiness zone : ")
        plant.zone = readLine()!!
        print("Enter Light requirements : ")
        plant.light = readLine()!!

        return plant.name.isNotEmpty() && plant.type.isNotEmpty() && plant.zone.isNotEmpty() && plant.light.isNotEmpty()
    }

    fun updatePlantData(plant : PlantModel) : Boolean {

        var tempName: String?
        var tempType: String?
        var tempZone: String?
        var tempLight: String?

        if (plant != null) {
            print("Enter a new Plant name for [ " + plant.name + " ] : ")
            tempName = readLine()!!
            print("Enter a new Plant type for [ " + plant.type + " ] : ")
            tempType = readLine()!!
            print("Enter a new Hardiness zone for [ " + plant.zone + " ] : ")
            tempZone = readLine()!!
            print("Enter a new Light requirements for [ " + plant.light + " ] : ")
            tempLight = readLine()!!

            if (!tempName.isNullOrEmpty() && !tempType.isNullOrEmpty() && !tempZone.isNullOrEmpty() && !tempLight.isNullOrEmpty()) {
                plant.name = tempName
                plant.type = tempType
                plant.zone = tempZone
                plant.light = tempLight
                return true
            }
        }
        return false
    }

    fun getId() : Long {
        var strId : String? // String to hold user input
        var searchId : Long // Long to hold converted id
        print("Enter id to Search/Update : ")
        strId = readLine()!!
        searchId = if (strId.toLongOrNull() != null && !strId.isEmpty())
            strId.toLong()
        else
            -9
        return searchId
    }
}