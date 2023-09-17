package com.gestiondesadherent.gestionAdherent.Repository;

import com.gestiondesadherent.gestionAdherent.ADHERENT.Adherent;
import com.gestiondesadherent.gestionAdherent.COTISATION.Cotisation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CotisationRepository extends JpaRepository<Cotisation, Long> {
    List<Cotisation> findByAdherent(Adherent adherent);

    List<Cotisation> findByAdherentId(Long adherentId);
}
