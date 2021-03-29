package com.tjrwns8024.wmms.service

import com.tjrwns8024.wmms.model.response.WasherInfo
import com.tjrwns8024.wmms.model.response.WasherListInfo

interface InfoService {
    fun getAvailableWM(): List<WasherListInfo>
    fun getAllWM(): List<WasherListInfo>
    fun getDetailWM(id: Int): WasherInfo
}