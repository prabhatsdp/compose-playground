package dev.prabhatpandey.composeplayground.core.utils.types

typealias ClickListener = () -> Unit

typealias TypedClickListener<T> = (value: T) -> Unit