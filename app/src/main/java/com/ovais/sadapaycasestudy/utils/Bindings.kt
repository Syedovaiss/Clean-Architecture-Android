package com.ovais.sadapaycasestudy.utils

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.*
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.facebook.shimmer.ShimmerFrameLayout
import com.ovais.sadapaycasestudy.utils.Constants.EMPTY_STRING

@BindingAdapter(value = ["recyclerAdapter"])
fun RecyclerView.bindAdapter(recyclerAdapter: RecyclerView.Adapter<*>) {
    this.adapter = recyclerAdapter
}

@BindingAdapter(value = ["decorators_enabled"])
fun RecyclerView.bindDecorator(decorators: Boolean?) {
    decorators?.let { isEnabled ->
        if (isEnabled) {
            addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
        }
    }
}

@BindingAdapter(value = ["apply_image"])
fun ImageView.applyImage(url: String?) {
    Glide.with(context)
        .load(url ?: EMPTY_STRING)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .into(this)
}

@BindingAdapter(value = ["toggle_visibility"])
fun View.toggleVisibility(isVisible: Boolean) {
    if (isVisible) show() else hide()
}

@BindingAdapter(value = ["shimmer_state"])
fun ShimmerFrameLayout.observeShimmerVisibility(state: Boolean) {
    if (state) {
        this.show()
        this.startShimmer()
    } else {
        this.stopShimmer()
        this.hide()
    }
}