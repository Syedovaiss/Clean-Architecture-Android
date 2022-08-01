

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
