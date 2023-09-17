package com.gestiondesadherent.gestionAdherent.Service;

import com.gestiondesadherent.gestionAdherent.ADHERENT.Adherent;

public interface CotisationService {

    public void enregistrerPaiement(Adherent adherent, double montant);

    public boolean estRegulier(Adherent adherent);

    boolean estAdherentRegulier(Long adherentId);
}
