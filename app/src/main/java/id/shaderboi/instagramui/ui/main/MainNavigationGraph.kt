package id.shaderboi.instagramui.ui.main

sealed class MainNavigationGraph(val route: String) {
    object Home: MainNavigationGraph("home")
    object Search: MainNavigationGraph("search")
    object Reels: MainNavigationGraph("reels")
    object Market: MainNavigationGraph("market")
    object MyProfile: MainNavigationGraph("profile")
}