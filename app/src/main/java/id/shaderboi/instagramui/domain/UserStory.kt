package id.shaderboi.instagramui.domain

import id.shaderboi.instagramui.domain.model.Content
import id.shaderboi.instagramui.domain.model.UserBriefInfo

data class UserStory(
    val contents: List<Content>,
    val userBriefInfo: UserBriefInfo,
    val seen: Boolean = false
)