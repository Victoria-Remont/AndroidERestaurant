package fr.isen.remont.androiderestaurant

import java.io.Serializable

class RegisterResult(val data: User) {}

class User(val id: Int): Serializable {}