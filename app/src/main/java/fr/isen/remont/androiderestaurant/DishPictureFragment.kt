package fr.isen.remont.androiderestaurant

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import fr.isen.remont.androiderestaurant.databinding.FragmentDishPictureBinding


class DishPictureFragment : Fragment() {
    private lateinit var binding: FragmentDishPictureBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDishPictureBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val url = arguments?.getString(URL)
        url?.let { if (url.isNotEmpty()) Picasso.get().load(url).into(binding.imageView) }
    }

    companion object{
        fun newInstance(pictureUrl: String) =
            DishPictureFragment().apply { arguments=Bundle().apply{putString(URL,pictureUrl)} }
        const val URL = "URL"
    }
}