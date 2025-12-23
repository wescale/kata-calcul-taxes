package org.yfortier.service;

import org.junit.jupiter.api.Test;
import org.yfortier.model.Facture;
import org.yfortier.model.Produit;
import org.yfortier.model.TypeProduit;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class FactureServiceTest {

    private final FactureService factureService = new FactureService();

    @Test
    void testGenererFactureInput1() {
        List<Produit> panier = new ArrayList<>();
        panier.add(new Produit("livre", new BigDecimal("12.49"), TypeProduit.LIVRE, false));
        panier.add(new Produit("CD musical", new BigDecimal("14.99"), TypeProduit.AUTRE, false));
        panier.add(new Produit("barre de chocolat", new BigDecimal("0.85"), TypeProduit.NOURRITURE, false));

        Facture facture = factureService.genererFacture(panier);
        String resultat = facture.toString();

        assertTrue(resultat.contains("1 livre : 12.49"));
        assertTrue(resultat.contains("1 CD musical : 16.49"));
        assertTrue(resultat.contains("1 barre de chocolat : 0.85"));
        assertTrue(resultat.contains("Montant des taxes : 1.50"));
        assertTrue(resultat.contains("Total : 29.83"));
    }

    @Test
    void testGenererFactureInput2() {
        List<Produit> panier = new ArrayList<>();
        panier.add(new Produit("boîte de chocolats importée", new BigDecimal("10.00"), TypeProduit.NOURRITURE, true));
        panier.add(new Produit("flacon de parfum importé", new BigDecimal("47.50"), TypeProduit.AUTRE, true));

        Facture facture = factureService.genererFacture(panier);
        String resultat = facture.toString();

        assertTrue(resultat.contains("1 boîte de chocolats importée : 10.50"));
        assertTrue(resultat.contains("1 flacon de parfum importé : 54.65"));
        assertTrue(resultat.contains("Montant des taxes : 7.65"));
        assertTrue(resultat.contains("Total : 65.15"));
    }

    @Test
    void testGenererFactureInput3() {
        List<Produit> panier = new ArrayList<>();
        panier.add(new Produit("flacon de parfum importé", new BigDecimal("27.99"), TypeProduit.AUTRE, true));
        panier.add(new Produit("flacon de parfum", new BigDecimal("18.99"), TypeProduit.AUTRE, false));
        panier.add(new Produit("boîte de pilules contre la migraine", new BigDecimal("9.75"), TypeProduit.MEDICAL, false));
        panier.add(new Produit("boîte de chocolats importés", new BigDecimal("11.25"), TypeProduit.NOURRITURE, true));

        Facture facture = factureService.genererFacture(panier);
        String resultat = facture.toString();

        assertTrue(resultat.contains("1 flacon de parfum importé : 32.19"));
        assertTrue(resultat.contains("1 flacon de parfum : 20.89"));
        assertTrue(resultat.contains("1 boîte de pilules contre la migraine : 9.75"));
        assertTrue(resultat.contains("1 boîte de chocolats importés : 11.85"));
        assertTrue(resultat.contains("Montant des taxes : 6.70"));
        assertTrue(resultat.contains("Total : 74.68"));
    }
}