package fr.uphf.questease.controller;

import fr.uphf.questease.model.Utilisateur;
import fr.uphf.questease.service.UtilisateurServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller du repositoire d'Utilisateur
 */
@RestController
@RequestMapping("/utilisateur")
public class UtilisateurController {

    /**
     * Le repositoire d'Utilisateur
     */
    private final UtilisateurServiceImpl utilRepository;

    /**
     * Le constructeur d'UtilisateurController
     * @param utililisateurRepository Le repositoire d'Utilisateur
     */
    public UtilisateurController(UtilisateurServiceImpl utililisateurRepository) {
        utilRepository = utililisateurRepository;
    }
    /**
     * Méthode Get pour récupérer un Utilisateur via son nom
     * @param nameUtil Le nom de l'Utilisateur à trouver
     * @return L'Utilisateur à trouver
    **/
    @GetMapping("/{idUtil}")
    public ResponseEntity<Iterable<Utilisateur>> getUserByName(@PathVariable String nameUtil){
        return ResponseEntity.ok(utilRepository.fetchOne(nameUtil));
    }

    /**
     * Méthode Post permettant d'ajouter un Utilisateur à la base de donnée
     * @param idUtil L'utilisateur à ajouté à la base de donnée
    **/
    @PostMapping("/{idUtil}")
    public void postUser(@PathVariable Utilisateur idUtil){
        utilRepository.saveUtilisateur(idUtil);
    }

    /**
     * Méthode Update permettant de mettre à jour un Utilisateur dans la base de donnée
     * @param idUser L'id de L'Utilisateur à mettre à jour
     * @param util L'utilisateur qui sera mis à jour
    **/
    @PatchMapping("/{idUtil}")
    public void updateUser(Long idUser, @PathVariable Utilisateur util){
        utilRepository.deleteUtilisateur(idUser);
        utilRepository.saveUtilisateur(util);
    }

    /**
     * Méthode Delete permettant de supprimer un Utilisateur de la base de donnée
     * @param idUtil L'id de l'Utilisateur à supprimer de la base de donnée
    **/
    @DeleteMapping("/{idUtil}")
    public void deleteUser(@PathVariable Long idUtil){
        utilRepository.deleteUtilisateur(idUtil);
    }

    /**
     * Méthode GET qui renvoie tous les JoueurTmp de la base de données
     * @return une list de JoueurTmp
     */
    @GetMapping()
    public List<Utilisateur> getAllUserGet(){return utilRepository.fetchUtilisateurList();}

    /**
     * Méthode POST qui renvoie tous les joueurs de la base de données
     * @return une list de JoueurTmp
     */
    @PostMapping()
    public List<Utilisateur> getAllUserPost(){return utilRepository.fetchUtilisateurList();}

}
