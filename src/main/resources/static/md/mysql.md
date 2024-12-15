# **_mysql.md🐬_**

## 1. Yhteys MySQL-tietokantaan Dockerissa 🔗

- Ota yhteys MySQL-tietokantaan komentoriviltä seuraavalla komennolla:

```bash
mysql -h 127.0.0.1 -P 3307 -u FLOORHEATING-USER -p
```

- Kun sinua pyydetään, syötä salasana:

MYSQL_PASSWORD=FLOORHEATING-PASS

## 2. Tietokannan hallinta 📊

- Näytä tietokannat:

```bash
SHOW DATABASES;
```

- Käytä tietokantaa:

```bash
USE FLOORHEATING;
```

- Näytä taulut:

```bash
SHOW TABLES;
```

- Kuvauksen näyttäminen tauluista:

```bash
DESC cables;
```

- Näytä kaikki rivit taulusta:

```bash
SELECT * FROM cables;
```
