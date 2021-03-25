package com.tjrwns8024.wmms.controller

import com.tjrwns8024.wmms.model.payload.request.WasherRequest
import com.tjrwns8024.wmms.service.RegisterService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/register")
class RegisterController(private var registerService: RegisterService) {

    @PostMapping("/input")
    fun registerWM(@RequestBody @Valid washer: WasherRequest) {
        registerService.registerWM(washer)
    }
}