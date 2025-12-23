package org.yfortier.service;

import org.yfortier.model.Facture;
import org.yfortier.model.Produit;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FactureService {
    public Facture genererFacture(List<Produit> produits) {
        List<String> lignesFacture = new ArrayList<>();
        BigDecimal totalTaxes = BigDecimal.ZERO;
        BigDecimal montantTotal = BigDecimal.ZERO;

        for (Produit produit : produits) {
            BigDecimal taxe = TaxeService.calculerTaxe(produit);
            BigDecimal prixTTC = produit.prixHT().add(taxe);

            // TODO: Refactoring possible - Remplacer le string en dur par une vraie gestion de quantité via un service.
            String ligne = "1 " + produit.nom() + " : " + prixTTC + "\n";
            lignesFacture.add(ligne);

            totalTaxes = totalTaxes.add(taxe);
            montantTotal = montantTotal.add(prixTTC);
        }

        return new Facture(lignesFacture, totalTaxes, montantTotal);
    }
}