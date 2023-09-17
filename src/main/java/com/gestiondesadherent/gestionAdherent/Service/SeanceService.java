package com.gestiondesadherent.gestionAdherent.Service;

import com.gestiondesadherent.gestionAdherent.SEANCE.Seance;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface SeanceService {

    Seance creer(Seance seance);

    List<Seance> lire();

    Optional<Seance> lireById(Long id);

    Seance modifier(Long id, Seance seance);

    String supprimer(Long id);
}
