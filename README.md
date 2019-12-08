# Zadanie ewaluacyjne JAVA

[![Java CI](https://github.com/sylwiaxbiniek/ZadanieJava/workflows/Java%20CI/badge.svg)](https://github.com/sylwiaxbiniek/ZadanieJava/actions/)
[![Build Status](https://travis-ci.com/sylwiaxbiniek/ZadanieJava.svg?branch=master)](https://travis-ci.com/sylwiaxbiniek/ZadanieJava)
[![codecov](https://codecov.io/gh/sylwiaxbiniek/ZadanieJava/branch/master/graph/badge.svg)](https://codecov.io/gh/sylwiaxbiniek/ZadanieJava)

## Budowanie

Obrazy dockerowe zawierające poszczególne aplikacje można zbudować wykorzystując Maven Wrapper który nie wymaga wcześniejszej instalacji:

```bash
./mvnw package
```

lub zainstalowanej już w systemie wersji Apache Maven:

```bash
mvn package
```

Wynikiem procesu budowania są trzy obrazy:

* docker.pkg.github.com/sylwiaxbiniek/zadaniejava/credit
* docker.pkg.github.com/sylwiaxbiniek/zadaniejava/customer   
* docker.pkg.github.com/sylwiaxbiniek/zadaniejava/product  

Budowanie obrazów jest jednym z kroków Java CI. Następnie są one wypychane do repozytorium [GitHub Packages](https://github.com/sylwiaxbiniek/ZadanieJava/packages).

## Testy

Testy można uruchomić używając polecenia:

```bash
./mvnw test
```

Testy zostały napisane w oparciu o framework JUnit 5. Pokrycie kodu testami jest mierzone przy wykorzystaniu pluginu jacoco. Raport z pokrycia kodu jest publikowany na stronie [codecov.io](https://codecov.io/gh/sylwiaxbiniek/ZadanieJava)

## Continuous integration

Projekt został zintegrowany z Travisem oraz GitHub Actions. Aktualny stan budowania jest symbolizowany przez badge na początku README. Dodatkowo umieszczona została informacja o aktualnym procentowym pokryciu kodu testami.
