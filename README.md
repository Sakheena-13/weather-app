Weather App

A simple Java Swing application that fetches and displays current weather information for any city using the OpenWeatherMap API.

Features

Enter a city name and get current weather details.

Displays:

Temperature (°C)

Humidity (%)

Weather description (e.g., clear sky, rain)

User-friendly GUI interface.

Screenshots

<img width="1528" height="917" alt="image" src="https://github.com/user-attachments/assets/5ccf3c84-38c2-4d27-a676-0b209a6a1c8a" />


Getting Started
Prerequisites

Java JDK installed (Java 8 or later)

JSON library (org.json JAR)

OpenWeatherMap API key

How to Compile and Run

<img width="715" height="348" alt="image" src="https://github.com/user-attachments/assets/36a8373a-2e43-43c4-b980-b93416c6e38c" />


Download or clone the repository.

Replace YOUR_API_KEY_HERE in WeatherApp.java with your OpenWeatherMap API key.

Compile the Java file (ensure json-20210307.jar is in the folder or classpath):

javac -cp .;json-20210307.jar WeatherApp.java


Run the application:

java -cp .;json-20210307.jar WeatherApp

Usage

Enter the city name.

Click Get Weather.

View the temperature, humidity, and weather description in the text area.

Project Structure
WeatherApp/
 ├─ WeatherApp.java          # Main Java source file
 ├─ json-20210307.jar        # JSON library
 └─ README.md                # Project documentation

Technologies Used

Java

Java Swing (GUI)

OpenWeatherMap API
