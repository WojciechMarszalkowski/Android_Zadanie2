package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.ProductListAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProductListAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ProductListScreen()
                }
            }
        }
    }
}

@Composable
fun ProductListScreen() {
    val products = listOf(
        Product("Telefon", "Ma 128 GB"),
        Product("Laptop", "Wysokiej jakości laptop gamingowy"),
        Product("Tablet", "Dobrej jakości ekran"),
        Product("Smartwatch", "Mierzy tętno, kroki i inne podstawowe rzeczy"),
        Product("Słuchawki", "Wygłuszają dźwięki zewnętrzne"),
        Product("Głośnik JBL", "Bardzo dobra jakość dźwięku"),
        Product("Myszka", "Bardzo cicha"),
        Product("Monitor", "Regulowany, bardzo dobra jakość obrazu"),
        Product("Klawiatura", "Podświetlana, cicha"),
        Product("Pendrive", "Kompaktowy, pojemny")
    )

    LazyColumn(
        modifier = Modifier.padding(16.dp)
    ) {
        items(products) { product ->
            ProductItem(product = product)
        }
    }
}

data class Product(val name: String, val description: String)

@Composable
fun ProductItem(product: Product) {
    Text(text = product.name, style = MaterialTheme.typography.titleMedium)
    Text(text = product.description, style = MaterialTheme.typography.bodyMedium, modifier = Modifier.padding(bottom = 16.dp))
}
