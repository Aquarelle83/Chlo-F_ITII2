package fr.isen.fournier.androiderestaurant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.isen.fournier.androiderestaurant.ui.theme.AndroidERestaurantTheme

//import org.json.JSONObject

class goToDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //val DetailDishTitle = intent.getStringExtra("dishTitle") ?: ""  // ex: tartare de saumon
        val DetailMenuTitle = intent.getStringExtra("MenuTitle")
        //val title = intent.getStringExtra("title")

        setContent {
            AndroidERestaurantTheme {
                // A surface container using the 'background' color from the theme
                val skyBlueColor = colorResource(id = R.color.sky_blue)
                val skyBlueFoncéColor = colorResource(id = R.color.sky_blue_foncé)
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(skyBlueColor, skyBlueFoncéColor),
                                startY = 0f,
                                endY = Float.POSITIVE_INFINITY
                            )
                        ),
                    color = Color.Transparent, // Couleur de fond transparente pour permettre au dégradé de se voir
                ) {
                    // Afficher la liste en fonction de la catégorie
                    DetailList(getDetailItems(DetailMenuTitle.orEmpty()))
                }

            }
        }
    }

    fun getDetailItems(category: String): List<String> {
        //Log.d("Category", category)
        return when (category) {
            "Tartare saumon mariné et avocat" -> resources.getStringArray(R.array.TartareSaumonDétails).toList()
            "Salade de chevre chaud" -> resources.getStringArray(R.array.SaladeChevreDétails).toList()
            "Salade Tomate Mozarella et sauce Balsamique" -> resources.getStringArray(R.array.TomateMozzaDétails).toList()

            "Lasagne" -> resources.getStringArray(R.array.LasagneDétails).toList()
            "Blanquette de veau avec riz" -> resources.getStringArray(R.array.BlanquetteDétails).toList()
            "Pate Carbonara" -> resources.getStringArray(R.array.PateCarbonaraeDétails).toList()

            "Moelleux au chocolat" -> resources.getStringArray(R.array.MoelleuxChocolatDetails).toList()
            "Tarte au citron meringuée" -> resources.getStringArray(R.array.TarteCitronMeringueDetails).toList()
            "Salade de fruits de saison" -> resources.getStringArray(R.array.SaladeFruitDetails).toList()

            else -> emptyList()
        }
    }

    @Composable
    fun DetailList(items: List<String>) {
        LazyColumn (
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ){
            items(items.size) { index ->
                DetailItem(index = items[index])
            }
        }
    }

    @Composable
    fun DetailItem(index: String) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (index.contains("Tartare saumon mariné et avocat")) {
                // Afficher l'image uniquement pour "Tartare saumon mariné et avocat"
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.tartare_saumon_avocat),
                        contentDescription = "Tartare saumon mariné et avocat",
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
            if(index.contains(("Salade de chevre chaud"))) {
                // Afficher l'image uniquement pour "Salade de chevre chaud"
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.chevre_chaud_au_miel),
                        contentDescription ="Salade de chevre chaud",
                        modifier = Modifier.fillMaxSize()
                    )

                }
            }
            if(index.contains(("Salade Tomate Mozarella et sauce Balsamique"))) {
                // Afficher l'image uniquement pour "Salade Tomate Mozarella et sauce Balsamique"
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.tomate_mozza),
                        contentDescription = "Salade Tomate Mozarella et sauce Balsamique",
                        modifier = Modifier.fillMaxSize()
                    )

                }
            }
            if(index.contains(("Lasagne"))) {
                // Afficher l'image uniquement pour "Lasagne"
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.lasagne),
                        contentDescription = "Lasagne",
                        modifier = Modifier.fillMaxSize()
                    )

                }
            }
            if(index.contains(("Blanquette de veau avec riz"))) {
                // Afficher l'image uniquement pour "Blanquette de veau avec riz"
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.blanquette_de_veau),
                        contentDescription = "Blanquette de veau avec riz",
                        modifier = Modifier.fillMaxSize()
                    )

                }
            }
            if(index.contains(("Pate Carbonara"))) {
                // Afficher l'image uniquement pour "Salade de chevre chaud"
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.pate_carbo),
                        contentDescription = "Pate Carbonara",
                        modifier = Modifier.fillMaxSize()
                    )

                }
            }

            if(index.contains(("Moelleux au chocolat"))) {
                // Afficher l'image uniquement pour "Moelleux au chocolat"
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.moelleux_chocolat),
                        contentDescription = "Moelleux au chocolat",
                        modifier = Modifier.fillMaxSize()
                    )

                }
            }
            if(index.contains(("Tarte au citron meringuée"))) {
                // Afficher l'image uniquement pour "Tarte au citron meringuée"
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.tarte_citron_meringu_e),
                        contentDescription = "Tarte au citron meringuée",
                        modifier = Modifier.fillMaxSize()
                    )

                }
            }
            if(index.contains(("Salade de fruits de saison"))) {
                // Afficher l'image uniquement pour "Salade de fruits de saison"
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.salade_de_fruit),
                        contentDescription = "Salade de fruits de saison",
                        modifier = Modifier.fillMaxSize()
                    )

                }
            }

            // Texte des détails du menu
            Surface(
                modifier = Modifier.padding(8.dp)
            ) {
                Text(
                    text = index,
                    color = Color.Black, // White text color
                    textAlign = TextAlign.Center, // Alignement du texte au centre horizontalement
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
    @Preview(showBackground = true)
    @Composable
    fun DetailListPreview() {
        val items = listOf(
            "Tartare saumon mariné et avocat",
        )
        AndroidERestaurantTheme {
            DetailList(items = items)
        }
    }
}




