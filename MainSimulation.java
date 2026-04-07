public class MainSimulation {

    public static void main(String[] args) {

        PatientProfileV1 p1 = new PatientProfileV1("P001", "Andi", "123456");
        PatientProfileV2 p2 = new PatientProfileV2("P002", "Budi", "654321", "Peanut", "Diabetes");

        IntegrationGateway<PatientProfileV1> g1 = new IntegrationGateway<>(p1);
        IntegrationGateway<PatientProfileV2> g2 = new IntegrationGateway<>(p2);

        System.out.println("=== LEVEL 1 ===");
        System.out.println(g1.fetchData("P001", 1).getData());
        System.out.println(g2.fetchData("P002", 1).getData());

        System.out.println("\n=== LEVEL 2 ===");
        System.out.println(g1.fetchData("P001", 2).getData());
        System.out.println(g2.fetchData("P002", 2).getData());

        System.out.println("\n=== LEVEL 3 ===");
        System.out.println(g1.fetchData("P001", 3).getData());
        System.out.println(g2.fetchData("P002", 3).getData());
    }
}

