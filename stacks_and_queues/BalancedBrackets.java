package stacks_and_queues;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://www.hackerrank.com/challenges/balanced-brackets/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=stacks-queues
 * <p>
 * A bracket is considered to be any one of the following characters: (, ), {, }, [, or ].
 * <p>
 * Two brackets are considered to be a matched pair if the an opening bracket
 * (i.e., (, [, or {) occurs to the left of a closing bracket (i.e., ), ], or })
 * of the exact same type. There are three types of matched pairs of brackets: [], {}, and ().
 */
public class BalancedBrackets {

    /**
     * Checks if brackets is balanced
     *
     * @param s string with brackets
     * @return YES if balanced else NO
     */
    public static String isBalanced(String s) {
        Deque<Character> openBrackets = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '[' || ch == '{' || ch == '(') {
                openBrackets.push(ch);
            } else {
                if (openBrackets.isEmpty()) {
                    return "NO";
                }
                char topBracket = openBrackets.pop();
                if (ch == ']' && topBracket != '['
                        || ch == '}' && topBracket != '{'
                        || ch == ')' && topBracket != '(') {
                    return "NO";
                }
            }
        }
        if (!openBrackets.isEmpty()) {
            return "NO";
        }
        return "YES";
    }
}
