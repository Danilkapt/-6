package ru.netology.nmedia.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.netology.nmedia.dto.Post

class PostRepositoryInMemoryImpl : PostRepository {

    private var posts = listOf(
        Post(
            id = 2,
            author = "Плетнев Даниил",
            content = "Москва полна очарования в любое время года. Однако некоторые ее уголки становятся особенно неотразимыми в огнях декоративной подсветки. Представляем список самых живописных «ночных» мест столицы, который будет полезен не только фотографам-любителям.",
            published = "1 минута назад",
            likedByMe = false,
            kolLikes = false,
            kolRep = 12
        ),
        Post(
            id = 2,
            author = "Плетнев Даниил",
            content = "Москва очень красивый город",
            published = "1 час назад",
            likedByMe = false,
            kolLikes = false,
            kolRep = 12
        ),
        Post(
            id = 3,
            author = "Плетнев Даниил",
            content = "Я застрял в магазине",
            published = "2 часа назад",
            likedByMe = false,
            kolLikes = false,
            kolRep = 12
        ),
        Post(
            id = 2,
            author = "Плетнев Даниил",
            content = "Красиво!",
            published = "День назад",
            likedByMe = false,
            kolLikes = false,
            kolRep = 12
        ),
    )

    private val data = MutableLiveData(posts)

    override fun getAll(): LiveData<List<Post>> = data
    override fun likeById(id: Long) {
        posts = posts.map {
           if (it.id != id) it else it.copy(likedByMe = !it.likedByMe)
        }
        data.value = posts
    }
}