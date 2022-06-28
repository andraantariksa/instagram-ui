package id.shaderboi.instagramui.data.dummy

import id.shaderboi.instagramui.domain.model.*
import kotlinx.datetime.Instant

object DummyData {
    val users = hashMapOf<String, User>(
        "natgeoindonesia" to User(
            briefInfo = UserBriefInfo(
                username = "natgeoindonesia",
                imageUrl = "https://raw.githubusercontent.com/andraantariksa/instagram-ui/master/assets/user/natgeoindonesia/profile.jpg",
                isOfficial = true,
            ),
            additionalInfo = UserAdditionalInfo(
                followers = 1,
                following = 1,
                postCount = 1
            ),
            postsMap = mapOf()
        ),
        "ecommurz" to User(
            briefInfo = UserBriefInfo(
                username = "ecommurz",
                imageUrl = "https://raw.githubusercontent.com/andraantariksa/instagram-ui/master/assets/user/ecommurz/profile.jpg",
            ),
            additionalInfo = UserAdditionalInfo(
                description = "Indo Biggest Tech Execs & Workers community \uD83C\uDDEE\uD83C\uDDE9\n" +
                        "Follow for MOST RECENT Tech stories in shitpost and memes \uD83E\uDD21\n" +
                        "Email: partnermurz@gmail.com\n" +
                        "TEAS TRACKER \uD83D\uDC47",
                fullName = "Ecommerce & Tech Meme Factory",
                followers = 148000,
                following = 141,
                postCount = 752
            ),
            story = listOf(
                Content.Image("https://firebasestorage.googleapis.com/v0/b/instagram-ui-shaderboi.appspot.com/o/user%2Fecommurz%2F279278660_1004747560150894_8300046238725122530_n.webp?alt=media&token=99b04605-8bd5-4261-9150-2cb146c59426"),
                Content.Image("https://firebasestorage.googleapis.com/v0/b/instagram-ui-shaderboi.appspot.com/o/user%2Fecommurz%2F279364530_2823559904604950_881192006437403722_n.webp?alt=media&token=2fb4f2c3-48d7-436f-a06c-bcb5b82f459a"),
                Content.Image("https://firebasestorage.googleapis.com/v0/b/instagram-ui-shaderboi.appspot.com/o/user%2Fecommurz%2F279391597_705156570682654_1190001259206406071_n.webp?alt=media&token=355f2d16-535d-4ad2-8a83-d0aa30ba635c"),
                Content.Video("https://firebasestorage.googleapis.com/v0/b/instagram-ui-shaderboi.appspot.com/o/user%2Fecommurz%2FEF4A87F5A51538459B5C7D9919A420AC_video_dashinit.mp4?alt=media&token=c16be7ee-7c73-427d-96b7-3ee0eb9b2df0")
            ),
        ),
        "uesaka_sumire" to User(
            briefInfo = UserBriefInfo(
                username = "uesaka_sumire",
                imageUrl = "https://raw.githubusercontent.com/andraantariksa/instagram-ui/master/assets/user/uesaka_sumire/profile.jpg",
                isOfficial = true,
            ),
            additionalInfo = UserAdditionalInfo(
                fullName = "上坂すみれ",
                userCaption = "Personal blog",
                description = "上坂すみれさんです。\n" +
                        "レッツビギンでございます！",
                url = "https://linktr.ee/SumireUesaka",
                postCount = 696,
                followers = 491000,
                following = 4
            ),
            postsMap = mapOf(
                1 to Post(
                    contents = listOf(
                        Content.Image("https://raw.githubusercontent.com/andraantariksa/instagram-ui/master/assets/user/uesaka_sumire/posts/1_1.jpg"),
                        Content.Image("https://raw.githubusercontent.com/andraantariksa/instagram-ui/master/assets/user/uesaka_sumire/posts/1_2.jpg"),
                        Content.Image("https://raw.githubusercontent.com/andraantariksa/instagram-ui/master/assets/user/uesaka_sumire/posts/1_3.jpg"),
                    ),
                    caption = """インスタグラムのフォロワーさまが49万人に！ありがとうございます！！
これからも仲良くしてくださいなヾ(*´∀｀*)ﾉ
最近めのお写真いろいろです

#上坂すみれ""",
                    likeCount = 1448,
                    relatedLike = listOf("adityo_w_pratomo", "nissacha05"),
                    createdAt = Instant.parse("2022-06-16T01:54:36.000Z")
                ),
                2 to Post(
                    contents = listOf(
                        Content.Image("https://raw.githubusercontent.com/andraantariksa/instagram-ui/master/assets/user/uesaka_sumire/posts/2_1.jpg"),
                        Content.Image("https://raw.githubusercontent.com/andraantariksa/instagram-ui/master/assets/user/uesaka_sumire/posts/2_2.jpg"),
                        Content.Image("https://raw.githubusercontent.com/andraantariksa/instagram-ui/master/assets/user/uesaka_sumire/posts/2_3.jpg"),
                        Content.Image("https://raw.githubusercontent.com/andraantariksa/instagram-ui/master/assets/user/uesaka_sumire/posts/2_4.jpg"),
                    ),
                    caption = """声優と夜あそび火曜日！！
しばしのお別れなのです…！！！

#たかはし上坂と夜あそび""",
                    likeCount = 31861,
                    relatedLike = listOf("adityo_w_pratomo", "nissacha05"),
                    createdAt = Instant.parse("2022-06-21T12:59:39.000Z")
                ),
                3 to Post(
                    contents = listOf(
                        Content.Image("https://raw.githubusercontent.com/andraantariksa/instagram-ui/master/assets/user/uesaka_sumire/posts/3_1.jpg"),
                        Content.Image("https://raw.githubusercontent.com/andraantariksa/instagram-ui/master/assets/user/uesaka_sumire/posts/3_2.jpg"),
                        Content.Image("https://raw.githubusercontent.com/andraantariksa/instagram-ui/master/assets/user/uesaka_sumire/posts/3_3.jpg"),
                        Content.Image("https://raw.githubusercontent.com/andraantariksa/instagram-ui/master/assets/user/uesaka_sumire/posts/3_4.jpg"),
                    ),
                    caption = """シンデレラガールズトロピカル公演のパンフレットで撮ったお写真です！
トロピカル〜！！
皆さま、よき週末をお過ごしくださいませ( ˘ω˘ )

#アイドルマスターシンデレラガールズ""",
                    likeCount = 34500,
                    relatedLike = listOf("adityo_w_pratomo", "nissacha05"),
                    createdAt = Instant.parse("2022-06-18T04:31:53.000Z")
                ),
                4 to Post(
                    contents = listOf(
                        Content.Image("https://raw.githubusercontent.com/andraantariksa/instagram-ui/master/assets/user/uesaka_sumire/posts/4_1.jpg"),
                        Content.Image("https://raw.githubusercontent.com/andraantariksa/instagram-ui/master/assets/user/uesaka_sumire/posts/4_2.jpg"),
                        Content.Image("https://raw.githubusercontent.com/andraantariksa/instagram-ui/master/assets/user/uesaka_sumire/posts/4_3.jpg"),
                        Content.Image("https://raw.githubusercontent.com/andraantariksa/instagram-ui/master/assets/user/uesaka_sumire/posts/4_4.jpg"),
                        Content.Image("https://raw.githubusercontent.com/andraantariksa/instagram-ui/master/assets/user/uesaka_sumire/posts/4_5.jpg"),
                    ),
                    caption = """夜あそびでーす！
まさかの…？！

#たかはし上坂と夜あそび
#上坂すみれ""",
                    likeCount = 31171,
                    relatedLike = listOf("adityo_w_pratomo", "nissacha05"),
                    createdAt = Instant.parse("2022-06-14T12:58:38.000Z")
                ),
            )
        ),
        "zachking" to User(
            briefInfo = UserBriefInfo(
                username = "zachking",
                imageUrl = "https://raw.githubusercontent.com/andraantariksa/instagram-ui/master/assets/user/zachking/profile.jpg",
                isOfficial = true
            ),
            story = listOf(),
            additionalInfo = UserAdditionalInfo(
                following = 212,
                followers = 24500000,
                postCount = 1047,
                fullName = "Zach King",
                description = "\uD83D\uDE03 Stories can make people smile.\n" +
                        "\uD83D\uDCECContact - hello@zachkingteam.com\n" +
                        "⤵️ These are the Links you are looking for ⤵️",
                userCaption = "Digital Creator",
                url = "www.zachkingteams.com/links"
            ),
            postsMap = mapOf(
                1 to Post(
                    contents = listOf(
                        Content.Video("https://raw.githubusercontent.com/andraantariksa/instagram-ui/master/assets/user/zachking/posts/1_1.mp4")
                    ),
                    caption = "Kids at Play ⚠️",
                    likeCount = 840967,
                    relatedLike = listOf("uesaka_sumire"),
                    createdAt = Instant.parse("2022-06-13T15:04:19.000Z"),
                )
            )
        )
    )

