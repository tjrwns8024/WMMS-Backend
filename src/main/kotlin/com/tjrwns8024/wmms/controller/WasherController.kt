package com.tjrwns8024.wmms.controller

import com.tjrwns8024.wmms.model.response.WasherID
import com.tjrwns8024.wmms.model.response.WasherInfo
import com.tjrwns8024.wmms.model.response.WasherListInfo
import com.tjrwns8024.wmms.service.WasherService
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/api/washer")
class WasherController(private val washerService: WasherService) {

    @PostMapping("/input")
    fun registerWM(@RequestParam name: String,
                   @RequestParam description: String,
                   @RequestParam image: MultipartFile): WasherID {
        return washerService.registerWM(name, description, image)
    }

    @GetMapping("/available")
    fun getAvailableWM(): List<WasherListInfo> {
        return washerService.getAvailableWM()
    }

    @GetMapping("/all")
    fun getAllWM(): List<WasherListInfo> {
        return washerService.getAllWM()
    }

    @GetMapping("/detail/{id}")
    fun getDetailWM(@PathVariable id: Int): WasherInfo {
        return washerService.getDetailWM(id)
    }

    @PostMapping("/status/{id}")
    fun changeWasherStatus(@PathVariable id: Int) {
        return washerService.changeWMStatus(id)
    }
}