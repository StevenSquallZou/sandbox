package algorithm.template;


import java.util.*;


/**
https://leetcode.cn/problems/network-delay-time/description/
743. 网络延迟时间
有 n 个网络节点，标记为 1 到 n。
给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， wi 是一个信号从源节点传递到目标节点的时间。
现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。

示例 1：
输入：times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
输出：2

示例 2：
输入：times = [[1,2,1]], n = 2, k = 1
输出：1

示例 3：
输入：times = [[1,2,1]], n = 2, k = 2
输出：-1
*/

public class NetworkDelay {
    public int networkDelayTime(int[][] times, int n, int k) {
        // 创建图的邻接表表示
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : times) {
            graph.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(new int[]{edge[1], edge[2]});
        }

        // 最短路径估计值，初始化为无穷大
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0; // 源点到自己的距离是0

        // 使用优先队列优化Dijkstra算法
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{k, 0}); // 从源点开始

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int d = curr[1];

            if (d > dist[node]) continue; // 如果当前节点的距离大于已知最短距离，则跳过

            // 遍历当前节点的所有邻接节点
            if (graph.containsKey(node)) {
                for (int[] edge : graph.get(node)) {
                    int next = edge[0];
                    int dNext = d + edge[1];
                    // 如果找到更短的路径，则更新并加入优先队列
                    if (dNext < dist[next]) {
                        dist[next] = dNext;
                        pq.offer(new int[]{next, dNext});
                    }
                }
            }
        }

        // 找到最长的最短路径
        int maxWait = Arrays.stream(dist).skip(1).max().getAsInt();
        return maxWait == Integer.MAX_VALUE ? -1 : maxWait;
    }
}
