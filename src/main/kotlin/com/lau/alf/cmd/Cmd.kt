package com.lau.alf.cmd

interface Cmd<T> {
    operator fun invoke(payload: T): Boolean
    fun isSatisfiedBy(payload: T): Boolean
}