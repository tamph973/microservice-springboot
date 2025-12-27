

Project: Microservice Spring Boot
=============================================

Short description
-----------------
Microservice-based full-stack e-commerce platform for a phone shop. Services include configuration, discovery, gateway, product/customer/order/payment/notification microservices; uses PostgreSQL, MongoDB, Kafka, Keycloak and Zipkin for tracing.

Repository structure
--------------------
- `services/config-server` \- Spring Cloud Config server
- `services/discovery` \- Eureka discovery server
- `services/gateway` \- Spring Cloud Gateway / API gateway
- `services/product`, `services/customer`, `services/order`, `services/payment`, `services/notification` \- domain microservices
- `docker-compose.yml` \- local infra: PostgreSQL, MongoDB, Kafka, Zookeeper, Keycloak, Zipkin, pgAdmin, maildev, mongo-express

Tech stack
----------
- Java, Spring Boot, Spring Cloud (Config, Eureka, Gateway)
- Spring Data JPA (Postgres), Spring Data MongoDB
- Kafka for async messaging
- Keycloak for auth, Zipkin for tracing
- Docker \& Docker Compose, Maven

Prerequisites
-------------
- Docker & Docker Compose
- Java 17+ (or project-specified)
- Maven (or use included Maven Wrapper)
- On Windows, use `mvnw.cmd` from each module or root if present

Ports (defaults from `docker-compose.yml`)
-----------------------------------------
- PostgreSQL: `5432` (user: `tamph`, password: `tamph`)
- pgAdmin: `5050`
- MongoDB: `27017`
- Kafka: `9092`
- Zookeeper: `22181` (mapped)
- Keycloak: `9098`
- Zipkin: `9411`
- Maildev: `1080` (web), `1025` (smtp)
- mongo-express: `8081`

Quick start (local, Windows - adjust for Linux/macOS)
----------------------------------------------------
1. Start infrastructure:
   - `docker-compose up -d`
2. Build services (Windows):
   - From project root: `mvnw.cmd -T 1C clean package -DskipTests`
   - Or per module: `cd services/<module> && mvnw.cmd clean package -DskipTests`
   - On macOS/Linux use `./mvnw ...`
3. Run services:
   - Use your IDE (IntelliJ) to run Spring Boot apps, or:
   - `java -jar services/<module>/target/<module>-*.jar --spring.profiles.active=local`
4. Access:
   - API Gateway base URL: check `services/gateway` config (default ports in `application.yml`)
   - Keycloak admin: http://localhost:9098
   - pgAdmin: http://localhost:5050
   - Zipkin: http://localhost:9411

Configuration notes
-------------------
- Centralized config: `services/config-server` serves common `application.yml` for modules.
- Each microservice reads connection properties from config server or local `application.yml` under `src/main/resources`.
- For DB initialization, check SQL scripts or JPA entities in each service.

Testing
-------
- Run unit tests: `mvnw.cmd test` (or `./mvnw test`)
- Integration tests may require running `docker-compose` infra.

Useful Docker commands
----------------------
- Start: `docker-compose up -d`
- Stop: `docker-compose down`
- View logs: `docker-compose logs -f kafka` (replace service)
- Remove volumes (caution): `docker-compose down -v`

Troubleshooting
---------------
- If Kafka advertised listener issues: ensure `KAFKA_ADVERTISED_LISTENERS` matches host reachable by services (e.g., `localhost:9092` for local dev).
- If services fail to fetch config: verify `config-server` is running and accessible.

Contributing & notes
--------------------
- Follow module-level README and `HELP.md` inside each `services/*` for service-specific run instructions.
- Keep service contracts (REST APIs) backwards compatible when possible.

License
-------
- Check repository root for license file or add `LICENSE` as needed.
