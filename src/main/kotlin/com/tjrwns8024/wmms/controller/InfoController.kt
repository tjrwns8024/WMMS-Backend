package com.tjrwns8024.wmms.controller

import com.tjrwns8024.wmms.model.response.WasherInfo
import com.tjrwns8024.wmms.service.InfoService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/info")
class InfoController(
        private val infoService: InfoService
) {

    @GetMapping("/available")
    fun getAvailableWM(): List<WasherInfo> =
            infoService.getAvailableWM()

    @GetMapping("/all")
    fun getAllWM(): List<WasherInfo> =
            infoService.getAllWM()
}