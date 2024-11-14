package fr.uphf.Questease.Controller;

import fr.uphf.Questease.Model.ChoseATrouverPrixJuste;
import fr.uphf.Questease.Service.ChoseATrouverPrixJusteServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controller du repositoire de ChoseATrouverPrixJuste
 */
@RestController
@RequestMapping("/chose")
public class ChoseATrouverPrixJusteController {

    /**
     * Implémentation du service permettant d'accéder au repositoire
     */
    private final ChoseATrouverPrixJusteServiceImpl repo;

    /**
     * Constructeur de la classe ChoseATrouverPrixJusteController
     * @param repo Repositoire de la classe ChoseATrouverPrixJusteController
     */
    public ChoseATrouverPrixJusteController(ChoseATrouverPrixJusteServiceImpl repo) {
        this.repo = repo;
    }

    /**
     * Méthode Get permettant de récupérer un des élément mystère du Prix Juste via son id
     * @param idChoseATrouver L'id du mot à trouver
     * @return L'élément récupéré
     */
    @GetMapping("/{idChoseATrouver}")
    public ResponseEntity<Optional<ChoseATrouverPrixJuste>> GetChoseById(@PathVariable Long idChoseATrouver) {
        return ResponseEntity.ok(repo.ReadChose(idChoseATrouver));
    }

    /**
     * Méthode Post permettant d'ajouter un élément mystère du Prix Juste à la base de donnée
     * @param C L'élément à ajouter à la base de donnée
     */
    @PostMapping("/{idChoseATrouver}")
    public void PostChose(@RequestBody ChoseATrouverPrixJuste C) {
        repo.SaveChose(C);
    }

    /**
     * Méthode Update permettant de mettre à jour un élément mystère du Prix Juste dans la base de donnée
     * @param idChoseATrouver L'id de l'élément qui mettra à jour
     * @param C L'élément qui sera mis à jour
     */
    @PatchMapping("/{idChoseATrouver}")
    public void UpdateChoseATrouver(@PathVariable Long idChoseATrouver, @RequestBody ChoseATrouverPrixJuste C) {
        repo.UpdateChose(C, idChoseATrouver);
    }

    /**
     * Méthode Delete permettant de supprimer un élément de la base de donnée
     * @param idChoseATrouver L'id de l'élément à supprimer
     */
    @DeleteMapping("/{idChoseATrouver}")
    public void DeleteChose(@PathVariable Long idChoseATrouver) {
        repo.DeleteChose(idChoseATrouver);
    }

    @GetMapping("/random")
    public ChoseATrouverPrixJuste GetRandomChose() {
        List<ChoseATrouverPrixJuste> liste = repo.FetchChoseList();
        return liste.get((int) (Math.random() * ((liste.size()) + 1)));
    }

    @GetMapping("")
    public List<ChoseATrouverPrixJuste> GetAll(){
        return repo.FetchChoseList();
    }
}

