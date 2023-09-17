package com.gestiondesadherent.gestionAdherent.COTISATION;

import com.gestiondesadherent.gestionAdherent.ADHERENT.Adherent;
import jdk.jfr.Enabled;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Cotisation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "adherent_id")
    private Adherent adherent;

    @Temporal(TemporalType.DATE)
    private Date datePaiement;

    private double montant;
}
