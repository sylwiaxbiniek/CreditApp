# CreditApp JAVA

[![Java CI](https://github.com/sylwiaxbiniek/ZadanieJava/workflows/Java%20CI/badge.svg)](https://github.com/sylwiaxbiniek/ZadanieJava/actions/)
[![Build Status](https://travis-ci.com/sylwiaxbiniek/ZadanieJava.svg?branch=master)](https://travis-ci.com/sylwiaxbiniek/ZadanieJava)
[![codecov](https://codecov.io/gh/sylwiaxbiniek/ZadanieJava/branch/master/graph/badge.svg)](https://codecov.io/gh/sylwiaxbiniek/ZadanieJava)

## Użycie aplikacji

Uruchomienie aplikacji nie wymaga wcześniejszego lokalnego budowania - wszystkie wymagane obrazy są dostępne do pobrania z internetu. Do uruchomienia aplikacji możemy wykorzystać docker-compose:

```bash
docker-compose up
```

od tego momentu możemy korzystać z usług CreateCredit oraz GetCredits które są wystawione pod adresem IP kontenera `credit`

Usługa CreateCredit może zostać wywołana przy pomocy zapytania POST:

```bash
curl -H "Content-Type: application/json" -d '{"customer":{"firstName":"Jan","pesel":"1234567890","surname":"Kowalski"},"product":{"productName":"samolot","value":1000000},"credit":{"creditName":"kredyt na samolot"}}' 172.19.0.3:8080/createCredit
```

Usługa GetCredits jest wywoływana zapytaniem GET:

```bash
curl 172.19.0.3:8080/getCredits
```

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
