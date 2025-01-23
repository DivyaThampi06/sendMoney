# Send Money Application

This is a dynamic **Send Money** application developed using **Jetpack Compose**, designed to provide a clean, intuitive, and responsive UI for transferring money. The project fulfills the requirements for parsing JSON dynamically, managing state, localization, validation, and error handling.

## Features

### 1. **Dynamic UI**
- Parses the provided JSON to dynamically generate the "Send Money" screen UI.
- Dynamically renders fields such as text fields, dropdowns, and other form elements based on the JSON structure.

### 2. **State Management**
- Uses Jetpack Compose's state management to store and manage user inputs and submitted requests efficiently.

### 3. **Localization**
- Supports both **English** and **Arabic** languages.
- Includes a language switcher that enables runtime toggling between the two languages.

### 4. **User Interface**
- Follows Android's design principles for navigation and layouts.
- Provides a clean and user-friendly experience with modern UI components.

### 5. **Validation**
- Implements validation for all form fields, including:
  - Regular expression (regex) validation.
  - Maximum length constraints.
  - Required fields.
- Displays user-friendly error messages for invalid inputs.

### 6. **Error Handling**
- Ensures robust error handling with descriptive messages to guide users.
- Highlights invalid fields for easy correction.

### 7. **Listing Submitted Requests**
- Provides a "View List" feature to display a list of all submitted requests.
- Each request is displayed with its respective field values in a structured format.

## Benefits of Jetpack Compose
- **Declarative UI**: Simplifies the creation of complex UIs with less boilerplate code.
- **Seamless State Management**: Manages UI state easily with Compose's state APIs.
- **Dynamic Rendering**: Allows dynamic rendering of fields and components based on external JSON.
- **Localization Support**: Enables runtime language switching efficiently.
- **Modern Design**: Provides a clean and responsive UI that adheres to Material Design guidelines.

## Prerequisites
- Android Studio Arctic Fox or later.
- Minimum SDK: 21 (Android 5.0 Lollipop).
- Kotlin 1.5 or later.
