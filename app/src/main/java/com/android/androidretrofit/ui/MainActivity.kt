package com.android.androidretrofit.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.android.androidretrofit.R

class MainActivity : AppCompatActivity() {

    private lateinit var postsButton: Button
    private lateinit var commentsButton: Button
    private lateinit var albumsButton: Button
    private lateinit var photosButton: Button
    private lateinit var todosButton: Button
    private lateinit var usersButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        postsButton = findViewById(R.id.posts_button)
        commentsButton = findViewById(R.id.comments_button)
        albumsButton = findViewById(R.id.albums_button)
        photosButton = findViewById(R.id.photos_button)
        todosButton = findViewById(R.id.todos_button)
        usersButton = findViewById(R.id.users_button)

        postsButton.setOnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            intent.putExtra("dataType", "posts")
            startActivity(intent)
        }

        commentsButton.setOnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            intent.putExtra("dataType", "comments")
            startActivity(intent)
        }

        albumsButton.setOnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            intent.putExtra("dataType", "albums")
            startActivity(intent)
        }

        photosButton.setOnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            intent.putExtra("dataType", "photos")
            startActivity(intent)
        }

        todosButton.setOnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            intent.putExtra("dataType", "todos")
            startActivity(intent)
        }

        usersButton.setOnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            intent.putExtra("dataType", "users")
            startActivity(intent)
        }
    }
}
