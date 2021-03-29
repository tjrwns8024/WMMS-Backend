package com.tjrwns8024.wmms.model.response

data class WasherListInfo(
        val id: Int,
        val name: String,
        val description: String,
        val status: Boolean,
        val register_date: String
)