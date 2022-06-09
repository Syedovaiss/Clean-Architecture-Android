package com.ovais.sadapaycasestudy.base

import android.os.Bundle
import android.view.*
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<VB : ViewDataBinding>() : Fragment() {

    private var _binding: VB? = null
    protected val binding: VB
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return getBindView(inflater, container)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onFragmentReady()
    }

    protected open fun onFragmentReady() = Unit
    abstract fun getBinding(inflater: LayoutInflater, container: ViewGroup?): VB

    private fun getBindView(inflater: LayoutInflater, container: ViewGroup?): View {
        return getBinding(inflater, container).apply {
            _binding = this
            lifecycleOwner = viewLifecycleOwner
        }.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}