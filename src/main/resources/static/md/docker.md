# **_docker.md🐳_**

## 1. Avaa Docker Desktop manuaalisesti

- Avaa Docker Desktop sovellus omalla tietokoneellasi.

## 2. Tietokannan luominen Dockeriin 📦

- Suorita seuraava komento luodaksesi MySQL-tietokannan Dockerissa:

```bash
docker run --name FLOORHEATING-MYSQL -e MYSQL_ROOT_PASSWORD=FLOORHEATING-ROOT -e MYSQL_DATABASE=FLOORHEATING -e MYSQL_USER=FLOORHEATING-USER -e MYSQL_PASSWORD=FLOORHEATING-PASS -p 3307:3306 -d mysql:latest
```

## 3. Kontin hallinta 🔧

- Sammuta kontti:

```bash
  docker stop FLOORHEATING-MYSQL
```

- Käynnistä kontti:

```bash
  docker start FLOORHEATING-MYSQL
```

- Tarkista kontti:

```bash
  docker ps
```

- Poista kontti:

```bash
  docker rm FLOORHEATING-MYSQL
```
