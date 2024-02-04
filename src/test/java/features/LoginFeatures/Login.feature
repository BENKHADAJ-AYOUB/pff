Feature: Connexion au compte utilisateur
  En tant qu'utilisateur,
  Je souhaite me connecter à mon compte,
  Afin de gérer mes commandes et mes informations personnelles.

  Scenario: Verifier la connexion réussie avec un compte utilisateur
    Given que je suis sur la page My Account pour login
    When je saisis mon login et mon mot de passe
    And je clique sur le bouton LOGIN
    Then le Dashboard doit s'afficher pour login avec signOut
