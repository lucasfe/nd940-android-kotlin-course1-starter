package com.udacity.shoestore.screens.instructions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.InstructionsFragmentBinding
import com.udacity.shoestore.screens.welcome.WelcomeFragmentArgs

class InstructionsFragment : Fragment() {

    private lateinit var binding: InstructionsFragmentBinding

    companion object {
        var hasVisitedInstructions = false
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.instructions_fragment,
                container,
                false
            )
        binding.btnInstructions.setOnClickListener {
            switchInstructionsState()
        }

        val listFragmentArgs by navArgs<InstructionsFragmentArgs>()

        if (!listFragmentArgs.showInstruction) {
            switchInstructionsState()
        }

        return binding.root
    }


    private fun switchInstructionsState() {
        hasVisitedInstructions = true
        findNavController().navigate(
            InstructionsFragmentDirections.actionInstructionsFragmentToShoeListFragment()
        )
    }
}
