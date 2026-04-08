# TP Panneaux — Application Android avec Fragments

## Description

Application Android démontrant l'utilisation des Fragments pour créer une interface
dynamique à deux panneaux. L'utilisateur peut naviguer entre deux fragments distincts
et interagir avec chacun d'eux (message personnalisé et curseur de niveau).

---

## Fonctionnalités

- Navigation entre deux panneaux via des boutons
- Panneau A : Bouton "Me saluer" qui affiche un message de bienvenue
- Panneau B : Curseur (SeekBar) de 0 à 100 avec affichage en temps réel
- Gestion de l'état : conservation du niveau après rotation de l'écran
- Navigation retour avec la pile de fragments (bouton "Retour" système)
<img width="345" height="769" alt="image" src="https://github.com/user-attachments/assets/6c7259b4-fedc-4119-a6ef-2adaa6cc0a40" />
<img width="341" height="767" alt="image" src="https://github.com/user-attachments/assets/9d509fe4-993a-4c4f-9eef-5d43ebce1ec4" />
---

## Fichiers principaux

### `activity_main.xml`

Layout principal contenant :

| Composant | ID | Rôle |
|---|---|---|
| `Button` | `btnPanneauA` | Affiche le Panneau A |
| `Button` | `btnPanneauB` | Affiche le Panneau B |
| `FrameLayout` | `panneau_container` | Conteneur dynamique pour les fragments |

### `fragment_panneau_a.xml`

Layout du Panneau A :

| Composant | ID | Rôle |
|---|---|---|
| `TextView` | `texteA` | Affiche le titre et le message |
| `Button` | `btnSaluer` | Déclenche le message de bienvenue |

### `PanneauA.java`

Logique du Panneau A :

- `onViewCreated()` : initialisation des vues
- `setOnClickListener()` : change le texte du TextView lors du clic
- `onResume()` / `onPause()` : logs pour tracer le cycle de vie

### `fragment_panneau_b.xml`

Layout du Panneau B :

| Composant | ID | Rôle |
|---|---|---|
| `TextView` | `texteB` | Affiche la valeur du niveau |
| `SeekBar` | `sliderNiveau` | Curseur permettant de choisir un niveau (0-100) |

### `PanneauB.java`

Logique du Panneau B :

- `onViewCreated()` : initialisation des vues
- `onProgressChanged()` : met à jour l'affichage quand le curseur bouge
- `onSaveInstanceState()` : sauvegarde la valeur du niveau
- `onViewCreated()` + `savedInstanceState` : restauration de l'état après rotation

### `MainActivity.java`

Logique principale :

| Méthode | Rôle |
|---|---|
| `onCreate()` | Initialise les boutons et affiche Panneau A par défaut |
| `chargerPanneau()` | Remplace le fragment dans le conteneur |
| `addToBackStack()` | Permet de revenir en arrière avec le bouton système |

---

## Concepts utilisés

| Concept | Description |
|---|---|
| `Fragment` | Composant réutilisable représentant une partie de l'interface |
| `FragmentManager` | Gère les fragments (ajout, remplacement, suppression) |
| `FragmentTransaction` | Effectue les opérations sur les fragments |
| `FrameLayout` | Conteneur simple pour accueillir les fragments |
| `replace()` | Remplace le fragment actuel par un nouveau |
| `addToBackStack()` | Ajoute la transaction à la pile pour navigation retour |
| `SeekBar` | Curseur permettant à l'utilisateur de choisir une valeur |
| `OnSeekBarChangeListener` | Écoute les changements du curseur |
| `onSaveInstanceState()` | Sauvegarde l'état du fragment avant destruction |
| `onViewCreated()` | Appelé après la création des vues du fragment |
| Cycle de vie des fragments | `onResume()`, `onPause()` pour tracer l'état |

---

## Environnement

- **IDE** : Android Studio
- **Langage** : Java
- **API cible** : 36.1
- **Émulateur** : Medium Phone API 36.1

---
