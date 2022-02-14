package fr.isen.remont.androiderestaurant

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import fr.isen.remont.androiderestaurant.R
import fr.isen.remont.androiderestaurant.databinding.FragmentSignUpBinding

class RegisterFragment : Fragment() {
    lateinit var binding: FragmentSignUpBinding

    var delegate: SignUpActivityFragmentInteraction? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.loginButton.setOnClickListener {
            delegate?.makeRequest(
                binding.email.toString(),
                binding.password.toString(),
                binding.name.toString(),
                binding.surname.toString(),
                false
            )
        }

        binding.loginButton.setOnClickListener {
            delegate?.showLogin()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is SignUpActivityFragmentInteraction) {
            delegate = context
        }
    }
}