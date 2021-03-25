package com.tjrwns8024.wmms.service

import com.tjrwns8024.wmms.model.payload.request.WasherRequest

interface RegisterService {
    fun registerWM(washerRequest: WasherRequest)
}