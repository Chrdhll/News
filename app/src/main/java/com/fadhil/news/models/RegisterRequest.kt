package com.fadhil.news.models

data class RegisterRequest(
    val username: String,
    val password: String,
    val fullname: String,
    val email: String
)