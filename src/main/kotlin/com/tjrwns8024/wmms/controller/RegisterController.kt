package com.tjrwns8024.wmms.controller

import com.tjrwns8024.wmms.service.RegisterService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/register")
class RegisterController(private val registerService: RegisterService) {

    @PostMapping("/input")
    fun registerWM(@RequestParam name: String,
                   @RequestParam description: String,
                   @RequestParam image: MultipartFile) {
        registerService.registerWM(name, description, image)
    }
}