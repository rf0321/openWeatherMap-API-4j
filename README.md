[![Build Status](https://travis-ci.org/ItinoseSan/openWeatherMap-API-4j.svg?branch=master)](https://travis-ci.org/ItinoseSan/openWeatherMap-API-4j)
# OpenWeatherMap4j
Java API wrapper of openweathermap.org which is released under the MIT Licence
# Usage
Its simple:)
```java
OpenWeatherMap4j openWeatherMap4j = new OpenWeatherMap4j("Your API key");
```
get current weather infomation. response is json
```java
openWeatherMap4j.getCurrentWeather("London");
```
get 5days weather forecast. 
```java
openWeatherMap4j.getWeatherForeCast("London");
```
# Reason not to parse json
Parse or dont parse, I got lost about this.But I thought that black value to user is not good. So I didnt parse.
# Contributing
Im waiting your contributing.
# Location of the Weather
Im using openweathermap.org reference about location.
