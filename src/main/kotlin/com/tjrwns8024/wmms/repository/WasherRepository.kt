package com.tjrwns8024.wmms.repository

import com.tjrwns8024.wmms.model.entitys.Washer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface WasherRepository : JpaRepository<Washer, Int> {
    fun findAllByStatus(status: Boolean): List<Washer>
    fun findAllBy(): List<Washer>
    fun findByName(name: String): Optional<Washer>
}