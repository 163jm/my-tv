package com.lizongying.mytv.speedtest

data class IptvChannel(
    val name: String,
    val url: String,
)

data class IptvEntry(
    val name: String,
    val url: String,
    val group: String,
    val logo: String,
    val speed: Double,      // MB/s，-1 表示失败
    val sourceIndex: Int,
)
