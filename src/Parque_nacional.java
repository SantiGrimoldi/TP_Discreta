import java.util.Queue;
import java.util.Stack;

public class Parque_nacional {
    Grafo_Ponderado_NoDirigido grafo;
    int[] verticeAnterior;
    int[] pesoCamino;
    public Parque_nacional(String[][] arreglo){
        grafo = new Grafo_Ponderado_NoDirigido(2*arreglo.length);
        fill(arreglo);
        int[][] array = grafo.dijkstra(arreglo[0][0]);
        verticeAnterior = array[0];
        pesoCamino = array[1];
    }

    private void fill(String[][] arreglo){
        for (int i = 0; i <arreglo.length;i++){
            for (int j = 0; j< 2;j++){
                if(!grafo.existsVertex(arreglo[i][j])){
                    grafo.addVertex(arreglo[i][j]);
                }
            }
            grafo.addEdge(arreglo[i][0],arreglo[i][1], Integer.parseInt(arreglo[i][2]));
        }
    }

    public void printCaminos(){
        for (int j = verticeAnterior.length-1;j>0;j--){
            Stack<Integer> pila = new Stack<>();
            if(pesoCamino[j]==Integer.MAX_VALUE)continue;
            int va = verticeAnterior[j];
            pila.push(j);
            while (va!=0){
                pila.push(va);
                va = verticeAnterior[va];
            }
            pila.push(0);
            System.out.print("[");
            while (!pila.isEmpty()){
                System.out.print(pila.pop()+", ");
            }
            System.out.println("time -> ("+pesoCamino[j]+" min)"+"]");


        }
    }
}
