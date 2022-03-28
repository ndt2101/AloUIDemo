package com.tuan2101.alouidemo.dataclasses


/**
 * Created by ndt2101 on 3/25/2022.
 */


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