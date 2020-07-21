package com.mentarey.packet.cook.entity

data class FoodCategoryItemUI(
    val localId: Long,
    val remoteId: String,
    val position: Int,
    val foodPictureUrl: String,
    val foodTitle: String,
    val foodCost: Double,
    val foodCostWithDiscount: Double,
    val backetCountString: String,
    val available: Boolean
)