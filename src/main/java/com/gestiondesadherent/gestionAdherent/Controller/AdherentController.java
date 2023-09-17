package com.gestiondesadherent.gestionAdherent.Controller;

import com.gestiondesadherent.gestionAdherent.ADHERENT.Adherent;
import com.gestiondesadherent.gestionAdherent.Service.AdherentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/Adherent")
@Api(tags = "AdherentController", description = "API de gestion des adhérents")
public class AdherentController {

    private final AdherentService adherentService;

    @PostMapping("/creer")
    @ApiOperation("Ajout de l'Adherent")
    public ResponseEntity<?> create(@RequestBody Adherent adherent){
        try {
            return ResponseEntity.ok(adherentService.creer(adherent));
        } catch (DataIntegrityViolationException e) {
            // Erreur de violation d'unicité (adherent déjà existant)
            return ResponseEntity.badRequest().body("l'adhérent existe déjà.");
        }
    }

    @GetMapping("/affichage")
    @ApiOperation("Liste des Adherent")
    public List<Adherent> read(){

        return adherentService.lire();
    }

    @GetMapping("/afficher/{id}")
    @ApiOperation("Detail d un Adherent")
    public Optional<Adherent> readAdherent(@PathVariable Long id){

        return adherentService.affichage(id);
    }

    @PutMapping("/modifier/{id}")
    @ApiOperation("Mise a jour d un Adherent")
    public Adherent update(@PathVariable Long id,@RequestBody Adherent adherent){

        return adherentService.modifier(id, adherent);
    }

    @DeleteMapping("/supprimer/{id}")
    @ApiOperation("Suppresion d un Adherent")
    public String delete(@PathVariable Long id){

        return adherentService.supprimer(id);
    }
}
