package org.yfortier.model;

import java.math.BigDecimal;
import java.util.List;

public class Facture {
    private final List<String> lignes;
    private final BigDecimal totalTaxes;
    private final BigDecimal totalTTC;

    public Facture(List<String> lignes, BigDecimal totalTaxes, BigDecimal totalTTC) {
        this.lignes = lignes;
        this.totalTaxes = totalTaxes;
        this.totalTTC = totalTTC;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        lignes.forEach(stringBuilder::append);
        stringBuilder.append("Montant des taxes : ").append(totalTaxes).append("\n");
        stringBuilder.append("Total : ").append(totalTTC);
        return stringBuilder.toString();
    }
}