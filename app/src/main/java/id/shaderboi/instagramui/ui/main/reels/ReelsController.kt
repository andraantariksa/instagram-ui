package id.shaderboi.instagramui.ui.main.reels

import android.content.Context
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem

class ReelsController(
    private val context: Context,
    val size: Int = 10
) {
    private val _playersBuffer: MutableList<ExoPlayer> = MutableList(size) {
        ExoPlayer.Builder(context).build().apply {
            setMediaItem(MediaItem.fromUri("https://raw.githubusercontent.com/andraantariksa/instagram-ui/master/assets/user/zachking/posts/1_1.mp4"))
            repeatMode = ExoPlayer.REPEAT_MODE_ALL
            prepare()
        }
    }
    val playersBuffer: List<ExoPlayer> = _playersBuffer

    fun fetchMoreContent() {

    }
}