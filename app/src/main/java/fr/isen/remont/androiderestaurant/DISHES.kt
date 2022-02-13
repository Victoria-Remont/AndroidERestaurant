package fr.isen.remont.androiderestaurant

import java.io.Serializable

enum class DISHES(val nameId : Int) :Serializable {

    MAIN(R.string.home_dish),
    DESSERT(R.string.home_dessert),
    STARTER(R.string.home_starter);
}