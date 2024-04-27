package prac3;
import java.util.List;
import java.util.LinkedList;
public class Camino {
	private GeneralTree<Integer> arbol = new GeneralTree<Integer>();
	
	public List<Integer> caminoAHojaMasLejana()
	{
		List<Integer> max = new LinkedList<Integer>();
		List<Integer> actual = new LinkedList<Integer>();
		if (arbol != null && !arbol.isEmpty())
			caminoAHojaMasLejana(arbol, max, actual);
		return max;
	}
	
	private void caminoAHojaMasLejana (GeneralTree<Integer> arb, List<Integer> max, List<Integer> actual){
		actual.add(arb.getData());
		if (arb.isLeaf() && actual.size() > max.size())
			{
				max.clear();
				max.addAll(actual);
			}

		for(GeneralTree<Integer> child: arb.getChildren())
			caminoAHojaMasLejana (child, max, actual);
		
		actual.remove(actual.size()-1);
	
}

	public Camino(GeneralTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	
}
