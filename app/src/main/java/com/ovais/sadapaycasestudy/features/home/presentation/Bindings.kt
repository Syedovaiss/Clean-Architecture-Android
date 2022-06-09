package com.ovais.sadapaycasestudy.features.home.presentation

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ovais.sadapaycasestudy.features.home.data.GithubRepositoryUIData
import com.ovais.sadapaycasestudy.utils.*

@BindingAdapter(value = ["bind_repos"])
fun RecyclerView.bindRepoData(data: List<GithubRepositoryUIData>?) {
    data?.let {
        if (it.isEmpty()) hide() else show()
        (adapter as GithubRepoAdapter?)?.listItems = it.toArrayList()
    } ?: hide()
}