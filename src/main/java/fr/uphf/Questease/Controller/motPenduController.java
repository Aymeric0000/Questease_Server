package fr.uphf.Questease.Controller;


import fr.uphf.Questease.Model.MotCryptex;
import fr.uphf.Questease.Model.MotPendu;
import fr.uphf.Questease.Repository.MotPenduRepository;
import fr.uphf.Questease.Service.MotCryptexServiceImpl;
import fr.uphf.Questease.Service.MotPenduServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controller du repositoire de motPendu
 */
@RestController
@RequestMapping("/motpendu")
public class motPenduController {

    /**
     * Le repositoire de motPendu
     */
    private final MotPenduServiceImpl repo;

    /**
     * Le constructeur de la classe motPenduController
     * @param repo Repositoire de la classe motPendu
     */
    public motPenduController(MotPenduServiceImpl repo) {
        this.repo = repo;
    }

    /**
     * Méthode Get permettant de récupérer un mot via son id
     * @param idMot L'id du mot à trouver lors d'un pendu
     * @return Le mot à trouver
     */
    @GetMapping("/{idMotPendu}")
    public Optional<MotPendu> getMotById(@PathVariable Long idMot) {
        return repo.FetchOne(idMot);
    }

    /**
     * Méthode Get permettant de récupérer tout les mots du Pendu
     * @return Une liste de tout les mots possibles du Pendu
     */
    @GetMapping()
    public List<MotPendu> getAllMotGet() {return repo.FetchMotPenduList();}

    /**
     * Méthode Post permettant d'ajouter un mot à la base de donnée
     * @param M Le mot à ajouter à la base de donnée
     */
    @PostMapping("/{idMotPendu}")
    public void PostMot(@PathVariable MotPendu M) {
        repo.SaveMotPendu(M);
    }

    /**
     * Méthode Update permettant de mettre à jour un mot dans la base de donnée
     * @param IdMotPendu L'id du mot à mettre à jour
     * @param M Le mot qui sera mis à jour
     */
    @PatchMapping("/{idMotPendu}")
    public void UpdateMot(Long IdMotPendu, @PathVariable MotPendu M) {
        repo.DeleteMotPendu(IdMotPendu);
        repo.SaveMotPendu(M);
    }

    /**
     * Méthode Delete permettant de supprimer un mot dans la base de donnée
     * @param idPendu L'id du mot dans la base de donnée à supprimer
     */
    @DeleteMapping("/{idMotPendu}")
    public void DeleteMot(@PathVariable Long idPendu) {
        repo.DeleteMotPendu(idPendu);
    }


}


