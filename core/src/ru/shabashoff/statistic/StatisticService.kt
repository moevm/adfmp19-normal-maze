package ru.shabashoff.statistic

import com.fasterxml.jackson.module.kotlin.*
import java.io.File

object StatisticService {
    private val FILE: String = "./statistic.json"
    private val mapper = jacksonObjectMapper()

    var players: MutableList<PlayerStatistic> = ArrayList()

    fun addPlayer(playerStatistic: PlayerStatistic) {
        players.add(playerStatistic)
        players.sortBy { e -> -e.score }
        save()
    }

    fun load() {
        val file = File(FILE)

        if (!file.isFile || !file.exists()) {
            players = ArrayList()
            save()
        } else players = mapper.readValue(file.inputStream())
    }

    fun save() {
        mapper.writeValue(File(FILE).outputStream(), players)
    }
}