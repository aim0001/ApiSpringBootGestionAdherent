package com.gestiondesadherent.gestionAdherent.Service;

import com.gestiondesadherent.gestionAdherent.PRESENCE.Presence;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface PresenceService {

    Presence creer(Presence presence);

    List<Presence> lire();

    Presence afficher(long id);

    Presence modifier(Long id, Presence presence);

    String supprimer(Long id);

    List<Date> getJoursDePresence(Long adherentId);

    int getNombreAbsences(Long adherentId, Date dateDebut, Date dateFin);
}
