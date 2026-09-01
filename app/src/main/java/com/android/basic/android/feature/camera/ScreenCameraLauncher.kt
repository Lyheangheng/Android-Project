package com.android.basic.android.feature.camera

import android.content.Context
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberBottomAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.FileProvider
import coil3.compose.AsyncImage
import com.android.basic.android.R
import java.io.File

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenCameraLauncher(
    onBack: () -> Unit
) {

    var capturedUri by remember { mutableStateOf<Uri?>(null) }
    val context = LocalContext.current
    var tempUri by remember { mutableStateOf<Uri?>(null) }
    val bottomBarScrollBehavior = BottomAppBarDefaults.exitAlwaysScrollBehavior(
        rememberBottomAppBarState()
    )

    fun createImageUri(context: Context): Uri {
        val file = File(context.cacheDir, "photo_${System.currentTimeMillis()}.jpg")
        return FileProvider.getUriForFile(
            context,
            "${context.packageName}.fileprovider",
            file
        )
    }

    val cameraLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicture()
    ) { isSuccess ->
        if (isSuccess) {
            capturedUri = tempUri
        } else {
            tempUri = null
        }
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("Camera Launcher")
                },
                navigationIcon = {
                    IconButton(
                        onClick = onBack
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.baseline_arrow_back_ios_new_24),
                            null
                        )
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                scrollBehavior = bottomBarScrollBehavior,
            ) {
                IconButton(
                    onClick = {}
                ) {
                    Icon(
                        painter = painterResource(R.drawable.baseline_home_24),
                        null
                    )
                }
            }
        }

    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            capturedUri?.let { uri ->
                AsyncImage(
                    model = uri,
                    contentDescription = "TAKEN IMAGE",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                )
            }
            Spacer(Modifier.weight(1f))
            TextButton(
                onClick = {
                    try {
                        val uri = createImageUri(context)
                        tempUri = uri
                        cameraLauncher.launch(uri)
                    } catch (
                        e: Exception
                    ) {
                        e.printStackTrace()
                    }
                }
            ) {
                Text("Open Camera")
            }
        }
    }
}


@Composable
@Preview(showBackground = false)
fun ScreenCameraLauncherPreview() {
    ScreenCameraLauncher(
        {}
    )
}