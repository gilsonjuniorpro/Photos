package com.github.sikv.photos.data

enum class DataSourceState {
    LOADING_INITIAL,
    INITIAL_LOADING_DONE,
    LOADING_NEXT,
    NEXT_DONE,
    ERROR
}