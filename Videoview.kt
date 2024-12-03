package com.example.videolayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.VideoData
import com.example.videolayout.ui.theme.VideoLayoutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VideoLayoutTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    VideoGrid()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun VideoGrid() {

    val sampleVideoData = listOf(
        VideoData(
            thumbnailUrl = "https://picsum.photos/seed/1/800/450",
            description = "Amazing nature video showcasing the beauty of the mountains.",
            duration = "3:45"
        ),
        VideoData(
            thumbnailUrl = "https://picsum.photos/seed/2/800/450",
            description = "City life in motion: a fast-paced journey through urban landscapes.",
            duration = "2:30"
        ),
        VideoData(
            thumbnailUrl = "https://picsum.photos/seed/3/800/450",
            description = "Explore the depths of the ocean with this stunning underwater footage.",
            duration = "5:20"
        ),
        VideoData(
            thumbnailUrl = "https://picsum.photos/seed/4/800/450",
            description = "A serene walk through the forest, capturing the essence of tranquility.",
            duration = "4:10"
        ),
        VideoData(
            thumbnailUrl = "https://picsum.photos/seed/5/800/450",
            description = "Experience the thrill of extreme sports with this adrenaline-pumping video.",
            duration = "6:05"
        )
    )

    FlowRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.spacedBy(3.dp)
    ) {
        sampleVideoData.forEach { videoData ->
            VideoItem(videoData = videoData)
        }
    }
}
@Composable
fun VideoItem(
    videoData: VideoData,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(8.dp)
            .width(160.dp) // Set a base width
    ) {
        Box {
            AsyncImage(
                model = videoData.thumbnailUrl,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(16f / 9f), // Common video aspect ratio
                contentScale = ContentScale.Crop
            )
            Text(
                text = videoData.duration,
                style = MaterialTheme.typography.bodySmall.copy(color = Color.White),
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .background(Color.Black.copy(alpha = 0.7f))
                    .padding(4.dp)
            )
        }
        Text(
            text = videoData.description,
            style = MaterialTheme.typography.bodySmall,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}
