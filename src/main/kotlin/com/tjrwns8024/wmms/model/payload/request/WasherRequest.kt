package com.tjrwns8024.wmms.model.payload.request

import javax.validation.constraints.NotEmpty

data class WasherRequest (
    @NotEmpty
    val name: String,
    @NotEmpty
    val description: String
)