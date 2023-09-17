package com.gestiondesadherent.gestionAdherent.Service;

import com.gestiondesadherent.gestionAdherent.ADHERENT.Adherent;
import com.gestiondesadherent.gestionAdherent.PRESENCE.Presence;
import com.gestiondesadherent.gestionAdherent.Repository.AdherentRepository;
import com.gestiondesadherent.gestionAdherent.Repository.PresenceRepository;
import com.gestiondesadherent.gestionAdherent.Repository.SeanceRepository;
import com.gestiondesadherent.gestionAdherent.SEANCE.Seance;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PresenceServiceImplem implements PresenceService {

    private final PresenceRepository presenceRepository;
    private final AdherentRepository adherentRepository;
    private final SeanceRepository seanceRepository;

    @Override
    public Presence creer(Presence presence) {
        Optional<Adherent> adherent = adherentRepository.findById(presence.getAdherent().getId());
        Optional<Seance> seance = seanceRepository.findById(presence.getSeance().getId());

        if (adherent.isPresent() && seance.isPresent()) {
            return presenceRepository.save(presence);
        } else {
            throw new IllegalArgumentException("Adhérent ou séance introuvable.");
        }

    }

    @Override
    public List<Presence> lire() {
        return presenceRepository.findAll();
    }

    @Override
    public Presence afficher(long id) {
        return presenceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Présence introuvable"));

    }

    @Override
    public Presence modifier(Long id, Presence presence) {
        Presence existingPresence = presenceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Présence introuvable"));
        ;

        // Mise à jour de la date de présence, si nécessaire
        existingPresence.setDate(presence.getDate());

        // Vous pouvez ajouter d'autres mises à jour ici si nécessaire

        return presenceRepository.save(existingPresence);
    }

    @Override
    public String supprimer(Long id) {
        presenceRepository.deleteById(id);
        return "Suppression reussie";
    }

    // interrogation à la base de données grace au repository et récupérer les dates de présence
    public List<Date> getJoursDePresence(Long adherentId) {

        List<Date> joursDePresence = presenceRepository.findDatesDePresenceByAdherentId(adherentId);
        return joursDePresence;
    }

    public int getNombreAbsences(Long adherentId, Date dateDebut, Date dateFin) {
        // Utilisez le repository pour compter le nombre d'absences de l'adhérent dans la plage de dates spécifiée
        int nombreAbsences = presenceRepository.countAbsencesByAdherentIdAndDateBetween(adherentId, dateDebut, dateFin);
        return nombreAbsences;
    }


}
