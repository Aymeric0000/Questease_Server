package fr.uphf.Questease.Model;

import jakarta.persistence.*;

/**
 * Représente le mot à trouver lors du jeu du Cryptex
 */
@Entity
@Table(name = "motCryptex")
public class MotCryptex {

    /**
     * L'id du mot à trouver lors du Cryptex
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idMotCryptex")
    private Long id;

    /**
     * Le mot à trouver lors du Cryptex
     */
    @Column(name = "mot",unique=true, nullable = false)
    private String mot;

    /**
     * TODO
     */
    @Column(name = "diff", nullable = false)
    private int diff;

    /**
     * L'indice lié au mot à trouver lors du Cryptex
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idIndice")
    private Indice Indice;
}
