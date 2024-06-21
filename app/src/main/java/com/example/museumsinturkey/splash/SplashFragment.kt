package com.example.lazaapp.ui.splash

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.lazaapp.base.BaseFragment
import com.example.museumsinturkey.databinding.FragmentSplashBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class SplashFragment : BaseFragment<FragmentSplashBinding>(FragmentSplashBinding::inflate) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        forwardFragment()
    }

    private fun forwardFragment() {
        lifecycleScope.launch {
            delay(1500)

            findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToCityFragment())

        }
    }
}
