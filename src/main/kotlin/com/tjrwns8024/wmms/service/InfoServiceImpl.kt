package com.tjrwns8024.wmms.service

import com.tjrwns8024.wmms.model.response.WasherInfo
import com.tjrwns8024.wmms.model.response.WasherListInfo
import com.tjrwns8024.wmms.repository.WasherRepository
import org.omg.CORBA.UserException
import org.springframework.stereotype.Service
import java.io.IOException

@Service
class InfoServiceImpl(private val washerRepository: WasherRepository) : InfoService {
    override fun getAvailableWM(): List<WasherListInfo> =
            washerRepository.findAllByStatus(true).map {
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
        }.orElseThrow{ Exception() }
    }
}