# SadaPay Case Study

## Objective
The goal of this assignment is to build a simple single-screen app that shows the current
trending Github repositories fetched from a public API. The design and business
specifications have been provided below.
We have deliberately kept the app simple enough for everyone to attempt it but we are keen to see the approach you take to solve it. You have the freedom to give your best to it and demonstrate your skills for us to evaluate you better.
You should approach this problem as if you are building an MVP app for our production users
- the process you follow and the things you should consider should reflect how you would
approach this solution if you were to be working for us on something we are going to release
to customers.


## App Requirements

- Please complete using either:
iOS using Swift as the development language and supporting min iOS-13
or Android using Kotlin as the development language and supporting min API level 21 (Lollipop)
- Use Git as you would on a normal production project to show code history and
development
- The app should fetch the trending repositories from the provided public API and display it to the users
- Assume API calls have a cost per call and that in general, slightly stale data is ok - but users should be able to see current data when required.
- Shimmer animation on the table cell while API is fetching
- Dark mode support (for bonus points)

## API Gateway

You need to fetch the data from the following endpoint.[Github Repositories](
https://api.github.com/search/repositories?q=language=+sort:stars ).

## Structure
###### Base Package includes all the base classes:
- Base Activity
- Base Fragment
- Base Adapter
- Base for Usecase Layer
- Base for mappers

###### Feature Package includes:
- Home Feature
> Includes Data, Domain, and Presentation Layer
## Data Layer
- Contains response POJOS
- Contains UI Data Mappers

## Presentation Layer
- Contains Fragments
- Contains View Models

## Domain Layer
- Contains Use cases
- Contains Repositories

## DI
- Contains Dependency Injection modules for a certain package
> Note: Common DI has separate package of DI which contains Managers and 
Singleton Components
## Utils
Util package contains:
 - General Extensions
- Network Extensions
- View Extensions
- Constants
- Binding Adapters
> Note: Binding adapters of a certain feature are inside it's presentation layer

## Testing

This case study includes Unit tests as well as Instrumentation tests

Frameworks used for testing
- Mockito
- JUnit
- Espresso etc. 
>Note: Debug package is added to it for testing UI with Hilt which includes HiltTestActivity, Custom Test Runner, Debug Manifest 

## License
[MIT](https://github.com/Syedovaiss/sada-pay-case-study/blob/master/LICENSE)
