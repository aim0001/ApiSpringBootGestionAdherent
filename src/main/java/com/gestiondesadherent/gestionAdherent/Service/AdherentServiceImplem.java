package com.gestiondesadherent.gestionAdherent.Service;

import com.gestiondesadherent.gestionAdherent.ADHERENT.Adherent;
import com.gestiondesadherent.gestionAdherent.Repository.AdherentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AdherentServiceImplem implements AdherentService{

private final AdherentRepository adherentRepository;
    @Override
    public Adherent creer(Adherent adherent) {
        return adherentRepository.save(adherent);
    }

    @Override
    public List<Adherent> lire() {
        return adherentRepository.findAll();
    }

    @Override
    public Optional<Adherent> affichage(Long id) {
        return adherentRepository.findById(id);
    }

    @Override
    public Adherent modifier(Long id, Adherent adherent) {
        return adherentRepository.findById(id)
                .map(a -> {
                        a.setName(adherent.getName());
                        return adherentRepository.save(a);
                }).orElseThrow(() -> new RuntimeException("Adherent non trouver !"));
    }

    @Override
    public String supprimer(Long id) {
        adherentRepository.deleteById(id);
        return "Adherent supprimer.";
    }
}
