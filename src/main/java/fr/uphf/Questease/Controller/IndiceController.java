package fr.uphf.Questease.Controller;

import fr.uphf.Questease.Model.Indice;
import fr.uphf.Questease.Repository.IndiceRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Controller du repositoire d'IndiceRepositoire
 */
@RestController
@RequestMapping
public class IndiceController {

    /**
     * Le repositoire de la classe Indice
     */
    private final IndiceRepository repo;

    /**
     * Constructeur de la classe IndiceController
     * @param repo Le repositoire de la classe Indice
     */
    public IndiceController(IndiceRepository repo) {
        this.repo = repo;
    }

    /**
     * Méthode Get permettant de récupérer un indice grâce à son Id
     * @param idIndice L'id de l'indice à récupérer
     * @return L'indice qui possède l'id précedemment mentionné
     */
    @GetMapping("/idIndice")
    public Optional<Indice> getIndiceById(@PathVariable Long idIndice) {
        return repo.findById(idIndice);
    }

    /**
     * Méthode Post permettant d'ajouter à la base de donnée un indice
     * @param I L'indice à ajouter à la base de donnée
     */
    @PostMapping("/{idIndice}")
    public void PostIndice(@PathVariable Indice I) {
        repo.save(I);
    }

    /**
     * Méthode Update permettant de mettre à jour un indice de la base de donnée
     * @param IdIndice L'id de l'indice à mettre à jour
     * @param I L'indice qui remplacera celui mis à jour
     */
    @PatchMapping("/{idIndice}")
    public void UpdateIndice(Long IdIndice, @PathVariable Indice I) {
        repo.deleteById(IdIndice);
        repo.save(I);
    }

    /**
     * Méthode Delete permettant de supprimer un Indice de la base de donnée
     * @param I L'indice supprimé de la base de donnée
     */
    @DeleteMapping("/{idIndice}")
    public void DeleteinfoSecu(@PathVariable Indice I) {
        repo.delete(I);
    }
}