package com.quiz.chat4;

import java.util.*;

public class GraphBFS {
    // 图的邻接表表示：Map<节点, 邻接节点列表>
    private Map<Integer, List<Integer>> adjList;

    public GraphBFS() {
        adjList = new HashMap<>();
    }

    // 添加无向边（可修改为有向）
    public void addEdge(int u, int v) {
        adjList.putIfAbsent(u, new ArrayList<>());
        adjList.putIfAbsent(v, new ArrayList<>());
        adjList.get(u).add(v);

    }
    // BFS 遍历函数
    public List<Integer> bfs(int start) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);

            for (int neighbor : adjList.getOrDefault(node, Collections.emptyList())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }

        return result;
    }
    public static void main(String[] args) {
        GraphBFS graph = new GraphBFS();

        // 构建一个示例图
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);

        // 执行 BFS
        List<Integer> bfsResult = graph.bfs(0);
        System.out.println("BFS Traversal: " + bfsResult);
    }
}
