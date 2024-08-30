# Secure Login Application

## Overview

This Secure Login Application is a Java-based desktop application that demonstrates advanced security features including biometric authentication and geolocation verification. It's built using JavaFX for the UI, SQLite for data storage, and incorporates fingerprint verification and location-based access control.

## Features

- User authentication with username and password
- Fingerprint biometric verification
- Geolocation-based access control
- Secure password hashing using BCrypt
- SQLite database for user data storage
- JavaFX-based user interface

## Prerequisites

- Java Development Kit (JDK) 11 or later
- Maven 3.6 or later
- SQLite 3
- Fingerprint reader hardware (for actual deployment)

## Setup

1. Clone the repository:
   ```
   git clone https://github.com/yourusername/secure-login-app.git
   cd secure-login-app
   ```

2. Set up the SQLite database:
   ```
   sqlite3 securelogin.db
   ```
   Then create the necessary tables (see Database Schema section below).

3. Install dependencies:
   ```
   mvn clean install
   ```

## Running the Application

To run the application, use the following Maven command:

```
mvn javafx:run
```

## Running Tests

To run the unit tests, use:

```
mvn test
```

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── securelogin/
│   │           ├── Main.java
│   │           ├── controller/
│   │           ├── dao/
│   │           ├── model/
│   │           ├── service/
│   │           └── util/
│   └── resources/
└── test/
    └── java/
        └── com/
            └── securelogin/
                └── service/
```

## Database Schema

```sql
CREATE TABLE users (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    username TEXT NOT NULL UNIQUE,
    password_hash TEXT NOT NULL,
    fingerprint BLOB,
    last_latitude REAL,
    last_longitude REAL
);
```

## Configuration

Application configuration can be modified in `src/main/resources/config.properties`.

## Security Considerations

- This application is a demonstration and should be further enhanced for production use.
- Ensure proper handling and storage of biometric data in compliance with relevant regulations.
- Implement additional security measures such as rate limiting and account lockout for production deployment.
- Regularly update dependencies to patch any security vulnerabilities.

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.

## Acknowledgments

- [JavaFX](https://openjfx.io/) for the UI framework
- [SQLite](https://www.sqlite.org/) for the database
- [BCrypt](https://github.com/patrickfav/bcrypt) for password hashing
- [SourceAFIS](https://github.com/robertvazan/sourceafis-java) for fingerprint matching
- [GeoClue](https://gitlab.freedesktop.org/geoclue/geoclue/-/wikis/home) for geolocation services