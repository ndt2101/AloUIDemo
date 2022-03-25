package com.tuan2101.dataclasses

import lombok.Data

/**
 * Created by ndt2101 on 3/25/2022.
 */
@Data
class Service(
    id: Long,
    name: String,
    val isTrusted: Boolean,
    val avatar: String,
    val tags: List<String>,
    val location: Float,
    val openTime: String,
    val closeTime: String,
    val rate: Float
) : BaseObject(id, name)
