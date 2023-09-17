package com.gestiondesadherent.gestionAdherent.Controller;

import com.gestiondesadherent.gestionAdherent.SEANCE.Seance;
import com.gestiondesadherent.gestionAdherent.Service.SeanceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/Seance")
@Api(tags = "SeanceController", description = "API de gestion des adhérents")
public class SeanceController {

    private final SeanceService seanceService;

    @PostMapping("/creer")
    @ApiOperation("Ajout d'une seance")
    public Seance create(@RequestBody Seance seance){
        return seanceService.creer(seance);
    }

    @GetMapping("/affichage")
    @ApiOperation("Liste des seances")
    public List<Seance> read(){
        return seanceService.lire();
    }

    @GetMapping("/afficher/{id}")
    @ApiOperation("Detail d une seance")
    public Optional<Seance> readById(@PathVariable Long id){
        return seanceService.lireById(id);
    }

    @PutMapping("/modifier/{id}")
    @ApiOperation("Modifier une seance")
    public Seance update(@PathVariable Long id, @RequestBody Seance seance){
        return seanceService.modifier(id, seance);
    }

    @DeleteMapping("/supprimer/{id}")
    @ApiOperation("Spprimer une seance")
    public String delete(@PathVariable Long id){
        return seanceService.supprimer(id);
    }
}
