package com.example.katarzyna.fastask.model


data class Task(
    val id: Int,
    val action: String,
    val location: String,
    val creatorid: String,
    val active: Boolean,
    val comment: String,
    val data: String
)