    val dummyComments = listOf(
        Comment(
            username = "kasumi_sr",
            comment = "寂しい\uD83D\uDE2Dお召し物可愛いですね\uD83C\uDF3C",
            likeCount = 1,
            createdAt = Instant.parse("2022-06-21T13:43:53.000Z")
        ),
        Comment(
            username = "maichelprasetio",
            comment = "\uD83D\uDE0A\uD83D\uDE0A\uD83D\uDE0A\uD83D\uDE0A\uD83E\uDD70\uD83E\uDD70\uD83E\uDD70\uD83E\uDD70\uD83D\uDE0D\uD83D\uDE0D\uD83D\uDE0D\uD83D\uDE0D\uD83D\uDE0D\uD83D\uDE0B\uD83D\uDE0B\uD83D\uDE0B\uD83D\uDE0B\uD83D\uDE0B\uD83D\uDE0D\uD83D\uDE0D\uD83D\uDE0D\uD83D\uDE0D\uD83D\uDE0D\uD83D\uDE0D❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️",
            likeCount = 1,
            createdAt = Instant.parse("2022-06-21T13:15:19.000Z")
        ),
        Comment(
            username = "takashima_nora",
            comment = "寂しいで",
            likeCount = 0,
            createdAt = Instant.parse("2022-06-21T14:15:22.000Z")
        ),
        Comment(
            username = "dsk77",
            comment = "あらかわいい",
            likeCount = 0,
            createdAt = Instant.parse("2022-06-21T14:18:55.000Z")
        ),
        Comment(
            username = "cl0_.n",
            comment = "寂しいです（ ; ; ）また戻ってくるまで待ってますね！！舞台頑張ってください\uD83D\uDD25\uD83E\uDD0D",
            likeCount = 1,
            createdAt = Instant.parse("2022-06-21T13:12:56.000Z")
        ),
        Comment(
            username = "kakipnut",
            comment = "同志、お疲れさまです(｀･ω･´)ゞ肩のちら見せが可愛らしいお召し物ですなぁ\uD83D\uDE0A",
            likeCount = 1,
            createdAt = Instant.parse("2022-06-21T14:19:00.000Z")
        ),
        Comment(
            username = "qiantian_zhenghong",
            comment = "可愛いね✨いつもいつも素敵ですよ☺️",
            likeCount = 1,
            createdAt = Instant.parse("2022-06-21T14:37:38.000Z")
        ),
    )

    val posts: List<UserPost>
        get() {
            val userPosts = mutableListOf<UserPost>()
            users.entries.forEach { userEntry ->
                val user = userEntry.value
                user.postsMap.entries.forEach { postEntry ->
                    userPosts.add(
                        UserPost(
                            userBrief = user.briefInfo,
                            post = postEntry.value
                        )
                    )
                }
            }
            userPosts.sortBy { userPost -> userPost.post.createdAt }
            return userPosts
        }

    val userStories: List<UserStory> = listOf()

    const val myUsername: Username = "uesaka_sumire"
}