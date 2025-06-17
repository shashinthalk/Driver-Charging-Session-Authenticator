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
- [ Project Roadmap](#-project-roadmap)
- [ Contributing](#-contributing)
- [ License](#-license)
- [ Acknowledgments](#-acknowledgments)

---

##  Overview

At the API layer, a key principle is to protect underlying services from overload while ensuring optimal
performance, even under high-traffic conditions. We employ an asynchronous queueing mechanism for
communication with internal services to achieve this.

---

##  Features


Authorization Service

---

##  Project Structure

```sh
└── Driver-Charging-Session-Authenticator/
    ├── .github
    │   └── workflows
    ├── Dockerfile
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
				<td><code>❯ REPLACE-ME</code></td>
			</tr>
			<tr>
				<td><b><a href='https://github.com/shashinthalk/Driver-Charging-Session-Authenticator/blob/master/build.gradle.kts'>build.gradle.kts</a></b></td>
				<td><code>❯ REPLACE-ME</code></td>
			</tr>
			<tr>
				<td><b><a href='https://github.com/shashinthalk/Driver-Charging-Session-Authenticator/blob/master/settings.gradle.kts'>settings.gradle.kts</a></b></td>
				<td><code>❯ REPLACE-ME</code></td>
			</tr>
			<tr>
				<td><b><a href='https://github.com/shashinthalk/Driver-Charging-Session-Authenticator/blob/master/Dockerfile'>Dockerfile</a></b></td>
				<td><code>❯ REPLACE-ME</code></td>
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
						<td><b><a href='https://github.com/shashinthalk/Driver-Charging-Session-Authenticator/blob/master/.github/workflows/readme.yml'>readme.yml</a></b></td>
						<td><code>❯ REPLACE-ME</code></td>
					</tr>
					<tr>
						<td><b><a href='https://github.com/shashinthalk/Driver-Charging-Session-Authenticator/blob/master/.github/workflows/deploy.yml'>deploy.yml</a></b></td>
						<td><code>❯ REPLACE-ME</code></td>
					</tr>
					<tr>
						<td><b><a href='https://github.com/shashinthalk/Driver-Charging-Session-Authenticator/blob/master/.github/workflows/ktlint.yml'>ktlint.yml</a></b></td>
						<td><code>❯ REPLACE-ME</code></td>
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
														<td><code>❯ REPLACE-ME</code></td>
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
																		<td><code>❯ REPLACE-ME</code></td>
																	</tr>
																	<tr>
																		<td><b><a href='https://github.com/shashinthalk/Driver-Charging-Session-Authenticator/blob/master/src/main/kotlin/com/shashinthalk/driverchargingsessionauthenticator/common/config/WebClientConfig.kt'>WebClientConfig.kt</a></b></td>
																		<td><code>❯ REPLACE-ME</code></td>
																	</tr>
																	<tr>
																		<td><b><a href='https://github.com/shashinthalk/Driver-Charging-Session-Authenticator/blob/master/src/main/kotlin/com/shashinthalk/driverchargingsessionauthenticator/common/config/JacksonConfig.kt'>JacksonConfig.kt</a></b></td>
																		<td><code>❯ REPLACE-ME</code></td>
																	</tr>
																	<tr>
																		<td><b><a href='https://github.com/shashinthalk/Driver-Charging-Session-Authenticator/blob/master/src/main/kotlin/com/shashinthalk/driverchargingsessionauthenticator/common/config/OpenApiConfig.kt'>OpenApiConfig.kt</a></b></td>
																		<td><code>❯ REPLACE-ME</code></td>
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
																		<td><b><a href='https://github.com/shashinthalk/Driver-Charging-Session-Authenticator/blob/master/src/main/kotlin/com/shashinthalk/driverchargingsessionauthenticator/authservice/dto/CallbackBody.kt'>CallbackBody.kt</a></b></td>
																		<td><code>❯ REPLACE-ME</code></td>
																	</tr>
																	</table>
																</blockquote>
															</details>
															<details>
																<summary><b>service</b></summary>
																<blockquote>
																	<table>
																	<tr>
																		<td><b><a href='https://github.com/shashinthalk/Driver-Charging-Session-Authenticator/blob/master/src/main/kotlin/com/shashinthalk/driverchargingsessionauthenticator/authservice/service/DecisionLogger.kt'>DecisionLogger.kt</a></b></td>
																		<td><code>❯ REPLACE-ME</code></td>
																	</tr>
																	<tr>
																		<td><b><a href='https://github.com/shashinthalk/Driver-Charging-Session-Authenticator/blob/master/src/main/kotlin/com/shashinthalk/driverchargingsessionauthenticator/authservice/service/AuthorizationService.kt'>AuthorizationService.kt</a></b></td>
																		<td><code>❯ REPLACE-ME</code></td>
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
																		<td><code>❯ REPLACE-ME</code></td>
																	</tr>
																	<tr>
																		<td><b><a href='https://github.com/shashinthalk/Driver-Charging-Session-Authenticator/blob/master/src/main/kotlin/com/shashinthalk/driverchargingsessionauthenticator/api/dto/SessionRequestBody.kt'>SessionRequestBody.kt</a></b></td>
																		<td><code>❯ REPLACE-ME</code></td>
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
																		<td><code>❯ REPLACE-ME</code></td>
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
																<td><code>❯ REPLACE-ME</code></td>
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
													<table>
													<tr>
														<td><b><a href='https://github.com/shashinthalk/Driver-Charging-Session-Authenticator/blob/master/src/test/kotlin/com/shashinthalk/driverchargingsessionauthenticator/DriverChargingSessionAuthenticatorApplicationTests.kt'>DriverChargingSessionAuthenticatorApplicationTests.kt</a></b></td>
														<td><code>❯ REPLACE-ME</code></td>
													</tr>
													</table>
													<details>
														<summary><b>authservice</b></summary>
														<blockquote>
															<details>
																<summary><b>service</b></summary>
																<blockquote>
																	<table>
																	<tr>
																		<td><b><a href='https://github.com/shashinthalk/Driver-Charging-Session-Authenticator/blob/master/src/test/kotlin/com/shashinthalk/driverchargingsessionauthenticator/authservice/service/AuthorizationServiceTest.kt'>AuthorizationServiceTest.kt</a></b></td>
																		<td><code>❯ REPLACE-ME</code></td>
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
																<summary><b>controller</b></summary>
																<blockquote>
																	<table>
																	<tr>
																		<td><b><a href='https://github.com/shashinthalk/Driver-Charging-Session-Authenticator/blob/master/src/test/kotlin/com/shashinthalk/driverchargingsessionauthenticator/api/controller/DriverSessionRequestControllerTest.kt'>DriverSessionRequestControllerTest.kt</a></b></td>
																		<td><code>❯ REPLACE-ME</code></td>
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
				<td><code>❯ REPLACE-ME</code></td>
			</tr>
			</table>
		</blockquote>
	</details>
</details>

---
##  Getting Started

###  Prerequisites

Before getting started with Driver-Charging-Session-Authenticator, ensure your runtime environment meets the following requirements:

- **Programming Language:** Kotlin
- **Package Manager:** Gradle
- **Container Runtime:** Docker


###  Installation

Install Driver-Charging-Session-Authenticator using one of the following methods:

**Build from source:**

1. Clone the Driver-Charging-Session-Authenticator repository:
```sh
❯ git clone https://github.com/shashinthalk/Driver-Charging-Session-Authenticator
```

2. Navigate to the project directory:
```sh
❯ cd Driver-Charging-Session-Authenticator
```

3. Install the project dependencies:


**Using `gradle`** &nbsp; [<img align="center" src="https://img.shields.io/badge/Kotlin-0095D5.svg?style={badge_style}&logo=kotlin&logoColor=white" />](https://kotlinlang.org/)

```sh
❯ gradle build
```


**Using `docker`** &nbsp; [<img align="center" src="https://img.shields.io/badge/Docker-2CA5E0.svg?style={badge_style}&logo=docker&logoColor=white" />](https://www.docker.com/)

```sh
❯ docker build -t shashinthalk/Driver-Charging-Session-Authenticator .
```




###  Usage
Run Driver-Charging-Session-Authenticator using the following command:
**Using `gradle`** &nbsp; [<img align="center" src="https://img.shields.io/badge/Kotlin-0095D5.svg?style={badge_style}&logo=kotlin&logoColor=white" />](https://kotlinlang.org/)

```sh
❯ gradle run
```


**Using `docker`** &nbsp; [<img align="center" src="https://img.shields.io/badge/Docker-2CA5E0.svg?style={badge_style}&logo=docker&logoColor=white" />](https://www.docker.com/)

```sh
❯ docker run -it {image_name}
```


###  Testing
Run the test suite using the following command:
**Using `gradle`** &nbsp; [<img align="center" src="https://img.shields.io/badge/Kotlin-0095D5.svg?style={badge_style}&logo=kotlin&logoColor=white" />](https://kotlinlang.org/)

```sh
❯ gradle test
```

---

##  Acknowledgments

- List any resources, contributors, inspiration, etc. here.

---