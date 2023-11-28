package com.xayappz.matchmania.models

sealed class Response<out T> {
    data class Success(val data: ArrayList<Data>) : Response<Data>()
    data class Error(val t: Throwable) : Response<Throwable>()
}