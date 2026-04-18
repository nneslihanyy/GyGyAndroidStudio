package com.example.turkcellintro.di

import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest

object SupabaseClient {
    val supabaseClient = createSupabaseClient(
        supabaseUrl = "https://xuvjpfvpezkpggtfnajq.supabase.co",
        supabaseKey = "sb_publishable_7IRZGmkHY3ZkdJL5gZ3fqQ_XVYokZK0"
    ) {
        install(Postgrest)
    }
}