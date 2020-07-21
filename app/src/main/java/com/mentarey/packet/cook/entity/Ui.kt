package com.mentarey.packet.cook.entity

data class FoodDetailsUI(
    val localId: Long,
    val categoryId: FoodCategoryId,
    val remoteId: String,
    val position: Int,
    val title: String,
    val description: String,
    val pictureUrl: String,
    val costForOne: Double,
    val backetFoodCount: Int
)