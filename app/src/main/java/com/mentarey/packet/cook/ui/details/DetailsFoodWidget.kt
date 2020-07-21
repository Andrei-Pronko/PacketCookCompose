package com.mentarey.packet.cook.ui.details

import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.ContextAmbient
import androidx.ui.core.Modifier
import androidx.ui.foundation.Box
import androidx.ui.foundation.Text
import androidx.ui.foundation.VerticalScroller
import androidx.ui.layout.*
import androidx.ui.material.Button
import androidx.ui.material.MaterialTheme
import androidx.ui.text.style.TextAlign
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import com.mentarey.packet.cook.entity.FoodCategoryId
import com.mentarey.packet.cook.entity.FoodDetailsUI
import com.mentarey.packet.cook.ui.cost.CostPickerWidget
import com.mentarey.packet.cook.ui.custom.CoilImage
import com.mentarey.packet.cook.ui.ext.getDefaultImageAsset

@ExperimentalLayout
@Composable
fun DetailsFoodWidget(foodDetailsUI: FoodDetailsUI) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom
    ) {
        VerticalScroller(modifier = Modifier.weight(1F)) {
            Box {
                // Image
                val context = ContextAmbient.current
                val defaultImageAsset = context.getDefaultImageAsset()
                CoilImage(
                    modifier = Modifier.preferredHeight(300.dp).fillMaxWidth(),
                    imageUrl = foodDetailsUI.pictureUrl,
                    defaultImageAsset = defaultImageAsset
                )
                // Title
                Text(
                    modifier = Modifier.gravity(Alignment.CenterHorizontally),
                    style = MaterialTheme.typography.h4,
                    text = foodDetailsUI.title,
                    textAlign = TextAlign.Center
                )
                // Description
                Text(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 4.dp),
                    style = MaterialTheme.typography.subtitle1,
                    text = foodDetailsUI.description,
                    textAlign = TextAlign.Start
                )
            }
        }
        CostPickerWidget(foodDetailsUI.backetFoodCount, foodDetailsUI.costForOne)
        Button(
            modifier = Modifier.gravity(Alignment.CenterHorizontally).padding(bottom = 4.dp),
            onClick = { }) {
            Text(text = "Добавить в корзину")
        }
    }
}

@Composable
fun TestConstraintDsl(foodDetailsUI: FoodDetailsUI) {
    ConstraintLayout {
        val (scrollableArea, bottomArea) = createRefs()

        VerticalScroller(modifier = Modifier.constrainAs(scrollableArea) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(parent.top)
            bottom.linkTo(bottomArea.top)
        }) {
            // Image
            val context = ContextAmbient.current
            val defaultImageAsset = context.getDefaultImageAsset()
            CoilImage(
                modifier = Modifier.preferredHeight(300.dp).fillMaxWidth(),
                imageUrl = foodDetailsUI.pictureUrl,
                defaultImageAsset = defaultImageAsset
            )
            // Title
            Text(
                modifier = Modifier.gravity(Alignment.CenterHorizontally),
                text = foodDetailsUI.title,
                textAlign = TextAlign.Center
            )
            // Description
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = foodDetailsUI.description,
                textAlign = TextAlign.Start
            )
        }
        Column(modifier = Modifier.padding(bottom = 4.dp).constrainAs(bottomArea) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(parent.bottom)
        }) {
            CostPickerWidget(foodDetailsUI.backetFoodCount, foodDetailsUI.costForOne)
            Button(
                modifier = Modifier.gravity(Alignment.CenterHorizontally),
                onClick = { }) {
                Text(
                    text = "Добавить в корзину"
                )
            }
        }
    }
}
/*
ConstraintLayout(constraintSet2) {
    // ScrollableArea
    VerticalScroller(
        modifier = Modifier.tag(ScrollableAreaTag).wrapContentHeight(Alignment.CenterVertically)
    ) {
        Column {
            // Image
            val context = ContextAmbient.current
            val defaultImageAsset = context.getDefaultImageAsset()
            CoilImage(
                modifier = Modifier.preferredHeight(300.dp).fillMaxWidth(),
                imageUrl = foodDetailsUI.pictureUrl,
                defaultImageAsset = defaultImageAsset
            )
            // Title
            Text(
                modifier = Modifier.gravity(Alignment.CenterHorizontally),
                text = foodDetailsUI.title,
                textAlign = TextAlign.Center
            )
            // Description
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = foodDetailsUI.description,
                textAlign = TextAlign.Start
            )
        }
    }
    // Food counter
    Box(modifier = Modifier.tag(CostPickerTag)) {
        CostPickerWidget(foodDetailsUI.backetFoodCount, foodDetailsUI.costForOne)
    }
    // Add food button
    Button(
        modifier = Modifier
            .tag(AddFoodButtonTag)
            .gravity(Alignment.CenterHorizontally),
        onClick = {

        }) {
        Text(text = "Добавить в корзину")
    }
}*/

