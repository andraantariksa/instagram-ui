package id.shaderboi.instagramui.domain.model

import id.shaderboi.instagramui.domain.model.story.UserPreview

data class Post(
    val userPreview: UserPreview,
    val images: List<Image>,
    val caption: String,
    val likeCount: Int,
    val relatedLike: List<Username>
)
