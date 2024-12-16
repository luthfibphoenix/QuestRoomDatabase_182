package com.example.week9.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.week9.ui.view.mahasiswa.DestinationInsert
import com.example.week9.ui.view.mahasiswa.DetailMhsView
import com.example.week9.ui.view.mahasiswa.HomeMhsView
import com.example.week9.ui.view.mahasiswa.InsertMhsView
import com.example.week9.ui.view.mahasiswa.ItemDetailMhs
import com.example.week9.ui.view.mahasiswa.UpdateMhsView


@Composable
fun PengelolaHalaman(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    NavHost(navController = navController, startDestination = DestinationInsert.route) {
        composable(
            route = DestinationInsert.route
        ){
            HomeMhsView(
                onDetailClick = { nim ->
                    navController.navigate("${DestinationDetail.route}/$nim")
                    println(
                        "PengelolaHalaman: $nim"
                    )
                },
                onAddMhs = {
                    navController.navigate(DestinationInsert.route)
                },
                modifier = modifier
            )
        }

        composable(
            route = DestinationInsert.route
        ) {
            InsertMhsView(onBack = {
                navController.popBackStack()
            }, onNavigate = {
                navController.popBackStack()
            },
                modifier = modifier,
            )
        }

        composable(
            DestinationDetail.routeWithArgs,
            arguments = listOf(
                navArgument(DestinationDetail.NIM) {
                    type = NavType.StringType
                }
            )
        ){
            val nim = it.arguments?.getString(DestinationDetail.NIM)

            nim?.let {  nim->
                DetailMhsView(
                    onBack = {
                        navController.popBackStack()
                    },
                    onEditClick = {
                        navController.navigate("${DestinationUpdate.route}/$it")
                    },
                    modifier = modifier,
                    onDeleteClick = {
                        navController.popBackStack()
                    }
                )
            }
        }
        composable(
            DestinationUpdate.routeWithArgs,
            arguments = listOf(
                navArgument(DestinationUpdate.NIM) {
                    type = NavType.StringType
                }
            )
        )
        {
            UpdateMhsView(
                onBack = {
                    navController.popBackStack()
                },
                onNavigate = {
                    navController.popBackStack()
                },
                modifier = modifier
            )
        }
    }
}