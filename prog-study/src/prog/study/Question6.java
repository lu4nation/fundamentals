package prog.study;

import java.util.Arrays;

public class Question6 {

        public static void rotateMatrix(int[][] matrix, int n) {
        /*
            - Processamos por camadas ate o centro do quadrado(matriz).
            - De 0 ate menor que n/2 pq como processamos todos os lados ao mesmo
            tempo de um quadrado, logo seu centro é largura / 2.
            - No caso de matriz 2x2 ou 3x3 o loop só precisa percorrer uma layer
            já que no caso 2x2 só tem uma layer por lado e no caso 3x3
            o centro é ignorado fazendo com que tenhamos uma layer a menos
            Sempre que N for ímpar teremos uma layer a menos
        */
            for (int layer = 0; layer < n / 2; ++layer) {
                int first = layer; //inicio e fim de um lado da layer.
                int last = n - 1 - layer;
                // vai do inicio até o fim - 1 pois o fim é substituído pelo início
            /* Iteração do For interno:
              N runs completes a layer
                First run!
                  T, 0, 1, R
                  1, 0, 1, 0
                  1, 0, 1, 0
                  L, 0, 1, B
                Second run!
                  1, T, 1, 1
                  1, 0, 1, R
                  L, 0, 1, 0
                  0, 0, B, 0
                  ...
                */

                for (int i = first; i < last; ++i) {
                    int offset = i - first;
                    //top = buffer
                    int top = matrix[first][i];

                    //mover o pixel do left para o top em relação ao pixel na posição
                    matrix[first][i] = matrix[last - offset][first];
                    // bottom -> left
                    matrix[last - offset][first] = matrix[last][last - offset];
                    // right -> bottom
                    matrix[last][last - offset] = matrix[i][last];
                    // buffer(top) -> right
                    matrix[i][last] = top;
                }
            }
        }

        public static void main(String[] args) {
            int n = 4;
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                Arrays.fill(matrix[i], (i % 2));
            }

            printMatrix(matrix, n);
            System.out.println();
            rotateMatrix(matrix, n);

            printMatrix(matrix, n);
        }

        public static void printMatrix(int[][] matrix, int n) {

            for (int i = 0; i < n; i++) {
                for (int o = 0; o < n; o++) {
                    System.out.print(matrix[i][o]);
                    System.out.print(", ");
                }
                System.out.println();
            }

        }
}
