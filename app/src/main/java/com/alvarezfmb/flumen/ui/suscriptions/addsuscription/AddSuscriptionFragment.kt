package com.alvarezfmb.flumen.ui.suscriptions.addsuscription

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.alvarezfmb.flumen.R
import com.alvarezfmb.flumen.database.DataSourceDatabase
import com.alvarezfmb.flumen.databinding.FragmentAddSuscriptionBinding
import com.alvarezfmb.flumen.utils.hideKeyboard


class AddSuscriptionFragment : Fragment() {

    private var _binding: FragmentAddSuscriptionBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AddSuscriptionViewModel by viewModels{
        AddSuscriptionViewModelFactory(DataSourceDatabase.getInstance(requireContext()).dataSourceDao)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddSuscriptionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.editTextAddSuscription.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                onAddSuscriptionButtonClick()
                true
            } else {
                false
            }
        }
        binding.buttonAddSuscription.setOnClickListener {
            onAddSuscriptionButtonClick()
        }
    }

    private fun onAddSuscriptionButtonClick() {
        hideKeyboard()
        val url = binding.editTextAddSuscription.text?.toString()
        viewModel.validateUrl(url)
        viewModel.validUrl.observe(viewLifecycleOwner, Observer { validUrl ->
            // TODO: evaluar migrar esta lógica al viewmodel
            if (validUrl) {
                binding.inputAddSuscription.helperText = ""
                viewModel.onValidUrlAdded(url)
                findNavController().navigate(R.id.action_addSuscription_to_suscriptionsFragment)
            } else {
                binding.inputAddSuscription.helperText = getString(R.string.invalid_url)
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}