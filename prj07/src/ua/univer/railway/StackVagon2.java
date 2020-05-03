package ua.univer.railway;

import java.util.ArrayList;
import java.util.List;

public class StackVagon2 implements IStackVagon {
	List<Vagon> list;
	
	public StackVagon2() {
		list = new ArrayList<>();
	}

	@Override
	public Vagon peek() {
		return list.get(list.size()-1);
	}

	@Override
	public Vagon push(Vagon v) {
		list.add(v);
		return v;
	}

	@Override
	public Vagon pop() {
		return list.remove(list.size()-1);
	}

	@Override
	public boolean isEmpty() {   //зачем? если мы не используем в 'pop' (remove)
		return list.isEmpty();
	}

	@Override
	public boolean isFull() {   // почему? isEmpty переопределяем, а тут заглушка
		return false;
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public void print() {
		System.out.println("+++++++++++++++++++++++++++++++");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
//		for (Vagon vagon : list) {
//			System.out.println(vagon);
//		}
	}

}
