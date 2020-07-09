package com.alvarezfmb.flumen.ui.suscriptions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.alvarezfmb.flumen.R
import com.alvarezfmb.flumen.databinding.FragmentSuscriptionsBinding


class SuscriptionsFragment : Fragment() {

    private var _binding: FragmentSuscriptionsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSuscriptionsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonAddSuscription.setOnClickListener {
            findNavController().navigate(R.id.action_suscriptionsFragment_to_addSuscription)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}