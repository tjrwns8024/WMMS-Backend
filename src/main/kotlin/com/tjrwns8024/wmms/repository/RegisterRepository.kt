package com.tjrwns8024.wmms.repository

import com.tjrwns8024.wmms.model.entitys.Washer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RegisterRepository : JpaRepository<Washer, Int> {
}