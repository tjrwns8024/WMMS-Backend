package com.tjrwns8024.wmms.model.entitys

import javax.persistence.*

@Entity(name = "wm")
class Washer(
        @Id
        @Column()
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Int = 0,

        @Column(nullable = false)
        var name: String,

        @Column(nullable = false)
        var description: String
) {
    constructor() : this(
            name = "default",
            description = "default"
    )
}