package prac3;

public class Navidad {
	private GeneralTree<Integer> arbol = new GeneralTree<Integer>();
	
	
	
	public String esAbetoNavidenio()
	{
		String ret = "No";
		if (arbol != null && esAbetoNavidenio(arbol))
			ret = "Yes";
		return ret;
	}
	
	public boolean esAbetoNavidenio(GeneralTree<Integer> arb)
	{
		if (arb.isLeaf() || arb.getChildren().size() < 3)
			return false;
		
		boolean aux = true;
		for(GeneralTree<Integer> child:arb.getChildren())
			aux &= esAbetoNavidenio(child);
		return aux;
	}

}
