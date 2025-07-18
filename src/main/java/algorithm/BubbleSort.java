package algorithm;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;


@Slf4j
public class BubbleSort {

    // 冒泡排序基础版本
    @Test
    public void bubbleSort() {
        int[] arr = {5, 3, 2, 4, 1};

        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 交换 arr[j] 和 arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        log.info("sorted array: {}", arr);
    }


    // 冒泡排序优化版本（检测是否已排序）
    @Test
    public void bubbleSortOptimized() {
        int[] arr = {5, 3, 2, 4, 1};

        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 交换 arr[j] 和 arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // 如果这一轮没有发生交换，说明数组已经有序
            if (!swapped) break;
        }

        log.info("sorted array: {}", arr);
    }

}
