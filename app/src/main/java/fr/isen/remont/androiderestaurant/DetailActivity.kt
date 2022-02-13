package fr.isen.remont.androiderestaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.isen.remont.androiderestaurant.databinding.ActivityDetailBinding
import fr.isen.remont.androiderestaurant.model.*
import org.json.JSONObject

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val dish = intent.getSerializableExtra("dish") as DishModel

        binding.dishPhotoPager.adapter = DishPictureAdapter(this,dish.images)

        binding.totalNumber.text = "1"
        var numberDish =  1
        binding.totalButton.text = "Ajouter au panier : " + (dish.prices[0].price.toFloat() * numberDish ) + "€"

        //add
        binding.plusButton.setOnClickListener{
            numberDish += 1
            binding.totalNumber.text = "" + numberDish
            binding.totalButton.text = "Ajouter au panier : " + (dish.prices[0].price.toFloat() * numberDish )+ "€"

        }
        //minus
        binding.minusButton.setOnClickListener{
            if (numberDish > 0) {
                numberDish -= 1
                binding.totalNumber.text = "" + numberDish
                binding.totalButton.text = "Ajouter au panier : " + (dish.prices[0].price.toFloat() * numberDish)+ "€"
            }
        }

        var dishWithHowMany  = JSONObject("""{"dish": dish, "number": numberDish}""")

        binding.dishPhotoPager.adapter = DishPictureAdapter(this,dish.images)

        initDetail(dish)

    }

    private fun initDetail(dish: DishModel){
        binding.detailTitle.text = dish.name_fr
        var ingredientString = dish.ingredients.joinToString(", "){it.name_fr}

        binding.dishingredient.text = ingredientString

    }
}