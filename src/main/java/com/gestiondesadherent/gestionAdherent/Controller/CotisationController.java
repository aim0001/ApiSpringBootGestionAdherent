package com.gestiondesadherent.gestionAdherent.Controller;

import com.gestiondesadherent.gestionAdherent.ADHERENT.Adherent;
import com.gestiondesadherent.gestionAdherent.Repository.AdherentRepository;
import com.gestiondesadherent.gestionAdherent.Service.CotisationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cotisations")
@AllArgsConstructor
@Api(tags = "CotisationController", description = "API de gestion des adhérents")
public class CotisationController {
  private final CotisationService cotisationService;
  private final AdherentRepository adherentRepository;

    @GetMapping("/regulier/{adherentId}")
    @ApiOperation("Regulariter des Adherents")
    public ResponseEntity<String> verifierRegularite(@PathVariable Long adherentId) {
        boolean estRegulier = cotisationService.estAdherentRegulier(adherentId);

        if (estRegulier) {
            return ResponseEntity.ok("L'adhérent est régulier dans ses cotisations.");
        } else {
            return ResponseEntity.ok("L'adhérent n'est pas régulier dans ses cotisations.");
        }
    }
}

