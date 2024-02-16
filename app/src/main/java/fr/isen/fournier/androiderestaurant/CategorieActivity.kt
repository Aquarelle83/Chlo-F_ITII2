package fr.isen.fournier.androiderestaurant

//import androidx.compose.ui.input.pointer.CancelTimeoutCancellationException.message
//import kotlinx.coroutines.NonCancellable.message
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import fr.isen.fournier.androiderestaurant.model.DataResult
import fr.isen.fournier.androiderestaurant.ui.theme.AndroidERestaurantTheme
//import goToDetailActivity
import org.json.JSONObject




class CategorieActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val category = intent.getStringExtra("category")
        fetchdata()


        setContent {
            AndroidERestaurantTheme {
                // A surface container using the 'background' color from the theme
                val skyBlueColor = colorResource(id = R.color.sky_blue)
                val skyBlueFoncéColor = colorResource(id = R.color.sky_blue_foncé)
                Surface(
                    modifier = Modifier.fillMaxSize().background(
                        Brush.verticalGradient(
                            colors = listOf(skyBlueColor, skyBlueFoncéColor),
                            startY = 0f,
                            endY = Float.POSITIVE_INFINITY
                        )
                    ),
                    color = Color.Transparent, // Couleur de fond transparente pour permettre au dégradé de se voir
                ) {
                    // Afficher la liste en fonction de la catégorie
                    //DishListComponent(getCategoryItems(categoryTitle), ::onDetailDishClick)
                    CategoryList(getCategoryItems(category.orEmpty())) { clickedItem ->
                        // Faire quelque chose lorsque l'utilisateur clique sur un élément
                        goToDetail(clickedItem)
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

    private fun fetchdata() {
        val url = "http://test.api.catering.bluecodegames.com/menu"
        val jsonObject = JSONObject()
        jsonObject.put("id_shop", "1")
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.POST,
            url,
            jsonObject,
            {

                Log.d("CategorieActivity", "les données en brut : $it")
                val result = Gson().fromJson(it.toString(), DataResult::class.java)
                result.data[0].items
            },
            {
                Log.e("CategorieActivity", "ERREUR : $it")
            })
        val requestQueue = Volley.newRequestQueue(this)
        requestQueue.add(jsonObjectRequest)
    }

    private fun goToDetail(category: String) {
        Toast.makeText(this, category, Toast.LENGTH_SHORT).show()
        val intent = Intent(this, goToDetailActivity::class.java).apply {
            putExtra("MenuTitle", category)
        }
        startActivity(intent)
    }
}


@Composable
fun CategoryList(items: List<String>, onItemClick: (String) -> Unit) {
    LazyColumn {
        items(items.size) { index ->
            Button(
                onClick = { onItemClick(items[index]) },
                modifier = Modifier.fillMaxWidth().padding(8.dp),
                shape = RoundedCornerShape(8.dp)

            ) {
                Text(text = items[index])
            }
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
    val items = listOf("Entrée", "Plats", "Dessert")
    AndroidERestaurantTheme {
        CategoryList(items = items, onItemClick = {})
    }
}

