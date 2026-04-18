package com.example.turkcellintro.data

import com.example.turkcellintro.model.Todo

class TodoRepository {
    suspend fun getTodos(): List<Todo> {
        return RetrofitClient.api.getTodos();
    }
}