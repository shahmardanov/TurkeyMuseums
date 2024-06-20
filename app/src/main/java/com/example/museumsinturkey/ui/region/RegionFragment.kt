package com.alijan.turkeymuseum.ui.district

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.alijan.turkeymuseum.ui.adapter.RegionAdapter
import com.alijan.turkeymuseum.ui.city.RegionViewModel
import com.example.museumsinturkey.databinding.FragmentDistrictBinding
import com.example.museumsinturkey.utill.NetworkResponse
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegionFragment : Fragment() {
    private var _binding: FragmentDistrictBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<RegionViewModel>()
    private val districtAdapter = RegionAdapter()
    private val args: DistrictFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDistrictBinding.inflate(layoutInflater)
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
        binding.rvDistrict.adapter = districtAdapter
        districtAdapter.onClick = {
            findNavController().navigate(
                DistrictFragmentDirections.actionDistrictFragmentToMuseumFragment(
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

                }

                is NetworkResponse.Loading -> {

                }

                is NetworkResponse.Success -> {
                    districtAdapter.updateList(it.data!!)
                }
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}