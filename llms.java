import java.util.Scanner;
class Node
{
	int data;
	Node next;
}
public class llms
{

	Node head;
	public void create(int n)
	{
		Scanner s = new Scanner(System.in);
		Node tmp = null;
		System.out.println("Enter Elements:");
		while(n > 0)
		{
			n--;
			int d = s.nextInt();
			Node newnode = new Node();
			newnode.data = d;
			if(head == null)
			{
				head = newnode;
				tmp = newnode;
			}
			else
			{
				tmp.next = newnode;
				tmp = tmp.next;
			}
		}
	}
	public void display()
	{
		Node tmp = head;
		while(tmp != null)
		{
			System.out.print(tmp.data + " ");
			tmp = tmp.next;
		}
		System.out.println("");
	}
	public llms merge(llms o)
	{
		llms on = new llms();
		Node t = head, k = o.head, ptr = null;
		while(t != null && k != null)
		{
			if(t.data < k.data) 
			{
				if(ptr == null)
				{
					on.head = t;
					ptr = t;
					t = t.next;
				}
				else
				{
					ptr.next = t;
					ptr = ptr.next;
					t = t.next;
				}
			}
			else
			{
				if(ptr == null)
				{
					on.head = k;
					ptr = k;
					k = k.next;
				}
				else
				{
					ptr.next = k;
					ptr = ptr.next;
					k = k.next;
				}
			}
		}
 		while(t != null)
 		{
 			ptr.next = t;
 			ptr = ptr.next;
 			t = t.next;
 		}
 		while(k != null)
 		{
 			ptr.next = k;
 			ptr = ptr.next;
 			k = k.next;
 		}
		return on;
	}
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of first linked list");
		int n = sc.nextInt();
		llms obj = new llms();
		obj.create(n);
		System.out.println("first Linked List:");
		obj.display();
		System.out.println("Enter the size of second linked list");
		int n1 = sc.nextInt();
		llms obj2 = new llms();
		obj2.create(n1);
		System.out.println("Second Linked list");
		obj2.display();
		llms obj3 = obj.merge(obj2);
		System.out.println("After merging :");
		obj3.display();
	}
}