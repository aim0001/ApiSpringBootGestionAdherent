package com.gestiondesadherent.gestionAdherent.Service;

import com.gestiondesadherent.gestionAdherent.ADHERENT.Adherent;
import com.gestiondesadherent.gestionAdherent.COTISATION.Cotisation;
import com.gestiondesadherent.gestionAdherent.Repository.CotisationRepository;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class CotisationServiceImplem implements CotisationService{

    private final CotisationRepository cotisationRepository;
    @Override
    public void enregistrerPaiement(Adherent adherent, double montant) {

        Cotisation cotisation = new Cotisation();
        cotisation.setAdherent(adherent);
        cotisation.setDatePaiement(new Date()); // Date actuelle
        cotisation.setMontant(montant);
        cotisationRepository.save(cotisation);
    }

    @Override
    public boolean estRegulier(Adherent adherent) {
        // Définir la fréquence de cotisation (par exemple, mensuelle)
        int frequenceAttendue = 1; // Une fois par mois

        // Récupérer les paiements de l'adhérent
        List<Cotisation> paiements = cotisationRepository.findByAdherent(adherent);

        // Calculer la fréquence réelle des paiements
        int paiementsActuels = paiements.size();

        return paiementsActuels >= frequenceAttendue;
    }

    public boolean estAdherentRegulier(Long adherentId) {
        // Récupérer les cotisations de l'adhérent à partir de la base de données
        List<Cotisation> cotisations = cotisationRepository.findByAdherentId(adherentId);

        // Définir la fréquence de cotisation attendue (par exemple, mensuelle)
        int frequenceAttendue = 1; // Une fois par mois

        // Vérifier la régularité en fonction de la fréquence attendue
        if (cotisations.size() >= frequenceAttendue) {
            return true; // Adhérent régulier
        } else {
            return false; // Adhérent non régulier
        }
    }
}
