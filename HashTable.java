import java.util.ArrayList;

public class HashTable
{
	private DoublyLinkedList[] L;//DoublyLinkedList listemdir.
	private int n,N;// n number_of_elements i temsil eder, N ise bucket_array size dir.
	private double loadFactor;
	
	/*public HashTable(double lf) 
	{
		loadFactor = lf;
		this.N = 20;
		L = new DoublyLinkedList[N];
		for(int i=0; i<L.length; i++)
		{
			L[i] = new DoublyLinkedList();
		}
	}*/
	/*private int compress(int h)// hashFunction dur.Gerekli hash degerini doner.
	{
		int hashCode = h % N;
		while(hashCode < 0)	hashCode += N*1000;	// Hash Eger negatif cikti varsayalim.Bu durumlar icin koydum
		return hashCode % N;
	}*/
	/*public void expand()// Bucket array size 2 katina cikarilir ve elemanlar yeni bucket_array a(2 katina cikarilmis haline) eklenir.
	{
		DoublyLinkedList[] new_list = new DoublyLinkedList[N*2];
		DoublyLinkedList[] old_list = new DoublyLinkedList[N];
		for(int i=0; i<new_list.length; i++)
		{
			new_list[i] = new DoublyLinkedList();
		}
		for(int i=0; i<old_list.length; i++)
		{
			old_list[i] = L[i];
		}
		this.N = N*2;
		this.n = 0;
		this.L = new_list;	
		/*for(int i=0; i<old_list.length; i++)
		{
			Node iterator = old_list[i].header.getNext();
			while(iterator != old_list[i].trailer && iterator != null)
			{	
				put(iterator.getKey(),iterator.getValue());
				iterator = iterator.getNext();
			}
		}
	}*/
	/*public int hashCode(String s)//ASCii karekter kodlarini toplayip hashCode olarak doner.
	{
		int counter = 0;
		for(int i=0; i<s.length(); i++)
		{
			String ks = "";
			ks = ks + s.charAt(i);
			counter += (int)Integer.parseInt(ks);
		}
		return counter;
	}*/
	/*public void checkLoadFactor()//Load factoru kontrol eder.Gerekirse genisletme(expand) islemi gerceklestirilir.
	{
		double factor = (double)n/N;
		if(factor > loadFactor)	
		expand();
	}*/
	/*public void put(String k, String v)// key ve value parametre olarak alir ve hashTable da ilgili yere yerlestirir.
	{
		checkLoadFactor();
		int hash = compress(k.toString().hashCode());
		DoublyLinkedList dll = L[hash];
		String t = dll.addLast(k, v);
		if(t != null)
		n ++;
		checkLoadFactor();
	}*/
	/*public void remove(String k,String v)	// key ve value parametre olarak alir ve o degeri ilgili DoublyLinkedList uzerinden siler.
	{
		int hash = compress(k.toString().hashCode());
		DoublyLinkedList dll = L[hash];
		String t = dll.remove(k,v);
		if(t != null)
		n --;
	}*/
	/*public ArrayList<String> get(String k)	// parametre olarak verilen Key degerinin degerini doner.
	{
		int hash = compress(k.toString().hashCode());
		DoublyLinkedList dll = L[hash];
		Node iterator = dll.header.getNext();
		while(iterator != dll.trailer)
		{
			if(iterator.getKey().equals(k))
			{
				return iterator.getValues();
			}
			iterator = iterator.getNext();
		}
		return null;
	}*/
	public void print()	// Ekrana bastirdigimiz metod
	{
		for(int i=0; i<L.length; i++)
		{
			System.out.print("Row"+i+"- ");
			if(L[i] == null)
			{
				System.out.println();
				continue;
			}
			L[i].printList();
		}
	}
	/*private class Node	// DoublyLinkedList class i icin kullanilan 'inner' Node classidir.
	{
		private String key;
		private ArrayList<String> value;
		private Node next,prev;
		public Node() 
		{	
			next = null;
			prev = null;
			key= null;
		}
		public Node(String k,Node p,Node n)
		{
			key = k;
			prev = p;
			next = n;
		}
		public void addValue(String v) {value.add(v);}
		public String getKey() {return key;}
		public void setKey(String k) {key = k;}
		public ArrayList<String> getValues() {	return value;}
		public void setNext(Node n) {next = n;}
		public void setPrev(Node p) {prev = p;}
		public Node getPrev(){return prev;}
		public Node getNext(){return next;}
		public String toStringNode()
		{
			String s = "";
			for(String t : value)
			{
				s = s + "," + t ;
			}
			return s;	
		}
	}*/
	private class DoublyLinkedList	// HashTable degerlerinin tutuldugu 'inner' DoublyLinkedList classidir.
	{
		/*private Node header,trailer;
		private int size;
		
		public int size() {return size;}
		public boolean isEmpty() {	return size == 0;}
		public DoublyLinkedList()
		{
			size = 0;
			header = new Node(null,null,null);
			trailer = new Node(null,header,null);
			header.setNext(trailer);
		}*/
		/*public boolean contains(String k,String v)//parametre olarak alinan key degerinin listede olup olmadigina bakilir
		{
			Node iterator = header.getNext();
			while(iterator != trailer)
			{
				if(iterator.getKey().equals(k))
				{
					ArrayList<String> temp_values = iterator.getValues();
					for(int i=0; i<temp_values.size(); i++)
					{
						if(temp_values.get(i).equals(v))	return true;//Degeri iceriyor demek.Listeye ekleme olmaz
					}
				}
				iterator = iterator.getNext();
			}
			return false;
		}*/
		/*public boolean isUnique(String k)
		{
			Node iterator = header.getNext();
			while(iterator != trailer)
			{
				if(iterator.getKey().equals(k))	return false;
				iterator = iterator.getNext();
			}
			return true;
		}*/
		/*public String addFirst(String k,String v)
		{
			if(!contains(k))
				return null;
			Node node = new Node(k,v,header,header.getNext());
			header.getNext().setPrev(node);
			header.setNext(node);
			size ++;
			return v;
		}*/
		/*public String addLast(String k,String v)// ***
		{
			if( contains(k,v))	
				return null;
			if(isUnique(k))
			{
				Node node = new Node(k,trailer.getPrev(),trailer);
				node.addValue(v);
				trailer.getPrev().setNext(node);
				trailer.setPrev(node);
				size ++;
				return v;
			}
			else
			{
				Node iterator = header.getNext();
				while(iterator != trailer)
				{
					if(iterator.getKey().equals(k))
					{
						iterator.addValue(v);
						size ++;
						return v;
					}
					iterator = iterator.getNext();
				}
			}
			return null;
			
		}*/
		/*public String remove(String k,String v)
		{
			Node removedNode = header.getNext();
			while(removedNode != null)
			{
				if(removedNode == trailer)
				{
					System.out.println("Value cannot found");
					return null;
				}
				if(removedNode.getKey().equals(k))
				{
					ArrayList<String> temp_values = removedNode.getValues();
					for(int i=0; i<temp_values.size(); i++)
					{
						if(temp_values.get(i).equals(v))
						{
							temp_values.remove(i);
							size --;
						}
					}
					if(temp_values.isEmpty())
					{
						removedNode.getNext().setPrev(removedNode.getPrev());
						removedNode.getPrev().setNext(removedNode.getNext());
						return v;
					}
				}
				else	removedNode = removedNode.getNext();
			}
			return v;
		}*/
		/*public void printList()
		{
			Node iterator = header.getNext();
			while(iterator != trailer)
			{
				System.out.print("("+iterator.getKey()+",["+iterator.toStringNode()+"])-> ");
				iterator = iterator.getNext();
			}
			System.out.println();
		}*/
	}
}
