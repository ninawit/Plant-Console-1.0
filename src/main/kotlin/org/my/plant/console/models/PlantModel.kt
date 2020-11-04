package org.my.plant.console.models

data class PlantModel (var id: Long = 0,
                       var name: String = "",
                       var type: String = "",
                       var fragrant: String = "",
                       var colour: String = "",
                       var height: String = "",
                       var category: String = "",
                       var zone: String = "",
                       var light: String = "",
                       var season: String =""
                        )

//                       val name = bind(UpdateView.Plant::nameProperty)
//                       val type = bind(UpdateView.Plant::typeProperty)
//                       val zone = bind(UpdateView.Plant::zoneProperty)
//                       val light = bind(UpdateView.Plant::lightProperty)


