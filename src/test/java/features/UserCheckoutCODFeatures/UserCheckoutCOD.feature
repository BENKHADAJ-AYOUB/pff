Feature: commander Consulter et finaliser l'achat dans mon panier avec paiement en espèces à la livraison

  En tant GUEST,
  Je souhaite commander consulter mon panier et finaliser mon achat
  Afin de procéder au paiement en espèces à la livraison
@tag4
  Scenario: Commander consulter le panier et finaliser l'achat avec paiement en espèces à la livraison en tant que User
    Given que je suis sur le shop pour USER
    And que j'ai ajouté des articles à mon panier pour USER
    When je navigue vers la page du panier pour USER
    Then je devrais voir un récapitulatif des articles pour USER
    When je modifie la quantité d'un article pour USER
    And je clique sur le bouton de mise à jour pour USER
    Then la quantité et le prix de l'article devrait être mise à jour pour USER
    When je clique sur le bouton Proceed to Checkout pour USER
    Then je devrais être redirigé vers la page Checkout pour remplir le formulaire pour USER
    And je sélectionne l'option de paiement Cash on Delivery pour USER
    And je confirme la commande pour USER
    Then La page détails commande va safficher et je verifie par le numéro de commande et lurl pour USER