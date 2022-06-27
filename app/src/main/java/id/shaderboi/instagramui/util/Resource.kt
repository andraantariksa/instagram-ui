package id.shaderboi.instagramui.util

sealed class Resource<T> {
    class Loading<T> : Resource<T>()
    class Loaded<T>(val data: T) : Resource<T>()
    class Error<T>(val error: Throwable) : Resource<T>()
}
