package id.shaderboi.instagramui.domain.model.story

import id.shaderboi.instagramui.domain.model.Content
import id.shaderboi.instagramui.domain.model.Username

data class Story(
    val username: Username,
    val contents: List<Content>,
)