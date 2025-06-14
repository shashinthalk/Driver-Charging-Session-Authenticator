package com.shashinthalk.driverchargingsessionauthenticator.authservice.service

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.stereotype.Service
import java.io.File
import java.io.FileWriter
import java.nio.file.Files
import java.nio.file.Paths

@Service
class DecisionLogger(private val objectMapper: ObjectMapper) {
    fun saveDecisionLog(
        logsDir: String = "logs",
        fileName: String = "decisions.jsonl",
        data: List<Any>,
    ) {
        val dir = Paths.get(logsDir)
        if (!Files.exists(dir)) {
            Files.createDirectories(dir)
        }

        val file = File("$logsDir/$fileName")
        FileWriter(file, true).use { writer ->
            data.forEach { obj ->
                val jsonString = objectMapper.writeValueAsString(obj)
                writer.write(jsonString)
                writer.write("\n")
            }
        }
    }
}
