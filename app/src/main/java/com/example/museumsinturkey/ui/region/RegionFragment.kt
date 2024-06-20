package com.alijan.turkeymuseum.ui.district

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.alijan.turkeymuseum.ui.adapter.RegionAdapter
import com.alijan.turkeymuseum.ui.city.RegionViewModel
import com.example.museumsinturkey.databinding.FragmentRegionBinding
import com.example.museumsinturkey.utill.NetworkResponse
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegionFragment : Fragment() {
    private var _binding: FragmentRegionBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<RegionViewModel>()
    private val regionAdapter = RegionAdapter()
    private val args: RegionFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegionBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requestApi()
        setAdapter()
        observeData()
    }

    private fun requestApi() {
        viewModel.getAllDistrict(args.city)
    }

    private fun setAdapter() {
        binding.rvDistrict.adapter = regionAdapter
        regionAdapter.onClick = {
            findNavController().navigate(
                RegionFragmentDirections.actionRegionFragmentToMuseumFragment(
                    args.city,
                    it
                )
            )
        }
    }

    private fun observeData() {
        viewModel.region.observe(viewLifecycleOwner) {
            when (it) {
                is NetworkResponse.Error -> {
                    Toast.makeText(context, "Data Failed", Toast.LENGTH_LONG).show()
                }

                is NetworkResponse.Loading -> {

                }

                is NetworkResponse.Success -> {
                    regionAdapter.updateList(it.data!!)
                }
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}