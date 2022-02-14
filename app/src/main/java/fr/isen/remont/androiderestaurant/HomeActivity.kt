package fr.isen.remont.androiderestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.util.Log
import android.widget.Toolbar
import fr.isen.remont.androiderestaurant.databinding.ActivityHomeBinding

const val TRANSFERT = "category_type"

class HomeActivity() : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // binding the buttons of the home page, leading to the starter, main dish and dessert page
        binding.btnStarter.setOnClickListener{
            changeActivity(DISHES.STARTER)
            Log.e("Starter page opened","HomeActivity closed")
        }

        binding.btnDish.setOnClickListener{
            changeActivity(DISHES.MAIN)
            Log.e("Main dish page opened","HomeActivity closed")
        }

        binding.btnDessert.setOnClickListener{
            changeActivity(DISHES.DESSERT)
            Log.e("Dessert page opened","HomeActivity closed")
        }



    }

    private fun changeActivity(category: DISHES){
        val intent = Intent(this, DishActivity::class.java)
        intent.putExtra(TRANSFERT, category)
        Log.i("INFO", "End of HomeActivity")
        startActivity(intent)
    }


}