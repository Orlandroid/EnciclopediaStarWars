package com.example.androidbase.presentation.ui.example

import kotlinx.serialization.Serializable


@Serializable
data class FeaturedContent(
	val contents: List<Resource>,
)
