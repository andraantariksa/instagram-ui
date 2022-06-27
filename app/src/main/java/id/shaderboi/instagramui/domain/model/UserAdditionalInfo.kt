package id.shaderboi.instagramui.domain.model

data class UserAdditionalInfo(
    val fullName: String? = null,
    val userCaption: String? = null,
    val description: String? = null,
    val url: String? = null,
    val postCount: Int,
    val followers: Int,
    val following: Int,
)