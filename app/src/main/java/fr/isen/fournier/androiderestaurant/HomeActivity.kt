@file:Suppress("UNUSED_EXPRESSION", "UNUSED_EXPRESSION")

package fr.isen.fournier.androiderestaurant

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
//import android.widget.Toast
import fr.isen.fournier.androiderestaurant.ui.theme.AndroidERestaurantTheme


class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            AndroidERestaurantTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
                    HomeScreen(::startCategoryActivity)
                }
            }
        }
    }

    // Fonction utilitaire pour afficher un Toast
    fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
    fun startCategoryActivity(category: String) {
        val intent = Intent(this,  CategorieActivity::class.java).apply {
            putExtra("category", category) // Passer la catégorie sélectionnée à l'activité suivante
        }
        startActivity(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        println("HomeActivity destroyed")
    }
}

@Composable
fun HomeScreen(onMenuClick: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Greeting("AndroidERestaurant")
        Spacer(modifier = Modifier.height(16.dp))
        CategoryButton("Entrée", Color(0xFF64B5F6)){
            onMenuClick("Entrée")
        }
        Spacer(modifier = Modifier.height(8.dp))
        CategoryButton("Plats", Color(0xFF64B5F6)) {
            // Action lorsque le bouton Plats est cliqué
            onMenuClick("Plats")
        }
        Spacer(modifier = Modifier.height(8.dp))
        CategoryButton("Dessert", Color(0xFF64B5F6)) {
            // Action lorsque le bouton Dessert est cliqué
            onMenuClick("Dessert")
        }
    }
}

@Composable
fun CategoryButton(category: String, color: Color, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        //colors = ButtonDefaults.buttonColors(backgroundColor = color),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .background(Color.White, shape = CircleShape)
            ) {
                // You can add an icon or text here if needed
            }
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = category,
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = name,
        modifier = modifier,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold
    )
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    AndroidERestaurantTheme {
        HomeScreen({})
    }
}