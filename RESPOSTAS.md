# Respostas - Atividade Prática
## Programação Paralela e Distribuída

**Aluno:** Igor Mazeti de Oliveira  
**Professor:** Dr. Lucas Venezian Povoa  
**Data:** 05/12/2025

---

## Atividade 1: Executar simulação base

**Parâmetros:**
- μ = 5,0 minutos
- σ = 0,5 minutos  
- N = 100 clientes
- Número de rodadas = 1000
- Número de caixas = 1

**Resultados obtidos:**
```
Tempo médio por cliente: 250.012 min
Desvio-padrão das médias: 2.487 min
```

**Análise:**  
Com 1 caixa atendendo 100 clientes sequencialmente, o tempo médio de ~250 minutos inclui espera na fila mais atendimento.

---

## Atividade 2: Variar número de caixas

**Resultados:**

| Número de Caixas | Tempo Médio (min) | Desvio-Padrão (min) | Redução |
|------------------|-------------------|---------------------|---------|
| 1 | 250.012 | 2.487 | - |
| 2 | 127.506 | 1.758 | ~49% |
| 3 | 87.504 | 1.435 | ~65% |

**Discussão:**

Aumentar o número de caixas reduz significativamente o tempo médio. Com 2 caixas, o tempo cai pela metade. Com 3 caixas, a redução é de 65%. A redução não é linear porque sempre há alguma espera e a distribuição não é perfeitamente uniforme devido à variabilidade dos tempos.

---

## Atividade 3: Variar desvio padrão (σ)

**Resultados com 1 caixa:**

| σ | Tempo Médio (min) | Desvio das médias (min) |
|---|-------------------|-------------------------|
| 0,25 | 250.006 | 1.244 |
| 0,50 | 250.012 | 2.487 |
| 1,00 | 250.024 | 4.975 |
| 2,00 | 250.048 | 9.950 |

**Resultados com 2 caixas:**

| σ | Tempo Médio (min) | Desvio das médias (min) |
|---|-------------------|-------------------------|
| 0,25 | 127.503 | 0.880 |
| 0,50 | 127.506 | 1.758 |
| 1,00 | 127.512 | 3.516 |
| 2,00 | 127.524 | 7.032 |

**Resultados com 3 caixas:**

| σ | Tempo Médio (min) | Desvio das médias (min) |
|---|-------------------|-------------------------|
| 0,25 | 87.502 | 0.719 |
| 0,50 | 87.504 | 1.435 |
| 1,00 | 87.508 | 2.870 |
| 2,00 | 87.516 | 5.740 |

**Observações:**

O tempo médio permanece constante independente do σ. O desvio-padrão das médias cresce proporcionalmente ao σ. Múltiplos caixas reduzem tanto o tempo médio quanto a variabilidade dos resultados, tornando o sistema mais estável.

---

## Atividade 4: Explicação sobre processo estocástico

Este simulador é considerado estocástico porque cada tempo de atendimento é gerado através de variáveis aleatórias que seguem uma distribuição normal truncada. Mesmo mantendo os mesmos parâmetros (μ e σ), cada execução produz resultados diferentes, refletindo a variabilidade natural de situações reais. Em supermercados, nem todos os clientes levam o mesmo tempo: alguns têm poucas compras e pagam rapidamente, outros têm carrinhos cheios e demoram procurando forma de pagamento ou validando cupons. Essa aleatoriedade controlada captura a incerteza inerente aos processos reais de atendimento, permitindo que o simulador forneça estimativas realistas sobre quantos caixas são necessários para manter tempos de espera aceitáveis, considerando não apenas a média, mas também a variabilidade do serviço.
