import java.util.*;
import java.util.stream.Collectors;

class Pedido {
    String id;
    String cliente;
    String status;
    double valor;

    Pedido(String id, String cliente, String status, double valor) {
        this.id = id;
        this.cliente = cliente;
        this.status = status;
        this.valor = valor;
    }
}

public class Main {

    public static void main(String[] args) {
        List<Pedido> pedidos = List.of(
                new Pedido("1", "Ana", "PENDENTE", 100),
                new Pedido("2", "Bruno", "APROVADO", 200),
                new Pedido("3", "Ana", "APROVADO", 150),
                new Pedido("4", "Carlos", "CANCELADO", 300),
                new Pedido("5", "Bruno", "PENDENTE", 50)
        );

        Map<String, Object> filtros = new HashMap<>();
        filtros.put("cliente", "Ana");
        filtros.put("status", "APROVADO");

        List<Pedido> filtrados = pedidos.stream()
                .filter(p -> aplicarFiltros(p, filtros))
                .collect(Collectors.toList());

        System.out.println("Filtrados:");
        filtrados.forEach(p -> System.out.println(p.id));

        Map<String, List<Pedido>> agrupadoPorStatus = pedidos.stream()
                .collect(Collectors.groupingBy(p -> p.status));

        System.out.println("\nAgrupado por status:");
        agrupadoPorStatus.forEach((status, lista) -> {
            System.out.println(status + ": " + lista.size());
        });

        Map<String, Double> totalPorCliente = pedidos.stream()
                .collect(Collectors.groupingBy(
                        p -> p.cliente,
                        Collectors.summingDouble(p -> p.valor)
                ));

        System.out.println("\nTotal por cliente:");
        totalPorCliente.forEach((cliente, total) -> {
            System.out.println(cliente + " -> " + total);
        });

        Map<String, Pedido> pedidoPorId = pedidos.stream()
                .collect(Collectors.toMap(p -> p.id, p -> p));

        System.out.println("\nPedido ID 3: " + pedidoPorId.get("3").cliente);
    }

    static boolean aplicarFiltros(Pedido p, Map<String, Object> filtros) {
        for (Map.Entry<String, Object> entry : filtros.entrySet()) {
            String campo = entry.getKey();
            Object valor = entry.getValue();

            switch (campo) {
                case "cliente":
                    if (!p.cliente.equals(valor)) return false;
                    break;
                case "status":
                    if (!p.status.equals(valor)) return false;
                    break;
                case "valorMin":
                    if (p.valor < (double) valor) return false;
                    break;
                case "valorMax":
                    if (p.valor > (double) valor) return false;
                    break;
            }
        }
        return true;
    }
}