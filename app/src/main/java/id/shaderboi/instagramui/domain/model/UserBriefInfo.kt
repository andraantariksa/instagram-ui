package id.shaderboi.instagramui.domain.model

data class UserBriefInfo(
    val username: String,
    val imageUrl: String = "https://raw.githubusercontent.com/andraantariksa/instagram-ui/master/assets/user/$username/profile.jpg",
    val isOfficial: Boolean = false,
)