package br.com.wkm;

public class Main {

    public static boolean isColunaCrescente = true;
    public static boolean isLinhaCrescente = true;
    public static int colunaParada = 0;
    public static int linhaParada = 0;
    public static int valorInicial = 1;

    public static void main(String[] args) {

        int inteiro = 4;

        int[][] matriz = retornarMatrizEspiral(inteiro);

        escreverConsoleMatrizEspiral(matriz, inteiro);
    }

    private static void escreverConsoleMatrizEspiral(int[][] matriz, int inteiro) {
        for (int linha = 0 ; linha < inteiro ; linha++) {
            for (int coluna = 0 ; coluna < inteiro ; coluna++) {
                int i = matriz[linha][coluna];
                System.out.print("[" + i + "]");
            }
            System.out.println();
        }
    }

    private static int[][] retornarMatrizEspiral(int inteiro) {

        int iteracao = inteiro -1;

        int valorMaximo = (int) Math.pow(inteiro, 2);
        int[][] matriz = new int[inteiro][inteiro];

        for (int contador = 1; contador <= valorMaximo; contador++) {

            if (isPercorrendoColuna(contador)) {
                if (isColunaCrescente) {
                    percorrerColunaCrescente(iteracao, matriz);
                } else {
                    percorrerColunaDecrescente(matriz);
                }
            } else {
                if (isLinhaCrescente) {
                    percorrerLinhaCrescente(iteracao, matriz);
                } else {
                    percorrerLinhaDecrescente(matriz);
                }
            }

        }

        return matriz;
    }

    private static void percorrerLinhaDecrescente(int[][] matriz) {
        for (int linha = linhaParada ; 0 <= linha ; linha--) {
            if (matriz[linha][colunaParada] == 0) {
                matriz[linha][colunaParada] = valorInicial++;
                linhaParada = linha;
            }
            continue;
        }
        isLinhaCrescente = true;
    }

    private static void percorrerLinhaCrescente(int iteracao, int[][] matriz) {
        for (int linha = linhaParada ; linha <= iteracao ; linha++) {
            if (matriz[linha][colunaParada] == 0) {
                matriz[linha][colunaParada] = valorInicial++;
                linhaParada = linha;
            }
            continue;
        }
        isLinhaCrescente = false;
    }

    private static void percorrerColunaDecrescente(int[][] matriz) {
        for (int coluna = colunaParada ; 0 <= coluna ; coluna--) {
            if (matriz[linhaParada][coluna] == 0) {
                matriz[linhaParada][coluna] = valorInicial++;
                colunaParada = coluna;
            }
            continue;
        }
        isColunaCrescente = true;
    }

    private static void percorrerColunaCrescente(int iteracao, int[][] matriz) {
        for (int coluna = colunaParada ; coluna <= iteracao ; coluna++) {
            if (matriz[linhaParada][coluna] == 0) {
                matriz[linhaParada][coluna] = valorInicial++;
                colunaParada = coluna;
            }
            continue;
        }
        isColunaCrescente = false;
    }

    static boolean isPercorrendoColuna(int contador) {
        return (contador % 2) != 0;
    }
}
