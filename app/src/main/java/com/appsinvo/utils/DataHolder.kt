package com.appsinvo.utils

import com.appsinvo.api.data.Category

object DataHolder {

    val categories = listOf(
        Category(
            id = 7,
            name = "Malls",
            icon = "http://appsinvodevlopment.com/walk_in/public/category_images/2.png",
            isSubcat = "1",
            type = "0"

        ),
        Category(
            id = 1,
            name = "Beauty",
            icon = "http://appsinvodevlopment.com/walk_in/public/category_images/4.png",
            isSubcat = "0",
            type = "0"
        ),
        Category(
            id = 2,
            name = "Restaurant",
            icon = "http://appsinvodevlopment.com/walk_in/public/category_images/1.png",
            isSubcat = "0",
            type = "0"
        ),
        Category(
            id = 4,
            name = "Food Court",
            icon = "http://appsinvodevlopment.com/walk_in/public/category_images/1.png",
            isSubcat = "0",
            type = "0"
        )
    )
}