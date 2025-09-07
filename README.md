# [nectar] - Android E-commerce App (Kotlin)

## 🛍️ Overview

[ASSIGNMENT_002].<br>

[AUTHOR : CHUO-CHHUNGSIM].<br>

[nectar] is a native Android application built with Kotlin. It aims to provide users with a seamless mobile shopping experience, allowing them to browse products, manage a shopping cart, and simulate the checkout process. This project is developed to [mention your main goal, e.g., learn modern Android development, build a portfolio piece, explore e-commerce app features].

## ✨ Features

*   **User Authentication:**
    *   [ ] User Sign-up
    *   [ ] User Login
    *   [ ] User Logout
    *   [ ] Password Reset (Optional)
*   **Product Browsing:**
    *   [ ] Display list of products (e.g., in a `RecyclerView`)
    *   [ ] View product details screen (description, price, images)
    *   [ ] Search functionality for products
    *   [ ] Filter products by category, price, etc. (Optional)
*   **Shopping Cart:**
    *   [ ] Add products to cart
    *   [ ] View cart items
    *   [ ] Update quantity of items in cart
    *   [ ] Remove items from cart
    *   [ ] Display cart total
*   **Checkout Process:**
    *   [ ] Enter shipping information (Mock or integrated)
    *   [ ] Select payment method (Mock or integrated)
    *   [ ] Order confirmation screen
*   **User Profile (Optional):**
    *   [ ] View past order history
    *   [ ] Manage account details (e.g., address, payment methods)
*   **Offline Support (Optional):**
    *   [ ] Cache product data for offline browsing
    *   [ ] Allow adding to cart offline and sync when online

*(Mark features with `[x]` as you complete them)*

## 🛠️ Technologies & Architecture

*   **Language:** Kotlin
*   **UI Toolkit:**
    *   Jetpack Compose (Recommended for new projects)
    *   XML with Views (If using the traditional approach)
*   **Architecture:**
    *   MVVM (Model-View-ViewModel) - Highly Recommended
    *   MVI (Model-View-Intent) - Alternative
*   **Android Jetpack Components:**
    *   **Lifecycle:** (ViewModels, LiveData/Kotlin Flows)
    *   **Navigation:** (Navigation Component)
    *   **Room:** (For local database/persistence)
    *   **DataStore:** (For simple key-value storage or typed objects)
    *   **Paging 3:** (For loading large datasets gradually)
    *   **WorkManager:** (For background tasks)
*   **Networking:**
    *   Retrofit 2 (For type-safe HTTP calls)
    *   OkHttp 3 (As the HTTP client for Retrofit)
    *   Gson / Moshi / Kotlinx Serialization (For JSON parsing)
*   **Dependency Injection:**
    *   Hilt (Recommended for Android)
    *   Koin (Alternative)
*   **Asynchronous Programming:**
    *   Kotlin Coroutines & Flows
*   **Image Loading:**
    *   Coil / Glide / Picasso
*   **Testing:**
    *   JUnit (Unit tests)
    *   Espresso (UI tests)
    *   Mockito/MockK (Mocking frameworks)
*   **Build Tool:** Gradle

## 🚀 Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing.

### Prerequisites

*   Android Studio (Latest stable version recommended - [Download here](https://developer.android.com/studio))
*   Android SDK (Ensure you have the necessary SDK Platforms and Build Tools installed via Android Studio's SDK Manager)
*   JDK (Java Development Kit - usually bundled with Android Studio)
*   An Android Emulator or a physical Android device (with USB Debugging enabled)

### Installation & Setup

1.  **Clone the repository:**
    