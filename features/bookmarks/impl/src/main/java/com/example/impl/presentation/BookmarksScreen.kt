package com.example.impl.presentation

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NoOpNavigator
import com.example.impl.R

import com.example.impl.data.Message
import com.example.impl.data.SampleData



@Composable
fun Conversation(messages: List<Message>) {
    Column {
        Column(modifier = Modifier.padding(start = 20.dp,bottom = 30.dp, top = 30.dp),verticalArrangement = Arrangement.Bottom,) {
            Text(
                text = "Bookmarks",
                style = TextStyle(
                    fontSize = 24.sp,
                    color = Color(0xFF333647),
                    fontWeight = FontWeight.Bold
                )
            )
            Text(
                text = "Saved articles to the library",
                //modifier = Modifier.padding(all = 4.dp),
                style = TextStyle(
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    color = Color(0xFF7C82A1)
                )
            )


        }
        //Spacer(modifier = Modifier.height(20.dp))
        LazyColumn {
            items(messages) { message ->
                MessageCard(message)
            }
        }
    }
}
@Composable
fun NoOpigator() {
   // Column {
        Column(modifier = Modifier.padding(start = 20.dp,bottom = 30.dp, top = 30.dp),verticalArrangement = Arrangement.Top,) {
            Text(
                text = "Bookmarks",
                style = TextStyle(
                    fontSize = 24.sp,
                    color = Color(0xFF333647),
                    fontWeight = FontWeight.Bold
                )
            )
            Text(
                text = "Saved articles to the library",
                //modifier = Modifier.padding(all = 4.dp),
                style = TextStyle(
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    color = Color(0xFF7C82A1)
                )
            )


        }
        Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = R.drawable.book),
                contentDescription = null,
                modifier = Modifier.size(100.dp),
            )
            Text(text = "You haven't saved any articles yet. Start reading and bookmarking them now",style = TextStyle(
                    fontSize = 16.sp,
            color = Color(0xFF333647),textAlign = TextAlign.Center,
            fontWeight = FontWeight.Medium),
                modifier = Modifier.padding(start = 100.dp, end = 100.dp)
            )
       // }
    }
}
@Preview
@Composable
fun PreviewConversation() {
    NoOpigator()
        //Conversation(SampleData.conversationSample)
}

@Composable
fun MessageCard(msg: Message) {
    Row(modifier = Modifier.padding(start = 20.dp, end = 20.dp, bottom =20.dp)) {
        msg.img?.let { painterResource(id = it) }?.let {
            Image(
                painter = it,
                contentDescription = null,
                modifier = Modifier
                    .size(96.dp)
                    //.clip(CircleShape)
                    //.border(1.5.dp, MaterialTheme.colorScheme.secondary, CircleShape)
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        Column() {
            msg.author?.let {
                Text(
                    text = it,
                    style = TextStyle( fontSize=14.sp,
                        color = Color(0xFF7C82A1),),
                    )
            }
            Spacer(modifier = Modifier.height(10.dp))
            msg.body?.let {
                Text(
                    text = it,
                    //modifier = Modifier.padding(all = 4.dp),
                    style = TextStyle( fontSize=16.sp,
                        color = Color(0xFF333647),fontWeight = FontWeight.Bold)
                )
            }
        }
    }
}

//fun BookmarksScreen() {
//
//}