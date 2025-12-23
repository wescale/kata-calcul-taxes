package org.yfortier.service;

import org.yfortier.model.Produit;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TaxeService {
    private static final BigDecimal TAUX_TAXE_BASE = new BigDecimal("0.10");
    private static final BigDecimal TAUX_TAXE_IMPORTATION = new BigDecimal("0.05");
    private static final BigDecimal INCREMENT_ARRONDI = new BigDecimal("0.05");

    public static BigDecimal calculerTaxe(Produit produit) {
        BigDecimal taux = BigDecimal.ZERO;

        if (!produit.typeProduit().estExonere()) {
            taux = taux.add(TAUX_TAXE_BASE);
        }

        if (produit.estImporte()) {
            taux = taux.add(TAUX_TAXE_IMPORTATION);
        }

        BigDecimal taxeBrute = produit.prixHT().multiply(taux);
        return arrondirTaxe(taxeBrute);
    }

    private static BigDecimal arrondirTaxe(BigDecimal valeur) {
        return valeur.divide(INCREMENT_ARRONDI, 0, RoundingMode.UP).multiply(INCREMENT_ARRONDI);
    }
}