package com.lizongying.mytv.speedtest

object ChannelHelper {

    // ── 分组 ──────────────────────────────────────────────────────

    fun baseGroup(name: String): String {
        val upper = name.uppercase()
        return when {
            upper.contains("CCTV") -> "央视频道"
            name.contains("卫视")  -> "卫视频道"
            else                   -> "其他频道"
        }
    }

    // ── Logo URL ──────────────────────────────────────────────────

    private const val LOGO_BASE =
        "https://ghfast.top/https://raw.githubusercontent.com/Jarrey/iptv_logo/main/tv/"

    fun buildLogoUrl(name: String): String {
        val encoded = name.toByteArray(Charsets.UTF_8)
            .joinToString("") { b ->
                val i = b.toInt() and 0xFF
                if (i in 0x41..0x5A || i in 0x61..0x7A || i in 0x30..0x39
                    || i == 0x2D || i == 0x5F || i == 0x2E || i == 0x7E
                ) {
                    i.toChar().toString()
                } else {
                    "%%%02X".format(i)
                }
            }
        return "$LOGO_BASE$encoded.png"
    }

    // ── 排序 key ──────────────────────────────────────────────────

}
