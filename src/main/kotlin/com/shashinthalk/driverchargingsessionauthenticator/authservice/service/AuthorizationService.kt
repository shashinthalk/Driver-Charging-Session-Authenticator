package com.shashinthalk.driverchargingsessionauthenticator.authservice.service

import com.shashinthalk.driverchargingsessionauthenticator.api.dto.SessionRequestBody
import com.shashinthalk.driverchargingsessionauthenticator.authservice.dto.CallbackBody
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import java.util.concurrent.ExecutionException
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException
import kotlin.random.Random

@Component
class AuthorizationService(
    private val decisionLogger: DecisionLogger,
) {
    private val restTemplate = RestTemplate()

    @RabbitListener(queues = ["authRequestQueue"])
    fun executeAuthorizationRequest(request: SessionRequestBody) {
        var status = ""
        val (station_id, driver_token, callback_url) = request
        try {
            val response =
                Executors.newSingleThreadExecutor().submit {
                    val duration = Random.nextLong(9000L, 11001L)
                    Thread.sleep(duration)
                    status = "allowed"
                }
            response.get(10000, TimeUnit.MILLISECONDS)
        } catch (ex: TimeoutException) {
            status = "unknown"
        } catch (ex: ExecutionException) {
            status = "unknown"
        } catch (ex: Exception) {
            status = "unknown"
        }

        try {
            val callback =
                CallbackBody(
                    station_id,
                    driver_token,
                    status,
                )
            restTemplate.postForLocation(request.callbackUrl, callback)
            decisionLogger.saveDecisionLog(data = listOf(callback))
        } catch (ex: Exception) {
            decisionLogger.saveDecisionLog(
                data =
                    listOf(
                        CallbackBody(
                            station_id,
                            driver_token,
                            ex.message.toString(),
                        ),
                    ),
            )
        }
    }
}
