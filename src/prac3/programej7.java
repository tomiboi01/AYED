package ayuda;

import java.util.List;

public class programej7 {

	public static void main(String[] args) {
		GeneralTree<Integer> catorce = new GeneralTree<Integer>(14);
		catorce.addChild(new GeneralTree<Integer>(16));
		catorce.addChild(new GeneralTree<Integer>(7));
		
		GeneralTree<Integer> quince = new GeneralTree<Integer>(15);
		quince.addChild(catorce);
		quince.addChild(new GeneralTree<Integer>(18));
		
		GeneralTree<Integer> nueve = new GeneralTree<Integer>(9);
		nueve.addChild(new GeneralTree<Integer>(8));
		
		GeneralTree<Integer> seis = new GeneralTree<Integer>(6);
		seis.addChild(new GeneralTree<Integer>(1));
		
		GeneralTree<Integer> diecisiete = new GeneralTree<Integer>(17);
		 diecisiete.addChild(new GeneralTree<Integer>(10));
		 diecisiete.addChild(seis);
		 
		 GeneralTree<Integer> arbol = new GeneralTree<Integer>(12);
		 arbol.addChild(diecisiete);
		 arbol.addChild(nueve);
		 arbol.addChild(quince);
		 
		 Camino camino = new Camino(arbol);
		 List<Integer> lista = camino.caminoAHojaMasLejana();
		 for(Integer i : lista)
			 System.out.println(i);
	}

}
