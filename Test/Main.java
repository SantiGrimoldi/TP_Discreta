import org.testng.Assert;
import org.testng.annotations.Test;

public class Main {


    @Test
    public static void test_grafo() {
        Grafo_Ponderado_NoDirigido grafo = new Grafo_Ponderado_NoDirigido();
        grafo.addVertex("madrid");
        grafo.addVertex("barcelona");
        grafo.addVertex("Valencia");
        grafo.addVertex("Asturias");
        grafo.addVertex("Galicia");
//        grafo.addVertex("Getafe");
        grafo.addEdge("madrid", "Valencia",20);
        grafo.addEdge("Asturias", "barcelona",15);
        grafo.addEdge("madrid", "Asturias",8);
        grafo.addEdge("Valencia", "barcelona",19);
        grafo.addEdge("Galicia", "barcelona",12);
        grafo.addEdge("Galicia", "Asturias",12);
        grafo.addEdge("Galicia", "Valencia",12);

        System.out.println(grafo.isGraphConexo());
        grafo.showGraph();
        grafo.fuentes().forEach(word-> System.out.println(word));
        grafo.sumideros().forEach(word-> System.out.println(word));

    }

    @Test
    public static void Test_recorridos(){
        Grafo_Ponderado_NoDirigido grafo = new Grafo_Ponderado_NoDirigido();
        grafo.addVertex("madrid");
        grafo.addVertex("barcelona");
        grafo.addVertex("Valencia");
        grafo.addVertex("Asturias");
        grafo.addVertex("Galicia");
        grafo.addVertex("Getafe");
        grafo.addEdge("madrid","barcelona",1);
        grafo.addEdge("barcelona","Valencia",2);
        grafo.addEdge("Valencia", "Asturias",3);
        grafo.addEdge("Asturias", "Galicia",4);
//        grafo.cercanos("madrid").forEach(word->System.out.println(word));
        System.out.println(grafo.isGraphConexo());


    }


    @Test
    public static void Test_conexos(){
        Grafo_Ponderado_NoDirigido grafo = new Grafo_Ponderado_NoDirigido();
        grafo.addVertex("a");
        grafo.addVertex("b");
        grafo.addVertex("c");
        grafo.addVertex("d");
        grafo.addEdge("a","b",2);
        grafo.addEdge("b","c",2);
        grafo.addEdge("c","d",2);
        grafo.addEdge("d","a",2);
        System.out.println(grafo.isGraphConexo());
    }
}

