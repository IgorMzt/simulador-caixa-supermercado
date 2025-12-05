import java.util.PriorityQueue;

public class SimulacaoCaixaSupermercado {

    private int numeroCaixas;
    private int totalClientes;
    private double mediaTempoAtendimentoPorCliente;
    private double desvioPadraoTempoAtendimentoPorCliente;

    private static final double TEMPO_MINIMO_ATENDIMENTO = 0.1;

    private final java.util.Random rng = new java.util.Random(42);

    public void setNumeroCaixas(int n) { this.numeroCaixas = n; }
    public void setTotalClientes(int n) { this.totalClientes = n; }
    public void setMediaTempoAtendimentoPorCliente(double mu) {
        this.mediaTempoAtendimentoPorCliente = mu;
    }
    public void setDesvioPadraoTempoAtendimentoPorCliente(double sigma) {
        this.desvioPadraoTempoAtendimentoPorCliente = sigma;
    }

    private double tempoAtendimentoNormalTruncado() {
        double z = rng.nextGaussian();
        double s = mediaTempoAtendimentoPorCliente +
                desvioPadraoTempoAtendimentoPorCliente * z;
        return (s < TEMPO_MINIMO_ATENDIMENTO) ? TEMPO_MINIMO_ATENDIMENTO : s;
    }

    public double simular() {
        PriorityQueue<Double> caixasLivres = new PriorityQueue<>();
        
        for (int i = 0; i < numeroCaixas; i++) {
            caixasLivres.add(0.0);
        }
        
        double tempoTotalEspera = 0.0;
        
        for (int i = 0; i < totalClientes; i++) {
            double tempoLivreCaixa = caixasLivres.poll();
            double tempoAtendimento = tempoAtendimentoNormalTruncado();
            double tempoFimAtendimento = tempoLivreCaixa + tempoAtendimento;
            tempoTotalEspera += tempoFimAtendimento;
            caixasLivres.add(tempoFimAtendimento);
        }
        
        return tempoTotalEspera / totalClientes;
    }
}
