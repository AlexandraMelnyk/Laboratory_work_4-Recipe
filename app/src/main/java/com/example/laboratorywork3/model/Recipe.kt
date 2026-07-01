package com.example.laboratorywork3.model

data class Recipe(

    val id: Int,

    var title: String,

    var ingredients: String,

    var instructions: String,

    var cookingTime: Int,

    var difficulty: String

)