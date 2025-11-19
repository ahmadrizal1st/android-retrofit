package com.android.androidretrofit.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.androidretrofit.R
import com.android.androidretrofit.api.RetrofitInstance
import com.android.androidretrofit.model.Post
import com.android.androidretrofit.model.Comment
import com.android.androidretrofit.model.Album
import com.android.androidretrofit.model.Photo
import com.android.androidretrofit.model.Todo
import com.android.androidretrofit.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val detailTitle = findViewById<TextView>(R.id.detail_title)
        val detailBody = findViewById<TextView>(R.id.detail_body)

        val itemId = intent.getIntExtra("itemId", -1)
        val dataType = intent.getStringExtra("dataType")

        if (itemId != -1 && dataType != null) {
            when (dataType) {
                "posts" -> fetchPost(itemId, detailTitle, detailBody)
                "comments" -> fetchComment(itemId, detailTitle, detailBody)
                "albums" -> fetchAlbum(itemId, detailTitle, detailBody)
                "photos" -> fetchPhoto(itemId, detailTitle, detailBody)
                "todos" -> fetchTodo(itemId, detailTitle, detailBody)
                "users" -> fetchUser(itemId, detailTitle, detailBody)
            }
        }
    }

    private fun fetchPost(id: Int, titleView: TextView, bodyView: TextView) {
        RetrofitInstance.apiInterface.getPostById(id).enqueue(object : Callback<Post> {
            @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if (response.isSuccessful) {
                    val post = response.body()
                    titleView.text = post?.title ?: "No Title"
                    bodyView.text = post?.body ?: "No Body"
                } else {
                    titleView.text = "Error"
                    bodyView.text = "Failed to load post"
                }
            }

            @SuppressLint("SetTextI18n")
            override fun onFailure(call: Call<Post>, t: Throwable) {
                titleView.text = "Error"
                bodyView.text = t.message ?: "Unknown error"
            }
        })
    }

    private fun fetchComment(id: Int, titleView: TextView, bodyView: TextView) {
        RetrofitInstance.apiInterface.getCommentById(id).enqueue(object : Callback<Comment> {
            @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call<Comment>, response: Response<Comment>) {
                if (response.isSuccessful) {
                    val comment = response.body()
                    titleView.text = comment?.name ?: "No Name"
                    bodyView.text = comment?.body ?: "No Body"
                } else {
                    titleView.text = "Error"
                    bodyView.text = "Failed to load comment"
                }
            }

            @SuppressLint("SetTextI18n")
            override fun onFailure(call: Call<Comment>, t: Throwable) {
                titleView.text = "Error"
                bodyView.text = t.message ?: "Unknown error"
            }
        })
    }

    private fun fetchAlbum(id: Int, titleView: TextView, bodyView: TextView) {
        RetrofitInstance.apiInterface.getAlbumById(id).enqueue(object : Callback<Album> {
            @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call<Album>, response: Response<Album>) {
                if (response.isSuccessful) {
                    val album = response.body()
                    titleView.text = album?.title ?: "No Title"
                    bodyView.text = "Album ID: ${album?.id}"
                } else {
                    titleView.text = "Error"
                    bodyView.text = "Failed to load album"
                }
            }

            @SuppressLint("SetTextI18n")
            override fun onFailure(call: Call<Album>, t: Throwable) {
                titleView.text = "Error"
                bodyView.text = t.message ?: "Unknown error"
            }
        })
    }

    private fun fetchPhoto(id: Int, titleView: TextView, bodyView: TextView) {
        RetrofitInstance.apiInterface.getPhotoById(id).enqueue(object : Callback<Photo> {
            @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call<com.android.androidretrofit.model.Photo>, response: Response<com.android.androidretrofit.model.Photo>) {
                if (response.isSuccessful) {
                    val photo = response.body()
                    titleView.text = photo?.title ?: "No Title"
                    bodyView.text = "URL: ${photo?.url}"
                } else {
                    titleView.text = "Error"
                    bodyView.text = "Failed to load photo"
                }
            }

            @SuppressLint("SetTextI18n")
            override fun onFailure(call: Call<com.android.androidretrofit.model.Photo>, t: Throwable) {
                titleView.text = "Error"
                bodyView.text = t.message ?: "Unknown error"
            }
        })
    }

    private fun fetchTodo(id: Int, titleView: TextView, bodyView: TextView) {
        RetrofitInstance.apiInterface.getTodoById(id).enqueue(object : Callback<Todo> {
            @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call<com.android.androidretrofit.model.Todo>, response: Response<com.android.androidretrofit.model.Todo>) {
                if (response.isSuccessful) {
                    val todo = response.body()
                    titleView.text = todo?.title ?: "No Title"
                    bodyView.text = "Completed: ${todo?.completed}"
                } else {
                    titleView.text = "Error"
                    bodyView.text = "Failed to load todo"
                }
            }

            @SuppressLint("SetTextI18n")
            override fun onFailure(call: Call<com.android.androidretrofit.model.Todo>, t: Throwable) {
                titleView.text = "Error"
                bodyView.text = t.message ?: "Unknown error"
            }
        })
    }

    private fun fetchUser(id: Int, titleView: TextView, bodyView: TextView) {
        RetrofitInstance.apiInterface.getUserById(id).enqueue(object : Callback<User> {
            @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful) {
                    val user = response.body()
                    titleView.text = user?.name ?: "No Name"
                    bodyView.text = "Email: ${user?.email}"
                } else {
                    titleView.text = "Error"
                    bodyView.text = "Failed to load user"
                }
            }

            @SuppressLint("SetTextI18n")
            override fun onFailure(call: Call<User>, t: Throwable) {
                titleView.text = "Error"
                bodyView.text = t.message ?: "Unknown error"
            }
        })
    }
}
