package com.udacity.shoestore.screens.shoelist

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoelistFragmentBinding
import com.udacity.shoestore.models.Shoe

class ShoeListFragment : Fragment() {
    private lateinit var binding: ShoelistFragmentBinding

    private lateinit var viewModel: ShoeListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.shoelist_fragment,
            container,
            false
        )
        binding.listToolBar.inflateMenu(R.menu.menu)

        binding.listToolBar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.action_logout -> {
                    findNavController().navigate(
                        ShoeListFragmentDirections.actionMenuLogoutAction(true)
                    )
                    true
                }
                else -> false
            }
        }
        viewModel = ViewModelProvider(this).get(ShoeListViewModel::class.java)
        binding.lifecycleOwner = this

        binding.fab.setOnClickListener { view: View ->
            Navigation.findNavController(view).navigate(R.id.add_shoe_action)
        }

        val listFragmentArgs by navArgs<ShoeListFragmentArgs>()
        viewModel.addShoe(listFragmentArgs.shoe)

        viewModel.shoeList.observe(
            viewLifecycleOwner, Observer { shoeList ->
                loadShoeList(shoeList)
            }
        )
        return binding.root
    }


    private fun loadShoeList(list: List<Shoe>?) {
        val resultList = list ?: emptyList()
        resultList.forEach {
            val textView = TextView(context)
            textView.text = it.name
            binding.shoeListContainer.addView(textView)
        }
    }
}
