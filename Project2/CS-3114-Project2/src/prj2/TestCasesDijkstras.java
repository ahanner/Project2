package prj2;

import static org.junit.Assert.assertEquals;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Test;

public class TestCasesDijkstras {

    public InputDijkstras readFile(String name) {
        int n = -1;
        int m = -1;
        int source = 0;
        int count = 0;
        int[][] edges = new int[1][1];
        int[] distances = new int[1];
        try {
            File myObj = new File(name);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] splited = data.split(" ", 0);
                if (n == -1) {
                    n = Integer.valueOf(splited[0]);
                    m = Integer.valueOf(splited[1]);
                    source = Integer.valueOf(splited[2]);
                    edges = new int[m][3];
                }
                else if (count < m) {
                    edges[count][0] = Integer.valueOf(splited[0]);
                    edges[count][1] = Integer.valueOf(splited[1]);
                    edges[count][2] = Integer.valueOf(splited[2]);
                    count += 1;
                }
                else {
                    distances = new int[n];
                    for (int i = 0; i < n; i++) {
                        distances[i] = Integer.valueOf(splited[i]);
                    }
                }
            }
            myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return new InputDijkstras(n, edges, distances, source);
    }


    @Test
    public void testwith1() {
        InputDijkstras test = readFile("graphs/test1.txt");
        int n = test.n;
        int[][] edges = test.edges;
        DijkstrasWithHeap dWith = new DijkstrasWithHeap(n, edges);
        int[] distancesWith = dWith.run(test.source);
        int[] expectedDistances = test.distances;

        for (int i = 0; i < n; i++) {
            assertEquals(
                "There seems to be a problem with your dijkstrasWithHeap implementation",
                distancesWith[i], expectedDistances[i]);
        }
    }


    @Test
    public void testwithout1() {
        InputDijkstras test = readFile("graphs/test1.txt");
        int n = test.n;
        int[][] edges = test.edges;
        DijkstrasWithoutHeap dWithout = new DijkstrasWithoutHeap(n, edges);
        int[] distancesWithout = dWithout.run(test.source);
        int[] expectedDistances = test.distances;

        for (int i = 0; i < n; i++) {
            assertEquals(
                "There seems to be a problem with your dijkstrasWithoutHeap implementation",
                distancesWithout[i], expectedDistances[i]);
        }
    }


    @Test
    public void testwith2() {
        InputDijkstras test = readFile("graphs/test2.txt");
        int n = test.n;
        int[][] edges = test.edges;
        DijkstrasWithHeap dWith = new DijkstrasWithHeap(n, edges);
        int[] distancesWith = dWith.run(test.source);
        int[] expectedDistances = test.distances;

        for (int i = 0; i < n; i++) {
            assertEquals(
                "There seems to be a problem with your dijkstrasWithHeap implementation",
                distancesWith[i], expectedDistances[i]);
        }
    }


    @Test
    public void testwithout2() {
        InputDijkstras test = readFile("graphs/test2.txt");
        int n = test.n;
        int[][] edges = test.edges;
        DijkstrasWithoutHeap dWithout = new DijkstrasWithoutHeap(n, edges);
        int[] distancesWithout = dWithout.run(test.source);
        int[] expectedDistances = test.distances;

        for (int i = 0; i < n; i++) {
            assertEquals(
                "There seems to be a problem with your dijkstrasWithoutHeap implementation",
                distancesWithout[i], expectedDistances[i]);
        }
    }


    @Test
    public void testwith3() {
        InputDijkstras test = readFile("graphs/test3.txt");
        int n = test.n;
        int[][] edges = test.edges;
        DijkstrasWithHeap dWith = new DijkstrasWithHeap(n, edges);
        int[] distancesWith = dWith.run(test.source);
        int[] expectedDistances = test.distances;

        for (int i = 0; i < n; i++) {
            assertEquals(
                "There seems to be a problem with your dijkstrasWithHeap implementation",
                distancesWith[i], expectedDistances[i]);
        }
    }


    @Test
    public void testwithout3() {
        InputDijkstras test = readFile("graphs/test3.txt");
        int n = test.n;
        int[][] edges = test.edges;
        DijkstrasWithoutHeap dWithout = new DijkstrasWithoutHeap(n, edges);
        int[] distancesWithout = dWithout.run(test.source);
        int[] expectedDistances = test.distances;

        for (int i = 0; i < n; i++) {
            assertEquals(
                "There seems to be a problem with your dijkstrasWithoutHeap implementation",
                distancesWithout[i], expectedDistances[i]);
        }
    }


    @Test
    public void testwith4() {
        InputDijkstras test = readFile("graphs/test4.txt");
        int n = test.n;
        int[][] edges = test.edges;
        DijkstrasWithHeap dWith = new DijkstrasWithHeap(n, edges);
        int[] distancesWith = dWith.run(test.source);
        int[] expectedDistances = test.distances;

        for (int i = 0; i < n; i++) {
            assertEquals(
                "There seems to be a problem with your dijkstrasWithHeap implementation",
                distancesWith[i], expectedDistances[i]);
        }
    }


    @Test
    public void testwithout4() {
        InputDijkstras test = readFile("graphs/test4.txt");
        int n = test.n;
        int[][] edges = test.edges;
        DijkstrasWithoutHeap dWithout = new DijkstrasWithoutHeap(n, edges);
        int[] distancesWithout = dWithout.run(test.source);
        int[] expectedDistances = test.distances;

        for (int i = 0; i < n; i++) {
            assertEquals(
                "There seems to be a problem with your dijkstrasWithoutHeap implementation",
                distancesWithout[i], expectedDistances[i]);
        }
    }


    @Test
    public void testwith5() {
        InputDijkstras test = readFile("graphs/test5.txt");
        int n = test.n;
        int[][] edges = test.edges;
        DijkstrasWithHeap dWith = new DijkstrasWithHeap(n, edges);
        int[] distancesWith = dWith.run(test.source);
        int[] expectedDistances = test.distances;

        for (int i = 0; i < n; i++) {
            assertEquals(
                "There seems to be a problem with your dijkstrasWithHeap implementation",
                distancesWith[i], expectedDistances[i]);
        }
    }


    @Test
    public void testwithout5() {
        InputDijkstras test = readFile("graphs/test5.txt");
        int n = test.n;
        int[][] edges = test.edges;
        DijkstrasWithoutHeap dWithout = new DijkstrasWithoutHeap(n, edges);
        int[] distancesWithout = dWithout.run(test.source);
        int[] expectedDistances = test.distances;

        for (int i = 0; i < n; i++) {
            assertEquals(
                "There seems to be a problem with your dijkstrasWithoutHeap implementation",
                distancesWithout[i], expectedDistances[i]);
        }
    }


    @Test
    public void testwith6() {
        InputDijkstras test = readFile("graphs/test6.txt");
        int n = test.n;
        int[][] edges = test.edges;
        DijkstrasWithHeap dWith = new DijkstrasWithHeap(n, edges);
        int[] distancesWith = dWith.run(test.source);
        int[] expectedDistances = test.distances;

        for (int i = 0; i < n; i++) {
            assertEquals(
                "There seems to be a problem with your dijkstrasWithHeap implementation",
                distancesWith[i], expectedDistances[i]);
        }
    }


    @Test
    public void testwithout6() {
        InputDijkstras test = readFile("graphs/test6.txt");
        int n = test.n;
        int[][] edges = test.edges;
        DijkstrasWithoutHeap dWithout = new DijkstrasWithoutHeap(n, edges);
        int[] distancesWithout = dWithout.run(test.source);
        int[] expectedDistances = test.distances;

        for (int i = 0; i < n; i++) {
            assertEquals(
                "There seems to be a problem with your dijkstrasWithoutHeap implementation",
                distancesWithout[i], expectedDistances[i]);
        }
    }


    @Test
    public void testwith7() {
        InputDijkstras test = readFile("graphs/test7.txt");
        int n = test.n;
        int[][] edges = test.edges;
        DijkstrasWithHeap dWith = new DijkstrasWithHeap(n, edges);
        int[] distancesWith = dWith.run(test.source);
        int[] expectedDistances = test.distances;

        for (int i = 0; i < n; i++) {
            assertEquals(
                "There seems to be a problem with your dijkstrasWithHeap implementation",
                distancesWith[i], expectedDistances[i]);
        }
    }


    @Test
    public void testwithout7() {
        InputDijkstras test = readFile("graphs/test7.txt");
        int n = test.n;
        int[][] edges = test.edges;
        DijkstrasWithoutHeap dWithout = new DijkstrasWithoutHeap(n, edges);
        int[] distancesWithout = dWithout.run(test.source);
        int[] expectedDistances = test.distances;

        for (int i = 0; i < n; i++) {
            assertEquals(
                "There seems to be a problem with your dijkstrasWithoutHeap implementation",
                distancesWithout[i], expectedDistances[i]);
        }
    }


    @Test
    public void testwith8() {
        InputDijkstras test = readFile("graphs/test8.txt");
        int n = test.n;
        int[][] edges = test.edges;
        DijkstrasWithHeap dWith = new DijkstrasWithHeap(n, edges);
        int[] distancesWith = dWith.run(test.source);
        int[] expectedDistances = test.distances;

        for (int i = 0; i < n; i++) {
            assertEquals(
                "There seems to be a problem with your dijkstrasWithHeap implementation",
                distancesWith[i], expectedDistances[i]);
        }
    }


    @Test
    public void testwithout8() {
        InputDijkstras test = readFile("graphs/test8.txt");
        int n = test.n;
        int[][] edges = test.edges;
        DijkstrasWithoutHeap dWithout = new DijkstrasWithoutHeap(n, edges);
        int[] distancesWithout = dWithout.run(test.source);
        int[] expectedDistances = test.distances;

        for (int i = 0; i < n; i++) {
            assertEquals(
                "There seems to be a problem with your dijkstrasWithoutHeap implementation",
                distancesWithout[i], expectedDistances[i]);
        }
    }


    @Test
    public void testwith9() {
        InputDijkstras test = readFile("graphs/test9.txt");
        int n = test.n;
        int[][] edges = test.edges;
        DijkstrasWithHeap dWith = new DijkstrasWithHeap(n, edges);
        int[] distancesWith = dWith.run(test.source);
        int[] expectedDistances = test.distances;

        for (int i = 0; i < n; i++) {
            assertEquals(
                "There seems to be a problem with your dijkstrasWithHeap implementation",
                distancesWith[i], expectedDistances[i]);
        }
    }


    @Test
    public void testwithout9() {
        InputDijkstras test = readFile("graphs/test9.txt");
        int n = test.n;
        int[][] edges = test.edges;
        DijkstrasWithoutHeap dWithout = new DijkstrasWithoutHeap(n, edges);
        int[] distancesWithout = dWithout.run(test.source);
        int[] expectedDistances = test.distances;

        for (int i = 0; i < n; i++) {
            assertEquals(
                "There seems to be a problem with your dijkstrasWithoutHeap implementation",
                distancesWithout[i], expectedDistances[i]);
        }
    }


    @Test
    public void testwith10() {
        InputDijkstras test = readFile("graphs/test10.txt");
        int n = test.n;
        int[][] edges = test.edges;
        DijkstrasWithHeap dWith = new DijkstrasWithHeap(n, edges);
        int[] distancesWith = dWith.run(test.source);
        int[] expectedDistances = test.distances;

        for (int i = 0; i < n; i++) {
            assertEquals(
                "There seems to be a problem with your dijkstrasWithHeap implementation",
                distancesWith[i], expectedDistances[i]);
        }
    }


    @Test
    public void testwithout10() {
        InputDijkstras test = readFile("graphs/test10.txt");
        int n = test.n;
        int[][] edges = test.edges;
        DijkstrasWithoutHeap dWithout = new DijkstrasWithoutHeap(n, edges);
        int[] distancesWithout = dWithout.run(test.source);
        int[] expectedDistances = test.distances;

        for (int i = 0; i < n; i++) {
            assertEquals(
                "There seems to be a problem with your dijkstrasWithoutHeap implementation",
                distancesWithout[i], expectedDistances[i]);
        }
    }

    class InputDijkstras {
        public int n;
        public int[][] edges;
        public int[] distances;
        public int source;

        public InputDijkstras(
            int n,
            int[][] edges,
            int[] distances,
            int source) {
            this.n = n;
            this.edges = edges;
            this.distances = distances;
            this.source = source;
        }
    }

}
