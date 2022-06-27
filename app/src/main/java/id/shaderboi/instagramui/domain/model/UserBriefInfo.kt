package id.shaderboi.instagramui.domain.model

data class UserBriefInfo(
    val username: String,
    val imageUrl: String? = null,
    val isOfficial: Boolean = false,
)