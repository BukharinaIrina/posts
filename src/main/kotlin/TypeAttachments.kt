package ru.netology

data class PhotoAttachment(
    override val type: String = "Photo",
    val content: Photo
) : Attachment

data class AlbumAttachment(
    override val type: String = "Album",
    val content: Album
) : Attachment

data class AudioAttachment(
    override val type: String = "Audio",
    val content: Audio
) : Attachment

data class NoteAttachment(
    override val type: String = "Note",
    val content: Note
) : Attachment

data class LinkAttachment(
    override val type: String = "Link",
    val content: Link
) : Attachment

