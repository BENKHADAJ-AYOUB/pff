@POECSOFT23-814
Feature: vérifier qu'un utilisateur peut modifier la quantité d'un produit ajouter au panier puis le supprimer
  En tant qu'utilisateur,
    Je souhaite modifier supprimer mon panier

  @POECSOFT23-808 @tchach
  Scenario: vérifier qu'un utilisateur peut modifier la quantité d'un produit ajouter au panier puis le supprimer
    Given que je suis sur le shop pour updateDelete
    And que j'ai ajouté des articles à mon panier pour updateDelete
    When je navigue vers la page du panier pour updateDelete
    Then je devrais voir un récapitulatif des articles pour updateDelete
    When je modifie la quantité d'un article pour updateDelete
    And je clique sur le bouton de mise à jour pour updateDelete
    Then la quantité et le prix de l'article devrait être mise à jour pour updateDelete
    When je clique sur l'icon X remove pour updateDelete
    Then le message Your basket is currently empty est afficher  pour updateDelete