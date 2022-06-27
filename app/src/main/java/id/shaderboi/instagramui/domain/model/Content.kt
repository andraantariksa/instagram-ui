package id.shaderboi.instagramui.domain.model

sealed class Content {
    data class Image(
        val url: String
    ) : Content()

    data class Video(
        val url: String
    ) : Content()
}