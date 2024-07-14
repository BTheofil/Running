package hu.tb.auth.domain

interface PatternValidator {

    fun matches(value: String): Boolean
}