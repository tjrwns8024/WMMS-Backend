package com.tjrwns8024.wmms.service

import org.springframework.web.multipart.MultipartFile

interface RegisterService {
    fun registerWM(name: String, description: String, image: MultipartFile)
}