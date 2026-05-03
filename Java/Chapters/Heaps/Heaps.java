import java.util.*;

public class Heaps {
    public static void main(String[] args) {
        // Heap hp = new Heap();

        // hp.add(3);
        // hp.add(4);
        // hp.add(1);
        // hp.add(5);

        // while (!hp.isEmpty()) {
        // System.out.println(hp.remove());
        // }

        // HeapSort hs = new HeapSort();
        // int arr[] = { 1, 2, 4, 3, 5 };

        // hs.maxSort(arr);

        // for (int i = 0; i < arr.length; i++) {
        // System.out.println(arr[i]);
        // }

        // NearbyCar me = new NearbyCar();
        // int pts[][] = { { 3, 3 }, { 5, -1 }, { 2, 4 } };
        // int k = 2;
        // me.nearByCar(pts, k);

        // ConnectRope cr = new ConnectRope();
        // int rope[] = { 2, 3, 3, 4, 6 };
        // System.out.println(cr.minCost(rope));

        // WeakestSoldier row = new WeakestSoldier();
        // int army[][] = { { 1, 0, 0, 0 }, { 1, 1, 1, 1 }, { 1, 0, 0, 0 }, { 1, 0, 0, 0
        // } };

        // row.weakRow(army, 2);

        SlidingWindow sw = new SlidingWindow();
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        System.out.println(sw.maxOfSlidingWindow(arr, 3));

    }
}

class SlidingWindow {
    private class Pair implements Comparable<Pair> {
        int val;
        int idx;

        Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        public int compareTo(Pair p2) {
            return p2.val - this.val;
        }
    }

    public ArrayList<Integer> maxOfSlidingWindow(int arr[], int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            pq.add(new Pair(arr[i], i));
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(pq.peek().val);

        for (int i = k; i < arr.length; i++) {

            while (pq.size() > 0 && pq.peek().idx <= i - k) {
                pq.poll();
            }
            pq.add(new Pair(arr[i], i));
            result.add(pq.peek().val);
        }

        return result;
    }
}

class WeakestSoldier {
    private class Row implements Comparable<Row> {
        int soldiers;
        int row;

        Row(int soldiers, int row) {
            this.soldiers = soldiers;
            this.row = row;
        }

        @Override
        public int compareTo(Row r2) {
            if (this.soldiers == r2.soldiers) {
                return this.row - r2.row;
            }
            return this.soldiers - r2.soldiers;
        }
    }

    public void weakRow(int army[][], int k) {
        PriorityQueue<Row> pq = new PriorityQueue<>();

        for (int i = 0; i < army.length; i++) {
            int count = 0;
            for (int j = 0; j < army[i].length; j++) {
                count += army[i][j] == 1 ? 1 : 0;
            }
            pq.add(new Row(count, i));
        }

        for (int i = 0; i < k; i++) {
            System.out.println("Row " + pq.remove().row);
        }
    }
}

class ConnectRope {
    public int minCost(int rope[]) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < rope.length; i++) {
            pq.add(rope[i]);
        }

        int totalCost = 0;
        while (pq.size() != 1) {
            int first = pq.remove();
            int second = pq.remove();

            int cost = first + second;
            totalCost += cost;

            pq.add(cost);
        }

        return totalCost;
    }
}

class NearbyCar {
    static class Point implements Comparable<Point> {
        int x;
        int y;
        int dist;
        int idx;

        public Point(int x, int y, int dist, int idx) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.idx = idx;
        }

        @Override
        public int compareTo(Point p2) {
            return this.dist - p2.dist;
        }
    }

    public void nearByCar(int pts[][], int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>();

        for (int i = 0; i < pts.length; i++) {
            int dist = (pts[i][0] * pts[i][0]) + (pts[i][1] * pts[i][1]);
            pq.add(new Point(pts[i][0], pts[i][1], dist, i));
        }

        for (int i = 0; i < k; i++) {
            System.out.println("car" + pq.remove().idx);
        }
    }

}

class HeapSort {
    // maxHeap - o(nlogn)
    public void maxSort(int arr[]) {
        int n = arr.length;
        for (int i = n / 2; i >= 0; i--) {
            heapify(i, n, arr);
        }

        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(0, i, arr);
        }
    }

    private void heapify(int i, int n, int arr[]) { // i - root, n - size
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int maxIdx = i;

        if (left < n && arr[left] > arr[maxIdx]) {
            maxIdx = left;
        }

        if (right < n && arr[right] > arr[maxIdx]) {
            maxIdx = right;
        }

        if (maxIdx != i) {
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;

            heapify(maxIdx, n, arr);
        }
    }
}

class Heap {
    ArrayList<Integer> heap = new ArrayList<>();

    public void add(int data) {// O(logn)
        // add at last idx
        heap.add(data);

        int child = heap.size() - 1;
        int parent = (child - 1) / 2;

        // min Heap
        while (heap.get(child) < heap.get(parent)) {
            // swap
            int temp = heap.get(child);
            heap.set(child, heap.get(parent));
            heap.set(parent, temp);

            // check upper
            child = parent;
            parent = (child - 1) / 2;
        }
    }

    public int peek() {
        return heap.get(0);
    }

    public int remove() {
        int data = heap.get(0);

        // swap 1st and last
        heap.set(0, heap.get(heap.size() - 1));
        heap.set(heap.size() - 1, data);

        // delete last
        heap.remove(heap.size() - 1);

        // heapify
        heapify(0);
        return data;
    }

    private void heapify(int i) { // i = root index
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int minIdx = i;

        if (left < heap.size() && heap.get(minIdx) > heap.get(left)) {
            minIdx = left;
        }

        if (right < heap.size() && heap.get(minIdx) > heap.get(right)) {
            minIdx = right;
        }

        if (minIdx != i) {
            int temp = heap.get(i);
            heap.set(i, heap.get(minIdx));
            heap.set(minIdx, temp);

            heapify(minIdx);
        }
    }

    public boolean isEmpty() {
        return heap.size() == 0;
    }
}
