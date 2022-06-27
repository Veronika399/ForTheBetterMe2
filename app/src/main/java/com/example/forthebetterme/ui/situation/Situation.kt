package com.example.forthebetterme.ui.situation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.forthebetterme.databinding.SituationFragmentBinding

class Situation: Fragment() {
private lateinit var binding:SituationFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=SituationFragmentBinding.inflate(layoutInflater)
        binding.buttonExitSavjeti.setOnClickListener { goInitial() }
        return binding.root
    }

    private fun goInitial() {
        val action=SituationDirections.actionSituationToInitial()
        findNavController().navigate(action)
    }
}