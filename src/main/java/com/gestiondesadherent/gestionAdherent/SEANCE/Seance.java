package com.gestiondesadherent.gestionAdherent.SEANCE;

import com.gestiondesadherent.gestionAdherent.ADHERENT.Adherent;
import com.gestiondesadherent.gestionAdherent.PRESENCE.Presence;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Seance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "adherent_id")
    private Adherent adherent;

}
