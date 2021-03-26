package com.tjrwns8024.wmms.service

import com.tjrwns8024.wmms.model.entitys.Washer
import com.tjrwns8024.wmms.model.payload.request.WasherRequest
import com.tjrwns8024.wmms.repository.RegisterRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Service
class RegisterServiceImpl(private var registerRepository: RegisterRepository) : RegisterService {
    override fun registerWM(washerRequest: WasherRequest) {

        registerRepository.save(
                Washer(
                        name = washerRequest.name,
                        description = washerRequest.description,
                        image = "fsadfas",
                        register_date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
                )
        )
    }
}