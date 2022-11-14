import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

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
                if(i!=j) {
                    matriz_aristas[i][j] = Integer.MAX_VALUE;
                }
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



    public List<String> fuentes(){
        List<String> lista = new ArrayList<>();

        for(int i = 0; i<capacidad;i++){
            boolean fuente = true;
            for ( int j = 0; j <capacidad;j++){
                if (matriz_aristas[j][i] != Integer.MAX_VALUE){
                    fuente = false;
                    break;
                }
            }
            if (fuente){
                lista.add(vertices[i]);
            }
        }
        return lista;
    }

    public List<String> sumideros(){
        List<String> lista = new ArrayList<>();
        for (int i = 0; i<capacidad ; i++){
            boolean sumidero = true;
            for (int j = 0; j< capacidad;j++){
                if (matriz_aristas[i][j] != Integer.MAX_VALUE){
                    sumidero = false;
                    break;
                }
            }
            if (sumidero){
                lista.add(vertices[i]);
            }
        }
        return lista;
    }


    public List<String> cercanos(String name){
        List<String> lista = new ArrayList<>();
        boolean[] booleanos = new boolean[capacidad];
        lista.add(name);
        cercanos(find(name), 0,lista, booleanos);
        return lista;
    }

    private void cercanos(int vertice, int recorrido, List<String> list,boolean[] booleanos){
        if (recorrido > 1){
            return;
        }
        else {
            for (int i =0; i<capacidad;i++){
                if (matriz_aristas[vertice][i]!=Integer.MAX_VALUE && !booleanos[i]){
                    list.add(vertices[i]);
                    booleanos[i] = true;
                    cercanos(i,recorrido+1,list,booleanos);
                }
            }
        }

    }


    public boolean isGraphConexo(){
        for (int i = 0; i < cantidad_de_vertices; i++) {
            if (!isVertexConexo(vertices[i]))
                return false;
        }
        return true;
    }

    public boolean isVertexConexo(String vertex){
        boolean[] visited = new boolean[cantidad_de_vertices];
        visited[find(vertex)] = true;
        checkGraph(listAdy(vertex).get(0), visited);
        return visitedAll(visited);

    }

    private void checkGraph(String vertex, boolean[] visited){
        if (!visited[find(vertex)] && !listAdy(vertex).isEmpty()) {
            visited[find(vertex)] = true;
            checkGraph(listAdy(vertex).get(0), visited);
        }
    }

    private boolean visitedAll(boolean[] visited){
        for (int i = 0; i < visited.length; i++){
            if (!visited[0]) return false;
        }
        return true;
    }


    public void dijkstra(String name){
        int starting_position = find(name);
        Integer[] s = new Integer[capacidad];
        s[0] = starting_position;
        int[] peso_camino = matriz_aristas[starting_position];
        int[] vertice_aneterior = new int[capacidad];
        for (int i = 0; i< vertice_aneterior.length;i++){
            vertice_aneterior[i] = starting_position;
        }
        boolean[] checked = new boolean[capacidad];
        for (int i = 0; i<capacidad;i++){
            if(s[i]!=null){
                checked[s[i]] = true;
            }
        }
        for(int i = 1; i< capacidad ;i++){
            int min = findmin(starting_position,checked);
            int road = peso_camino[min];
            s[i] = min;
            checked[min] = true;
            for (int j = 0; j<capacidad;j++){
                if (!checked[j]){
                    if(matriz_aristas[min][j] == Integer.MAX_VALUE)continue;
                     int nuevo_camino = road + matriz_aristas[min][j];
                     if(nuevo_camino < peso_camino[j]){
                         peso_camino[j] = nuevo_camino;
                         vertice_aneterior[j] = min;
                     }
                }
            }
        }
        System.out.print("Peso caminos: %n[");
        for (int i = 0;i<capacidad;i++){
            System.out.print(peso_camino[i]+", ");
        }
        System.out.println("]");
        System.out.print("Vertice anterior: %n[");
        for (int i = 0;i<capacidad;i++){
            System.out.print(vertice_aneterior[i]+", ");
        }
        System.out.println("]");



    }

    private int findmin(int position, boolean[] checked){
        int min = Integer.MAX_VALUE;
        int devolver = 0;
        for (int i = 0; i<capacidad;i++){
            if (matriz_aristas[position][i]<min && !checked[i]){
                min = matriz_aristas[position][i];
                devolver = i;
            }
        }
        return devolver;
    }



}
