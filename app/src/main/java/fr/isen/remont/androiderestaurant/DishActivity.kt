package fr.isen.remont.androiderestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import fr.isen.remont.androiderestaurant.databinding.ActivityDishBinding
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.DefaultRetryPolicy
import com.android.volley.Request
import com.android.volley.toolbox.*
import com.google.gson.Gson
import fr.isen.remont.androiderestaurant.model.DishModel
import fr.isen.remont.androiderestaurant.model.DishResultModel
import org.json.JSONObject

class DishActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDishBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDishBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val category : DISHES= intent.getSerializableExtra (TRANSFERT) as DISHES
        binding.mainDishTitle.setText(category.nameId)

        // getting the recyclerview by its id
        val recyclerview = binding.recyclerview

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)

        val queue = Volley.newRequestQueue(this)
        val url = "http://test.api.catering.bluecodegames.com/menu"
        val jsonObject = JSONObject()
        jsonObject.put("id_shop","1")

        // Request a string response from the provided URL
        val request = JsonObjectRequest(
            Request.Method.POST,url,jsonObject,
            { response ->
                var gson= Gson()
                var dishResult = gson.fromJson(response.toString(), DishResultModel::class.java)

                when (category){
                    DISHES.STARTER -> displayDishes(dishResult.data[0].items)
                    DISHES.MAIN -> displayDishes(dishResult.data[1].items)
                    DISHES.DESSERT -> displayDishes(dishResult.data[2].items)
                }



            }, {
                // Error in request
                Log.i( "","Volley error: $it")
            })

        // Volley request policy, only one time request to avoid duplicate transaction
        request.retryPolicy = DefaultRetryPolicy(
            DefaultRetryPolicy.DEFAULT_TIMEOUT_MS,
            // 0 means no retry
            0, // DefaultRetryPolicy.DEFAULT_MAX_RETRIES = 2
            1f // DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
        )

        // Add the volley post request to the request queue
        queue.add(request)

    }

    private fun displayDishes(dishResult: List<DishModel>) {
//RecyclerView
        // getting the recyclerview by its id
        val recyclerview = binding.recyclerview

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = CustomAdapter(dishResult) {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("dish", it)
            startActivity(intent)
        }
    }

}