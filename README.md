<p align="center"><h1 align="center">DRIVER-CHARGING-SESSION-AUTHENTICATOR</h1></p>
<p align="center">
	<img src="https://img.shields.io/github/last-commit/shashinthalk/Driver-Charging-Session-Authenticator?style=default&logo=git&logoColor=white&color=0080ff" alt="last-commit">
	<img src="https://img.shields.io/github/languages/top/shashinthalk/Driver-Charging-Session-Authenticator?style=default&color=0080ff" alt="repo-top-language">
	<img src="https://img.shields.io/github/languages/count/shashinthalk/Driver-Charging-Session-Authenticator?style=default&color=0080ff" alt="repo-language-count">
</p>
<p align="center"><!-- default option, no dependency badges. -->
</p>
<p align="center">
	<!-- default option, no dependency badges. -->
</p>
<br>

##  Table of Contents

- [ Overview](#-overview)
- [ Features](#-features)
- [ Project Structure](#-project-structure)
  - [ Project Index](#-project-index)
- [ Getting Started](#-getting-started)
  - [ Prerequisites](#-prerequisites)
  - [ Installation](#-installation)
  - [ Usage](#-usage)
  - [ Testing](#-testing)
- [ API Endpoints](#-api-endpoints)

---

##  Overview

This Spring Boot application serves as a robust authentication service for electric vehicle charging sessions. At its core, the system protects backend services from being overwhelmed while ensuring lightning-fast performance, even when things get busy. We've built it with an asynchronous queueing system that keeps everything running smoothly, no matter how many drivers are trying to start their charging sessions at once.

Think of it as the smart bouncer for your EV charging network - it makes sure only the right people get in, and it does so without creating a traffic jam.

---

##  Features

**Protection from Overload**

This system is built to protect underlying services from traffic overload. By offloading requests through an asynchronous technique, the system ensures that backend services are not overwhelmed by a large number of simultaneous requests, which support maintaining reliability and stability under heavy load conditions.

**Asynchronous Queueing Mechanism**

The use of an asynchronous queueing mechanism allows requests to be processed without blocking other operations. This non-blocking technique ensures that even when multiple requests are being handled simultaneously, each request is processed and queued independently, preventing delays and reducing the risk of service disruption.

**Authorization Flow Logs**

Simple logging system that captures authorization decisions made by the ACL service for debugging purposes. Records the decision outcome along with essential context like station ID, driver token, and status. Provides quick visibility into authorization patterns and enables troubleshooting when charging sessions fail or behave unexpectedly.

---

##  Project Structure

```sh
└── Driver-Charging-Session-Authenticator/
    ├── .github
    │   └── workflows
    ├── README.md
    ├── build.gradle.kts
    ├── gradle
    │   └── wrapper
    ├── gradlew
    ├── gradlew.bat
    ├── logs
    │   └── decisions.jsonl
    ├── settings.gradle.kts
    └── src
        ├── main
        └── test
```


###  Project Index
<details open>
	<summary><b><code>DRIVER-CHARGING-SESSION-AUTHENTICATOR/</code></b></summary>
	<details> <!-- __root__ Submodule -->
		<summary><b>__root__</b></summary>
		<blockquote>
			<table>
			<tr>
				<td><b><a href='https://github.com/shashinthalk/Driver-Charging-Session-Authenticator/blob/master/gradlew.bat'>gradlew.bat</a></b></td>
				<td><code>❯ Gradle wrapper script for Windows</code></td>
			</tr>
			<tr>
				<td><b><a href='https://github.com/shashinthalk/Driver-Charging-Session-Authenticator/blob/master/build.gradle.kts'>build.gradle.kts</a></b></td>
				<td><code>❯ Main build configuration with dependencies and plugins</code></td>
			</tr>
			<tr>
				<td><b><a href='https://github.com/shashinthalk/Driver-Charging-Session-Authenticator/blob/master/settings.gradle.kts'>settings.gradle.kts</a></b></td>
				<td><code>❯ Gradle project settings and configuration</code></td>
			</tr>
			</table>
		</blockquote>
	</details>
	<details> <!-- .github Submodule -->
		<summary><b>.github</b></summary>
		<blockquote>
			<details>
				<summary><b>workflows</b></summary>
				<blockquote>
					<table>
					<tr>
						<td><b><a href='https://github.com/shashinthalk/Driver-Charging-Session-Authenticator/blob/master/.github/workflows/deploy.yml'>deploy.yml</a></b></td>
						<td><code>❯ CI/CD pipeline for deployment automation</code></td>
					</tr>
					<tr>
						<td><b><a href='https://github.com/shashinthalk/Driver-Charging-Session-Authenticator/blob/master/.github/workflows/ktlint.yml'>ktlint.yml</a></b></td>
						<td><code>❯ Kotlin code style and formatting checks</code></td>
					</tr>
					</table>
				</blockquote>
			</details>
		</blockquote>
	</details>
	<details> <!-- src Submodule -->
		<summary><b>src</b></summary>
		<blockquote>
			<details>
				<summary><b>main</b></summary>
				<blockquote>
					<details>
						<summary><b>kotlin</b></summary>
						<blockquote>
							<details>
								<summary><b>com</b></summary>
								<blockquote>
									<details>
										<summary><b>shashinthalk</b></summary>
										<blockquote>
											<details>
												<summary><b>driverchargingsessionauthenticator</b></summary>
												<blockquote>
													<table>
													<tr>
														<td><b><a href='https://github.com/shashinthalk/Driver-Charging-Session-Authenticator/blob/master/src/main/kotlin/com/shashinthalk/driverchargingsessionauthenticator/DriverChargingSessionAuthenticatorApplication.kt'>DriverChargingSessionAuthenticatorApplication.kt</a></b></td>
														<td><code>❯ Main Spring Boot application entry point</code></td>
													</tr>
													</table>
													<details>
														<summary><b>common</b></summary>
														<blockquote>
															<details>
																<summary><b>config</b></summary>
																<blockquote>
																	<table>
																	<tr>
																		<td><b><a href='https://github.com/shashinthalk/Driver-Charging-Session-Authenticator/blob/master/src/main/kotlin/com/shashinthalk/driverchargingsessionauthenticator/common/config/CoroutineConfig.kt'>CoroutineConfig.kt</a></b></td>
																		<td><code>❯ Coroutine and async processing configuration</code></td>
																	</tr>
																	<tr>
																		<td><b><a href='https://github.com/shashinthalk/Driver-Charging-Session-Authenticator/blob/master/src/main/kotlin/com/shashinthalk/driverchargingsessionauthenticator/common/config/WebClientConfig.kt'>WebClientConfig.kt</a></b></td>
																		<td><code>❯ HTTP client configuration for external services</code></td>
																	</tr>
																	<tr>
																		<td><b><a href='https://github.com/shashinthalk/Driver-Charging-Session-Authenticator/blob/master/src/main/kotlin/com/shashinthalk/driverchargingsessionauthenticator/common/config/OpenApiConfig.kt'>OpenApiConfig.kt</a></b></td>
																		<td><code>❯ API documentation and Swagger configuration</code></td>
																	</tr>
																	</table>
																</blockquote>
															</details>
														</blockquote>
													</details>
													<details>
														<summary><b>authservice</b></summary>
														<blockquote>
															<details>
																<summary><b>dto</b></summary>
																<blockquote>
																	<table>
																	<tr>
																		<td><b><a href='https://github.com/shashinthalk/Driver-Charging-Session-Authenticator/blob/master/src/main/kotlin/com/shashinthalk/driverchargingsessionauthenticator/authservice/dto/AclRecordBody.kt'>AclRecordBody.kt</a></b></td>
																		<td><code>❯ Data transfer object for ACL record responses</code></td>
																	</tr>
																	<tr>
																		<td><b><a href='https://github.com/shashinthalk/Driver-Charging-Session-Authenticator/blob/master/src/main/kotlin/com/shashinthalk/driverchargingsessionauthenticator/authservice/dto/CallbackBody.kt'>CallbackBody.kt</a></b></td>
																		<td><code>❯ Data transfer object for callback responses</code></td>
																	</tr>
																	</table>
																</blockquote>
															</details>
															<details>
																<summary><b>authenticate</b></summary>
																<blockquote>
																	<table>
																	<tr>
																		<td><b><a href='https://github.com/shashinthalk/Driver-Charging-Session-Authenticator/blob/master/src/main/kotlin/com/shashinthalk/driverchargingsessionauthenticator/authservice/authenticate/Authenticator.kt'>Authenticator.kt</a></b></td>
																		<td><code>❯ Core authentication logic and validation</code></td>
																	</tr>
																	</table>
																</blockquote>
															</details>
															<details>
																<summary><b>logger</b></summary>
																<blockquote>
																	<table>
																	<tr>
																		<td><b><a href='https://github.com/shashinthalk/Driver-Charging-Session-Authenticator/blob/master/src/main/kotlin/com/shashinthalk/driverchargingsessionauthenticator/authservice/logger/DecisionLogger.kt'>DecisionLogger.kt</a></b></td>
																		<td><code>❯ Authorization decision logging</code></td>
																	</tr>
																	</table>
																</blockquote>
															</details>
															<details>
																<summary><b>service</b></summary>
																<blockquote>
																	<table>
																	<tr>
																		<td><b><a href='https://github.com/shashinthalk/Driver-Charging-Session-Authenticator/blob/master/src/main/kotlin/com/shashinthalk/driverchargingsessionauthenticator/authservice/service/AuthorizationService.kt'>AuthorizationService.kt</a></b></td>
																		<td><code>❯ Core business logic for session authorization</code></td>
																	</tr>
																	</table>
																</blockquote>
															</details>
														</blockquote>
													</details>
													<details>
														<summary><b>api</b></summary>
														<blockquote>
															<details>
																<summary><b>dto</b></summary>
																<blockquote>
																	<table>
																	<tr>
																		<td><b><a href='https://github.com/shashinthalk/Driver-Charging-Session-Authenticator/blob/master/src/main/kotlin/com/shashinthalk/driverchargingsessionauthenticator/api/dto/RequestAcknowledgment.kt'>RequestAcknowledgment.kt</a></b></td>
																		<td><code>❯ API response model for request confirmations</code></td>
																	</tr>
																	<tr>
																		<td><b><a href='https://github.com/shashinthalk/Driver-Charging-Session-Authenticator/blob/master/src/main/kotlin/com/shashinthalk/driverchargingsessionauthenticator/api/dto/SessionRequestBody.kt'>SessionRequestBody.kt</a></b></td>
																		<td><code>❯ Request payload model for charging sessions</code></td>
																	</tr>
																	</table>
																</blockquote>
															</details>
															<details>
																<summary><b>controller</b></summary>
																<blockquote>
																	<table>
																	<tr>
																		<td><b><a href='https://github.com/shashinthalk/Driver-Charging-Session-Authenticator/blob/master/src/main/kotlin/com/shashinthalk/driverchargingsessionauthenticator/api/controller/DriverSessionRequestController.kt'>DriverSessionRequestController.kt</a></b></td>
																		<td><code>❯ REST API endpoints for driver session management</code></td>
																	</tr>
																	</table>
																</blockquote>
															</details>
														</blockquote>
													</details>
													<details>
														<summary><b>exception</b></summary>
														<blockquote>
															<table>
															<tr>
																<td><b><a href='https://github.com/shashinthalk/Driver-Charging-Session-Authenticator/blob/master/src/main/kotlin/com/shashinthalk/driverchargingsessionauthenticator/exception/ValidationExceptionHandler.kt'>ValidationExceptionHandler.kt</a></b></td>
																<td><code>❯ Global exception handling and error responses</code></td>
															</tr>
															</table>
														</blockquote>
													</details>
												</blockquote>
											</details>
										</blockquote>
									</details>
								</blockquote>
							</details>
						</blockquote>
					</details>
				</blockquote>
			</details>
			<details>
				<summary><b>test</b></summary>
				<blockquote>
					<details>
						<summary><b>kotlin</b></summary>
						<blockquote>
							<details>
								<summary><b>com</b></summary>
								<blockquote>
									<details>
										<summary><b>shashinthalk</b></summary>
										<blockquote>
											<details>
												<summary><b>driverchargingsessionauthenticator</b></summary>
												<blockquote>
													<details>
														<summary><b>api</b></summary>
														<blockquote>
															<details>
																<summary><b>controller</b></summary>
																<blockquote>
																	<table>
																	<tr>
																		<td><b><a href='https://github.com/shashinthalk/Driver-Charging-Session-Authenticator/blob/master/src/test/kotlin/com/shashinthalk/driverchargingsessionauthenticator/api/controller/DriverSessionRequestControllerTest.kt'>DriverSessionRequestControllerTest.kt</a></b></td>
																		<td><code>❯ Controller layer tests for API endpoints</code></td>
																	</tr>
																	</table>
																</blockquote>
															</details>
														</blockquote>
													</details>
													<details>
														<summary><b>authservice</b></summary>
														<blockquote>
															<details>
																<summary><b>service</b></summary>
																<blockquote>
																	<table>
																	<tr>
																		<td><b><a href='https://github.com/shashinthalk/Driver-Charging-Session-Authenticator/blob/master/src/test/kotlin/com/shashinthalk/driverchargingsessionauthenticator/authservice/service/AuthorizationServiceTest.kt'>AuthorizationServiceTest.kt</a></b></td>
																		<td><code>❯ Unit tests for authorization business logic</code></td>
																	</tr>
																	</table>
																</blockquote>
															</details>
														</blockquote>
													</details>
												</blockquote>
											</details>
										</blockquote>
									</details>
								</blockquote>
							</details>
						</blockquote>
					</details>
				</blockquote>
			</details>
		</blockquote>
	</details>
	<details> <!-- logs Submodule -->
		<summary><b>logs</b></summary>
		<blockquote>
			<table>
			<tr>
				<td><b><a href='https://github.com/shashinthalk/Driver-Charging-Session-Authenticator/blob/master/logs/decisions.jsonl'>decisions.jsonl</a></b></td>
				<td><code>❯ Authorization decision logs in JSON Lines format</code></td>
			</tr>
			</table>
		</blockquote>
	</details>
</details>

---
##  Getting Started

Ready to get this authentication service up and running? It's pretty straightforward! Just make sure you have the basics covered and you'll be authenticating charging sessions in no time.

###  Prerequisites

Before diving in, you'll need these essentials:

- **Programming Language:** Kotlin
- **Build Tool:** Gradle
- **Java:** JDK 17 or higher (Spring Boot 3.x requirement)


###  Installation

Getting the project set up is as easy as 1-2-3:

**Build from source:**

1. Clone the repository to your local machine:
```sh
❯ git clone https://github.com/shashinthalk/Driver-Charging-Session-Authenticator
```

2. Navigate to the project directory:
```sh
❯ cd Driver-Charging-Session-Authenticator
```

3. Build the project using the Gradle wrapper:

**Using `./gradlew`** &nbsp; [<img align="center" src="https://img.shields.io/badge/Kotlin-0095D5.svg?style={badge_style}&logo=kotlin&logoColor=white" />](https://kotlinlang.org/)

```sh
❯ ./gradlew build  
```

That's it! Gradle will download all dependencies and build your Spring Boot application.

###  Usage

Time to fire up your authentication service! Here's how to get it running:

**Using `./gradlew`** &nbsp; [<img align="center" src="https://img.shields.io/badge/Kotlin-0095D5.svg?style={badge_style}&logo=kotlin&logoColor=white" />](https://kotlinlang.org/)

```sh
❯ ./gradlew bootRun
```

Your Spring Boot application will start up and be ready to handle authentication requests. By default, it runs on port 3000 with context path `/dcsl`, but you can configure this in your `application.properties` or `application.yml` file.

###  Testing

We've got comprehensive tests to make sure everything works as expected. Run them with:

**Using `./gradlew`** &nbsp; [<img align="center" src="https://img.shields.io/badge/Kotlin-0095D5.svg?style={badge_style}&logo=kotlin&logoColor=white" />](https://kotlinlang.org/)

```sh
❯ ./gradlew test
```

This will run all unit tests and integration tests, giving you confidence that your authentication service is rock solid.

---

##  API Endpoints

🚀 **Live API:** https://shashinthalk.cc/dcsl

### Available Endpoints

The service provides RESTful endpoints for managing driver charging session authentication. Here are the main endpoints you'll be working with:

- **POST** `/driver/session/authenticate` - Authenticate a driver charging session
- **GET** `/health` - Health check endpoint
- **GET** `/swagger-ui/index.html` - API documentation (Swagger UI)

*For detailed API documentation, visit:* https://shashinthalk.cc/dcsl/swagger-ui/index.html

