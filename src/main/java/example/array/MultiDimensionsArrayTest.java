package example.array;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import java.util.ArrayList;
import java.util.List;


/**
 * int[2][3]: there are 2 rows in the array, each row has 3 columns:
 *     [
 *       [0, 0, 0],
 *       [0, 0, 0]
 *     ]
 * or
 *     [0][0], [0][1], [0][2]
 *     [1][0], [1][1], [1][2]
 */
@Slf4j
public class MultiDimensionsArrayTest {

    public static void main(String[] args) {
        log.info("Started");

        int[][] array = new int[2][3];
        log.info("int[2][3] length: {}", array.length);

        for (int i = 0; i < array.length; i++) {
            log.info("----------array[{}].length: {}----------", i, array[i].length);

            List<String> list = new ArrayList<>();
            for (int j = 0; j < array[i].length; j++) {
                list.add(String.format("[%d][%d]", i, j));
            }
            log.info("{}", StringUtils.join(list, ", "));
        }

        log.info("Ended");
    }

}