package fr.isen.remont.androiderestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.util.Log
import fr.isen.remont.androiderestaurant.databinding.ActivityHomeBinding

class HomeActivity() : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnStarter.setOnClickListener{
            changeActivity("Entrées")
        }

        binding.btnDish.setOnClickListener{
            changeActivity("Plats")
        }

        binding.btnDessert.setOnClickListener{
            changeActivity("Desserts")
        }

    }

    private fun changeActivity(category: String){
        val intent = Intent(this, DishActivity::class.java)
        intent.putExtra("category_type", category)
        startActivity(intent)
    }


}