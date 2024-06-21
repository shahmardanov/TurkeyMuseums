package com.example.lazaapp.base

import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("load_image_local")
fun setImageSrc(imageView: ImageView, resId: Int) {
    imageView.setImageResource(resId)
}
