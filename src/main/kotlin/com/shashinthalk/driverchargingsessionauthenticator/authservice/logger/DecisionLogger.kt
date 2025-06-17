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
 * This service saves decision data to a JSONL file
 * Gets its own line as a JSON object
 **/
@Service
class DecisionLogger(private val objectMapper: ObjectMapper) {
    /**
     * Save a list of decision log entries in the log file.
     *
     * @param logsDir Directory of the log file
     * @param fileName Name of the log file
     * @param data List of decisions
     */
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
