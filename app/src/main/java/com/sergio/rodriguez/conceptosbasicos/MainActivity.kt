package com.sergio.rodriguez.conceptosbasicos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sergio.rodriguez.conceptosbasicos.ui.theme.ConceptosBasicosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConceptosBasicosTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeArticleApp()
                }
            }
        }
    }
}


@Composable
fun ComposeArticleApp() { //ESTO SERIA LA PAMTALLA
    ArticleCard(
        title = stringResource(id = R.string.title_jetpack_compose_tutorial),
        shortDescription = stringResource(id = R.string.compose_short_desc),
        longDescription = stringResource(id = R.string.compose_long_desc),
        painterResource(id = R.drawable.bg_compose_background),
        modifier = Modifier.background(Color.Gray)
    )
}

@Composable
fun ArticleCard( //ESTO ES EL CONTENIDO PARA LA PANTALLA
    title: String,
    shortDescription: String,
    longDescription: String,
    imagePainter: Painter,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
    ) {
        Image(
            painter = imagePainter,
            contentDescription = null
        )
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center
        )
        Text(
            text = shortDescription,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
        )
        Text(
            text = longDescription,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Justify
        )
    }
}


@Preview(showSystemUi = true)
@Composable
fun ComposeArticleAppPreview() {
    ConceptosBasicosTheme{
        ComposeArticleApp()
    }
}