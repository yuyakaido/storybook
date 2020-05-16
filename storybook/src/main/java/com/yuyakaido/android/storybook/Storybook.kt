package com.yuyakaido.android.storybook

import android.view.View
import java.io.Serializable

data class Storybook(
    val elements: List<Element>
) : Serializable

abstract class Element(val title: String) {
    abstract fun view(): View
}