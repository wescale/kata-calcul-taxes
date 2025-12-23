package org.yfortier.model;

import java.math.BigDecimal;

public record Produit(
        String nom,
        BigDecimal prixHT,
        TypeProduit typeProduit,
        boolean estImporte
) {}