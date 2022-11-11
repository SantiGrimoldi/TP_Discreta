import java.util.ArrayList;
import java.util.List;

public class Grafo_Ponderado_NoDirigido {
    int capacidad;
    int[][] matriz_aristas;
    String [] vertices;
    int cantidad_de_vertices = 0;
    int cant_aristas = 0;


    public Grafo_Ponderado_NoDirigido(int capacidad){
        this.capacidad = capacidad;
        matriz_aristas = new int [capacidad][capacidad];
        vertices = new String[capacidad];
        fill();
    }

    public Grafo_Ponderado_NoDirigido(){
        this.capacidad = 10;
        matriz_aristas = new int [capacidad][capacidad];
        fill();
        vertices = new String[capacidad];

    }


    private void fill(){
        for (int i = 0; i< capacidad;i++){
            for (int j = 0; j<capacidad;j++){
                matriz_aristas[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    private int find(String name){
        for (int i = 0; i<vertices.length;i++){
            if (vertices[i] == name){
                return i;
            }
        }
        return -1;
    }


    public void addVertex(String nombre){
        if (capacidad > cantidad_de_vertices){
            for(int i = 0; i< capacidad;i++){
                if (vertices[i] == null){
                    vertices[i] = nombre;
                    cantidad_de_vertices++;
                    break;
                }
            }
        }
        else {
            System.err.println("Se alcanzo la cantidad maxima de vertices");
        }
    }

    public void  addEdge(String a, String b, int value){
        matriz_aristas[find(a)][find(b)] = value;
        cant_aristas++;
    }

    public void deleteEdge(String a, String b){
        matriz_aristas[find(a)][find(b)] = Integer.MAX_VALUE;
        cant_aristas--;
    }

    public void  deleteVertex(String name){
        int position = find(name);
        vertices[position] = null;
        cantidad_de_vertices--;
        for (int i = 0; i < capacidad; i++){
            if (matriz_aristas[position][i] != Integer.MAX_VALUE){
                matriz_aristas[position][i] = Integer.MAX_VALUE;
                cant_aristas--;
            }
            if (matriz_aristas[i][position] != Integer.MAX_VALUE){
                matriz_aristas[i][position] = Integer.MAX_VALUE;
                cant_aristas--;
            }
        }
    }

    public boolean existsEdge(String a, String b ){
        return matriz_aristas[find(a)][find(b)] != Integer.MAX_VALUE;
    }

    public int order(){
        return cantidad_de_vertices;
    }

    public int quantityEdge(){
        return cant_aristas;
    }

    public List<String > listAdy(String name){
        List<String> lista = new ArrayList<>();
        for (int i  = 0; i< capacidad ;i++){
            if(matriz_aristas[find(name)][i] < Integer.MAX_VALUE)lista.add(vertices[i]);
        }
        return lista;
    }

    public void showGraph(){
        System.out.println("Vertices:");
        for (int i =0; i<capacidad;i++){
            if (vertices[i] != null)System.out.print(vertices[i] + ", ");
        }
        System.out.printf("%nAristas:%n");
        for(int i = 0; i< capacidad;i++){
            String fila = vertices[i];
            for (int j = 0 ;j<capacidad;j++){
                String columna = vertices[j];
                if (matriz_aristas[i][j] < Integer.MAX_VALUE){
                    System.out.println(fila+ " -> " + columna + " (" + matriz_aristas[i][j] + ")");
                }
            }
        }


    }


}
