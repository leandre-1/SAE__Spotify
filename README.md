# Exploration et Analyse de Données Musicales (Spotify) — SAÉ 1.02

Application console en Java développée dans le cadre de la **SAÉ 1.02 : Comparaison d'approches algorithmiques** (BUT Informatique 1ère année — IUT de Laval / Le Mans Université).

Ce projet a pour objectif d'explorer un jeu de données massives (jusqu'à **438 948 titres**) issu de l'Open Data Spotify, tout en analysant et en comparant les performances pratiques et les complexités théoriques de différentes structures de données et algorithmes.

---

## Fonctionnalités

- **Chargement dynamique des données :** Prise en charge de fichiers CSV de différentes tailles (100, 1 000, 10 000, 100 000 et 438 948 titres).
- **Filtrage :**
  - Filtre manuel linéaire par année.
  - Filtre optimisé Java (`removeIf` avec expressions Lambda) par année, artiste, album ou titre.
- **Tri multi-critères :**
  - **Tri Sélection** (sur la popularité, optimisé avec `ListIterator`).
  - **Tri Fusion** (avec tableau temporaire).
  - **Tri Java** (TimSort natif via `Collections.sort`).
- **Recherche :**
  - Recherche linéaire.
  - Recherche dichotomique (sur liste préalable triée).
- **Sauvegarde des requêtes (Optionnel) :** Export au format texte (CSV) et au format binaire (sérialisation d'objets Java).

---

## Étude Comparative et Performances

L'un des objectifs majeurs du projet est la réalisation d'un benchmark comparatif entre deux implémentations de l'interface `List` :
- **`ArrayList`** (Accès direct rapide, réallocation mémoire).
- **`LinkedList`** (Parcours par pointeurs, insertions/suppressions dynamiques).

Les temps d'exécution mesurés ont été confrontés aux complexités théoriques temporelles ($O(n)$, $O(n \log n)$, $O(n^2)$) et spatiales.

---

## Technologies et Outils

- **Langage :** Java 8+ (Mode console)
- **Environnement de développement :** Eclipse
- **Concepts POO & Java :** Collections (`ArrayList`, `LinkedList`), Iterators (`ListIterator`), Lambda / Predicates, API `java.time` (`LocalDate`), Sérialisation
- **Gestion de version :** Git & GitHub

---

## Structure du Projet
.
├── AppliMusique.java     # Classe principale (Menu console et traitements)
├── Musique.java          # Classe métier représentant une chanson
├── SAE_spotify.iml       # Fichier de configuration du projet (IntelliJ)
├── spotify_100.csv       # Jeu de données (100 musiques)
├── spotify_1000.csv      # Jeu de données (1 000 musiques)
├── spotify_10000.csv     # Jeu de données (10 000 musiques)
├── spotify_100000.csv    # Jeu de données (100 000 musiques)
└── README.md             # Documentation du projet
