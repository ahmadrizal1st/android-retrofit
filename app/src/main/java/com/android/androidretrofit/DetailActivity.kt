package com.android.androidretrofit

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailActivity : AppCompatActivity() {

    private lateinit var detailTextView: TextView
    private lateinit var dataType: String
    private var id: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        detailTextView = findViewById(R.id.detail_textView)
        dataType = intent.getStringExtra("dataType") ?: "posts"
        id = intent.getIntExtra("id", 1)

        when (dataType) {
            "posts" -> fetchPost(id)
            "comments" -> fetchComment(id)
            "albums" -> fetchAlbum(id)
            "photos" -> fetchPhoto(id)
            "todos" -> fetchTodo(id)
            "users" -> fetchUser(id)
        }
    }

    private fun fetchPost(id: Int) {
        RetrofitInstance.apiInterface.getPostById(id).enqueue(object : Callback<Post> {
            @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                val post = response.body()
                detailTextView.text = "ID: ${post?.id}\nTitle: ${post?.title}\nBody: ${post?.body}\nUser ID: ${post?.userId}"
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                Toast.makeText(this@DetailActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun fetchComment(id: Int) {
        RetrofitInstance.apiInterface.getCommentById(id).enqueue(object : Callback<Comment> {
            @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call<Comment>, response: Response<Comment>) {
                val comment = response.body()
                detailTextView.text = "ID: ${comment?.id}\nName: ${comment?.name}\nEmail: ${comment?.email}\nBody: ${comment?.body}\nPost ID: ${comment?.postId}"
            }

            override fun onFailure(call: Call<Comment>, t: Throwable) {
                Toast.makeText(this@DetailActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun fetchAlbum(id: Int) {
        RetrofitInstance.apiInterface.getAlbumById(id).enqueue(object : Callback<Album> {
            @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call<Album>, response: Response<Album>) {
                val album = response.body()
                detailTextView.text = "ID: ${album?.id}\nTitle: ${album?.title}\nUser ID: ${album?.userId}"
            }

            override fun onFailure(call: Call<Album>, t: Throwable) {
                Toast.makeText(this@DetailActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun fetchPhoto(id: Int) {
        RetrofitInstance.apiInterface.getPhotoById(id).enqueue(object : Callback<Photo> {
            @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call<Photo>, response: Response<Photo>) {
                val photo = response.body()
                detailTextView.text = "ID: ${photo?.id}\nTitle: ${photo?.title}\nURL: ${photo?.url}\nThumbnail: ${photo?.thumbnailUrl}\nAlbum ID: ${photo?.albumId}"
            }

            override fun onFailure(call: Call<Photo>, t: Throwable) {
                Toast.makeText(this@DetailActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun fetchTodo(id: Int) {
        RetrofitInstance.apiInterface.getTodoById(id).enqueue(object : Callback<Todo> {
            @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call<Todo>, response: Response<Todo>) {
                val todo = response.body()
                detailTextView.text = "ID: ${todo?.id}\nTitle: ${todo?.title}\nCompleted: ${todo?.completed}\nUser ID: ${todo?.userId}"
            }

            override fun onFailure(call: Call<Todo>, t: Throwable) {
                Toast.makeText(this@DetailActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun fetchUser(id: Int) {
        RetrofitInstance.apiInterface.getUserById(id).enqueue(object : Callback<User> {
            @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call<User>, response: Response<User>) {
                val user = response.body()
                detailTextView.text = "ID: ${user?.id}\nName: ${user?.name}\nUsername: ${user?.username}\nEmail: ${user?.email}\nPhone: ${user?.phone}\nWebsite: ${user?.website}\nAddress: ${user?.address?.street}, ${user?.address?.city}\nCompany: ${user?.company?.name}"
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                Toast.makeText(this@DetailActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        })
    }
}
