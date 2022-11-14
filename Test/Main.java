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

    @Test
    public static void test(){
        int[] a = new int[5];
        System.out.println(a[2]);
    }


    @Test
    public static void Dijkstra(){
        Grafo_Ponderado_NoDirigido grafo = new Grafo_Ponderado_NoDirigido(5);
        grafo.addVertex("1");
        grafo.addVertex("2");
        grafo.addVertex("3");
        grafo.addVertex("4");
        grafo.addVertex("5");
        grafo.addEdge("1","2",10);
        grafo.addEdge("2","1",10);
        grafo.addEdge("1","4",30);
        grafo.addEdge("4","1",30);
        grafo.addEdge("1","5",100);
        grafo.addEdge("5","1",100);
        grafo.addEdge("2","3",50);
        grafo.addEdge("3","2",50);
        grafo.addEdge("3","4",20);
        grafo.addEdge("4","3",20);
        grafo.addEdge("3","5",10);
        grafo.addEdge("5","3",10);
        grafo.addEdge("4","5",60);
        grafo.addEdge("5","4",60);
        grafo.dijkstra("1");


    }

    @Test
    public static void parque(){
        String[][] datos = new String[][]{
                new String[]{"Entrada","p1","10"},
                new String[]{"Entrada","p2","5"},
                new String[]{"Entrada","p3","8"},
                new String[]{"Entrada","p4","13"},
                new String[]{"Entrada","p5","9"},
                new String[]{"p3","p1","1"},
                new String[]{"p2","p5","1"},

        };
        Parque_nacional parque_nacional = new Parque_nacional(datos);
        parque_nacional.printCaminos();
    }
}

