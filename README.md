# Kiosk Order System
## Overview
This project demonstrates an object-oriented programming approach to building a Kiosk Order System for a coffee shop. The system allows users to order various menu items, manage their selections, and proceed with payment or cancellation actions. The implementation also includes threading to enhance functionality by tracking the duration of an active session.

## Features
### 1. Menu Management
- Add items to the order using the "+" button.
- Items appear in the order list with their quantities.
- The confirm button resets the quantity of the selected items to zero and deactivates the button.

### 2. Payment System
- Pay button:
  - Displays a dialog with order details and total cost.
  - Users can confirm payment (via the "YES" button) or return to the menu selection (via the "NO" button).

### 3. Order Cancellation
- Reset button:
  - Clears all items added to the order.
- Selected button:
  - Displays a dialog confirming if the user wishes to cancel the order.
  - Provides options to either proceed with cancellation or return to the menu.
 
### 4. Timer Integration
- A multithreaded feature tracks and displays the elapsed time during the ordering process.

## Class Structure
The application is divided into several Java classes, each responsible for specific functionalities:

- InnerFrameOrder.java: Handles the main order interface.
- OrderDialog.java: Manages dialogs for order confirmation and payment.
- OrderCall.java: Coordinates order processes.
- TimerThread.java: Implements the timer functionality using threads.
- ThreadTimerex.java: Demonstrates thread execution for timing.
- CoffeeMenu.java: Defines the menu items and their properties.
- CoffeeMain.java: Main class for launching the application.

## Key Screens
- Add items:
  - Example: Adding two Americanos updates the order list.
- Payment Dialog:
  - Options to proceed with payment (YES) or cancel (NO).
- Reset Orders:
  - Clears the current order and resets the interface.
- Cancel Selected Orders:
  - Displays a dialog to confirm or cancel the selected order.

## Advantages
- Successfully implemented a kiosk-like system to manage orders and calculate total costs.
- Introduced multithreading to track order durations.

## Improvement
- Extend the timer functionality to automatically reset the menu after a specified duration.

## Dependencies

- Java SE: Ensure a Java development environment is installed.
- Image Assets:
  - americano.jpg
  - chocosm.jpg
  - strawsm.jpg
  - bananasm.jpg
  - mocha.jpg
  - espresso.jpg
  - cappuccino.jpg
  - cafelatte.jpg
  - pay.png
  - reset.png
  - selected.jpg

## How to Run
- Compile all Java files in the project directory.
- Execute CoffeeMain.java to launch the application.
- Interact with the interface to simulate the kiosk's features.

