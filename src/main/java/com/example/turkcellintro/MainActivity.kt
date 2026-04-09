package com.example.turkcellintro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.turkcellintro.ui.theme.TurkcellIntroTheme

// class MainActivity : ComponentActivity() --->> Component Activityi kalıtım alıyoruz
// Kendi oluşturduğum MainActivity classına component olma özelliğini ekledik.
//MainActivity SubClass ComponentActivity superClass


class MainActivity : ComponentActivity() {

    //override kalıtım aldığım classtaki bir metodu dğeiştirmek ya da geliştirmek için kullanılan yöntemdir

    override fun onCreate(savedInstanceState: Bundle?) {

        //super ==> kalıtım aldığım class
        //Bu method normalde çalıştığı gibi çalışmaya devam etsin
        super.onCreate(savedInstanceState)

        // kendi istediğim ( bu sayfaya özel ) kodlar çalışsın
        setContent {

            }
        }
    }
