package com.jedi.algo.find;

public class UF {
    private int[] ids;
    private int count;

    public UF(int n) {
        count = n;
        ids = new int[n];
        for (int i = 0; i < n; i++) {
            ids[i] = i;
        }
    }

    public int getCount() {
        return count;
    }

    private int find(int p) {
        return ids[p];
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);

        if (pId == qId) return;

        for (int i = 0; i < ids.length; i++) {
            if (ids[i] == pId) ids[i] = qId;
        }
    }

    public int quickFind(int p){
        while (p != ids[p]){
            p = ids[p];
        }
        return p;
    }
    // p = 3, q = 4
    // 3 == 3 and 4 == 4
    // ids[3] = 3 ids[4] = 4
    public void quickUnion(int p, int q) {
        int pId = find(p);
        ids[q] = pId;
    }
}
