package algorithm;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


/**
 * Valid inputs can be : (){}[]
 * Logic:
 *      Number of opening bracket and closing bracket has to be same.
 *      Bracket should be opened before closing.
 * Example:
 *      (){}[] - balanced
 *      (({{))}} - balanced
 *      ({) - unbalanced
 *      (}) - unbalanced
 */
@Slf4j
public class BalancedBracketChecker {

    public static void main(String[] args) {
        log.info("BalancedBracketChecker started");

        BalancedBracketChecker balancedBracketChecker = new BalancedBracketChecker();

        String input = "(){}[]";
        boolean result = balancedBracketChecker.checkBracketBalanced(input);
        log.info("result: {}", result);

        log.info("BalancedBracketChecker ended");
    }


    public boolean checkBracketBalanced(String input) {
        if (StringUtils.isBlank(input)) {
            log.warn("input is blank, return false");
            return false;
        }

        Map<Character, Stack<Character>> stackMap = initStackMap();

        for (int i = 0; i < input.length(); i++) {
            char character = input.charAt(i);
            Stack<Character> characterStack = stackMap.get(character);
            if (characterStack == null) {
                log.info("stack NOT found in stackMap, unsupported character: {}", character);
                return false;
            }

            if (isOpeningBracket(character)) {
                characterStack.push(character);
            } else if (isClosingBracket(character)) {
                if (characterStack.isEmpty()) {
                    return false;
                } else {
                    characterStack.pop();
                }
            } else {
                log.info("unrecognized character: {}", character);
                return false;
            }
        }

        return checkAllStacks(stackMap);
    }


    private boolean isClosingBracket(char character) {
        return character == ')' || character == '}' || character == ']';
    }


    private boolean isOpeningBracket(char character) {
        return character == '(' || character == '{' || character == '[';
    }


    private Map<Character, Stack<Character>> initStackMap() {
        Map<Character, Stack<Character>> stackMap = new HashMap<>();

        Stack<Character> stack1 = new Stack<>();
        stackMap.put('(', stack1);
        stackMap.put(')', stack1);

        Stack<Character> stack2 = new Stack<>();
        stackMap.put('{', stack2);
        stackMap.put('}', stack2);

        Stack<Character> stack3 = new Stack<>();
        stackMap.put('[', stack3);
        stackMap.put(']', stack3);

        return stackMap;
    }


    private boolean checkAllStacks(Map<Character, Stack<Character>> stackMap) {
        for (Stack<Character> characterStack : stackMap.values()) {
            if (!characterStack.isEmpty()) {
                return false;
            }
        }

        return true;
    }

}
