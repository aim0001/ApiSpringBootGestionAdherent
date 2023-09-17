package com.gestiondesadherent.gestionAdherent.Controller;

import com.gestiondesadherent.gestionAdherent.PRESENCE.Presence;
import com.gestiondesadherent.gestionAdherent.Service.PresenceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Presence")
@Api(tags = "PresenceController", description = "API de gestion des adhérents")
public class PresenceController {

    private final PresenceService presenceService;

    @PostMapping("/creer")
    @ApiOperation("Ajout de presence")
    public Presence create(@RequestBody Presence presence){
        return presenceService.creer(presence);
    }

    @GetMapping("/affichage")
    @ApiOperation("Liste de presence")
    public List<Presence> read(){
        return presenceService.lire();
    }

    @GetMapping("/afficher/{id}")
    @ApiOperation("Affichage d'une presence specifique")
    public Presence getPresenceById(@PathVariable Long id){
        return presenceService.afficher(id);
    }

    @PutMapping("/modifier/{id}")
    @ApiOperation("Modifier la presence")
    public Presence update(@PathVariable Long id,@RequestBody Presence presence){
        return presenceService.modifier(id, presence);
    }

    @DeleteMapping("/supprimer/{id}")
    @ApiOperation("Supprimer une presence")
    public String delete(@PathVariable Long id){
        return presenceService.supprimer(id);
    }

//Jour de presence
    @GetMapping("/adherents/{adherentId}/jour_de_presence")
    @ApiOperation("Les jours de presence d un Adherent specifique")
    public List<Date> getJoursDePresence(@PathVariable Long adherentId) {
        // Appel au service pour récupérer les jours de présence de l'adhérent
        List<Date> joursDePresence = presenceService.getJoursDePresence(adherentId);
        return joursDePresence;
    }
//Nombre d'absence
    @GetMapping("/adherents/{adherentId}/nombre-absences")
    @ApiOperation(("Nombres d adsence d un Adherent specifique"))
    public int getNombreAbsences(@PathVariable Long adherentId, @RequestParam("dateDebut") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateDebut, @RequestParam("dateFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateFin) {
        // Calcul de nombre d'absences de l'adhérent
        int nombreAbsences = presenceService.getNombreAbsences(adherentId, dateDebut, dateFin);
        return nombreAbsences;
    }


}
