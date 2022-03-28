package com.tuan2101.alouidemo.dataclasses


/**
 * Created by ndt2101 on 3/25/2022.
 */

class Service(
    id: Long,
    name: String,
    val isTrusted: Boolean,
    val avatar: String,
    val tags: List<String>,
    val location: Float,
    val openTime: String,
    val closeTime: String,
    val rate: Float,
    val sale: String?
) : BaseObject(id, name)
