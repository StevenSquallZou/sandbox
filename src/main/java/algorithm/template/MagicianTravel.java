package algorithm.template;


import java.util.*;


public class MagicianTravel {

    public static int minTotalDistance(int numCities, int[] cityA, int[] cityB, int numMagic, int[][] cityConn) {
        // Build adjacency list with distances
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < numCities; i++) {
            adj.add(new ArrayList<>());
        }

        // Populate adjacency list from cityConn
        for (int[] conn : cityConn) {
            int u = conn[0];
            int v = conn[1];
            int distance = conn[2];
            adj.get(u).add(new int[]{v, distance});
            adj.get(v).add(new int[]{u, distance});
        }

        // Collect all road distances
        List<Integer> distances = new ArrayList<>();
        boolean[] visited = new boolean[numCities];
        dfs(0, adj, visited, distances);

        // Calculate total distance
        int totalDistance = 0;
        for (int d : distances) {
            totalDistance += d;
        }

        // If we can eliminate roads, remove the largest distances first
        if (numMagic > 0 && !distances.isEmpty()) {
            distances.sort(Collections.reverseOrder());
            for (int i = 0; i < Math.min(numMagic, distances.size()); i++) {
                totalDistance -= distances.get(i);
            }
        }

        return totalDistance;
    }

    private static void dfs(int city, List<List<int[]>> adj, boolean[] visited, List<Integer> distances) {
        visited[city] = true;
        for (int[] neighbor : adj.get(city)) {
            int nextCity = neighbor[0];
            int distance = neighbor[1];
            if (!visited[nextCity]) {
                distances.add(distance);
                dfs(nextCity, adj, visited, distances);
            }
        }
    }

    public static void main(String[] args) {
        // Example usage
        int numCities = 4;
        int[] cityA = {0, 1, 2};
        int[] cityB = {1, 2, 3};
        int numMagic = 2;
        int[][] cityConn = {{0, 1, 5}, {1, 2, 10}, {2, 3, 15}};

        int result = minTotalDistance(numCities, cityA, cityB, numMagic, cityConn);
        System.out.println("Minimum total distance: " + result); // Output: 5
    }
}