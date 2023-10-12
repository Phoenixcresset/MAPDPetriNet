# MAPDPetriNet

README pour l'utilisation du PetriNet


# Notes de conception

- Quelle est la différence entre weight et value ? J'ai l'impression qu'ils sont confondus dans l'énoncé, à demander aux profs.
- Est-ce qu'il nous faut garder tous les getters et setters ? Certains ne sont jamais utilisés et un peu obsolètes, normalement ils ne sont faits que quand on a besoin des valeurs dans une autre classe, à demander aussi.
- Jusqu'à où on pousse pour les erreurs ? Ca a l'air difficile et surtout fastidieux de toutes les faire
- Il faut faire des tests


# Grille d'Auto-évaluation

## Commentaires
- [x] Code écrit en anglais (nom de variables, méthodes, fonctions, classes, packages, etc.).
- [ ] Commentaires écrits dans une seule langue (commentaires en français = pour dialoguer tous les deux et donc à supprimer à terme).
- [x] Les commentaires (javadoc) des méthodes publiques en permettent la réutilisation.
- [ ] Il y a dans le code des commentaires à destination des mainteneurs.

## Style et conventions
- [x] Les indentations sont homogènes (utiliser Eclipse pour auto formatter).
- [x] La forme des noms respecte le style du language (CamelCase pour les variables, CAPITALES pour les constantes).
- [x] L'ordre des déclarations est toujours le même (attributs, constructeurs, setters et getters, méthodes).
- [x] Les noms sont porteurs de sens (je coche, tu me dis si certains te déplaisent).

## Modularité
- [x] Le paquetage racine ne contient directement aucune classe.
- [x] Le fichier package.info décrit le contenu et la responsabilité de chaque paquetage.
- [x] Chaque classe a une responsabilité de calcul et ne se limite pas à stocker des données.
- [x] Il n'y a pas d'attribut public (encapsulation).
- [x] Les méthodes ne sont pas trop longues (ex : 15 lignes).

## Sûreté
- [ ] Les méthodes se protègent (tests des paramètres, levée d'exception).
- [ ] Chaque méthode possède au moins un test.
- [ ] Les tests sont automatisés et s'enchainent pour vérifier la non-régression.

## Évolutivité / Maintenance
- [x] Les classes importées sont nommées explicitement.
- [x] Il n'y a pas de valeur utilisée sans être déclarée par une constante.
- [x] Le code est factorisé.
