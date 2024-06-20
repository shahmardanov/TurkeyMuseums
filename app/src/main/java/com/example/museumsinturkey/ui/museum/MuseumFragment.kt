package com.alijan.turkeymuseum.ui.museum

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.alijan.turkeymuseum.ui.adapter.MuseumAdapter
import com.example.museumsinturkey.databinding.FragmentMuseumBinding
import com.example.museumsinturkey.utill.NetworkResponse
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MuseumFragment : Fragment() {
    private var _binding: FragmentMuseumBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<MuseumViewModel>()
    private val museumAdapter = MuseumAdapter()
    private val args: MuseumFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMuseumBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter()
        requestApi()
        observeData()
    }

    private fun requestApi() {
        viewModel.getAllMuseum(args.city, args.district)
    }

    private fun setAdapter() {
        binding.rvMuseum.adapter = museumAdapter
    }

    private fun observeData() {
        viewModel.museums.observe(viewLifecycleOwner) {
            when (it) {
                is NetworkResponse.Error -> {
                    Toast.makeText(context, "Data Failed", Toast.LENGTH_LONG).show()
                }

                is NetworkResponse.Loading -> {

                }

                is NetworkResponse.Success -> {
                    museumAdapter.updateList(it.data!!)
                }
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}