package entities;

import java.util.ArrayList;
import java.util.List;

public class Compras extends Product implements Cartao {
    private Double total;
    private List<Product> itens = new ArrayList<>();

    public Compras(Double price, String name, Double total) {
        super(price, name);
        this.total = total;
    }

    public Double getTotal() {
        return total;
    }

    public List<Product> getItens() {
        return itens;
    }

    public void addProduct(Product p) {
        itens.add(p);
    }

    public void removeProduct(Product p) {
        itens.remove(p);
    }

    // Método que percorre a lista e soma os valores dos itens
    @Override
    public double compras() {
        double soma = 0.0;
        for (Product item : itens) {
            soma += item.getPrice(); // Presume que Product tem o método getPrice()
        }
        total = soma; // Atualiza o total com a soma dos itens
        return total;
    }

    // Verifica se o total está dentro do limite disponível
    @Override
    public boolean limit(double haveLimit) {
        return total <= haveLimit;
    }

    @Override
    public String toString() {
        // Ordena os produtos pelo preço do maior para o menor
        itens.sort((p1, p2) -> p2.getPrice().compareTo(p1.getPrice()));

        StringBuilder result = new StringBuilder();
        result.append("Produtos comprados:\n");

        for (Product item : itens) {
            result.append(item.toString()).append("\n");
        }

        double limiteRestante = total;

        if (limit(limiteRestante)) {
            result.append(String.format("\nSaldo restante no cartão: R$%.2f\n", limiteRestante - total));
        } else {
            result.append("\nVocê não tem limite disponível.\n");
            result.append(String.format("Total das compras: R$%.2f\n", total));
        }

        return result.toString();
    }

}
