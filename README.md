
# wastless

# Gestion d'offre

## Météo de la semaine 
Notre application offre la possibilité de consulter la météo, qui faite par une méthode ***GET***, on utilise la route ***Weather***.

**Exemple :** /Weather

## Faire une recherche d'offre
La recherche d'une offre qui faite par une méthode ***GET*** , on utilise la route ***OfferSearch***.
Cette route contient options suivante :

 - **ProductName** qui nous permet de sélectionner une offre par nom.
 - **Page** ce champ nous sera utile pour passer d'une page à une autre facilement.

 **Exemple :** /OfferSearch?ProductName=IPhone&Page=2
 
## Consulter les détails d'une offre
Cette méthode est faite par une méthode ***GET*** , on utilise la route ***OfferConsult***.
Cette route contient l'option suivante :

 - **ProductId** ce champ indique l'offre qu'on veut récuperer les détail *CE CHAMP EST OBLIGATOIRE* .

 **Exemple :** /OfferConsult?ProductId=2
