package com.tsun.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xiaoyu.swun
 */
public class BreadthFirstPaths {
    private boolean[] marked;
    private boolean[] edgeTo[];
    private final int s;

    public BreadthFirstPaths(int s) {
        this.s = s;
    }

    private void bfs(Graph G, int s) {
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        marked[s] = true;
        while (!q.isEmpty()) {
            int v = q.poll();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    q.add(w);
                    marked[w] = true;
//                    edgeTo[w] = v;
                }
            }
        }
    }
}
