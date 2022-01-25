package fr.isen.remont.androiderestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast


class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val btnStarter = findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.btnStarter)
        val btnDish = findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.btnDish)
        val btnDessert = findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.btnDessert)

        btnStarter.setOnClickListener{
            ChangeActivity(getString(R.string.home_starter))
        }

        btnDish.setOnClickListener{
            ChangeActivity(getString(R.string.home_dish))
        }

        btnDessert.setOnClickListener{
            ChangeActivity(getString(R.string.home_dessert))
        }

    }

    private fun ChangeActivity(category: String) {
        //Toast.makeText(this@HomeActivity, "L'entrée est sélectionnée", Toast.LENGTH_SHORT).show()
        val changePage = Intent(this@HomeActivity, MainDishActivity::class.java).putExtra("category_type",category)
        Log.i("INFO", "End of MainDishActivity")
        startActivity(changePage)

    }
}