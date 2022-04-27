package id.shaderboi.instagramui.ui

sealed class NavigationGraph(val route: String) {
    object Home: NavigationGraph("home")
    object Search: NavigationGraph("search")
    object Reels: NavigationGraph("reels")
    object Market: NavigationGraph("market")
    object Profile: NavigationGraph("profile")
}