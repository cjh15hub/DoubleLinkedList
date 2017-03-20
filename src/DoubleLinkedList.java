/**
 * This class is a linked list where each node can access it's next and previous nodes
 * @author Charles Haines, Kelsey Shaak
 * @version 0.3
 **/


public class DoubleLinkedList {

	LinkNode head;
	LinkNode tail;
	int pointer = 0;
	int size = 0;
	
	/**
	 * default constructor
	 */
	public DoubleLinkedList(){
	}
	
	/**
	 * Inserts a node at the beginning of the linked list with the term given
	 * @param str is the string term
	 */
	public void beginWith(String str){
		if(size==0){
			head = new LinkNode(str);
			tail = head;
		}else{
			LinkNode node = new LinkNode(str);
			LinkNode n = head;
			n.previous_node = node;
			node.next_node = head;
			head = node;
		}
		size++;
	}
	
	/**
	 * Inserts a node at the end of the linked list with the term given
	 * @param str is the string term
	 */
	public void endWith(String str){
		if(size==0){
			head = new LinkNode(str);
			tail = head;
		}else{
			LinkNode node = new LinkNode(str);
			LinkNode n = tail;
			n.next_node = node;
			node.previous_node = tail;
			tail = node;
		}
		size++;
	}
	

	/**
	 * Insert node at a given position with the term given. Index of node will be position.
	 * @param str is the string term
	 * @param position
	 * @throws Exception Out of bounds
	 */
	public void insert(String str, int position) throws Exception{
		LinkNode b = new LinkNode(str);
		LinkNode a = head;
		if(position == 0){
			a.previous_node = b;
			b.next_node = a;
			head = b;
		}else{
			a = getNode(position-1);
			LinkNode c = a.next_node;
			a.next_node = b;
			b.previous_node = a;
			b.next_node = c;
			c.previous_node = b;
			
		}
		size++;
	}
	
	/**
	 * Removes a node at a given position.
	 * @param position
	 * @throws Exception Out of bounds
	 */
	public void remove(int position)throws Exception{
		LinkNode b = head;
		if(position == 0){
			b.next_node = head;
			b.previous_node = null;
		}else{
			b = getNode(position);
			LinkNode a = b.previous_node;
			LinkNode c = b.next_node;
			a.next_node = c;
			c.previous_node = a;
			b = null;
		}
		size--;
	}
	
	/**
	 * Replaces a given node's term at given position with the term given or
	 * throws out of bounds exception if position is invalid.
	 * @param str is the string term
	 * @param position
	 * @throws Exception Out of bounds
	 */
	public void replace(String str, int position)throws Exception{		
		getNode(position).term = str;	
	}
	
	private LinkNode getNode(int position) throws Exception{
		if(position < 0 || position >=size){
			throw new Exception("Out of bounds");
		}
		LinkNode ln = head;
		for(pointer = 0; pointer < position; pointer++){
			ln = ln.next_node;
		}
		return ln;
	}
	
	/**
	 * Returns the term at a given position or throws out of bounds exception if
	 * position is invalid.
	 * @param position
	 * @return term at position
	 * @throws Exception Out of bounds
	 */
	public String get(int position) throws Exception{
		return getNode(position).term;
	}
	
	/**
	 * Returns linked list as a string.
	 */
	public String toString(){
		
		String s = "";
		LinkNode node = head;
		for(int i = 0; i < size-1; i++){
			s += "(" + node.term + " ) , ";
			node = node.next_node;
		}
		s += "(" + node.term + " )";
		return s;
	}
	
	/**
	 * @return the first element
	 */
	public String getHead(){
		return head.term;
	}
	
	/**
	 * @return the last element
	 */
	public String getTail(){
		
		if(size == 0)
			return null;
		else if(size == 1)
			return head.term;
		else
			return tail.term;
	}
	
	/**
	 * 
	 * @return link list size
	 */
	public int getSize(){
		return size;
	}
	

	
	private class LinkNode {
		
		LinkNode previous_node;
		LinkNode next_node;
		String term;
		
		public LinkNode(String term){
			this.term = term;
		}
		
		/**
		 * 
		 * @return previous node
		 */
		public LinkNode getPrevious_node() {
			return previous_node;
		}
		
		/**
		 * sets previous node
		 * @param previous_node
		 */
		public void setPrevious_node(LinkNode previous_node) {
			this.previous_node = previous_node;
		}
		
		/**
		 * 
		 * @return next node
		 */
		public LinkNode getNext_node() {
			return next_node;
		}
		
		/**
		 * sets next node
		 * @param next_node
		 */
		public void setNext_node(LinkNode next_node) {
			this.next_node = next_node;
		}
		
		/**
		 * 
		 * @return term
		 */
		public String getTerm() {
			return term;
		}
		
		/**
		 * sets term
		 * @param term
		 */
		public void setTerm(String term) {
			this.term = term;
		}

	}//LinkNode
	
}
