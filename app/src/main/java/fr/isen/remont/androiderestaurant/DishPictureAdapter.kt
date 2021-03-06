package fr.isen.remont.androiderestaurant

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import fr.isen.remont.androiderestaurant.databinding.FragmentDishPictureBinding

class DishPictureAdapter(activity: AppCompatActivity, val pictures: List<String>): FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = pictures.size


    override fun createFragment(position: Int): Fragment {

        return DishPictureFragment.newInstance(pictures[position])
    }
}