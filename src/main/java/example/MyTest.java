package example;


import lombok.extern.slf4j.Slf4j;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;


@Slf4j
public class MyTest {
    private static final String USER_QUERY_WITH_LIMIT =
        """
        SELECT
            u.user_id, u.username, u.password_hash, r.resource_name
        FROM profile.user_resource ur
        JOIN profile.users u ON u.user_id = ur.user_id
        JOIN profile.resource r ON r.resource_id = ur.resource_id
        ORDER BY ur.user_resource_id
        LIMIT %d
        OFFSET %d
        """;


    public static void main(String[] args) {
        log.info("Started");

        Object result = USER_QUERY_WITH_LIMIT;
        log.info("Result: \n{}", result);

        log.info("Ended");
    }

}