package ua.univer.railway;

import java.util.Arrays;

public class StackVagon implements IStackVagon {
	private Vagon[] masVagon;
	private int top;
	
	public StackVagon() {
		masVagon = new Vagon[10];
		top = -1;
	}

	/* (non-Javadoc)
	 * @see ua.univer.railway.IStackVagon#peek()
	 */
	@Override
	public Vagon peek() {
		return masVagon[top];
	}
	
	private void eraseCapacity() {
	//	Vagon[] temp = new Vagon[masVagon.length*2];
	    //for (int i = 0; i < masVagon.length; i++) {
	    //	temp[i]= masVagon[i]; 
	    //}
	//	temp = Arrays.copyOf(masVagon, masVagon.length);
	//	masVagon = temp;
		
		masVagon = Arrays.copyOf(masVagon, masVagon.length*2);
	}
	
	/* (non-Javadoc)
	 * @see ua.univer.railway.IStackVagon#push(ua.univer.railway.Vagon)
	 */
	@Override
	public Vagon push(Vagon v) {
		if(isFull()) eraseCapacity();
		masVagon[++top] = v;
		return v;
	}
	
	/* (non-Javadoc)
	 * @see ua.univer.railway.IStackVagon#pop()
	 */
	@Override
	public Vagon pop() {
		if (!isEmpty()) {
			Vagon v = masVagon[top];
			masVagon[top]= null;
			top--;
			return v;
		} else return null;
	}
	
	/* (non-Javadoc)
	 * @see ua.univer.railway.IStackVagon#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return top == -1;
	}
	
	/* (non-Javadoc)
	 * @see ua.univer.railway.IStackVagon#isFull()
	 */
	@Override
	public boolean isFull() {
		return top == masVagon.length - 1;
	}
	
	/* (non-Javadoc)
	 * @see ua.univer.railway.IStackVagon#size()
	 */
	@Override
	public int size() {
		return top + 1;
	}
	
	/* (non-Javadoc)
	 * @see ua.univer.railway.IStackVagon#print()
	 */
	@Override
	public void print() {
		System.out.println("***********************************");
		for (int i = 0; i < size(); i++) {
			System.out.println(masVagon[i]);
		}
	}
	
	
}
