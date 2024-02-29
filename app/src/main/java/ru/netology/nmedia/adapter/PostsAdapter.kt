package ru.netology.nmedia.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.netology.nmedia.R
import ru.netology.nmedia.databinding.CardPostBinding
import ru.netology.nmedia.dto.Post

typealias OnLikeListener = (post: Post) -> Unit

class PostsAdapter(private val onLikeListener: OnLikeListener) : RecyclerView.Adapter<PostViewHolder>() {
    var list = emptyList<Post>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding = CardPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding, onLikeListener)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = list[position]
        holder.bind(post)
    }

    override fun getItemCount(): Int = list.size
}

class PostViewHolder(
    private val binding: CardPostBinding,
    private val onLikeListener: OnLikeListener
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(post: Post) {
        binding.apply {
            textView.text = post.author
            textView2.text = post.published
            connn.text = post.content
            textView4.text = post.kolRep.toString()
            var k = 12
            if (post.likedByMe) {
                imageView5?.setImageResource(ru.netology.nmedia.R.drawable.unlike)
            }
            if (post.kolLikes) {
                textView3?.text = "112"
            }

            imageView5.setOnClickListener() {
                post.likedByMe = !post.likedByMe
                post.kolLikes = !post.kolLikes
                imageView5.setImageResource(
                    if (post.likedByMe) ru.netology.nmedia.R.drawable.unlike else ru.netology.nmedia.R.drawable.heart
                )
                textView3.text = if (post.kolLikes) "111" else "112"

            }

            imageView2.setOnClickListener() {
                k = k + 100
                textView4.text = k.toString()
                if (k >= 1000) {
                    textView4.text =
                        (k / 1000).toString() + "." + ((k % 1000) / 100).toString() + "K"
                }
                if (k >= 10000) {
                    textView4.text = (k / 1000).toString() + "K"
                }
                if (k >= 1000000) {
                    textView4.text =
                        (k / 1000000).toString() + "." + ((k % 1000000) / 100000).toString() + "M"
                }

            }
        }
    }
}
