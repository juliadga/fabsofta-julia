package br.univille.projetofabsoftebooksjulia.entity;
public class PaymentMethod {
    private String type; // e.g., credit, debit, pix, paypal
    // Getters and Setters
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
}