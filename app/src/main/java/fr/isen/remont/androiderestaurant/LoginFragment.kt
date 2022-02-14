package fr.isen.remont.androiderestaurant

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import fr.isen.remont.androiderestaurant.R
import fr.isen.remont.androiderestaurant.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {
    lateinit var binding: FragmentLoginBinding

    var delegate: SignUpActivityFragmentInteraction? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is SignUpActivityFragmentInteraction) {
            delegate = context
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.login.setOnClickListener {
            delegate?.makeRequest(
                binding.email.toString(),
                binding.password.toString(),
                null,
                null,
                true
            )
        }

        binding.signUp.setOnClickListener {
            delegate?.showRegister()
        }
    }
}