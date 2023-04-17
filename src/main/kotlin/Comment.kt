package ru.netology

data class Comment(
    var id: Int = 0,
    val fromID: Int = 1,
    val date: Int = 0,
    val text: String = "Text",
    val donut: Donut,
    val replyToUser: Int = 1,
    val replyToComment: Int = 1,
    val attachments: Array<Attachment> = arrayOf(),
    val parentsStack: Array<ParentsStack> = arrayOf(),
    val thread: Thread
)

data class Donut(
    val isDon: Boolean = false,
    val placeholder: String = "placeholder"
)

data class ParentsStack(
    val replyPostID: Int = 1
)

data class Thread(
    var count: Int = 0,
    val items: Array<Comments> = arrayOf(),  //только для метода wall.getComments
    val canPost: Boolean = false,
    val showReplyButton: Boolean = false,
    val groupsCanPost: Boolean = false
)
