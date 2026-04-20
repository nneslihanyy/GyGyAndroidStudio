package com.example.turkcellintro.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.turkcellintro.data.TodoRepository
import com.example.turkcellintro.model.Todo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ToDoListViewModel : ViewModel() {
    private val repository = TodoRepository()

    private val _todos = MutableStateFlow<List<Todo>>(emptyList())
    val todos: StateFlow<List<Todo>> = _todos.asStateFlow();

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow();

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow();

    init {
        fetchTodos()
    }

    fun fetchTodos() {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null

            try {
                val result = repository.getTodos()
                _todos.value = result
            } catch (e: Exception) {
                _error.value = e.message ?: "Bir hata oluştu."
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun delete(id: Int) {
        viewModelScope.launch {
            try {
                repository.deleteTodo(id)
                fetchTodos()
            } catch (e: Exception) {
                println(e.message)
            }
        }
    }

    fun add(title: String, description: String? = null) {
        viewModelScope.launch {
            try {
                val id = (_todos.value.maxOfOrNull { it.id } ?: 0) + 1
                val newTodo = Todo(id = id, title = title, description = description)
                repository.addTodo(newTodo)
                fetchTodos()
            } catch (e: Exception) {
                println(e.message)
            }
        }
    }
}