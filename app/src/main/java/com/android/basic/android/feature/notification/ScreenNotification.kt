package com.android.basic.android.feature.notification

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.annotation.RequiresPermission
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import com.android.basic.android.R
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale

lateinit var contentTitle: String

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@OptIn(ExperimentalMaterial3Api::class, ExperimentalPermissionsApi::class)
@Composable
fun ScreenNotificationPermisson(
    onBack: () -> Unit
){

    val context = LocalContext.current

//    val permissionState = rememberPermissionState(
//        permission = Manifest.permission.POST_NOTIFICATIONS
//    )

//    // version 1
//
//    LaunchedEffect(Unit) {
//        if (permissionState.status.isGranted){
//            println("Permission granted")
//        }else{
//            permissionState.launchPermissionRequest()
//        }
//    }
//
//    //version 2
//    LaunchedEffect(permissionState) {
//        when{
//            permissionState.status.isGranted -> {
//                println("Permission granted")
//            }
//            permissionState.status.shouldShowRationale -> {
//                println("Permission denied")
//            }
//            else -> {
//                permissionState.launchPermissionRequest()
//            }
//        }
//    }

    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
    ) { isGranted ->
        if (isGranted){
            Toast.makeText(context, "Permission granted", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(context, "Permission denied", Toast.LENGTH_SHORT).show()
        }
    }

    LaunchedEffect(Unit){
        createNotificationChannel(context)
        // check if permission is already granted then it returns Launch Effect without calling to OS
        val isGranted = ContextCompat.checkSelfPermission(context,   Manifest.permission.POST_NOTIFICATIONS) == PackageManager.PERMISSION_GRANTED
        if(isGranted){
            Toast.makeText(context, "Permission granted", Toast.LENGTH_SHORT).show()
            return@LaunchedEffect
        }
        // asking for permission from OS through Manifest
        permissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)

    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Notification Permission")
                },
                navigationIcon = {
                    IconButton(
                        onClick = onBack
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.baseline_arrow_back_ios_new_24),
                            contentDescription = null,
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        },
        bottomBar = {
            BottomAppBar(

            ) {
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp),
                    onClick = {
                        sendNotification(
                            context,
                            title = "Title",
                            message = "Message"
                        )
                    }
                ) {
                    Text(text = "show notification")
                }
            }
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
        ) { }
    }


}

private fun createNotificationChannel(context: Context) {
    val channel = NotificationChannel(
        "default_channel",
        "General Notifications",
        NotificationManager.IMPORTANCE_HIGH
    )

    val manager = context.getSystemService(NotificationManager::class.java)
    manager.createNotificationChannel(channel)
}


@RequiresPermission(Manifest.permission.POST_NOTIFICATIONS)
fun sendNotification(
    context: Context,
    title: String,
    message: String,
) {
    val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    val builder = NotificationCompat.Builder(context, "default_channel")
        .setSmallIcon(R.drawable.ic_notification_24) // your icon
        .setContentTitle(title)
        .setContentText(message)
        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        .build()

    notificationManager.notify(System.currentTimeMillis().toInt(), builder)

}

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Preview(showBackground = false)
@Composable
fun ScreenNotificationPermissonPreview(){
    ScreenNotificationPermisson(
        onBack = {}
    )
}