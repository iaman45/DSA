class Solution {

    static class Pair {
        int node;
        int cost;
        int stops;

        Pair(int node, int cost, int stops) {
            this.node = node;
            this.cost = cost;
            this.stops = stops;
        }
    }

    public int findCheapestPrice(int n, int[][] flights,
                                 int src, int dst, int k) {

        ArrayList<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] flight : flights) {
            graph[flight[0]].add(
                new int[]{flight[1], flight[2]}
            );
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(src, 0, 0));
        dist[src] = 0;

        while (!q.isEmpty()) {

            Pair curr = q.poll();

            if (curr.stops > k) {
                continue;
            }

            for (int[] nei : graph[curr.node]) {

                int v = nei[0];
                int price = nei[1];

                if (curr.cost + price < dist[v]
                        && curr.stops <= k) {

                    dist[v] = curr.cost + price;

                    q.offer(
                        new Pair(
                            v,
                            dist[v],
                            curr.stops + 1
                        )
                    );
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE
                ? -1
                : dist[dst];
    }
}