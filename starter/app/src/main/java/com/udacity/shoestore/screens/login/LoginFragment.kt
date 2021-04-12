package com.udacity.shoestore.screens.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.LoginFragmentBinding
import com.udacity.shoestore.screens.shoelist.ShoeListFragmentArgs

class LoginFragment : Fragment() {

    private lateinit var binding: LoginFragmentBinding

    companion object {
        var isSignedIn = false
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.login_fragment, container, false)

        val listFragmentArgs by navArgs<LoginFragmentArgs>()

        if (listFragmentArgs.logout) {
            isSignedIn = false
        }

        if (isSignedIn) {
            doLogin(false)
        }

        binding.btnLogin.setOnClickListener {
            doLogin(true)
        }
        binding.btnLoginRegister.setOnClickListener {
            doLogin(true)
        }

        return binding.root
    }

    private fun doLogin(shouldShowWelcome: Boolean) {
        isSignedIn = true
        findNavController().navigate(
            LoginFragmentDirections.actionLoginFragmentToWelcomeFragment(shouldShowWelcome)
        )
    }
}