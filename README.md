# ApiSpringBootGestionAdherent
Les chemins
Controllers:
Gestion Adherent:
	Ajout: /Adherent/creer
	Afficher liste : /Adherent/affichage
	Afficher detail : /Adherent/afficher/{id}
	Mettre à jour : /Adherent/modifier/{id}
	Supprimer : /Adherent/supprimer/{id}
Gestion Seance:
	Ajout: /Seance/creer
	Afficher liste : /Seance/affichage
	Afficher detail : /Seance/afficher/{id}
	Mettre à jour : /Seance/modifier/{id}
	Supprimer : /Seance/supprimer/{id}
Gestion de Presence:
	Ajout: /Presence/creer
	Afficher liste : /Presence/affichage
	Afficher detail : /Presence/afficher/{id}
	Mettre à jour : /Presence/modifier/{id}
	Supprimer : /Presence/supprimer/{id}
	Jour de presence specifique d un Adherent: /Presence/adherents/{adherentId}/jour_de_presence
	Nombre d'absent : /Presence/adherents/{adherentId}/nombre-absences
Gestion de Cotisation:
	Regulariter des Adherents: /cotisation/regulier/adherentId
	
Deploiement: Pour deploier l'API aller à "gestionAdherent\target"  et ouvrir l'invite de commande à cette emplacement. tapez la commande "java -jar gestionAdherent-0.0.1-SNAPSHOT.jar".

Vous pouvez utilisez postman pour tester l'API.
