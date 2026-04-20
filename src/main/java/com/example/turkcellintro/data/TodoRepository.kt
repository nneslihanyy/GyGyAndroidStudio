package com.example.turkcellintro.data

import com.example.turkcellintro.di.SupabaseClient
import com.example.turkcellintro.model.Todo
import io.github.jan.supabase.postgrest.postgrest

class TodoRepository {
    private val db = SupabaseClient.supabaseClient.postgrest
    suspend fun getTodos(): List<Todo> {
        return db.from("todos").select().decodeList()
    }

    suspend fun addTodo(todo: Todo) {
        db.from("todos").insert(todo)
    }

    suspend fun deleteTodo(id: Int) {
        db.from("todos").delete {
            filter { eq("id", id) }
        }
    }
}