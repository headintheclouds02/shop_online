import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.shoponline.repository.ProductRepository
import com.example.shoponline.ui.screens.detail.DetailScreen
import com.example.shoponline.ui.screens.home.HomeScreen
import com.example.shoponline.view_model.product.ProductViewModel
import com.example.shoponline.view_model.product.ProductViewModelFactory
import kotlinx.serialization.Serializable

@Serializable
object ProductListRoute

@Serializable
data class ProductDetailRoute(
    val productId: Int
)


@Composable
fun MainNavGraph(
    navController: NavHostController = rememberNavController()
) {
    val repository = ProductRepository()

    val productViewModel: ProductViewModel = viewModel(
        factory = ProductViewModelFactory(repository)
    )

    NavHost(
        navController = navController,
        startDestination = ProductListRoute
    ) {
        composable<ProductListRoute> {
            HomeScreen(
                viewModel = productViewModel,
                onProductClick = { productId ->
                    navController.navigate(
                        ProductDetailRoute(productId = productId)
                    )
                }
            )
        }

        composable<ProductDetailRoute> { backStackEntry ->
            val route = backStackEntry.toRoute<ProductDetailRoute>()

            DetailScreen(
                navController = navController,
                productId = route.productId,
                viewModel = productViewModel
            )
        }
    }
}