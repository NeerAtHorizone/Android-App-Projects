package com.example.bookreader

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.bookreader.data.BookList
import com.example.bookreader.data.Dimensions
import com.example.bookreader.data.Screen
import com.example.bookreader.ui.theme.BookReaderTheme
import com.example.bookreader.ui.theme.Typography

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BookReaderTheme {
                Surface{
                    MainNavigation()
                }
            }
        }
    }
}

//-----------navigation's-------------

@Composable
fun MainNavigation(){
    val navController = rememberNavController()
    NavHost(navController, startDestination = Screen.OnLaunch.route) {
        composable(Screen.Home.route) {
            BookReaderApp()
        }
        composable(Screen.OnLaunch.route) {
            Start(navController)
        }

    }
}

//--------preview--------------

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BookReaderTheme {
        MainNavigation()
    }
}

/*
-------------- 28 days of books reading-------------------------
*/

//-------- on launch---------

@Composable
fun Start(navController: NavHostController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.secondaryContainer),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .width(200.dp)
                .height(200.dp)
                .border(width = 4.dp, shape = RoundedCornerShape(100.dp), color = MaterialTheme.colorScheme.onSecondaryContainer)
                .clip(RoundedCornerShape(100.dp)),
            painter = painterResource(R.drawable.abcicon),
            contentDescription = null
        )
        Button(
            modifier = Modifier
                .padding(Dimensions.paddingSmall)
                .border(width = 2.dp, color = MaterialTheme.colorScheme.onSecondaryContainer, shape = RoundedCornerShape(24.dp)),
            colors = ButtonColors(contentColor = MaterialTheme.colorScheme.onSecondaryContainer, containerColor = MaterialTheme.colorScheme.secondaryContainer, disabledContainerColor = MaterialTheme.colorScheme.tertiaryContainer, disabledContentColor = MaterialTheme.colorScheme.onTertiaryContainer),
            onClick = {navController.navigate(Screen.Home.route)},
        ) {
            Text(
                text = "Let's read!  📖",
                style = Typography.labelMedium
            )
        }
    }
}

//------ReaderAppBar ()---------
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookReaderTopBar(modifier: Modifier){
    CenterAlignedTopAppBar(

            title = {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "28 Days of Book Reading",
                        style = Typography.displayMedium,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
            },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    )
}

//----------------BookReader App---------------
@Composable
fun BookReaderApp(){
    Scaffold(
        topBar = { BookReaderTopBar(modifier = Modifier
            .background(MaterialTheme.colorScheme.primaryContainer),)}
    ) {
            innerPadding ->
        BookReaderScreen(modifier = Modifier.padding(innerPadding))
    }
}

//----------------Book Reader Screen ----------

@Composable
fun BookReaderScreen(modifier: Modifier){
    LazyColumn(
        modifier = modifier
            .padding(Dimensions.paddingSmall)
            .clip(RoundedCornerShape(4.dp))
            .background(MaterialTheme.colorScheme.secondaryContainer)
    ) {
        items(4) {

            index ->
            Column (
                modifier = Modifier
                    .padding(Dimensions.paddingSmall)
                    .clip(RoundedCornerShape(8.dp))
                    .background(MaterialTheme.colorScheme.surfaceBright)
            ){
                Text(
                    text = "Week ${index + 1}",
                    color = MaterialTheme.colorScheme.onSurface,
                    style = Typography.labelMedium,
                    modifier  = Modifier.padding(Dimensions.paddingSmall)
                )
                WeekCard(index)
            }

        }
    }

}


//------Week Card ---- 4 such card vertically arranged , 2 card will be visible at on screen, scrollable vertically

@Composable
fun WeekCard(index: Int) {
    //    text = levelMedium
    val from = (index) * 7
    val to = (index + 1) * 7
    val bookList = BookList


    LazyRow {
        items (to - from) {

            item ->
            if ( from + item < bookList.size ){
                Column {
                    Text(
                        modifier = Modifier
                            .padding( horizontal =  Dimensions.paddingSmall),
                        text = "Day ${from + item + 1}",
                        style = Typography.bodyMedium
                    )
                    DayCard(
                        name = stringResource(bookList[from + item].bookName) ,
                        about = stringResource(bookList[from + item].aboutBook),
                        image = bookList[from + item].imgRes,
                        summary = stringResource( bookList[from + item].bookSummary)
                    )
//                    SummaryCard(name = bookList[from + item].bookName, summary = bookList[from + item].bookSummary )
                }
            }


        }
    }
}

//------Day Card ----- 7 such card horizontally arranged in each WeekCard , 2.5 card will be visible at on screen, scrollable horizontally
/*
    clickable - when clicked - the summary of the book will appear
    Todo - animation transition when clicked
 */

@Composable
fun DayCard(
    name : String,
    image : Int,
    about : String,
    summary: String
){
//  text = bodyMedium

    var visible by remember { mutableStateOf(true) }


    val handleClick = {visible = !visible}

        Column(
            modifier = Modifier
                .padding(horizontal = Dimensions.paddingSmall)
                .width(Dimensions.cardWidth)
                .height(Dimensions.cardHeight)
                .clickable(onClick = { handleClick() })
        ) {
            AnimatedVisibility(
                    visible = visible,
                    enter = slideInVertically(initialOffsetY = { -40 }) + fadeIn(initialAlpha = 0.3f),
                exit = slideOutVertically(targetOffsetY = { -80}) +  fadeOut(targetAlpha = 0f)
            ) {
                Column {
                    Text(
                        modifier = Modifier
                            .height(Dimensions.textBoxheight)
                            .padding(
                                horizontal = Dimensions.lableHorizontalPadding,
                                vertical = Dimensions.lableVerticalPadding
                            ),
                        text = name,
                        style = Typography.bodyMedium
                    )
                    ImageBox(image)
                    Text(
                        text = about,
                        style = Typography.bodySmall,
                        modifier = Modifier
                            .padding(horizontal = Dimensions.lableHorizontalPadding, vertical = Dimensions.lableVerticalPadding)
                    )
                }
                }
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(20.dp))
            AnimatedVisibility(
                visible = !visible,

                enter = slideInVertically( initialOffsetY = { 40 } )+ fadeIn(initialAlpha = 0f),
                exit = slideOutVertically( targetOffsetY = {100}) + fadeOut(targetAlpha = 0f)
            ) {
                SummaryCard(name = name, summary = summary)

            }

        }
}



//------- Summary card-----------

@Composable
fun SummaryCard(name: String, summary : String ){
    Column (
        modifier = Modifier
            .padding(horizontal = Dimensions.paddingSmall)
            .width(250.dp)
            .height(Dimensions.cardHeight)
    ){
        Text(
            modifier = Modifier
                .padding(horizontal = Dimensions.lableHorizontalPadding, vertical = Dimensions.lableVerticalPadding),
            text = name,
            style = Typography.bodyMedium
        )
        Text(
            text = summary,
            style = Typography.bodySmall,
            modifier = Modifier
                .padding(horizontal = Dimensions.lableHorizontalPadding, vertical = Dimensions.lableVerticalPadding)
        )

    }
}




//----ImageBox ----- 1 image box in each DayCard

@Composable
fun ImageBox( @DrawableRes image : Int){

        Image(
            modifier = Modifier
                .size(250.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop,
            painter = painterResource(image),
            contentDescription = null
        )
}

