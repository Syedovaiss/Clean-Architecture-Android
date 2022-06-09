package com.ovais.sadapaycasestudy.base

interface BaseMapper<From, To> {

    fun map(from: From): To
}