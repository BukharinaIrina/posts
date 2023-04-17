package ru.netology

class PostNotFoundException(message: String) : RuntimeException(message)

data class Post(
    var id: Int = 0,
    val ownerID: Int = 1,
    val fromID: Int = 1,
    val createdBy: Int = 1,
    val date: Int = 0,
    val text: String = "text",
    val replyOwnerID: Int = 1,
    val replyPostID: Int = 1,
    var friendsOnly: Int = 0,
    val comments: Comments?,
    val copyright: Copyringht,
    val like: Likes?,
    val reposts: Reposts,
    val views: Views,
    val postType: String = "post",
    val postSource: PostSourse,
    val geo: Geo,
    val signerID: Int = 0,
    val copyHistory: Array<Reposts> = arrayOf(),
    val canPin: Boolean = false,
    val canDelete: Boolean = false,
    val canEdit: Boolean = false,
    val isPinned: Boolean = false,
    val markedAsAds: Boolean = false,
    val isFavorite: Boolean = false,
    val donut: vkDonut,
    val postponedID: Int = 0,
    val attachments: Array<Attachment> = arrayOf()
)

data class Comments(
    var count: Int = 0,
    val canPost: Boolean = false,
    val groupsCanPost: Boolean = false,
    val canClose: Boolean = false,
    val canOpen: Boolean = false
)

data class Copyringht(
    var id: Int = 0,
    val link: String = "link",
    val name: String = "name",
    val type: String = "type"
)

data class Likes(
    var count: Int = 0,
    val userLikes: Boolean = false,
    val canLike: Boolean = false,
    val canPublish: Boolean = false
)

data class Reposts(
    var count: Int = 0,
    val userReposted: Boolean = false
)

data class Views(
    var count: Int = 0
)

data class PostSourse(
    val type: String = "vk",
    val platform: String = "android",
    val data: String = "04.04.2023",
    val url: String = "url"
)

data class Geo(
    val type: String = "type",
    val coordinates: String = "coordinates",
    val plase: Plase
)

data class Plase(
    var id: Int = 0,
    val title: String = "title",
    val latitude: Int = 30,
    val longitude: Int = 30,
    val created: Int = 0,
    val icon: String = "icon",
    val checkins: Int = 0,
    val updated: Int = 0,
    val type: Int = 0,
    val countri: Int = 0,
    val city: Int = 0,
    val adress: String = "adress"
)

data class vkDonut(
    val isDount: Boolean = false,
    val paidDuration: Int = 0,
    val placeholder: Placeholder,
    val canPublishFreeCopy: Boolean = false,
    val editMode: String = "all"
)

data class Placeholder(
    val plug: String = "plug"
)

object WallService {
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()
    private var lastPostID = 1
    private var lastCommentID = 1

    fun clear() {
        posts = emptyArray()
        comments = emptyArray()
        lastPostID = 1
        lastCommentID = 1
    }

    fun add(post: Post): Post {
        posts += post.copy(id = lastPostID++)
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, postArray) in posts.withIndex()) {
            if (postArray.id == post.id) {
                posts[index] = post.copy(text = "TEXT")
                return true
            }
        }
        return false
    }

    fun createComment(postID: Int, comment: Comment): Comment {
        for ((index, postArray) in posts.withIndex()) {
            if (postArray.id == postID) {
                comments += comment.copy(id = lastCommentID++)
                return comments.last()
            }
        }
        throw PostNotFoundException("No post with id $postID")
    }
}

fun main() {
    println(
        WallService.add(
            Post(
                comments = Comments(), copyright = Copyringht(), like = Likes(), reposts = Reposts(),
                views = Views(), postSource = PostSourse(), geo = Geo(plase = Plase()),
                copyHistory = arrayOf(Reposts()), donut = vkDonut(placeholder = Placeholder()),
                attachments = arrayOf(
                    LinkAttachment(
                        content = Link(
                            photo = Photo(sizes = arrayOf(Sizes())),
                            product = Product(price = Price(currency = Currency())), button = Button(action = Action())
                        )
                    )
                )
            )
        )
    )
    println()
    println(
        WallService.add(
            Post(
                comments = Comments(), copyright = Copyringht(), like = Likes(), reposts = Reposts(),
                views = Views(), postSource = PostSourse(), geo = Geo(plase = Plase()),
                copyHistory = arrayOf(Reposts()), donut = vkDonut(placeholder = Placeholder()),
                attachments = arrayOf(PhotoAttachment(content = Photo(sizes = arrayOf(Sizes()))))
            )
        )
    )
    println()
    println(
        WallService.update(
            Post(
                2, comments = Comments(), copyright = Copyringht(), like = Likes(), reposts = Reposts(),
                views = Views(), postSource = PostSourse(), geo = Geo(plase = Plase()),
                copyHistory = arrayOf(Reposts()), donut = vkDonut(placeholder = Placeholder()),
                attachments = arrayOf(PhotoAttachment(content = Photo(sizes = arrayOf(Sizes()))))
            )
        )
    )
    println(
        WallService.update(
            Post(
                8, comments = Comments(), copyright = Copyringht(), like = Likes(), reposts = Reposts(),
                views = Views(), postSource = PostSourse(), geo = Geo(plase = Plase()),
                copyHistory = arrayOf(Reposts()), donut = vkDonut(placeholder = Placeholder()),
                attachments = arrayOf(PhotoAttachment(content = Photo(sizes = arrayOf(Sizes()))))
            )
        )
    )
    println()
    println(
        WallService.createComment(
            2, comment = Comment(
                donut = Donut(), attachments = arrayOf(PhotoAttachment(content = Photo(sizes = arrayOf(Sizes())))),
                parentsStack = arrayOf(ParentsStack()), thread = Thread()
            )
        )
    )
    println()
    println(
        WallService.createComment(
            3, comment = Comment(
                donut = Donut(), attachments = arrayOf(PhotoAttachment(content = Photo(sizes = arrayOf(Sizes())))),
                parentsStack = arrayOf(ParentsStack()), thread = Thread()
            )
        )
    )
}