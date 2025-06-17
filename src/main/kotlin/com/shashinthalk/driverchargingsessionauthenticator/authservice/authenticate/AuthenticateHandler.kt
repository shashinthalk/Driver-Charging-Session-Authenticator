package com.shashinthalk.driverchargingsessionauthenticator.authservice.authenticate

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.shashinthalk.driverchargingsessionauthenticator.authservice.dto.AclRecordBody
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Service

@Service
class AuthenticateHandler {
    private val objectMapper = jacksonObjectMapper()

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
