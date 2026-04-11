package com.example.turkcellintro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.turkcellintro.ui.theme.TurkcellIntroTheme


// Portföy sayfası - kişisel tanıtım ekranı
class PortfolioActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            TurkcellIntroTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
                    PortfolioEkrani(Modifier.padding(paddingValues))
                }
            }
        }
    }
}


// Renk sabitleri - HTML tasarımdaki koyu temadan alındı
val ArkaPlan = Color(0xFF131313)
val KartRengi = Color(0xFF1C1B1B)
val AnaRenk = Color(0xFF00DAF3)  // turkuaz/cyan tonu
val YaziRengi = Color(0xFFE5E2E1)
val SolukYazi = Color(0xFF909097)
val KenarlikRengi = Color(0xFF45464D)


// Ana portföy ekranı composable fonksiyonu
@Composable
fun PortfolioEkrani(modifier: Modifier) {
    // ScrollState ile ekranın kaydırılabilir olmasını sağlıyoruz
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(ArkaPlan)
            .verticalScroll(scrollState)
            .padding(horizontal = 24.dp, vertical = 32.dp)
    ) {

        // === Header / Başlık Kısmı ===
        BaslikBolumu()

        Spacer(modifier = Modifier.height(40.dp))

        // === Yetenekler Kısmı ===
        YeteneklerBolumu()

        Spacer(modifier = Modifier.height(32.dp))

        // === Eğitim Kısmı ===
        EgitimBolumu()

        Spacer(modifier = Modifier.height(32.dp))

        // === İletişim ===
        IletisimBolumu()

        Spacer(modifier = Modifier.height(40.dp))

        // === Alt kısım (footer) ===
        AltBilgi()
    }
}

// İsim, meslek ve konum bilgileri
@Composable
fun BaslikBolumu() {
    Column {
        Text(
            text = "Deniz Yılmaz",
            color = Color.White,
            fontSize = 30.sp,
            fontWeight = FontWeight.ExtraBold
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "Junior Android Developer",
            color = AnaRenk,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Konum bilgisi
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "📍",
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = "Istanbul, TR",
                color = SolukYazi,
                fontSize = 13.sp
            )
        }
    }
}


// Yetenek etiketleri bölümü
@Composable
fun YeteneklerBolumu() {
    // Yetenek listesi - iki satıra bölerek gösteriyoruz
    val satirBir = listOf("Kotlin", "Java", "Android SDK")
    val satirIki = listOf("Git", "Firebase", "XML Layouts")

    Column {
        // Bölüm başlığı
        Text(
            text = "YETENEKLER",
            color = SolukYazi,
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = 3.sp
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Birinci satır etiketler
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            satirBir.forEach { yetenek ->
                YetenekEtiketi(yetenek)
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // İkinci satır etiketler
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            satirIki.forEach { yetenek ->
                YetenekEtiketi(yetenek)
            }
        }
    }
}


// Tek bir yetenek etiketi (chip) composable'ı
@Composable
fun YetenekEtiketi(text: String) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(6.dp))
            .background(KartRengi)
            .border(1.dp, KenarlikRengi.copy(alpha = 0.3f), RoundedCornerShape(6.dp))
            .padding(horizontal = 14.dp, vertical = 8.dp)
    ) {
        Text(
            text = text,
            color = YaziRengi,
            fontSize = 13.sp
        )
    }
}


// Eğitim bilgisi bölümü
@Composable
fun EgitimBolumu() {
    Column {
        Text(
            text = "EĞİTİM",
            color = SolukYazi,
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = 3.sp
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Sol kenarlık efekti için Row + dikey çizgi
        Row {
            // Dikey çizgi (sol kenarlık)
            Box(
                modifier = Modifier
                    .width(2.dp)
                    .height(70.dp)
                    .background(AnaRenk.copy(alpha = 0.3f))
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(
                    text = "Boğaziçi University",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "B.A. Visual Communication Design",
                    color = SolukYazi,
                    fontSize = 14.sp
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "2012 — 2016",
                    color = SolukYazi.copy(alpha = 0.6f),
                    fontSize = 12.sp
                )
            }
        }
    }
}


// İletişim bölümü
@Composable
fun IletisimBolumu() {
    Column {
        Text(
            text = "İLETİŞİM",
            color = SolukYazi,
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = 3.sp
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Android uygulamalar geliştirmeye odaklanıyorum. İş birliği için iletişime geçebilirsiniz.",
            color = SolukYazi,
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "✉ hello@example.com",
            color = AnaRenk,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
    }
}


// Alt bilgi / footer
@Composable
fun AltBilgi() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalDivider(
            color = KenarlikRengi.copy(alpha = 0.2f),
            thickness = 1.dp
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Son Teslim: 15 Nisan",
            color = AnaRenk,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "© 2024 Portfolio",
            color = SolukYazi.copy(alpha = 0.5f),
            fontSize = 11.sp
        )
    }
}
