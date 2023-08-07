package com.appsinvo.api.data


import androidx.annotation.DrawableRes
import com.google.gson.annotations.SerializedName

data class CategoriesResponse(
    @SerializedName("categories")
    val categories: List<Category> = listOf()
)
data class Category(
    @SerializedName("icon")
    @DrawableRes val icon: Int = 0,
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("is_subcat")
    val isSubcat: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("type")
    val type: String = ""
)