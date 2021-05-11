import edu.princeton.cs.algs4.ST;

import javax.swing.plaf.metal.MetalIconFactory;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Sen Yan
 * @create 2021-04-24-9:26
 */
public class Str {
    /**zigzag string based on a given number of rows */
    public String convert(String s, int numRows) {
        StringBuffer[] list = new StringBuffer[numRows];
        for (int i = 0; i < list.length; i++) {
            list[i] = new StringBuffer();
        }
        for (int i = 0; i < s.length(); i++) {
            int k = i % (2 * numRows - 2);
            if (k <= numRows - 1){
                list[k].append(s.charAt(i));
            }else{
                list[2 * numRows - 2 - k].append(s.charAt(i));
            }
        }
        String result = "";
        for (StringBuffer sb : list){
            result = result.concat(sb.toString());
        }
        return result;
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()){
            if (c == '('){
                stack.push(')');
            }else if(c == '['){
                stack.push(']');
            }else if (c == '{'){
                stack.push('}');
            }else{
                if(stack.isEmpty() || stack.pop() != c){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
/*
leetcode 22
数字 n 代表生成括号的对数，请你设计一个函数，
用于能够生成所有可能的并且 有效的 括号组合。
 */
    public List<String> generateParenthesis(int n) {
        if (n == 1){
            ArrayList<String> list = new ArrayList<>();
            list.add("()");
            return list;
        }
        List<String> parenthesis = generateParenthesis(n - 1);
        ArrayList<String> list = new ArrayList<>();
        for (String s : parenthesis){
            if (!list.contains(s + "()")){
                list.add(s + "()");
            }
            if (!list.contains("()" + s)){
                list.add("()" + s);
            }
            if (!list.contains("(" + s + ")")){
                list.add("(" + s + ")");
            }
        }
        list.addAll(generateParenthesis(n - 1));
        list.removeIf(s -> s.length() != 2 * n);
        return list;
    }

}
