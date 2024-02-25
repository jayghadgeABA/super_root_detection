package com.w3conext.super_user_detection.magisk

import java.io.File

object MagiskChecker {

    fun isInstalled(): Boolean {
        val magisk = File("/data/adb/magisk.img")
        if (magisk.exists()) {
            return true
        }
        var suFile = File("/su/bin/su")
        if (!suFile.exists()) {
            suFile = File("/system/xbin/su")
        }
        return suFile.exists()
    }
}