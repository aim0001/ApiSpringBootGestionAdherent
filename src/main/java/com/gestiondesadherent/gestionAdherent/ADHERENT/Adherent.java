package com.gestiondesadherent.gestionAdherent.ADHERENT;

import com.gestiondesadherent.gestionAdherent.COTISATION.Cotisation;
import com.gestiondesadherent.gestionAdherent.PRESENCE.Presence;
import com.gestiondesadherent.gestionAdherent.SEANCE.Seance;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Adherent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "adherent", cascade = CascadeType.ALL)
    private List<Presence> presences;

    @OneToMany(mappedBy = "adherent", cascade = CascadeType.ALL)
    private List<Seance> seances;

    @OneToMany(mappedBy = "adherent", cascade = CascadeType.ALL)
    private List<Cotisation> cotisations;

}
