package ua.univer.railway;

public interface IStackVagon {

	Vagon peek();

	Vagon push(Vagon v);

	Vagon pop();

	boolean isEmpty();

	boolean isFull();

	int size();

	void print();

}