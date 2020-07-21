package com.mentarey.packet.cook.ui.ext

import android.content.Context
import androidx.ui.graphics.ImageAsset
import androidx.ui.graphics.imageFromResource
import com.mentarey.packet.cook.R

fun Context.getDefaultImageAsset(): ImageAsset =
    imageFromResource(resources, R.drawable.food_not_found)