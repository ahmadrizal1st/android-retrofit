package com.android.androidretrofit.ui

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.android.androidretrofit.R
import com.android.androidretrofit.api.RetrofitInstance
import com.android.androidretrofit.model.Album
import com.android.androidretrofit.model.Comment
import com.android.androidretrofit.model.Photo
import com.android.androidretrofit.model.Post
import com.android.androidretrofit.model.Todo
import com.android.androidretrofit.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var dataType: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val toolbar = findViewById<Toolbar>(R.id.toolbar_list)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        listView = findViewById(R.id.listView)
        dataType = intent.getStringExtra("dataType") ?: "posts"

        when (dataType) {
            "posts" -> fetchPosts()
            "comments" -> fetchComments()
            "albums" -> fetchAlbums()
            "photos" -> fetchPhotos()
            "todos" -> fetchTodos()
            "users" -> fetchUsers()
        }

        listView.setOnItemClickListener { _, _, position, _ ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("dataType", dataType)
            intent.putExtra("itemId", position + 1) // Assuming IDs start from 1
            startActivity(intent)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun fetchPosts() {
        RetrofitInstance.apiInterface.getAllPosts().enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                val posts = response.body()
                val adapter = ArrayAdapter(this@ListActivity, android.R.layout.simple_list_item_1, posts?.map { it.title } ?: emptyList())
                listView.adapter = adapter
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Toast.makeText(this@ListActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun fetchComments() {
        RetrofitInstance.apiInterface.getAllComments().enqueue(object : Callback<List<Comment>> {
            override fun onResponse(call: Call<List<Comment>>, response: Response<List<Comment>>) {
                val comments = response.body()
                val adapter = ArrayAdapter(this@ListActivity, android.R.layout.simple_list_item_1, comments?.map { it.name } ?: emptyList())
                listView.adapter = adapter
            }

            override fun onFailure(call: Call<List<Comment>>, t: Throwable) {
                Toast.makeText(this@ListActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun fetchAlbums() {
        RetrofitInstance.apiInterface.getAllAlbums().enqueue(object : Callback<List<Album>> {
            override fun onResponse(call: Call<List<Album>>, response: Response<List<Album>>) {
                val albums = response.body()
                val adapter = ArrayAdapter(this@ListActivity, android.R.layout.simple_list_item_1, albums?.map { it.title } ?: emptyList())
                listView.adapter = adapter
            }

            override fun onFailure(call: Call<List<Album>>, t: Throwable) {
                Toast.makeText(this@ListActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun fetchPhotos() {
        RetrofitInstance.apiInterface.getAllPhotos().enqueue(object : Callback<List<Photo>> {
            override fun onResponse(call: Call<List<Photo>>, response: Response<List<Photo>>) {
                val photos = response.body()
                val adapter = ArrayAdapter(this@ListActivity, android.R.layout.simple_list_item_1, photos?.map { it.title } ?: emptyList())
                listView.adapter = adapter
            }

            override fun onFailure(call: Call<List<Photo>>, t: Throwable) {
                Toast.makeText(this@ListActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun fetchTodos() {
        RetrofitInstance.apiInterface.getAllTodos().enqueue(object : Callback<List<Todo>> {
            override fun onResponse(call: Call<List<Todo>>, response: Response<List<Todo>>) {
                val todos = response.body()
                val adapter = ArrayAdapter(this@ListActivity, android.R.layout.simple_list_item_1, todos?.map { it.title } ?: emptyList())
                listView.adapter = adapter
            }

            override fun onFailure(call: Call<List<Todo>>, t: Throwable) {
                Toast.makeText(this@ListActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun fetchUsers() {
        RetrofitInstance.apiInterface.getAllUsers().enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                val users = response.body()
                val adapter = ArrayAdapter(this@ListActivity, android.R.layout.simple_list_item_1, users?.map { it.name } ?: emptyList())
                listView.adapter = adapter
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                Toast.makeText(this@ListActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        })
    }
}
