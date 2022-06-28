package id.shaderboi.instagramui.domain.model

import kotlinx.datetime.Instant

data class Comment(
    val username: String,
    val comment: String,
    val createdAt: Instant,
    val likeCount: Int
)