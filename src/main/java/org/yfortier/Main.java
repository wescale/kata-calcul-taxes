package org.yfortier;

import org.yfortier.model.Facture;
import org.yfortier.model.Produit;
import org.yfortier.model.TypeProduit;
import org.yfortier.service.FactureService;

import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FactureService factureService = new FactureService();

        // --- INPUT 1 ---
        List<Produit> panier1 = List.of(
                new Produit("livre", new BigDecimal("12.49"), TypeProduit.LIVRE, false),
                new Produit("CD musical", new BigDecimal("14.99"), TypeProduit.AUTRE, false),
                new Produit("barre de chocolat", new BigDecimal("0.85"), TypeProduit.NOURRITURE, false)
        );

        Facture facture1 = factureService.genererFacture(panier1);

        System.out.println("### Output 1 ###");
        System.out.println(facture1);
        System.out.println("\n-------------------\n");

        // --- INPUT 2 ---
        List<Produit> panier2 = List.of(
                new Produit("boîte de chocolats importée", new BigDecimal("10.00"), TypeProduit.NOURRITURE, true),
                new Produit("flacon de parfum importé", new BigDecimal("47.50"), TypeProduit.AUTRE, true)
        );

        Facture facture2 = factureService.genererFacture(panier2);

        System.out.println("### Output 2 ###");
        System.out.println(facture2);
        System.out.println("\n-------------------\n");

        // --- INPUT 3 ---
        List<Produit> panier3 = List.of(
                new Produit("flacon de parfum importé", new BigDecimal("27.99"), TypeProduit.AUTRE, true),
                new Produit("flacon de parfum", new BigDecimal("18.99"), TypeProduit.AUTRE, false),
                new Produit("boîte de pilules contre la migraine", new BigDecimal("9.75"), TypeProduit.MEDICAL, false),
                new Produit("boîte de chocolats importés", new BigDecimal("11.25"), TypeProduit.NOURRITURE, true)
        );

        Facture facture3 = factureService.genererFacture(panier3);

        System.out.println("### Output 3 ###");
        System.out.println(facture3);
    }
}