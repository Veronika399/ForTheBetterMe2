package com.example.forthebetterme.ui.initial_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.forthebetterme.databinding.InitialFragmentBinding


class Initial: Fragment() {

    private lateinit var binding: InitialFragmentBinding



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= InitialFragmentBinding.inflate(layoutInflater)
        binding.buttonMojdan.setOnClickListener { gowrite() }
        binding.buttonSituacije.setOnClickListener { readsituation() }
        binding.buttonGlazba.setOnClickListener { listenmusic() }
        binding.buttonProsliDani.setOnClickListener { pastday() }
        return binding.root
    }

    private fun pastday() {
        val action=InitialDirections.actionInitialToNoteListFragment3()
        findNavController().navigate(action)
    }

    private fun listenmusic() {
        val action=InitialDirections.actionInitialToEmotionMusic()
        findNavController().navigate(action)
    }

    private fun readsituation() {
        val action=InitialDirections.actionInitialToSituation()
        findNavController().navigate(action)
    }

    private fun gowrite() {
        val action= InitialDirections.actionInitialToNewNoteFragment4()
        findNavController().navigate(action)
    }

}