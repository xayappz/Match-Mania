package com.xayappz.matchmania.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.xayappz.matchmania.controllers.Request
import com.xayappz.matchmania.databinding.RecyclerBinding
import com.xayappz.matchmania.utils.AdapterHelper

class MatchFragment : Fragment() {

    private lateinit var binding: RecyclerBinding
    private var dataState = 0
    private val viewModel: com.xayappz.matchmania.controllers.Request by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = RecyclerBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.isComplete.observe(viewLifecycleOwner) {
            AdapterHelper().adapterSet(
                requireActivity(),
                binding.matchListRv,
                binding.matchListRvSoccer,
                binding.matchListRvTennis,
                dataState,
                binding.sporttypeCK,
                binding.sporttypeSC,
                binding.sporttypeTN
            )
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: Int) =
            MatchFragment().apply {
                arguments = Bundle().apply {
                    putInt(MainActivity.state, param1)
                }
            }

        fun newInstance() =
            MatchFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            dataState = it.getInt(MainActivity.state)

        }

    }
}