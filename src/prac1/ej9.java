
/* */

package prac1;
import java.util.Stack;

public class ej9 {

    public static void main(String[] args) {
        System.out.println(estaBalanceado("(((((n}}}}}"));

        


    }

    public static boolean estaBalanceado(String s){
        if (s.isEmpty() || s == null)
            return true;
        Stack<Character> pila = new Stack<Character>();
        for(char c:s.toCharArray()){
            if ((c == '(') || (c == '{') || (c == '['))
                pila.push(c);
            else
                if ((c == ')') || (c == ']') || (c == '}'))
                {
                    if ((pila.isEmpty()) || (pila.pop() != c))
                        return false;
                }
        }
        return pila.isEmpty();
    }


}
    