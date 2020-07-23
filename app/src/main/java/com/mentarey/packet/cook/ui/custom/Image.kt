package com.mentarey.packet.cook.ui.custom

import androidx.compose.Composable
import androidx.compose.launchInComposition
import androidx.compose.state
import androidx.core.graphics.drawable.toBitmap
import androidx.ui.core.ContentScale
import androidx.ui.core.ContextAmbient
import androidx.ui.core.Modifier
import androidx.ui.foundation.Image
import androidx.ui.graphics.ImageAsset
import androidx.ui.graphics.asImageAsset
import coil.Coil
import coil.request.GetRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun CoilImage(modifier: Modifier, imageUrl: String, defaultImageAsset: ImageAsset) {
    val context = ContextAmbient.current
    val imageState = state { defaultImageAsset }
    launchInComposition {
        val request = GetRequest.Builder(context).data(imageUrl).build()
        imageState.value = try {
            val urlDrawable = withContext(Dispatchers.IO) { Coil.execute(request).drawable }
            when (urlDrawable) {
                null -> defaultImageAsset
                else -> urlDrawable.toBitmap().asImageAsset()
            }
        } catch (e: Throwable) {
            defaultImageAsset
        }
    }
    Image(asset = imageState.value, modifier = modifier, contentScale = ContentScale.Crop)
}