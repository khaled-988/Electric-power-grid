public class PowerGridUtils {
	// Return the IDs of all elements in the power grid pg in pre-order.
	public static Queue < Integer > collectPreorder (GT <PGElem > pg) {
		
		if ( pg ==null || pg.empty() )
			return new LinkedQueue<Integer>();
		pg.findRoot();
		Queue<Integer> tmp=new LinkedQueue<>();
		tmp.enqueue(pg.retrieve().getId());

		pre(pg, pg.retrieve().getId(),tmp,true);
				return tmp;
	}
	


	private static boolean pre(GT<PGElem> pg, int id,Queue<Integer> tmp,boolean e) {
		boolean found = false;
		
		if (pg.nbChildren() == 0)
			return true;
		
		else {
			boolean ex=true;
			for (int i = 0; i < pg.nbChildren() ; i++) {
				pg.findChild(i);
				tmp.enqueue(pg.retrieve().getId());
				found = pre(pg, id,tmp,ex);
/*				if (pg.retrieve().getId()==id) {
					return true;
				}
*/			
				if (ex)
				pg.findParent();
				else
					break;
			}
		}
		
		return found;
		
	}

	
	

	
	

	public static boolean find (GT < PGElem > pg , int id) {
		if (pg.empty() || pg==null	)
			return false;
		pg.findRoot();
		return find33(pg, id);
	}
	
	private static boolean find33(GT<PGElem> pg, int id ) {
		boolean n = false;
		if(pg.retrieve().getId() == id)
			return true;
		else {
			
			for(int i = 0 ; i<pg.nbChildren();i++) {
				pg.findChild(i);
				n=find33(pg,id);
				if(n)
					return true;
				pg.findParent();
			}
			return false;
		}
		
	}
	
	
	// Add the generator element gen to the power grid pg. This can only be done if
	// the grid is empty. If successful, the method returns true. If there is
	// already a generator, or gen is not of type Generator, false is returned.
	public static boolean addGenerator (GT <PGElem > pg , PGElem gen ) {
		if (ElemType.Generator.equals(gen.getType()) && pg.empty()) {
			pg.insert(gen);
			return true;
		}
		return false;
	}

	// Attaches pgn to the element id and returns true if successful. Note that a
	// consumer can only be attached to a transmitter, and no element can be be
	// attached to it. The tree must not contain more than one generator located at
	// the root. If id does not exist, or there is already aelement with the same ID
	// as pgn, pgn is not attached, and the method retrurns false.
	public static boolean attach (GT <PGElem > pg , PGElem pgn , int id) {
		if (pg.empty())
			return false;
		pg.findRoot();
		GT<PGElem> tmp = pg;	
		if (tmp.empty() == false && !find(tmp, pgn.getId())) {
			tmp.findRoot();
			if (find(tmp, id)) {
				if (pgn.getType().equals(ElemType.Consumer)) {
					
					if (tmp.retrieve().getType().equals(ElemType.Transmitter)) {

						tmp.insert(pgn);
						return true;
					}
				} else if (pgn.getType().equals(ElemType.Transmitter)) {
					if (!tmp.retrieve().getType().equals(ElemType.Consumer)) {
						
					tmp.insert(pgn);
					return true;
					}
				}
			}
		}
		return false;
	}

	// Removes element by ID, all corresponding subtree is removed. If removed, true
	// is returned, false is returned otherwise.
	public static boolean remove (GT <PGElem > pg , int id) {
		if (pg.empty())
			return false;
		if (find(pg, id)) {
			pg.remove();
			return true;
		}
		return false;
	}

	// Computes total power that consumed by a element (and all its subtree). If id
	// is incorrect, -1 is returned.
	public static double totalPower (GT <PGElem > pg , int id) {
		if (pg.empty())
			return -1;
		if (find(pg, id)) {
			/*int i = pg.nbChildren();
			double total = 0;
			for (int x = 0; x < i; x++) {
				if (ElemType.Consumer.equals(pg.retrieve().getType()))
					total += pg.retrieve().getPower();
			}*/
			return sum(pg, id);
		}

		return -1;
	}

	// Checks if the power grid contains an overload. The method returns the ID of
	// the first element preorder that has an overload and -1 if there is no
	// overload.
	public static int findOverload (GT <PGElem > pg){
		
		
		
		
		
		
		if (pg.empty() || pg==null)
			return -1;
		pg.findRoot();
		LinkedQueue<PGElem> tmp = new LinkedQueue<>();
		preOver(pg, pg.retrieve().getId(),tmp,true);
		
		int x=tmp.length();
		for (int i=0;i<x;i++) {
			PGElem con=tmp.serve();
			double sum=totalPower(pg, con.getId());
			if (sum>con.getPower())
				return con.getId();
		}
		//preOrderPg(tmp, pg, 0, pg.nbChildren());
		//preOrderPg(pg, pg.retrieve().getId(), tmp);
		/*int x = tmp.length();
		for (int i = 0; i < x; i++) {
			if (tmp.serve().getPower() > totalPower(pg, pg.retrieve().getId()))
				return pg.retrieve().getId();
		}*/
		return -1;
	}
	private static boolean preOver(GT<PGElem> pg, int id,LinkedQueue<PGElem> tmp,boolean e) {
		boolean found = false;
		if (pg.nbChildren() == 0)
			return true;
		
		else {
			boolean ex=true;
			for (int i = 0; i < pg.nbChildren() ; i++) {
				pg.findChild(i);
				tmp.enqueue(pg.retrieve());
				found = preOver(pg, id,tmp,ex);
/*				if (pg.retrieve().getId()==id) {
					return true;
				}
*/			
				if (ex)
				pg.findParent();
				else
					break;
			}
		}
		return found;
		
	}
	
	private static double sum(GT<PGElem> pg, int id) {
		if (pg.empty())
			return -1;
		//pg.findRoot();
		LinkedQueue<Double> tmp=new LinkedQueue<>();
		double x=0;
		//tmp.enqueue(pg.retrieve().getPower());
		if (pg.retrieve().getType().equals(ElemType.Consumer))
			tmp.enqueue(pg.retrieve().getPower());
		helpSum(pg, id, tmp, true);
		int y=tmp.length();
		for (int i=0;i<y;i++) {
			x+=tmp.serve();
		}
		return x;
	}
	
	private static double helpSum(GT<PGElem> pg, int id,LinkedQueue<Double> tmp,boolean e) {
		double found = 0.0;
		if (pg.nbChildren() == 0)
			return 0.0;
		
		else {
			boolean ex=true;
			for (int i = 0; i < pg.nbChildren() ; i++) {
				pg.findChild(i);
				if (pg.retrieve().getType().equals(ElemType.Consumer))
				tmp.enqueue(pg.retrieve().getPower());
				found = helpSum(pg, id, tmp, ex);
	
				if (ex)
				pg.findParent();
				else
					break;
			}
		}
		return found;
			}
}