package com.mentarey.packet.cook.ui.menu

import androidx.compose.Composable
import androidx.ui.core.ContextAmbient
import androidx.ui.core.Modifier
import androidx.ui.foundation.clickable
import androidx.ui.foundation.lazy.LazyColumnItems
import androidx.ui.layout.fillMaxWidth
import androidx.ui.layout.height
import androidx.ui.layout.padding
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import com.mentarey.packet.cook.entity.FoodCategoryId
import com.mentarey.packet.cook.entity.MainMenuUI
import com.mentarey.packet.cook.ui.custom.CoilImage
import com.mentarey.packet.cook.ui.ext.getDefaultImageAsset

@Composable
fun MainMenuWidget(list: List<MainMenuUI>, onMenuItemClicked: (FoodCategoryId) -> Unit = {}) {
    LazyColumnItems(list) {
        MainMenuImage(it.categoryImage, it.categoryId, onMenuItemClicked)
    }
}

@Composable
fun MainMenuImage(
    imageUrl: String,
    foodCategoryId: FoodCategoryId,
    onMenuItemClicked: (FoodCategoryId) -> Unit = {}
) {
    val clickable = Modifier.clickable { onMenuItemClicked(foodCategoryId) }
    val defaultImageAsset = ContextAmbient.current.getDefaultImageAsset()
    CoilImage(
        modifier = clickable.height(300.dp).fillMaxWidth().padding(8.dp, 8.dp, 8.dp, 4.dp),
        imageUrl = imageUrl,
        defaultImageAsset = defaultImageAsset
    )
}

@Preview
@Composable
fun MainImagePreview() {
    MainMenuImage(
        "https://firebasestorage.googleapis.com/v0/b/kyxniabrest-f911c.appspot.com/o/%D0%BF%D0%B8%D1%86%D1%86%D0%B0%2F%D0%BE%D1%81%D1%82%D1%80%D0%B0%D1%8F.jpg?alt=media&token=3d6ddfea-d268-4239-aafb-d9d4295af313",
        FoodCategoryId.Pizza
    )
}