@Preview
@ExperimentalLayout
@Composable
fun DetailsFoodWidgetPreview() {
    DetailsFoodWidget(
        FoodDetailsUI(
            localId = 1,
            categoryId = FoodCategoryId.Pizza,
            remoteId = "",
            position = 1,
            backetFoodCount = 1,
            costForOne = 9.9,
            description = "Длинное длинное описание\nДлинное длинное описание\nДлинное длинное описание\nДлинное длинное описание\nДлинное длинное описание\nДлинное длинное описание\n" +
                    "Длинное длинное описание\n" +
                    "Длинное длинное описание\n" +
                    "Длинное длинное описание\n" +
                    "Длинное длинное описание\n" +
                    "Длинное длинное описание\n" +
                    "Длинное длинное описание\n" +
                    "Длинное длинное описание\n" +
                    "Длинное длинное описание\n" +
                    "Длинное длинное описание\n" +
                    "Длинное длинное описание\n" +
                    "Длинное длинное описание\n" +
                    "Длинное длинное описание\n" +
                    "Длинное длинное описание\n" +
                    "Длинное длинное описание\n" +
                    "Длинное длинное описание\n" +
                    "Длинное длинное описание\n" +
                    "Длинное длинное описание\n" +
                    "Длинное длинное описание\n" +
                    "Длинное длинное описание\n" +
                    "Длинное длинное описание\n" +
                    "Длинное длинное описание111",
            title = "Пицца",
            pictureUrl = "https://firebasestorage.googleapis.com/v0/b/kyxniabrest-f911c.appspot.com/o/%D0%BF%D0%B8%D1%86%D1%86%D0%B0%2F%D0%BE%D1%81%D1%82%D1%80%D0%B0%D1%8F.jpg?alt=media&token=3d6ddfea-d268-4239-aafb-d9d4295af313"
        )
    )
}


@Composable
fun TestConstraintDslPreview() {
    TestConstraintDsl(
        FoodDetailsUI(
            localId = 1,
            categoryId = FoodCategoryId.Pizza,
            remoteId = "",
            position = 1,
            backetFoodCount = 1,
            costForOne = 9.9,
            description = "Длинное длинное описание\nДлинное длинное описание\nДлинное длинное описание\nДлинное длинное описание\nДлинное длинное описание\nДлинное длинное описание\n" +
                    "Длинное длинное описание\n" +
                    "Длинное длинное описание\n" +
                    "Длинное длинное описание\n" +
                    "Длинное длинное описание\n" +
                    "Длинное длинное описание\n" +
                    "Длинное длинное описание\n" +
                    "Длинное длинное описание\n" +
                    "Длинное длинное описание\n" +
                    "Длинное длинное описание\n" +
                    "Длинное длинное описание\n" +
                    "Длинное длинное описание\n" +
                    "Длинное длинное описание\n" +
                    "Длинное длинное описание\n" +
                    "Длинное длинное описание\n" +
                    "Длинное длинное описание\n" +
                    "Длинное длинное описание\n" +
                    "Длинное длинное описание\n" +
                    "Длинное длинное описание\n" +
                    "Длинное длинное описание\n" +
                    "Длинное длинное описание\n" +
                    "Длинное длинное описание111",
            title = "Пицца",
            pictureUrl = "https://firebasestorage.googleapis.com/v0/b/kyxniabrest-f911c.appspot.com/o/%D0%BF%D0%B8%D1%86%D1%86%D0%B0%2F%D0%BE%D1%81%D1%82%D1%80%D0%B0%D1%8F.jpg?alt=media&token=3d6ddfea-d268-4239-aafb-d9d4295af313"
        )
    )
}