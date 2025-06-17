package com.shashinthalk.driverchargingsessionauthenticator.authservice.authenticate

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.shashinthalk.driverchargingsessionauthenticator.authservice.dto.AclRecordBody
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Service

/**
 * Validating the driver token against to the station id
 * Using a local ACL (Access Control List)
 */
@Service
class AuthenticateHandler {
    private val objectMapper = jacksonObjectMapper()

    /**
     * Validates if a driverToken is allowed for the specified station id.
     *
     * Read data from `acl.json`. If the record is found, return "allowed".
     * If no match is found, return "not allowed".
     * If an error, return "unknown".
     *
     * @param stationId Station Identifier of the charging station
     * @param driverToken Driver Identifier to be validated
     * @return Authorization status: "allowed", "not allowed", or "unknown"
     */
    suspend fun validateDriverAndStationWithAcl(
        stationId: String,
        driverToken: String,
    ): String =
        withContext(Dispatchers.IO) {
            val aclFile = ClassPathResource("acl.json")
            if (!aclFile.exists()) {
                return@withContext "unknown"
            }
            try {
                val inputStream = aclFile.inputStream
                val aclRecords: List<AclRecordBody> = objectMapper.readValue(inputStream)
                inputStream.close()
                return@withContext if (aclRecords.any { it.stationId == stationId && it.driverToken == driverToken }) {
                    "allowed"
                } else {
                    "not allowed"
                }
            } catch (ex: Exception) {
                return@withContext "unknown"
            }
        }
}
