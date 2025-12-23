package org.yfortier.model;

public enum TypeProduit {
    LIVRE(true),
    NOURRITURE(true),
    MEDICAL(true),
    AUTRE(false);

    private final boolean estExonere;

    TypeProduit(boolean estExonere) {
        this.estExonere = estExonere;
    }

    public boolean estExonere() {
        return estExonere;
    }
}