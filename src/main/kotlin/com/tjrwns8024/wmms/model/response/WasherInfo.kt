package com.tjrwns8024.wmms.model.response

data class WasherInfo(
        val id: Int,
        val name: String,
        val description: String,
        val image: String,
        val status: String,
        val register_date: String
)