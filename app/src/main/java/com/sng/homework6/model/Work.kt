package com.sng.homework6.model

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.collections.ArrayList

data class Work(
    var company: String, var title: String,
    var technologies: String,
    var projects: String,
    var startDate: Date, var endDate: Date,
    var additionalDetails: String
) {
}