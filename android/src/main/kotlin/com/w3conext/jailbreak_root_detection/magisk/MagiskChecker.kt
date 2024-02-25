package com.w3conext.super_user_detection.magisk

import java.io.File

object MagiskChecker {

    fun isInstalled(): Boolean {
        val magisk = File("/data/adb/magisk.img")
        val magiskDb = File("/data/adb/magisk.db")
        val magiskpolicy = File("/data/adb/magiskpolicy")

        if (magisk.exists() || magiskDb.exists() || magiskpolicy.exists()) {
            return true
        }
        var suFile = File("/su/bin/su")
        if (!suFile.exists()) {
            suFile = File("/system/xbin/su")
        }
        return suFile.exists()
    }
}