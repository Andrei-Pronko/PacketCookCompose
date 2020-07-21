package com.mentarey.packet.cook

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.setContent
import androidx.ui.tooling.preview.Preview
import com.mentarey.packet.cook.entity.FoodCategoryId
import com.mentarey.packet.cook.entity.MainMenuUI
import com.mentarey.packet.cook.ui.AppTheme
import com.mentarey.packet.cook.ui.menu.MainMenuWidget

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                MainMenuWidget(mainMenuList)
            }
        }
    }
}


private val mainMenuList = listOf(
    MainMenuUI(
        categoryId = FoodCategoryId.Pizza,
        categoryImage = "https://firebasestorage.googleapis.com/v0/b/kyxniabrest-f911c.appspot.com/o/%D0%BF%D0%B8%D1%86%D1%86%D0%B0%2F%D0%BE%D1%81%D1%82%D1%80%D0%B0%D1%8F.jpg?alt=media&token=3d6ddfea-d268-4239-aafb-d9d4295af313",
        position = 1
    ),
    MainMenuUI(
        categoryId = FoodCategoryId.Pizza,
        categoryImage = "https://firebasestorage.googleapis.com/v0/b/kyxniabrest-f911c.appspot.com/o/%D0%BF%D0%B8%D1%86%D1%86%D0%B0%2F%D0%BE%D1%81%D1%82%D1%80%D0%B0%D1%8F.jpg?alt=media&token=3d6ddfea-d268-4239-aafb-d9d4295af313",
        position = 1
    ),
    MainMenuUI(
        categoryId = FoodCategoryId.Pizza,
        categoryImage = "https://firebasestorage.googleapis.com/v0/b/kyxniabrest-f911c.appspot.com/o/%D0%BF%D0%B8%D1%86%D1%86%D0%B0%2F%D0%BE%D1%81%D1%82%D1%80%D0%B0%D1%8F.jpg?alt=media&token=3d6ddfea-d268-4239-aafb-d9d4295af313",
        position = 1
    ),
    MainMenuUI(
        categoryId = FoodCategoryId.Pizza,
        categoryImage = "https://firebasestorage.googleapis.com/v0/b/kyxniabrest-f911c.appspot.com/o/%D0%BF%D0%B8%D1%86%D1%86%D0%B0%2F%D0%BE%D1%81%D1%82%D1%80%D0%B0%D1%8F.jpg?alt=media&token=3d6ddfea-d268-4239-aafb-d9d4295af313",
        position = 1
    )
)

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AppTheme {
        MainMenuWidget(mainMenuList)
    }
}