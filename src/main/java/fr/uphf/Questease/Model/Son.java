package fr.uphf.Questease.Model;

import jakarta.persistence.*;

/**
 * Représente le son à décrire lors du jeu du Son
 */
@Entity
@Table(name = "Son")
public class Son {

    /**
     * L'id du son à décrire
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Le path menant au son à décrire
     */
    @Column(name = "cheminSon", nullable = false)
    private String cheminSon;

    /**
     * L'indice lié au son à décrire
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idIndice")
    private Indice Indice;
}
