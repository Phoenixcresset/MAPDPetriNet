# MAPDPetriNet

## Introduction
Ce projet est un modèle de PétriNet du groupe d'élève SREDNIAWA Florian et LAMBERTIN Jean-Baptiste dans le cadre de l'UE MAPD de deuxième année en TAF DCL d'IMT Atlantique.

## Utilisation

Afin d'utiliser le PétriNet, il faut créer les éléments , les ajouter avec le PetriNet avec les fonctions dans la classe associée, et ensuite utiliser la fonction linkPlaceWithTransition afin de créer les connections voulues.
Les transitions sont activables avec leur fonction step().
Afin de vérifier l'évolution du réseau, il est possible d'utiliser la fonction toString() du PetriNet pour une représentation plus graphique, ou toStringElements pour une approche plus exhaustive.
L'exécution des tests se fait en lançant JUnit dans Eclipse via Coverage As -> JUnit Test.

# Grille d'Auto-évaluation

## Commentaires
- [x] Code écrit en anglais (nom de variables, méthodes, fonctions, classes, packages, etc.).
- [x] Commentaires écrits dans une seule langue.
- [x] Les commentaires (javadoc) des méthodes publiques en permettent la réutilisation.
- [x] Il y a dans le code des commentaires à destination des mainteneurs.
- [x] Mise à disposition d'un main contenant du code montrant le fonctionnnement du reseau.  

## Style et conventions
- [x] Les indentations sont homogènes.
- [x] La forme des noms respecte le style du language (CamelCase pour les variables, CAPITALES pour les constantes).
- [x] L'ordre des déclarations est toujours le même (attributs, constructeurs, setters et getters, méthodes).
- [x] Les noms sont porteurs de sens.

## Modularité
- [x] Le paquetage racine ne contient directement aucune classe.
- [x] Le fichier package.info décrit le contenu et la responsabilité de chaque paquetage.
- [x] Chaque classe a une responsabilité de calcul et ne se limite pas à stocker des données.
- [x] Il n'y a pas d'attribut public (encapsulation).
- [x] Les méthodes ne sont pas trop longues (ex : 15 lignes).

## Sûreté
- [x] Les méthodes se protègent (tests des paramètres, levée d'exception).
- [x] Chaque méthode possède au moins un test.
- [x] Les tests sont automatisés et s'enchainent pour vérifier la non-régression.

## Évolutivité / Maintenance
- [x] Les classes importées sont nommées explicitement.
- [x] Il n'y a pas de valeur utilisée sans être déclarée par une constante.
- [x] Le code est factorisé.


# Changements de conception : cf document word associé
