package prac3;

import java.util.*;

public class program {
    public static void main(String[] args) {

        GeneralTree<Character> mushu = new GeneralTree<Character>('c');
        mushu.addChild(new GeneralTree<Character>('d'));
        mushu.addChild(new GeneralTree<Character>('e'));;
;
        GeneralTree<Character> zazu = new GeneralTree<Character>('c');

        zazu.addChild(new GeneralTree<Character>('f'));
       

        GeneralTree<Character> coyote = new GeneralTree<Character>('A');

        coyote.addChild(new GeneralTree<Character>('b'));
        coyote.addChild(mushu);
        coyote.addChild(zazu);

        
        System.out.println("");
        

        mushu.addChild(new GeneralTree<Character>('g'));
        zazu.addChild(new GeneralTree<Character>('g'));
        coyote.addChild(new GeneralTree<Character>('g'));
        zazu.addChild(new GeneralTree<Character>('g'));
        coyote.PorNiveles();
        System.out.println(coyote.ancho());

    }
}
