package com.example.zuperheros

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.zuperheros.Data.myHero
import com.example.zuperheros.Data.myHerosList
import com.example.zuperheros.ui.theme.ZuperTheme
import kotlinx.coroutines.handleCoroutineException
import kotlin.math.round
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CardElevation
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextFieldDefaults.contentPadding
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ZuperTheme {
                Surface ( modifier = Modifier.fillMaxSize()){
                    ZuperApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(){
    CenterAlignedTopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.displayLarge
                )
            }
        },
        modifier = Modifier
    )
}

@Composable
fun ZuperApp(){
    Scaffold(
        topBar = {AppBar()}
    ) {
        innerPadding ->
        LazyColumn (
            contentPadding = innerPadding
        ){
            items (myHerosList){
                item ->
                HeroCard(
                    name = stringResource(item.nameRes),
                    description = stringResource(item.descriptionRes),
                    imgRes = item.imageRes,
                    modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small))
                )
            }
        }

    }
}


@Composable
fun HeroCard( name : String, description : String, imgRes : Int, modifier: Modifier){
    Card (
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(R.dimen.padding_small))
    ){
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()
                .padding(dimensionResource(R.dimen.padding_medium))
        ){
            Column (
                modifier = Modifier
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = name,
                    style = MaterialTheme.typography.displaySmall
                )
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Column {
                HeroIcon(imgRes,modifier)
            }
        }
    }
}

@Composable
fun HeroIcon(
    @DrawableRes heroRes: Int,
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier
            .size(dimensionResource(R.dimen.card_height))
            .clip(RoundedCornerShape(dimensionResource(R.dimen.padding_small))),
        contentScale = ContentScale.FillHeight,
        painter = painterResource(heroRes),
        contentDescription = null
    )
}

@Composable
@Preview(showBackground = true)
fun HeroScreenpreview(){
    ZuperTheme {
        ZuperApp()
    }
}

