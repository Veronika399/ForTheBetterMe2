package com.example.forthebetterme.ui.emotionmusic

import android.media.AudioManager
import android.media.SoundPool
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.forthebetterme.R
import com.example.forthebetterme.databinding.EmotionsMusicFragmentBinding

class EmotionMusic: Fragment() {
    private lateinit var mSoundPool: SoundPool
    private var mLoaded: Boolean = false
    var mSoundMap: HashMap<Int, Int> = HashMap()
    private lateinit var binding:EmotionsMusicFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=EmotionsMusicFragmentBinding.inflate(layoutInflater)
        loadSounds()
        binding.buttonhappy.setOnClickListener { playSound(R.raw.sreca) }
        binding.buttonrelax.setOnClickListener { playSound(R.raw.opustanje) }
        binding.buttonljubav.setOnClickListener { playSound(R.raw.ljubav)  }
        binding.buttonsad.setOnClickListener { playSound(R.raw.tuga)  }
        binding.buttonusamljenost.setOnClickListener { playSound(R.raw.usamljenost)  }
        binding.buttonuzbudenje.setOnClickListener { playSound(R.raw.uzbudenje)  }
        binding.buttonExitEmocije.setOnClickListener { goInitial() }
        return binding.root
    }

    private fun goInitial() {
        val action=EmotionMusicDirections.actionEmotionMusicToInitial()
        findNavController().navigate(action)
    }


    private fun playSound(selectedSound: Int) {
        val soundID = this.mSoundMap[selectedSound] ?: 0
        this.mSoundPool.play(soundID, 1f, 4f, 1, 0, 1f)
    }

    private fun loadSounds() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            this.mSoundPool = SoundPool.Builder().setMaxStreams(10).build()
        } else {
            this.mSoundPool = SoundPool(10, AudioManager.STREAM_MUSIC, 0)
        }
        this.mSoundPool.setOnLoadCompleteListener { _, _, _ -> mLoaded = true }
        this.mSoundMap[R.raw.ljubav] = this.mSoundPool.load(this.activity, R.raw.ljubav, 1)
        this.mSoundMap[R.raw.opustanje] = this.mSoundPool.load(this.activity, R.raw.opustanje, 1)
        this.mSoundMap[R.raw.sreca] = this.mSoundPool.load(this.activity, R.raw.sreca, 1)
        this.mSoundMap[R.raw.tuga] = this.mSoundPool.load(this.activity, R.raw.tuga, 1)
        this.mSoundMap[R.raw.usamljenost] = this.mSoundPool.load(this.activity, R.raw.usamljenost, 1)
        this.mSoundMap[R.raw.uzbudenje] = this.mSoundPool.load(this.activity, R.raw.uzbudenje, 1)
    }



}