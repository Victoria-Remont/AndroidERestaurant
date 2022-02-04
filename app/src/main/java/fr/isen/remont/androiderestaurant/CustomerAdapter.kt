package fr.isen.remont.androiderestaurant

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import fr.isen.remont.androiderestaurant.databinding.CardViewDesignBinding
import fr.isen.remont.androiderestaurant.model.DishModel

class CustomAdapter(val mList: List<DishModel>, val onDishClicked: (DishModel) -> Unit) : RecyclerView.Adapter<CustomAdapter.DishViewHolder>() {

    class DishViewHolder(binding: CardViewDesignBinding):RecyclerView.ViewHolder(binding.root){
        val dishPicture = binding.imageChoice
        val dishName = binding.textChoice
        val dishPrice = binding.priceChoice

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DishViewHolder {
        val binding = CardViewDesignBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)

        return DishViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DishViewHolder, position: Int) {

        val dish = mList[position]

        // sets the text to the textview from our itemHolder class
        holder.dishName.text = dish.name_fr

        // sets the text to the priceview from our itemHolder class
        holder.dishPrice.text = dish.prices[0].price + "€"

        Picasso.get()
            .load(if (dish.images[0].isNotEmpty()) dish.images[0] else null)
            .error(R.drawable.pitichat).placeholder(R.drawable.pitichat)
            .resize(60,60)
            .into(holder.dishPicture)

        holder.itemView.setOnClickListener{
            onDishClicked(dish)
        }

    }

    override fun getItemCount(): Int {
        return mList.size
    }

}
