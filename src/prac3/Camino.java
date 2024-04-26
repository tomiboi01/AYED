package ayuda;
import java.util.List;
import java.util.LinkedList;
public class Camino {
	private GeneralTree<Integer> arbol = new GeneralTree<Integer>();
	
	public List<Integer> caminoAHojaMasLejana(){
		if (arbol != null && !arbol.isEmpty())
			return caminoAHojaMasLejana(arbol);
		return new LinkedList<Integer>();
	}
	
	private List<Integer> caminoAHojaMasLejana (GeneralTree<Integer> arb){
		List<Integer> aux;
		LinkedList<Integer> max = new LinkedList<Integer>();
		if (arb.hasChildren())
		{
			for(GeneralTree<Integer> child: arb.getChildren())
			{
				aux = caminoAHojaMasLejana (child);
				if (aux.size() >= max.size())
				{
					max = new LinkedList<Integer>(aux);
				}
			}
			
		}
		
		max.addFirst(arb.getData());
		return max;
		
	}

	public Camino(GeneralTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	
}
