package com.example.week9.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.week9.ui.view.mahasiswa.DestinationInsert
import com.example.week9.ui.view.mahasiswa.InsertMhsView


@Composable
fun PengelolaHalaman(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    NavHost(navController = navController, startDestination = DestinationInsert.route) {
        composable(
            route = DestinationInsert.route
        ) {
            InsertMhsView(onBack = { }, onNavigate = { })
        }
    }
}