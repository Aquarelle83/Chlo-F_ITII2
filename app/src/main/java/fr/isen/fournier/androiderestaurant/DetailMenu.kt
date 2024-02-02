import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.isen.fournier.androiderestaurant.ui.theme.AndroidERestaurantTheme

class PlateDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val category = intent.getStringExtra("category")

        setContent {
            AndroidERestaurantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Afficher les détails du plat
                    PlateDetail(category.orEmpty())
                }
            }
        }
    }
}
fun getCategoryItems(category: String): List<String> {
    //Log.d("Category", category)
    return when (category.lowercase()) {
        "entrée" -> resources.getStringArray(R.array.entrees).toList()
        "plats" -> resources.getStringArray(R.array.plats).toList()
        "dessert" -> resources.getStringArray(R.array.desserts).toList()
        else -> emptyList()
    }
}
}

@Composable
fun CategoryList(items: List<String>) {
    LazyColumn {
        items(items.size) { index ->
            ListItem(text = items[index])
        }
    }
}

@Composable
fun ListItem(text: String) {
    Text(text = text, modifier = Modifier.padding(16.dp))

}

@Preview(showBackground = true)
@Composable
fun CategoryListPreview() {
    AndroidERestaurantTheme {
        CategoryList(arrayListOf("fghjkl","hjk","wsxdcfg"))
    }
}