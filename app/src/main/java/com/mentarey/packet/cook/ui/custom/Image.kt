package com.mentarey.packet.cook.ui.custom

import androidx.compose.*
import androidx.core.graphics.drawable.toBitmap
import androidx.ui.core.ContentScale
import androidx.ui.core.ContextAmbient
import androidx.ui.core.Modifier
import androidx.ui.foundation.Image
import androidx.ui.graphics.ImageAsset
import androidx.ui.graphics.asImageAsset
import coil.Coil
import coil.request.GetRequest

@Composable
fun CoilImage(modifier: Modifier, imageUrl: String, defaultImageAsset: ImageAsset) {
    val context = ContextAmbient.current
    var imageState: ImageAsset by state { defaultImageAsset }
    launchInComposition {
        val request = GetRequest.Builder(context).data(imageUrl).build()
        imageState = try {
            when (val urlDrawable = Coil.execute(request).drawable) {
                null -> defaultImageAsset
                else -> urlDrawable.toBitmap().asImageAsset()
            }
        } catch (e: Throwable) {
            defaultImageAsset
        }
    }
    Image(asset = imageState, modifier = modifier, contentScale = ContentScale.Crop)
}