# Zadanie ewaluacyjne JAVA

[![Java CI](https://github.com/sylwiaxbiniek/ZadanieJava/workflows/Java%20CI/badge.svg)](https://github.com/sylwiaxbiniek/ZadanieJava/actions/new)
[![Build Status](https://travis-ci.com/sylwiaxbiniek/ZadanieJava.svg?branch=master)](https://travis-ci.com/sylwiaxbiniek/ZadanieJava)
[![codecov](https://codecov.io/gh/sylwiaxbiniek/ZadanieJava/branch/master/graph/badge.svg)](https://codecov.io/gh/sylwiaxbiniek/ZadanieJava)

## Budowanie

Projekt można zbudować używając zainstalowanej już wersji Apache Maven:

```bash
mvn clean install
```

lub wykorzystując Maven Wrapper który nie wymaga wcześniejszej instalacji:

```bash
./mvnw clean install
```

## Testy

Testy jednostkowe zostały napisane w oparciu o framework JUnit 5. Pokrycie kodu testami jest mierzone przy wykorzystaniu pluginu jacoco. Raport z pokrycia kodu jest publikowany na stronie [codecov.io](https://codecov.io/gh/sylwiaxbiniek/ZadanieJava)

## Continuous integration

Projekt został zintegrowany z Travisem. Aktualny stan budowania jest symbolizowany przez badge na początku README. Dodatkowo umieszczona została informacja o aktualnym procentowym pokryciu kodu testami.
