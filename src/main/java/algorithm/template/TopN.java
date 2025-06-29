package algorithm.template;


import java.util.Arrays;

public class TopN {
    // 父节点下标
    private int parent(int n) {
        return (n - 1) / 2;
    }

    // 左节点下标
    private int left(int n) {
        return 2 * n + 1;
    }

    // 右节点下标
    private int right(int n) {
        return 2 * n + 2;
    }

    // 构建小顶堆，保证父节点小于左右子节点
    private void buildHeap(int n, int[] data) {
        for (int i = 1; i < n; i++) {
            int t = i;
            // 调整堆，如果节点比父亲节点小，则交换
            while (t != 0 && data[t] < data[parent(t)]) {
                // 交换节点
                int temp = data[t];
                data[t] = data[parent(t)];
                data[parent(t)] = temp;
                t = parent(t);
            }
        }
    }

    // 调整data[i]
    private void adjust(int i, int n, int[] data) {
        // 小于堆的根节点，不调整
        if (data[i] <= data[0]) {
            return;
        }

        // 置换堆顶
        int temp = data[i];
        data[i] = data[0];
        data[0] = temp;

        // 调整堆顶
        int t = 0;
        while ((left(t) < n && data[left(t)] < data[t]) || (right(t) < n && data[right(t)] < data[t])) {
            if (right(t) < n && data[right(t)] < data[left(t)]) {
                // 右孩子更小，置换右孩子
                temp = data[t];
                data[t] = data[right(t)];
                data[right(t)] = temp;
                t = right(t);
            } else {
                // 否则置换左孩子
                temp = data[t];
                data[t] = data[left(t)];
                data[left(t)] = temp;
                t = left(t);
            }
        }
    }

    // 寻找topN，调整data，将topN排到最前面
    public int[] findTopN(int n, int[] data) {
        // 先构建n个数的小顶堆
        buildHeap(n, data);
        // n往后的数进行调整
        for (int i = n; i < data.length; i++) {
            adjust(i, n, data);
        }
        return data;
    }

    // 测试方法
    public static void main(String[] args) {
        // 第一组测试 12个
        int[] arr1 = {58, 26, 45, 18, 22, 39, 96, 75, 80, 65, 63, 28};
        System.out.println("原数组：" + Arrays.toString(arr1));
        TopN topn = new TopN();
        int[] result = topn.findTopN(5, arr1);
        System.out.println("数组进行Top-N调整：" + Arrays.toString(result));

        // 第二组测试 随机100个
        int[] tempList = new int[100];
        for (int i = 0; i < 100; i++) {
            tempList[i] = (int) (Math.random() * 1000);
        }
        System.out.println("原数组：" + Arrays.toString(tempList));
        result = topn.findTopN(5, tempList);
        System.out.println("数组进行Top-N调整：" + Arrays.toString(result));
    }
}
