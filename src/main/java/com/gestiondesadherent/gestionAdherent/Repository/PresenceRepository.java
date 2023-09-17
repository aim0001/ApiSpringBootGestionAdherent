package com.gestiondesadherent.gestionAdherent.Repository;

import com.gestiondesadherent.gestionAdherent.PRESENCE.Presence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface PresenceRepository extends JpaRepository<Presence, Long> {
    List<Date> findDatesDePresenceByAdherentId(Long adherentId);

    int countAbsencesByAdherentIdAndDateBetween(Long adherentId, Date dateDebut, Date dateFin);
}
