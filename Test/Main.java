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
        grafo.addEdge("madrid", "Valencia",20);
        grafo.addEdge("Asturias", "barcelona",15);
        grafo.addEdge("madrid", "Asturias",8);
        grafo.addEdge("Valencia", "barcelona",19);

        Assert.assertEquals(grafo.order(), 4);
        Assert.assertEquals(grafo.quantityEdge(),4);
//        grafo.deleteEdge("madrid","Valencia");
//        Assert.assertEquals(grafo.quantityEdge(),3);
//        grafo.deleteVertex("Valencia");
//        Assert.assertEquals(grafo.quantityEdge(),2);

        Assert.assertFalse(grafo.existsEdge("Valencia","madrid"));
        Assert.assertTrue(grafo.existsEdge("madrid","Valencia"));
        grafo.listAdy("madrid").forEach(word-> System.out.println(word));




    }
}

