package com.example.turkcellintro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.turkcellintro.ui.theme.TurkcellIntroTheme


// class MainActivity : ComponentActivity() -> ComponentActivity'i kalıtım alıyoruz.
// MainActivity: SubClass, ComponentActivity: SuperClass
class MainActivity : ComponentActivity() {

    // override: Kalıtım alınan classtaki bir metodu özelleştirmek için kullanılır.
    override fun onCreate(savedInstanceState: Bundle?) {
        // super: Kalıtım alınan üst class'ın orijinal metodunu da çalıştırır.
        super.onCreate(savedInstanceState)

        enableEdgeToEdge() // Status Bar uyumluluğunu sağlar.

        setContent {
            TurkcellIntroTheme {
                // Scaffold: UI bileşenleri için temel yapı (alt-üst bar vb.) sağlar.
                // UI (composable) beklediği için süslü parantez (lambda) kullanılır.
                Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
                    MyAppStart(Modifier.padding(paddingValues))
                }
            }
        }
    }
}

// UI tanımlayan fonksiyonların @Composable olması zorunludur.
@Composable
fun MyAppStart(modifier: Modifier) {
    ///normal tanımlama ==> ekranda değişikliği göremeyiz
    //val count: Int = 0

    Column(modifier = modifier) {
        //Sayac()
        Test()
    }
}
//recomposition jetpack composeda ekranın ilgili kısmının tekrar çalıştırılmasına denir
// remember: Veriyi hafızada tutmaya yarar.
// Compose, ekranda bir değişiklik olduğunda (Recomposition) fonksiyonu baştan aşağı tekrar çalıştırır.
// Eğer remember kullanmazsak, count değişkeni her seferinde sıfırlanır.
// remember sayesinde değişkenin son değeri korunur ve ekrana yansıtılır.


@Composable
fun Sayac() {
    var count = remember { mutableStateOf(0) }

    Text("Merhaba", color = Color.Black)

    Text("Sayı ${count.value}")

    Button(onClick = { count.value++ }) {
        Text("Tıkla")
    }

}

@Composable
fun Test() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
                .background(Color.Blue),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Text("MERHABA")

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Yellow),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Text("Merhaba4")
                Text("Merhaba5")
            }
            Text("Merhaba 2 ")
            Text("Merhaba 3")
        }
    }
}
