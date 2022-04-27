package id.shaderboi.instagramui.domain.model.story

data class UserPreview(
    val imageUrl: String,
    val username: String,
    val isOfficial: Boolean = false
)