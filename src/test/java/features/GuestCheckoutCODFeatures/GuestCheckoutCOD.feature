@POECSOFT23-810
Feature: Vérifier qu'un guest peux commander consulter et finaliser l'achat dans son panier avec paiement en espèces à la livraison
  En tant qu'utilisateur GUEST,
  Je souhaite commander consulter mon panier et finaliser mon achat
  Afin de procéder au paiement en espèces à la livraison

  @POECSOFT23-806 @tchach
  Scenario: Vérifier qu'un guest peux commander consulter et finaliser l'achat dans son panier avec paiement en espèces à la livraison
    Given que je suis sur le shop
    And que j'ai ajouté des articles à mon panier
    When je navigue vers la page du panier
    Then je devrais voir un récapitulatif des articles
    When je modifie la quantité d'un article
    And je clique sur le bouton de mise à jour
    Then la quantité et le prix de l'article devrait être mise à jour
    When je clique sur le bouton Proceed to Checkout
    Then je devrais être redirigé vers la page Checkout pour remplir le formulaire
    And je sélectionne l'option de paiement Cash on Delivery
    And je confirme la commande
    Then La page détails commande va safficher et je verifie par le numéro de command
