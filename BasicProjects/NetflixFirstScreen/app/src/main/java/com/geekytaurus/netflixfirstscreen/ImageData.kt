package com.geekytaurus.netflixfirstscreen

import androidx.annotation.DrawableRes


data class ImageItem(@DrawableRes val imageRes: Int, val name: String)

val imageList = listOf(
    ImageItem(R.drawable.netflix_dp1, "DP-1"),
    ImageItem(R.drawable.netflix_dp2, "DP-2"),
    ImageItem(R.drawable.netflix_dp3, "DP-3"),
    ImageItem(R.drawable.netflix_dp4, "DP-4"),
    ImageItem(R.drawable.netflix_dp5, "DP-5"),
    )