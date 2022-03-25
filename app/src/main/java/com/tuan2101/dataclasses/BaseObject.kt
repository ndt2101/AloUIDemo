package com.tuan2101.dataclasses

import lombok.Data

/**
 * Created by ndt2101 on 3/25/2022.
 */

@Data
open class BaseObject(
    val id: Long,
    val name: String
) {
    override fun equals(other: Any?): Boolean {
        return super.equals(other) && other is BaseObject && other.id == id && other.name == name
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + name.hashCode()
        return result
    }
}