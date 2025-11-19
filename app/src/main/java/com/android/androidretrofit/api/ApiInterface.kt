package com.android.androidretrofit.api

import com.android.androidretrofit.model.Album
import com.android.androidretrofit.model.Comment
import com.android.androidretrofit.model.Photo
import com.android.androidretrofit.model.Post
import com.android.androidretrofit.model.ResponseData
import com.android.androidretrofit.model.Todo
import com.android.androidretrofit.model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

    // Posts
    @GET("/posts")
    fun getAllPosts(): Call<List<Post>>

    @GET("/posts/{id}")
    fun getPostById(@Path("id") id: Int): Call<Post>

    // Comments
    @GET("/comments")
    fun getAllComments(): Call<List<Comment>>

    @GET("/comments/{id}")
    fun getCommentById(@Path("id") id: Int): Call<Comment>

    // Albums
    @GET("/albums")
    fun getAllAlbums(): Call<List<Album>>

    @GET("/albums/{id}")
    fun getAlbumById(@Path("id") id: Int): Call<Album>

    // Photos
    @GET("/photos")
    fun getAllPhotos(): Call<List<Photo>>

    @GET("/photos/{id}")
    fun getPhotoById(@Path("id") id: Int): Call<Photo>

    // Todos
    @GET("/todos")
    fun getAllTodos(): Call<List<Todo>>

    @GET("/todos/{id}")
    fun getTodoById(@Path("id") id: Int): Call<Todo>

    // Users
    @GET("/users")
    fun getAllUsers(): Call<List<User>>

    @GET("/users/{id}")
    fun getUserById(@Path("id") id: Int): Call<User>
}
