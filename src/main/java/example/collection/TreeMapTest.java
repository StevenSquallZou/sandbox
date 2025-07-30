package example.collection;


import lombok.extern.slf4j.Slf4j;
import java.util.Map;
import java.util.TreeMap;


@Slf4j
public class TreeMapTest {

    public static void main(String[] args) {
        log.info("Started");

        TreeMap<String, Integer> treeMap = new TreeMap<>();
        // 添加示例数据
        treeMap.put("ac", 10);
        treeMap.put("ab", 15);
        treeMap.put("aa", 20);

        // 遍历方式
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            log.info("Key: {}, Value: ", entry.getKey(), entry.getValue());
        }

        log.info("Ended");
    }

}
