# Android MVVM Sample Project

This is an Android project demonstrating the use of **Kotlin**, **MVVM architecture**, **Dagger-Hilt** for Dependency Injection, **Retrofit** for network requests, **Kotlin Coroutines** and **Flow** for asynchronous programming, and various **Jetpack** libraries. The project follows **Clean Architecture** principles to ensure a modular, testable, and maintainable codebase.

## Features

- **Kotlin** as the main programming language
- **MVVM** (Model-View-ViewModel) architecture
- **Clean Architecture** pattern
- **Dagger-Hilt** for dependency injection
- **Retrofit** for network communication
- **Kotlin Coroutines** for background tasks
- **Kotlin Flow** for reactive programming
- **Jetpack Components** such as ViewModel, Compose, Navigation
- Error handling with Result wrappers

## Tech Stack

### 1. **Kotlin**
Kotlin is the primary language used for the project, ensuring concise, safe, and modern development.

### 2. **MVVM Architecture**
MVVM separates business logic from UI to ensure that the code is maintainable and scalable:
- **Model**: Handles the data layer (e.g., remote API calls, database queries).
- **View**: Displays data on the screen and forwards user actions to the ViewModel.
- **ViewModel**: Acts as the middleman between the Model and the View. It processes the data and provides it in a format the View can consume.

### 3. **Dagger-Hilt**
[Dagger-Hilt](https://developer.android.com/training/dependency-injection/hilt-android) is used for dependency injection. This makes the code more modular, testable, and clean. 

### 4. **Retrofit**
[Retrofit](https://square.github.io/retrofit/) is used to handle network requests. Retrofit, along with **Kotlin Coroutines**, allows easy and clean handling of API calls asynchronously.

### 5. **Kotlin Coroutines**
[Coroutines](https://kotlinlang.org/docs/coroutines-overview.html) are used for managing asynchronous tasks, making code more concise and readable.

### 6. **Kotlin Flow**
[Flow](https://kotlinlang.org/docs/flow.html) is used for handling streams of data asynchronously. It is integrated with LiveData and ViewModel for efficient data processing and UI updates.

### 7. **Jetpack Libraries**
- **ViewModel**: Lifecycle-aware components to store and manage UI-related data.
- **Navigation**: Manages in-app navigation with safe args.
  
## Architecture

This project follows the **Clean Architecture** guidelines to provide separation of concerns and ensure high testability and maintainability. The architecture is split into different layers:
- **Presentation Layer**: Responsible for showing the data on the screen, typically contains ViewModels, Fragments, and Activities.
- **Domain Layer**: Contains business logic and use cases, with no dependency on other layers.
- **Data Layer**: Handles data sources such as the network, database, etc. Includes repositories that serve as single sources of truth.

# Coming soon
- Unit tests for ViewModel and Repositories
- New details screen
