# Factory Robot Hazard Analyzer

## Overview

Factory Robot Hazard Analyzer is a Java-based application that evaluates the hazard risk score of a factory robot based on arm precision, worker density, and machinery state.

The project demonstrates Object-Oriented Programming concepts, exception handling, SOLID principles, clean code practices, and design patterns.

## Technologies Used

- Java 17
- Maven
- JUnit 5
- Git
- GitHub
- IntelliJ IDEA

## Functional Requirements

The application evaluates robot hazard risk using:

- Arm Precision
- Worker Density
- Machinery State

### Hazard Risk Formula

Hazard Risk = ((1.0 - armPrecision) * 15.0) + (workerDensity * machineRiskFactor)

### Machinery Risk Factors

| Machinery State | Risk Factor |
|---|---:|
| Worn | 1.3 |
| Faulty | 2.0 |
| Critical | 3.0 |

## Concepts Demonstrated

- Classes and Objects
- Encapsulation
- Abstraction
- Exception Handling
- Custom Exceptions
- SOLID Principles
- DRY, KISS and YAGNI
- Design Patterns
- Unit Testing with JUnit 5

## Project Development

The project is developed incrementally using separate Git feature branches for each use case.

- `main` – Project documentation
- `develop` – Integrated development branch
- `feature/UC1-display-static-message`
- `feature/UC2-accept-inputs`
- `feature/UC3-calculate-hazard-risk`
- `feature/UC4-input-validation`
- `feature/UC5-refactor-validation`
- `feature/UC6-custom-exception`
- `feature/UC7-machinery-risk-mapping`
- `feature/UC8-modular-oops-design`

Each completed feature branch is merged into the develop branch after implementation and testing.