package org.yfortier.service;

import org.junit.jupiter.api.Test;
import org.yfortier.model.Produit;
import org.yfortier.model.TypeProduit;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TaxeServiceTest {

    @Test
    void testCalculTaxeProduitStandardNonImporte() {
        Produit cd = new Produit("CD musical", new BigDecimal("14.99"), TypeProduit.AUTRE, false);
        BigDecimal taxe = TaxeService.calculerTaxe(cd);
        assertEquals(new BigDecimal("1.50"), taxe);
    }

    @Test
    void testCalculTaxeProduitExonereNonImporte() {
        Produit livre = new Produit("livre", new BigDecimal("12.49"), TypeProduit.LIVRE, false);
        BigDecimal taxe = TaxeService.calculerTaxe(livre);
        assertEquals(new BigDecimal("0.00"), taxe);
    }

    @Test
    void testCalculTaxeProduitImporteExonere() {
        Produit chocolatsImportes = new Produit("boîte de chocolats importée", new BigDecimal("10.00"), TypeProduit.NOURRITURE, true);
        BigDecimal taxe = TaxeService.calculerTaxe(chocolatsImportes);
        assertEquals(new BigDecimal("0.50"), taxe);
    }

    @Test
    void testCalculTaxeProduitImporteStandard() {
        Produit parfumImporte = new Produit("flacon de parfum importé", new BigDecimal("47.50"), TypeProduit.AUTRE, true);
        BigDecimal taxe = TaxeService.calculerTaxe(parfumImporte);
        assertEquals(new BigDecimal("7.15"), taxe);
    }
}
