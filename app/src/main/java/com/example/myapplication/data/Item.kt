package com.example.myapplication.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Item(
    @StringRes val nameResId: Int,       // For the name of the item (string resource ID)
    @StringRes val categoryResId: Int,   // For the category name (string resource ID)
    val itemQuality: String,             // For the quality or description (e.g., "1kg")
    val itemPrice: Int,                  // For the price of the item
    @DrawableRes val imageResId: Int     // For the image (drawable resource ID)
)
