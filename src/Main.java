
public class Main {

	private static GT<PGElem> buildPG() {
		GT<PGElem> pg = new LinkedGT<PGElem>();
		PowerGridUtils.addGenerator(pg, new PGElem(3, ElemType.Generator, 36));
		PowerGridUtils.addGenerator(pg, new PGElem(3, ElemType.Generator, 36));
		PowerGridUtils.attach(pg, new PGElem(4, ElemType.Transmitter, 18), 3);
		PowerGridUtils.attach(pg, new PGElem(5, ElemType.Transmitter, 18), 3);
		PowerGridUtils.attach(pg, new PGElem(7, ElemType.Transmitter, 18), 3);
		PowerGridUtils.attach(pg, new PGElem(8, ElemType.Transmitter, 12), 4);
		PowerGridUtils.attach(pg, new PGElem(6, ElemType.Transmitter, 12), 4);
		PowerGridUtils.attach(pg, new PGElem(9, ElemType.Transmitter, 12), 6);
		PowerGridUtils.addGenerator(pg, new PGElem(3, ElemType.Generator, 36));
		PowerGridUtils.attach(pg, new PGElem(10, ElemType.Consumer, 9), 4);
		PowerGridUtils.attach(pg, new PGElem(12, ElemType.Consumer, 4), 5);
		PowerGridUtils.attach(pg, new PGElem(16, ElemType.Consumer, 4), 5);
		PowerGridUtils.attach(pg, new PGElem(17, ElemType.Consumer, 4), 7);
		PowerGridUtils.attach(pg, new PGElem(13, ElemType.Consumer, 3), 8);
		PowerGridUtils.attach(pg, new PGElem(11, ElemType.Consumer, 3), 8);
		PowerGridUtils.attach(pg, new PGElem(14, ElemType.Consumer, 4), 8);
		PowerGridUtils.attach(pg, new PGElem(12, ElemType.Consumer, 4), 5);
		PowerGridUtils.attach(pg, new PGElem(10, ElemType.Transmitter, 12), 4);

		return pg;
	}

	private static <T> void print(Queue<T> q) {

		System.out.println("------------------");
		if (q == null) {
			System.out.println("null");
		} else if (q.length() == 0) {
			System.out.println("empty");
			return;
		} else {
			for (int i = 0; i < q.length(); i++) {
				T e = q.serve();
				q.enqueue(e);
				System.out.println(e);
			}
		}
		System.out.println("------------------");
	}

	public static void main(String[] args) {
		GT<PGElem> pg = buildPG();
		Queue<Integer> ids = PowerGridUtils.collectPreorder(pg);
		print(ids);
		for (int i = 0; i < ids.length(); i++) {
			int id = ids.serve();
			ids.enqueue(id);
			System.out.println("Power consumed by Element " + id + " : " + PowerGridUtils.totalPower(pg, id));
		}
		System.out.println("Overload at Element " + PowerGridUtils.findOverload(pg));
	}

}
