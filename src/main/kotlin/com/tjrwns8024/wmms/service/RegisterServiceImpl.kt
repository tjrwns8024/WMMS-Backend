package com.tjrwns8024.wmms.service

import com.tjrwns8024.wmms.model.entitys.Washer
import com.tjrwns8024.wmms.repository.WasherRepository
import com.tjrwns8024.wmms.util.S3Service
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Service
class RegisterServiceImpl(
        private val registerRepository: WasherRepository,
        private val s3Service: S3Service) : RegisterService {

    override fun registerWM(name: String, description: String, image: MultipartFile) {
        registerRepository.save(
                Washer(
                        name = name,
                        description = description,
                        image = s3Service.upload(image, "washer/")!!,
                        status = false,
                        register_date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
                )
        )
    }
}