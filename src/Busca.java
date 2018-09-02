
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Busca {

    public static void main(String[] args) {
        int n = 100000;
        int v[] = new int[n];
        for (int i = 0; i < v.length; i++) {
            v[i] = i * 10;
        }

        //embaralha(v);
        int k = 5001;

        long tempoInicial = System.nanoTime();
        buscaSequencial(v, k);
        long tempoFinal = System.nanoTime();
        System.out.println("Busca Sequencial: " + (tempoFinal - tempoInicial) + "ns" + " - " + TimeUnit.MILLISECONDS.convert((tempoFinal - tempoInicial), TimeUnit.NANOSECONDS) + "ms");
        tempoInicial = System.nanoTime();
        //buscaSequencialRecursiva(v, v.length, k);
        tempoFinal = System.nanoTime();
        System.out.println("Busca Sequencial Recursiva: " + (tempoFinal - tempoInicial) + "ns" + " - " + TimeUnit.MILLISECONDS.convert((tempoFinal - tempoInicial), TimeUnit.NANOSECONDS) + "ms");
        tempoInicial = System.nanoTime();
        buscaSequencialOrdenada(v, k);
        tempoFinal = System.nanoTime();
        System.out.println("Busca Sequencial Ordenado: " + (tempoFinal - tempoInicial) + "ns" + " - " + TimeUnit.MILLISECONDS.convert((tempoFinal - tempoInicial), TimeUnit.NANOSECONDS) + "ms");
        tempoInicial = System.nanoTime();
        //buscaSeqOrdRecursiva(v, 0, k);
        tempoFinal = System.nanoTime();
        System.out.println("Busca Sequencial Ordenado Recursivo: " + (tempoFinal - tempoInicial) + "ns" + " - " + TimeUnit.MILLISECONDS.convert((tempoFinal - tempoInicial), TimeUnit.NANOSECONDS) + "ms");
        tempoInicial = System.nanoTime();
        buscaBinaria(v, k);
        tempoFinal = System.nanoTime();
        System.out.println("Busca Binária: " + (tempoFinal - tempoInicial) + "ns" + " - " + TimeUnit.MILLISECONDS.convert((tempoFinal - tempoInicial), TimeUnit.NANOSECONDS) + "ms");
        tempoInicial = System.nanoTime();
        buscaPorInterpolacao(v, k);
        tempoFinal = System.nanoTime();
        System.out.println("Busca por Interpolação: " + (tempoFinal - tempoInicial) + "ns" + " - " + TimeUnit.MILLISECONDS.convert((tempoFinal - tempoInicial), TimeUnit.NANOSECONDS) + "ms");
    }

    public static int buscaSequencial(int vetor[], int k) {
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == k) {
                return i;
            }
        }
        return -1;
    }

    public static int buscaSequencialOrdenada(int vetor[], int k) {
        for (int i = 0; i < vetor.length && vetor[i] <= k; i++) {
            if (vetor[i] == k) {
                return i;
            }
        }
        return -1;
    }

    public static int buscaSequencialRecursiva(int[] vetor, int n, int k) {
        if (n <= 0) {
            return -1;
        } else if (vetor[n - 1] == k) {
            return n - 1;
        } else {
            return buscaSequencialRecursiva(vetor, n - 1, k);
        }
    }

    public static int buscaSeqOrdRecursiva(int[] vetor, int m, int k) {
        if (m >= vetor.length || vetor[m] > k) {
            return -1;
        } else if (vetor[m] == k) {
            return m;
        } else {
            return buscaSeqOrdRecursiva(vetor, m + 1, k);
        }
    }

    public static int buscaBinaria(int vetor[], int k) {
        int inicio = 0, fim = vetor.length - 1, centro;
        while (inicio <= fim) {
            centro = inicio + (fim - inicio) / 2;
            if (k == vetor[centro]) {
                return centro;
            } else if (k > vetor[centro]) {
                inicio = centro + 1;
            } else {
                fim = centro - 1;
            }
        }
        return -1;
    }

    public static int buscaPorInterpolacao(int[] vetor, int x) {
        int inferior = 0, superior = vetor.length - 1, meio;
        while (inferior <= superior && x >= vetor[inferior] && x <= vetor[superior]) {
            meio = inferior + ((superior - inferior) * (x - vetor[inferior]))
                    / (vetor[superior] - vetor[inferior]);
            if (vetor[meio] < x) {
                inferior = meio + 1;
            } else if (vetor[meio] > x) {
                superior = meio - 1;
            } else {
                return meio;
            }
        }
        return -1;
    }

    private static void embaralha(int[] embaralhado) {
        Random random = new Random();
        int elementosRestantes = embaralhado.length;
        while (elementosRestantes > 0) {
            int k = random.nextInt(elementosRestantes);

            int temp = embaralhado[k];
            embaralhado[k] = embaralhado[elementosRestantes - 1];
            embaralhado[elementosRestantes - 1] = temp;

            elementosRestantes--;
        }
    }
}
