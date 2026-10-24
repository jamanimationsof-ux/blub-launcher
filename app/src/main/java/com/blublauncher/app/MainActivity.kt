package com.blublauncher.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val LauncherBlue = Color(0xFF17D9FF)
private val DeepNavy = Color(0xFF06142F)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(DeepNavy.toArgb()),
            navigationBarStyle = SystemBarStyle.dark(DeepNavy.toArgb()),
        )
        setContent {
            MaterialTheme(colorScheme = darkColorScheme(
                primary = LauncherBlue,
                background = DeepNavy,
                surface = DeepNavy,
                onPrimary = Color.White,
                onBackground = Color.White,
                onSurface = Color.White,
            )) {
                LauncherScreen()
            }
        }
    }
}

@Composable
private fun LauncherScreen() {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .background(DeepNavy),
    ) {
        val mascotHeight = minOf(maxWidth * 0.34f, maxHeight * 0.18f)
        val logoHeight = minOf(maxWidth * 0.40f, maxHeight * 0.19f)
        val playHeight = minOf(maxWidth * 0.25f, maxHeight * 0.14f)
        val tileHeight = minOf(maxWidth * 0.34f, maxHeight * 0.21f)

        Image(
            painter = painterResource(R.drawable.bg_tall),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize(),
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(DeepNavy.copy(alpha = 0.18f)),
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = maxHeight)
                .verticalScroll(rememberScrollState())
                .windowInsetsPadding(WindowInsets.safeDrawing)
                .padding(horizontal = 22.dp, vertical = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
        ) {
            Image(
                painter = painterResource(R.drawable.blub_front),
                contentDescription = "Маскот Blub",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .height(mascotHeight)
                    .aspectRatio(1f),
            )

            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = "Blub Launcher",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(logoHeight),
            )

            Text(
                text = "MINECRAFT JAVA\nНА ТЕЛЕФОНЕ",
                color = LauncherBlue,
                fontSize = 14.sp,
                lineHeight = 18.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 2.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(vertical = 4.dp),
            )

            Image(
                painter = painterResource(R.drawable.button_play),
                contentDescription = "Играть",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(playHeight)
                    .clip(RoundedCornerShape(22.dp))
                    .clickable { },
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
            ) {
                LauncherTile(
                    label = "Настройки",
                    iconRes = R.drawable.icon_settings,
                    modifier = Modifier.weight(1f).height(tileHeight),
                )
                LauncherTile(
                    label = "Версии",
                    iconRes = R.drawable.icon_versions,
                    modifier = Modifier.weight(1f).height(tileHeight),
                )
                LauncherTile(
                    label = "Аккаунт",
                    iconRes = null,
                    modifier = Modifier.weight(1f).height(tileHeight),
                )
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(top = 4.dp),
            ) {
                Image(
                    painter = painterResource(R.drawable.icon_blub),
                    contentDescription = null,
                    modifier = Modifier.size(34.dp),
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Сила в простоте",
                    color = LauncherBlue,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    letterSpacing = 1.sp,
                )
            }
        }
    }
}

@Composable
private fun LauncherTile(
    label: String,
    iconRes: Int?,
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier
            .clip(RoundedCornerShape(22.dp))
            .clickable { }
            .semantics { contentDescription = label },
        shape = RoundedCornerShape(22.dp),
        color = DeepNavy.copy(alpha = 0.68f),
        contentColor = Color.White,
        border = androidx.compose.foundation.BorderStroke(2.dp, Color(0xFF1679D3)),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 4.dp, vertical = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            if (iconRes != null) {
                Image(
                    painter = painterResource(iconRes),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.size(42.dp),
                )
            } else {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null,
                    tint = LauncherBlue,
                    modifier = Modifier.size(42.dp),
                )
            }
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = label,
                fontSize = 13.sp,
                lineHeight = 16.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Medium,
            )
        }
    }
}
