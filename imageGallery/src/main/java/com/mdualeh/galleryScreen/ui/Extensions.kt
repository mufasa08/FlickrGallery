package com.mdualeh.galleryScreen.ui

import java.text.ParseException
import java.text.SimpleDateFormat

fun String.convertUTCToLocal(): String {
    try {
        val parser = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
        val formatter = SimpleDateFormat("dd/MM/yyyy HH:mm")
        val formattedDate = formatter.format(parser.parse(this))
        return formattedDate
    } catch (e: ParseException) {
        return "Date Unknown"
    }
}