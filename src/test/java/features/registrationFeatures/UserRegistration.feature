Feature: Création de compte client
  En tant qu'utilisateur,
  Je souhaite créer un compte client,
  Afin de gérer mes commandes et mes informations personnelles.
@tag3
  Scenario: Verifier la création réussie d'un compte client
    Given que je suis sur la page My Account
    When je remplis le formulaire de création de compte
    And je clique sur le bouton REGISTER
    Then le dashboard compte client est afficher avec signOut

