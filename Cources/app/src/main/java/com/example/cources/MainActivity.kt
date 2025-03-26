package com.example.cources

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cources.model.DataSource
import com.example.cources.model.Topic
import com.example.cources.ui.theme.CourcesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CourcesTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .statusBarsPadding(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CoursesAppTheme( modifier = Modifier.padding(top = 100.dp))
                }
            }
        }
    }
}

@Composable
fun Capsule(topic: Topic, modifier: Modifier = Modifier){

        Card {
            Row {
                Box{
                    Image(
                        painter = painterResource(id = topic.img),
                        contentDescription = null,
                        modifier = Modifier
                            .size(width = 68.dp, height = 68.dp)
                            .aspectRatio(1f),
                        contentScale = ContentScale.Crop
                    )
                }
                Column {
                    Text(
                        text = stringResource(id = topic.topic),
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(
                            start = dimensionResource(id = R.dimen.small),
                            top = dimensionResource(id = R.dimen.small),
                            end = dimensionResource(id = R.dimen.small)
                        )
                    )
                    Row ( verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_grain),
                            contentDescription = null
                        )
                        Text(
                            text = topic.count.toString(),
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.padding(start = dimensionResource(id = R.dimen.small))
                        )
                    }
                }
            }
        }
}


@Composable
fun CoursesAppTheme(modifier: Modifier = Modifier){
    val courseList = DataSource.topics
    LazyVerticalGrid(
        columns = GridCells.Fixed(1),
        modifier = Modifier.padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.small)),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.small))
    ) {
        items(courseList.size){
            index -> Capsule(topic = courseList[index])
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CourseAppThemePreview(){
    CoursesAppTheme()
}