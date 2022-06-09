package com.ovais.sadapaycasestudy.features.home.presentation

import android.view.ViewGroup
import com.ovais.sadapaycasestudy.base.BaseAdapter
import com.ovais.sadapaycasestudy.base.BaseViewHolder
import com.ovais.sadapaycasestudy.databinding.ItemRepoRowsBinding
import com.ovais.sadapaycasestudy.features.home.data.GithubRepositoryUIData
import com.ovais.sadapaycasestudy.utils.inflater

class GithubRepoAdapter(override var itemClickListener: (GithubRepositoryUIData) -> Unit) :
    BaseAdapter<GithubRepositoryUIData, GithubRepoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubRepoViewHolder =
        GithubRepoViewHolder(
            ItemRepoRowsBinding.inflate(
                parent.inflater,
                parent,
                false
            ),
            itemClickListener
        )
}

class GithubRepoViewHolder(
    private val binding: ItemRepoRowsBinding,
    private val itemClickListener: (GithubRepositoryUIData) -> Unit
) : BaseViewHolder<GithubRepositoryUIData>(binding.root) {

    override fun onBind(item: GithubRepositoryUIData, position: Int) {
        binding.item = item
        binding.root.setOnClickListener {
            itemClickListener.invoke(item)
        }
    }
}