package com.mentarey.packet.cook.ui.category

import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.ContextAmbient
import androidx.ui.core.Modifier
import androidx.ui.core.drawOpacity
import androidx.ui.foundation.Text
import androidx.ui.foundation.lazy.LazyColumnItems
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.Divider
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import com.mentarey.packet.cook.R
import com.mentarey.packet.cook.entity.FoodCategoryItemUI
import com.mentarey.packet.cook.ui.custom.CoilImage
import com.mentarey.packet.cook.ui.ext.getDefaultImageAsset

@ExperimentalLayout
@Composable
fun FoodCategoryWidget(list: List<FoodCategoryItemUI>) {
    LazyColumnItems(list) {
        FoodCategoryElement(it)
    }
}

@ExperimentalLayout
@Composable
fun FoodCategoryElement(foodCategoryItem: FoodCategoryItemUI) {
    val context = ContextAmbient.current
    Column(Modifier.padding(32.dp, 4.dp)) {
        // Title
        Text(
            modifier = Modifier.padding(bottom = 2.dp).gravity(Alignment.CenterHorizontally),
            text = foodCategoryItem.foodTitle
        )
        // Image
        Stack {
            val imageModifier = when (foodCategoryItem.available) {
                true -> Modifier.drawOpacity(1F)
                false -> Modifier.drawOpacity(0.5F)
            }
            val defaultImageAsset = context.getDefaultImageAsset()
            CoilImage(
                modifier = imageModifier + Modifier.height(150.dp).fillMaxWidth(),
                imageUrl = foodCategoryItem.foodPictureUrl,
                defaultImageAsset = defaultImageAsset
            )
            if (!foodCategoryItem.available) {
                Text(
                    modifier = Modifier.gravity(Alignment.Center),
                    text = context.getString(R.string.food_not_available)
                )
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Food Cost
            FoodCostFull(
                foodCost = foodCategoryItem.foodCost,
                foodCostWithDiscount = foodCategoryItem.foodCostWithDiscount
            )
            // Backet
            Text(text = foodCategoryItem.backetCountString)
        }
    }
}

@ExperimentalLayout
@Composable
fun FoodCostFull(modifier: Modifier = Modifier, foodCost: Double, foodCostWithDiscount: Double) {
    Row(modifier) {
        val isDiscount = foodCost != foodCostWithDiscount
        FoodCostWithDivider(foodCost, isDiscount)
        if (isDiscount) {
            Text(
                modifier = Modifier.padding(start = 4.dp),
                text = foodCostWithDiscount.toString()
            )
        }
        Text(
            modifier = Modifier.padding(start = 4.dp),
            text = ContextAmbient.current.getString(R.string.symbol_currency)
        )
    }
}

@ExperimentalLayout
@Composable
fun FoodCostWithDivider(foodCost: Double, isCrossOut: Boolean) {
    Stack(modifier = Modifier.preferredWidth(IntrinsicSize.Min)) {
        Text(
            modifier = Modifier.gravity(Alignment.CenterStart),
            text = foodCost.toString()
        )
        if (isCrossOut) {
            Divider(
                modifier = Modifier.gravity(Alignment.Center).preferredHeight(2.dp),
                color = Color.Red
            )
        }
    }
}

@ExperimentalLayout
@Composable
@Preview
fun FoodCategoryWidgetPreview() {
    FoodCategoryWidget(testCategory)
}

val testCategory = listOf(
    FoodCategoryItemUI(
        localId = 1,
        available = true,
        backetCountString = "В корзине: 1",
        foodCost = 9.9,
        foodCostWithDiscount = 9.5,
        foodPictureUrl = "https://firebasestorage.googleapis.com/v0/b/kyxniabrest-f911c.appspot.com/o/%D0%BF%D0%B8%D1%86%D1%86%D0%B0%2F%D0%BE%D1%81%D1%82%D1%80%D0%B0%D1%8F.jpg?alt=media&token=3d6ddfea-d268-4239-aafb-d9d4295af313",
        foodTitle = "Тестовый продукт 1",
        position = 1,
        remoteId = ""
    ),
    FoodCategoryItemUI(
        localId = 1,
        available = false,
        backetCountString = "В корзине: 3",
        foodCost = 9.9,
        foodCostWithDiscount = 9.9,
        foodPictureUrl = "https://firebasestorage.googleapis.com/v0/b/kyxniabrest-f911c.appspot.com/o/%D0%BF%D0%B8%D1%86%D1%86%D0%B0%2F%D0%BE%D1%81%D1%82%D1%80%D0%B0%D1%8F.jpg?alt=media&token=3d6ddfea-d268-4239-aafb-d9d4295af313",
        foodTitle = "Тестовый продукт 2",
        position = 1,
        remoteId = ""
    )
)