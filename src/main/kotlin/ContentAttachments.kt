package ru.netology

data class Photo(
    val type: String = "Photo",
    val content: String = type,
    var id: Int = 0,
    val albumID: Int = 1,
    val ownerID: Int = 1,
    val userID: Int = 1,
    val text: String = "text",
    val date: Int = 0,
    val sizes: Array<Sizes> = arrayOf()
)

data class Sizes(
    val type: String = "type",
    val url: String = "url",
    val width: Int = 1,
    val height: Int = 1,
    val widthW: Int = 1,
    val heightH: Int = 1
)

data class Album(
    val type: String = "Album",
    val content: String = type,
    var id: Int = 0,
    val thumb: Photo,
    val ownerID: Int = 1,
    val title: String = "title",
    val description: String = "description",
    val created: Int = 0,
    val updated: Int = 0,
    val size: Int = 6
)

data class Audio(
    val type: String = "Audio",
    val content: String = type,
    var id: Int = 0,
    val ownerID: Int = 1,
    val artist: String = "artist",
    val title: String = "title",
    val duration: Int = 50,
    val url: String = "url",
    val lyricsID: Int = 1,
    val albumID: Int = 1,
    val genreID: Int = 1,
    val date: Int = 0,
    val noSearch: Boolean = false,
    val isHg: Boolean = false
)

data class Note(
    val type: String = "Note",
    val content: String = type,
    var id: Int = 0,
    val ownerID: Int = 1,
    val title: String = "title",
    val text: String = "text",
    val date: Int = 0,
    val comments: Int = 0,
    val readComments: Int = 0,
    val viewURL: String = "url",
    val privacyView: String = "privacyView",
    val canComment: Boolean = false,
    val textWiki: String = "textWiki"
)

data class Link(
    val type: String = "Link",
    val content: String = type,
    val url: String = "url",
    val title: String = "title",
    val caption: String = "caption",
    val description: String = "description",
    val photo: Photo,
    val product: Product,
    val button: Button,
    val previewPage: String = "preview_page",
    val previewURL: String = "preview_url"
)

data class Product(
    val price: Price
)

data class Price(
    val amount: Int = 1,
    val currency: Currency,
    val text: String = "text"
)

data class Currency(
    val id: Int = 1,
    val name: String = "name"
)

data class Button(
    val title: String = "title",
    val action: Action
)

data class Action(
    val type: String = "type",
    val openURL: String = "openURL",
    val url: String = "url"
)

