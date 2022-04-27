package id.shaderboi.instagramui.data

import id.shaderboi.instagramui.domain.model.Image
import id.shaderboi.instagramui.domain.model.Post
import id.shaderboi.instagramui.domain.model.story.UserPreview

object DummyData {
    val userPreviews = arrayOf(
        UserPreview(
            imageUrl = "https://firebasestorage.googleapis.com/v0/b/instagram-ui-shaderboi.appspot.com/o/user%2Fandraantariksa%2F9760691.png?alt=media&token=df8b7fea-3199-4905-a9fc-76d3edac2fe0",
            username = "andraantariksa"
        ),
        UserPreview(
            imageUrl = "https://firebasestorage.googleapis.com/v0/b/instagram-ui-shaderboi.appspot.com/o/user%2Fuesaka_sumire%2F64978161_909062649264382_3005495153122082816_n%20(1).jpg?alt=media&token=8bd019f1-37a6-4137-8476-b6914656808a",
            username = "uesaka_sumire",
            isOfficial = true
        )
    )

    val posts = arrayOf(
        Post(
            userPreviews[1],
            listOf(
                Image("https://firebasestorage.googleapis.com/v0/b/instagram-ui-shaderboi.appspot.com/o/user%2Fuesaka_sumire%2F278886211_4995084707254773_7325795218567940095_n.jpg?alt=media&token=ad53326a-c6db-4513-9218-580436d9008a"),
                Image("https://firebasestorage.googleapis.com/v0/b/instagram-ui-shaderboi.appspot.com/o/user%2Fuesaka_sumire%2F278896246_384685423558823_8941339597698473105_n.jpg?alt=media&token=cac18601-faa4-44a8-a8de-1f27ad6cf5f4"),
                Image("https://firebasestorage.googleapis.com/v0/b/instagram-ui-shaderboi.appspot.com/o/user%2Fuesaka_sumire%2F278909468_518625036522993_8966454040855118101_n.jpg?alt=media&token=08c29f72-9102-46f7-8879-f261d684d783")
            ),
            "Test 123",
            36,
            listOf("a", "b")
        )
    )
}