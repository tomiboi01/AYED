package prac3;


public class programej7 {

	public static void main(String[] args) {
		
		GeneralTree<Integer> dosuno = new GeneralTree<Integer>(1);
		dosuno.addChild(new GeneralTree<Integer>(1));
		dosuno.addChild(new GeneralTree<Integer>(1));
		dosuno.addChild(new GeneralTree<Integer>(1));
		
		GeneralTree<Integer> unouno = new GeneralTree<Integer>(0);
		unouno.addChild(dosuno);
		unouno.addChild(new GeneralTree<Integer>(1));
		
		GeneralTree<Integer> trescuatro = new GeneralTree<Integer>(0);
		trescuatro.addChild(new GeneralTree<Integer>(1));
		
		GeneralTree<Integer> doscuatro = new GeneralTree<Integer>(0);
		doscuatro.addChild(trescuatro);
		
		

		
		GeneralTree<Integer> unodos = new GeneralTree<Integer>(1);
		unodos.addChild(new GeneralTree<Integer>(1));
		unodos.addChild(doscuatro);
		
		
		
		GeneralTree<Integer> trescinco = new GeneralTree<Integer>(0);
		trescinco.addChild(new GeneralTree<Integer>(0));
		trescinco.addChild(new GeneralTree<Integer>(0));
		
		GeneralTree<Integer> doscinco = new GeneralTree<Integer>(0);
		doscinco.addChild(trescinco);
		
		GeneralTree<Integer> unotres = new GeneralTree<Integer>(1);
		unotres.addChild(doscinco);
		
		 
		 GeneralTree<Integer> cero = new GeneralTree<Integer>(1);
		 cero.addChild(unouno);
		 cero.addChild(unodos);
		 cero.addChild(unotres);

		 cero.PorNiveles();
		 Camino camino = new Camino(cero);
		 for(Integer i: camino.caminoAHojaMasLejana())
			 System.out.println(i);
	}
	
	

}