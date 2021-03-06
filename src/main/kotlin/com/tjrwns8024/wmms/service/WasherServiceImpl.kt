package com.tjrwns8024.wmms.service

import com.tjrwns8024.wmms.model.entitys.Washer
import com.tjrwns8024.wmms.model.response.WasherID
import com.tjrwns8024.wmms.model.response.WasherInfo
import com.tjrwns8024.wmms.model.response.WasherListInfo
import com.tjrwns8024.wmms.repository.WasherRepository
import com.tjrwns8024.wmms.util.S3Service
import org.omg.SendingContext.RunTime
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.lang.RuntimeException
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.Exception

@Service
class WasherServiceImpl(
        private val washerRepository: WasherRepository,
        private val s3Service: S3Service
) : WasherService {
    override fun registerWM(name: String, description: String, image: MultipartFile): WasherID {
        washerRepository.findByName(name).ifPresent { throw RuntimeException("없는 세탁기입니다.") }

        washerRepository.save(
                Washer(
                        name = name,
                        description = description,
                        image = s3Service.upload(image, "washer/")!!,
                        status = "UNAVAILABLE",
                        register_date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
                )
        )

        val washerID = washerRepository.findByName(name).orElseThrow { throw RuntimeException("없는 세탁기입니다.") }.id

        return WasherID(washerID)
    }

    override fun getAvailableWM(): List<WasherListInfo> =
            washerRepository.findAllByStatus("AVAILABLE").map {
                WasherListInfo(
                        it.id,
                        it.name,
                        it.description,
                        it.status,
                        it.register_date
                )
            }

    override fun getAllWM(): List<WasherListInfo> =
            washerRepository.findAllBy().map {
                WasherListInfo(
                        it.id,
                        it.name,
                        it.description,
                        it.status,
                        it.register_date
                )
            }

    override fun getDetailWM(id: Int): WasherInfo {
        return washerRepository.findById(id).map {
            WasherInfo(
                    it.id,
                    it.name,
                    it.description,
                    it.image,
                    it.status,
                    it.register_date
            )
        }.orElseThrow { RuntimeException() }
    }

    override fun changeWMStatus(id: Int) {
        val washer = washerRepository.findById(id).orElseThrow { Exception() }

        when (washer.status) {
            "AVAILABLE" -> washer.status = "UNAVAILABLE"
            "UNAVAILABLE" -> washer.status = "AVAILABLE"
        }

        washerRepository.save(washer)

    }
}