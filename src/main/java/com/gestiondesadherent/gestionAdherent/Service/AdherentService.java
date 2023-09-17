package com.gestiondesadherent.gestionAdherent.Service;

import com.gestiondesadherent.gestionAdherent.ADHERENT.Adherent;

import java.util.List;
import java.util.Optional;

public interface AdherentService {

    Adherent creer(Adherent adherent);

    List<Adherent> lire();

    Optional<Adherent> affichage(Long id);

    Adherent modifier(Long id, Adherent adherent);

    String supprimer(Long id);
}
