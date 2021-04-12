package com.udacity.shoestore.screens.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.DetailsFragmentBinding
import com.udacity.shoestore.models.Shoe

class DetailsFragment : Fragment() {

    private lateinit var binding: DetailsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.details_fragment, container, false)

        binding.btnDetailsSave.setOnClickListener {
            findNavController().navigate(DetailsFragmentDirections.actionListShoes(getShoe()))
        }

        binding.btnDetailsCancel.setOnClickListener {
            findNavController().navigate(DetailsFragmentDirections.actionListShoes(null))
        }

        return binding.root
    }


    private fun getShoe(): Shoe {

        val size = if (binding.etDetailsSize.text.isNullOrBlank()) 0.0
        else binding.etDetailsSize.text.toString().toDouble()

        return Shoe(
            binding.etDetailsName.text.toString(),
            size,
            binding.etDetailsCompany.text.toString(),
            binding.etDetailsDescription.text.toString(),
            listOf("Image 1", "Image 2")
        )
    }
}
