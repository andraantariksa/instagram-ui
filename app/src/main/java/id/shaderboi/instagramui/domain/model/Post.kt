package id.shaderboi.instagramui.domain.model

import kotlinx.datetime.Instant

data class Post(
    val contents: List<Content>,
    val caption: String,
    val likeCount: Int,
    val relatedLike: List<Username>,
    val createdAt: Instant
)
