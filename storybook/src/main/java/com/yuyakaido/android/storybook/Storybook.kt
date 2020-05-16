package com.yuyakaido.android.storybook

import android.view.View
import java.io.Serializable

data class Storybook(
    val elements: List<() -> View>
) : Serializable
