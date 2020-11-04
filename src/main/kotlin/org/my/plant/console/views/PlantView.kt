package org.my.plant.console.views

import org.my.plant.console.models.PlantJSONStore
import org.my.plant.console.models.PlantModel

class PlantView {

    fun menu(): Int {

        var option: Int
        var input: String?

        println("MAIN MENU")
        println(" 1. Add Plant")
        println(" 2. Update Plant")
        println(" 3. List All Plants")
        println(" 4. Search Plants")
        println(" 5. Delete Plant")
        println(" 6. Filter Plants")
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

    fun showPlant(plant: PlantModel) {

        if (plant != null)
            println("Plant Details [ $plant ]")
        else
            println("Plant Not Found...")
    }

    fun addPlantData(plant: PlantModel): Boolean {

        println()
        print("Enter a Plant Name: ")
        plant.name = readLine()!!
        print("Enter a Plant Type (Outdoor/Indoor): ")
        plant.type = readLine()!!
        print("Is plant fragrant (yes/no): ")
        plant.fragrant = readLine()!!
        println("Enter a Plant Colour: ")
        println("   Red")
        println("   Green")
        println("   Blue")
        println("   Yellow")
        println("   Black")
        println("   White")
        println("   Pink")
        println("   Purple")
        println("   Orange")
        plant.colour = readLine()!!
        print("Enter a Plant Height (in cm): ")
        plant.height = readLine()!!
        println("Enter a Plant Category : ")
        println("   Plant")
        println("   Flower")
        println("   Bush")
        println("   Tree")
        plant.category = readLine()!!
        println("Enter Hardiness zone: ")
        println("   zone 1 - (-51 to -45)")
        println("   zone 2 - (-45 to -40)")
        println("   zone 3 - (-40 to -35)")
        println("   zone 4 - (-35 to -29)")
        println("   zone 5 - (-29 to -23)")
        println("   zone 6 - (-23 to -18)")
        println("   zone 7 - (-18 to -12)")
        println("   zone 8 - (-12 to -7)")
        println("   zone 9 - (-7 to -1)")
        println("   zone 10 - (-1 to 4)")
        println("   zone 11 - (4 to 10)")
        println("   zone 12 - (10 to 16)")
        println("   zone 13 - (16 to 21)")
        plant.zone = readLine()!!
        println("Enter Light requirements: ")
        println("   full-sun -> (6-10 hrs/day)")
        println("   part-sun -> (3-6 hrs/day)")
        println("   shade -> (1-3hrs/day)")
        plant.light = readLine()!!
        println("Enter a Plant Season")
        plant.season = readLine()!!

        return plant.name.isNotEmpty() && plant.type.isNotEmpty() && plant.zone.isNotEmpty() && plant.light.isNotEmpty()
    }

    fun updatePlantData(plant: PlantModel): Boolean {

        var tempName: String?
        var tempType: String?
        var tempFragrant: String?
        var tempColour: String?
        var tempHeight: String?
        var tempCategory: String?
        var tempZone: String?
        var tempLight: String?
        var tempSeason: String?

        if (plant != null) {
            print("Enter a new Plant name for [ " + plant.name + " ] : ")
            tempName = readLine()!!
            print("Enter a new Plant type for [ " + plant.type + " ] : ")
            tempType = readLine()!!
            print("Enter if Plant fragrant for [ " + plant.fragrant + " ] : ")
            tempFragrant = readLine()!!
            print("Enter a new Plant colour for [ " + plant.colour + " ] : ")
            tempColour = readLine()!!
            print("Enter a new Plant height for [ " + plant.height + " ] : ")
            tempHeight = readLine()!!
            print("Enter a new Plant category for [ " + plant.category + " ] : ")
            tempCategory = readLine()!!
            print("Enter a new Hardiness zone for [ " + plant.zone + " ] : ")
            tempZone = readLine()!!
            print("Enter a new Light requirements for [ " + plant.light + " ] : ")
            tempLight = readLine()!!
            print("Enter a new Plant season for [ " + plant.season + " ] : ")
            tempSeason = readLine()!!

            if (!tempName.isNullOrEmpty() && !tempType.isNullOrEmpty() && !tempZone.isNullOrEmpty() && !tempLight.isNullOrEmpty()) {
                plant.name = tempName
                plant.type = tempType
                plant.fragrant = tempFragrant
                plant.colour = tempColour
                plant.height = tempHeight
                plant.category = tempCategory
                plant.zone = tempZone
                plant.light = tempLight
                plant.season = tempSeason
                return true
            }
        }
        return false
    }
    //TO DO...
    fun filter(plant: PlantModel) {
    }

    fun getId() : Long {

        var strId : String? // String to hold user input
        var searchId : Long // Long to hold converted id
        print("Enter plant ID: ")
        strId = readLine()!!
        searchId = if (strId.toLongOrNull() != null && !strId.isEmpty())
            strId.toLong()
        else
            -9
        return searchId
    }
}