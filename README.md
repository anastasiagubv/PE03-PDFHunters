# PE03 - PDF Hunters (Atac de força bruta)

Pràctica Entregable 03 — Programació de Serveis i Processos (DAM2)
Grup 4

## Objectiu

Desenvolupar una aplicació Java que recuperi contrasenyes d'accés a documents PDF
mitjançant diferents tècniques de cerca: força bruta, força bruta restringida per
patró, atac de diccionari i generació de variants.

## Estructura

```
PE03-PDFHunters/
├── pom.xml
└── src/
    └── main/
        ├── java/cat/escolapia/
        │   ├── Main.java              (menú principal)
        │   ├── PDFChecker.java        (obertura de PDFs protegits amb PDFBox)
        │   ├── BruteForce.java        (Missió 1 i 2)
        │   ├── DictionaryAttack.java  (Missió 3)
        │   ├── PasswordVariants.java  (Missió 4)
        │   └── Statistics.java        (Missió 5 - estadístiques)
        └── resources/
            ├── diccionari.txt
            └── documents/             (PDFs protegits proporcionats pel professor)
```

## Missions

1. **PIN BREAKER** — contrasenya numèrica de 4 dígits (0000-9999).
2. **ALPHANUMERIC HUNTER** — contrasenya amb patró restringit `C?NNNN`.
3. **DICTIONARY ATTACK** — cerca mitjançant un fitxer de diccionari.
4. **FINAL BOSS** — diccionari + generació de variants.
5. **ESTADÍSTIQUES** — comparativa de temps, intents i velocitat de cada missió.

## Execució

```bash
mvn clean package
java -jar target/PDFHunters-1.0-SNAPSHOT.jar
```

## Estat

Esquelet del projecte Maven creat i dependència de PDFBox 3.0.8 configurada.
Classes i mètodes pendents d'implementar per missió (veure `TODO` a cada classe).
