package com.gestiondesadherent.gestionAdherent.Service;

import com.gestiondesadherent.gestionAdherent.ADHERENT.Adherent;
import com.gestiondesadherent.gestionAdherent.Repository.AdherentRepository;
import com.gestiondesadherent.gestionAdherent.Repository.SeanceRepository;
import com.gestiondesadherent.gestionAdherent.SEANCE.Seance;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SeanceServiceImplem implements SeanceService{

    private final SeanceRepository seanceRepository;
    private final AdherentRepository adherentRepository;
    @Override
    public Seance creer(Seance seance) {
        Optional<Adherent> adherent = adherentRepository.findById(seance.getAdherent().getId());

        if (adherent.isPresent()){
            return seanceRepository.save(seance);
        }else {
            throw new IllegalArgumentException("L'Adhérent n'existe pas.");
        }
    }

    @Override
    public List<Seance> lire() {
        return seanceRepository.findAll();
    }

    @Override
    public Optional<Seance> lireById(Long id) {
        return seanceRepository.findById(id);
    }

    @Override
    public Seance modifier(Long id, Seance seance) {
        return seanceRepository.findById(id)
                .map(s->{
                    s.setAdherent(seance.getAdherent());
                    return seanceRepository.save(s);
                }).orElseThrow(() -> new RuntimeException("La seance n'existe pas dans le bdd !"));
    }

    @Override
    public String supprimer(Long id) {
         seanceRepository.deleteById(id);
        return "Seance supprimer !";
    }
}
