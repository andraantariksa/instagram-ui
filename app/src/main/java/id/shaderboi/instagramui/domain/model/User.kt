package id.shaderboi.instagramui.domain.model

data class User(
    val briefInfo: UserBriefInfo,
    val additionalInfo: UserAdditionalInfo,
    val contents: List<Content> = listOf(),
    val postsMap: Map<Int, Post> = mapOf(),
) {
    val posts: List<Post>
        get() {
            val posts = mutableListOf<Post>()
            postsMap.entries.forEach { postEntry ->
                posts.add(postEntry.value)
            }
            posts.sortBy { post -> post.createdAt }
            return posts
        }

}