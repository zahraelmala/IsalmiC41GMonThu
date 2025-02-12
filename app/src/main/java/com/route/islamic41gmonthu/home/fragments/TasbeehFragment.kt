package com.route.islamic41gmonthu.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.islamic41gmonthu.R
import com.route.islamic41gmonthu.databinding.FragmentHadethBinding
import com.route.islamic41gmonthu.databinding.FragmentQuranBinding
import com.route.islamic41gmonthu.databinding.FragmentTasbeehBinding

class TasbeehFragment : Fragment() {
    lateinit var azkarList: MutableList<String>
    lateinit var binding: FragmentTasbeehBinding
    private var currentIndex = 0
    private var counter=0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTasbeehBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        azkarList = resources.getStringArray(R.array.azkarList).toMutableList()
        initView()
        onSebhaClick()

    }

    private fun onSebhaClick() {
        binding.imvSebhaBody.setOnClickListener{
            binding.imvSebhaBody.rotation += (360/33).toFloat()
            if(counter<33){
                counter++
            }
            else{
                counter=0
                currentIndex = if(currentIndex < azkarList.size-1) ++currentIndex else 0
                binding.tvZikr.text = azkarList[currentIndex]

            }
            binding.tvCounter.text = "$counter"

        }
    }

    private fun initView() {
        binding.tvZikr.text = azkarList[currentIndex]
        binding.tvCounter.text = "$counter"

    }
}