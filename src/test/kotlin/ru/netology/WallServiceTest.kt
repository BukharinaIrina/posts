package ru.netology

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class WallServiceTest {

    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun add_post() {
        val result = WallService.add(
            Post(
                0, comments = Comments(), copyright = Copyringht(), like = Likes(), reposts = Reposts(),
                views = Views(), postSource = PostSourse(), geo = Geo(plase = Plase()),
                copyHistory = arrayOf(Reposts()), donut = vkDonut(placeholder = Placeholder()),
                attachments = arrayOf(PhotoAttachment(content = Photo(sizes = arrayOf(Sizes()))))
            )
        )

        assertEquals(1, result.id)
    }

    @Test
    fun update_true() {
        WallService.add(
            Post(
                0, 1, 1, comments = Comments(), copyright = Copyringht(), like = Likes(), reposts = Reposts(),
                views = Views(), postSource = PostSourse(), geo = Geo(plase = Plase()),
                copyHistory = arrayOf(Reposts()), donut = vkDonut(placeholder = Placeholder()),
                attachments = arrayOf(PhotoAttachment(content = Photo(sizes = arrayOf(Sizes()))))
            )
        )

        val update = WallService.update(
            Post(
                1, 2, 2, comments = Comments(), copyright = Copyringht(), like = Likes(), reposts = Reposts(),
                views = Views(), postSource = PostSourse(), geo = Geo(plase = Plase()),
                copyHistory = arrayOf(Reposts()), donut = vkDonut(placeholder = Placeholder()),
                attachments = arrayOf(PhotoAttachment(content = Photo(sizes = arrayOf(Sizes()))))
            )
        )

        assertEquals(true, update)
    }

    @Test
    fun update_false() {
        WallService.add(
            Post(
                0, 1, 1, comments = Comments(), copyright = Copyringht(), like = Likes(), reposts = Reposts(),
                views = Views(), postSource = PostSourse(), geo = Geo(plase = Plase()),
                copyHistory = arrayOf(Reposts()), donut = vkDonut(placeholder = Placeholder()),
                attachments = arrayOf(PhotoAttachment(content = Photo(sizes = arrayOf(Sizes()))))
            )
        )

        val update = WallService.update(
            Post(
                2, 2, 2, comments = Comments(), copyright = Copyringht(), like = Likes(), reposts = Reposts(),
                views = Views(), postSource = PostSourse(), geo = Geo(plase = Plase()),
                copyHistory = arrayOf(Reposts()), donut = vkDonut(placeholder = Placeholder()),
                attachments = arrayOf(PhotoAttachment(content = Photo(sizes = arrayOf(Sizes()))))
            )
        )

        assertEquals(false, update)
    }

    @Test
    fun createComment_true() {
        WallService.add(
            Post(
                0, 1, 1, comments = Comments(), copyright = Copyringht(), like = Likes(), reposts = Reposts(),
                views = Views(), postSource = PostSourse(), geo = Geo(plase = Plase()),
                copyHistory = arrayOf(Reposts()), donut = vkDonut(placeholder = Placeholder()),
                attachments = arrayOf(PhotoAttachment(content = Photo(sizes = arrayOf(Sizes()))))
            )
        )

        val comment = Comment(
            1, donut = Donut(), attachments = arrayOf(PhotoAttachment(content = Photo(sizes = arrayOf(Sizes())))),
            parentsStack = arrayOf(ParentsStack()), thread = Thread()
        )

        val createComment = WallService.createComment(1, comment)

        assertEquals(comment, createComment)
    }

    @Test(expected = PostNotFoundException::class)
    fun shouldThrow() {
        WallService.add(
            Post(
                0, 1, 1, comments = Comments(), copyright = Copyringht(), like = Likes(), reposts = Reposts(),
                views = Views(), postSource = PostSourse(), geo = Geo(plase = Plase()),
                copyHistory = arrayOf(Reposts()), donut = vkDonut(placeholder = Placeholder()),
                attachments = arrayOf(PhotoAttachment(content = Photo(sizes = arrayOf(Sizes()))))
            )
        )

        WallService.createComment(
            6, Comment(
                donut = Donut(), attachments = arrayOf(PhotoAttachment(content = Photo(sizes = arrayOf(Sizes())))),
                parentsStack = arrayOf(ParentsStack()), thread = Thread()
            )
        )
    }
}