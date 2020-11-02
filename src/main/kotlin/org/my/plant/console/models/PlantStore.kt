package org.my.plant.console.models

//as a developer guarantying for any one else
//who implements PlantStore has to follow this rules:
interface PlantStore {
    fun findAll(): List<PlantModel>
    fun findOne(id: Long): PlantModel?
    fun create(plant: PlantModel)
    fun update(plant: PlantModel)
    fun delete(plant: PlantModel)
}