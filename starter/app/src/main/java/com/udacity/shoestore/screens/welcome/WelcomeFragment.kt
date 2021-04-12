package com.udacity.shoestore.screens.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.WelcomeFragmentBinding

class WelcomeFragment : Fragment() {

    private lateinit var binding: WelcomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.welcome_fragment,
            container,
            false
        )

        binding.btnWelcome.setOnClickListener {
            navigateToInstructions(true)
        }
        val listFragmentArgs by navArgs<WelcomeFragmentArgs>()

        if (!listFragmentArgs.showHome)
            navigateToInstructions(false)

        return binding.root
    }


    private fun navigateToInstructions(state: Boolean) {
        findNavController().navigate(
            WelcomeFragmentDirections.actionWelcomeFragmentToInstructionsFragment(state)
        )
    }
}
