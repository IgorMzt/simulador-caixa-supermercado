import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String... args) {
        
        System.out.println("=".repeat(80));
        System.out.println("ATIVIDADE PRÁTICA - SIMULAÇÃO DE CAIXAS DE SUPERMERCADO");
        System.out.println("=".repeat(80));
        System.out.println();
        
        System.out.println("ATIVIDADE 1: Simulação base (μ=5.0, σ=0.5, N=100, 1000 rodadas)");
        System.out.println("-".repeat(80));
        executarSimulacao(1, 5.0, 0.5, 100, 1000);
        System.out.println();
        
        System.out.println("ATIVIDADE 2: Variação do número de caixas");
        System.out.println("-".repeat(80));
        System.out.println("Comparando 1, 2 e 3 caixas:");
        System.out.println();
        for (int caixas = 1; caixas <= 3; caixas++) {
            System.out.printf("Com %d caixa(s):%n", caixas);
            executarSimulacao(caixas, 5.0, 0.5, 100, 1000);
            System.out.println();
        }
        
        System.out.println("ATIVIDADE 3: Variação do desvio padrão (σ)");
        System.out.println("-".repeat(80));
        double[] desviosPadrao = {0.25, 0.5, 1.0, 2.0};
        for (int caixas = 1; caixas <= 3; caixas++) {
            System.out.printf("=== Com %d caixa(s) ===%n%n", caixas);
            for (double sigma : desviosPadrao) {
                System.out.printf("σ = %.2f:%n", sigma);
                executarSimulacao(caixas, 5.0, sigma, 100, 1000);
                System.out.println();
            }
        }
    }

    private static void executarSimulacao(int numCaixas, double media, double desvio, 
                                          int atendimentos, int numSimulacoes) {
        final List<Double> mediasAtendimento = new ArrayList<>();
        SimulacaoCaixaSupermercado simulador = new SimulacaoCaixaSupermercado();

        for (int i = 0; i < numSimulacoes; i++) {
            simulador.setNumeroCaixas(numCaixas);
            simulador.setTotalClientes(atendimentos);
            simulador.setMediaTempoAtendimentoPorCliente(media);
            simulador.setDesvioPadraoTempoAtendimentoPorCliente(desvio);

            double mediaAtendimento = simulador.simular();
            mediasAtendimento.add(mediaAtendimento);
        }

        double mediaFinal = media(mediasAtendimento);
        double dp = desvioPadrao(mediasAtendimento, mediaFinal);

        System.out.printf("  Média dos tempos de atendimento (%d simulações): %.3f min%n",
                numSimulacoes, mediaFinal);
        System.out.printf("  Desvio-padrão das médias: %.3f min%n", dp);
    }

    private static double media(List<Double> xs) {
        double s = 0.0;
        for (double x : xs) s += x;
        return s / xs.size();
    }

    private static double desvioPadrao(List<Double> xs, double m) {
        double s2 = 0.0;
        for (double x : xs) {
            double d = x - m;
            s2 += d * d;
        }
        return Math.sqrt(s2 / (xs.size() - 1));
    }
}
