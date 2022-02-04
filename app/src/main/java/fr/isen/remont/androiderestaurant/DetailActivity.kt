package fr.isen.remont.androiderestaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.isen.remont.androiderestaurant.databinding.ActivityDetailBinding
import fr.isen.remont.androiderestaurant.model.ItemViewModel

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dish = intent.getSerializableExtra("dish") as ItemViewModel
        initDetail(dish)

    }

    private fun initDetail(dish: ItemViewModel){
        binding.detailTitle.text = dish.text
    }
}