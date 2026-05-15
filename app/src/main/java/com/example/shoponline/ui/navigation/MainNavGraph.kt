import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.shoponline.ui.screens.detail.DetailScreen
import com.example.shoponline.ui.screens.home.HomeScreen

@Composable
fun MainNavGraph(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable(route = "home") {
            HomeScreen(navController = navController)
        }

        composable(route = "detail") {
            DetailScreen(product = product, navController = navController)
        }
    }
}