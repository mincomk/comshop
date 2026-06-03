package com.github.ityeri.comshop.contract

enum class CommandResult {
    SUCCESS,
    FAILED
    ;

    fun toInt(): Int =
        if (this == CommandResult.SUCCESS) 1
        else 0
}
