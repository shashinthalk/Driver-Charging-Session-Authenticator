package com.shashinthalk.driverchargingsessionauthenticator.authservice.logger

import com.fasterxml.jackson.databind.ObjectMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.stereotype.Service
import java.io.File
import java.io.FileWriter
import java.nio.file.Files
import java.nio.file.Paths

/**
 * This service saves decision data to a JSONL file - basically a log where each decision
 * gets its own line as a JSON object. This makes it really easy to add new decisions
 * without touching existing ones, and quickly scan through the file to see what happened.
 **/
@Service
class DecisionLogger(private val objectMapper: ObjectMapper) {
    suspend fun saveDecisionLog(
        logsDir: String = "logs",
        fileName: String = "decisions.jsonl",
        data: List<Any>,
    ) = withContext(Dispatchers.IO) {
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
