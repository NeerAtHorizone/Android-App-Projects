package com.example.zuperheros.Data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.zuperheros.R

data class myHero(
    @StringRes val nameRes: Int,
    @StringRes val descriptionRes: Int,
    @DrawableRes val imageRes: Int
)


val myHerosList = listOf(
    myHero(
        nameRes = R.string.hero1,
        descriptionRes = R.string.description1,
        imageRes = R.drawable.android_superhero1
    ),
    myHero(
        nameRes = R.string.hero2,
        descriptionRes = R.string.description2,
        imageRes = R.drawable.android_superhero2
    ),
    myHero(
        nameRes = R.string.hero3,
        descriptionRes = R.string.description3,
        imageRes = R.drawable.android_superhero3
    ),
    myHero(
        nameRes = R.string.hero4,
        descriptionRes = R.string.description4,
        imageRes = R.drawable.android_superhero4
    ),
    myHero(
        nameRes = R.string.hero5,
        descriptionRes = R.string.description5,
        imageRes = R.drawable.android_superhero5
    ),
    myHero(
        nameRes = R.string.hero6,
        descriptionRes = R.string.description6,
        imageRes = R.drawable.android_superhero6
    )
)
