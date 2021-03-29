package com.tjrwns8024.wmms.model.entitys

import javax.persistence.*

@Entity(name = "wm")
class Washer(
        @Id
        @Column
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int = 0,

        @Column(nullable = false)
        val name: String,

        @Column(nullable = false)
        val description: String,

        @Column(nullable = false)
        val image: String,

        @Column(nullable = false)
        val status: Boolean,

        @Column(nullable = false)
        val register_date: String
)