package com.tjrwns8024.wmms.service

import com.tjrwns8024.wmms.model.response.WasherID
import com.tjrwns8024.wmms.model.response.WasherInfo
import com.tjrwns8024.wmms.model.response.WasherListInfo
import org.springframework.web.multipart.MultipartFile

interface WasherService {
    fun registerWM(name: String, description: String, image: MultipartFile): WasherID
    fun getAvailableWM(): List<WasherListInfo>
    fun getAllWM(): List<WasherListInfo>
    fun getDetailWM(id: Int): WasherInfo
    fun changeWMStatus(id: Int)
}