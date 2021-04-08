package com.tjrwns8024.wmms.model.entitys

import javax.persistence.*

@Entity(name = "tbl_wm")
data class Washer(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int = 0,

        @Column(nullable = false)
        var name: String = "",

        @Column(nullable = false)
        var description: String = "",

        @Column(nullable = false)
        var image: String = "",

        @Column(nullable = false)
        var status: String = "",

        @Column(nullable = false)
        var register_date: String = ""
)