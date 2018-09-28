import java.util.Scanner;
class Node
{
	int data;
	Node next;
}
public class palinlist
{
	Node head;
	public void create(int n)
	{
		System.out.println("Enter Elements:");
		Scanner s = new Scanner(System.in);
		Node tmp = null;
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
	public void reverse()
	{
		Node cur = head, prev = null, next = null;
		while(cur != null)
		{
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur =  next;
		}
		head = prev;
	}
	public void copy(palinlist o)
	{
		Node tmp = o.head, ptr = null;
		while(tmp != null)
		{
			if(head == null)
			{
				head = tmp;
				ptr = tmp;
				tmp = tmp.next;
			}
			else
			{
				ptr.next = tmp;
				ptr = ptr.next;
				tmp = tmp.next;
			}
		}
	}
	public boolean palin(palinlist o)
	{
		Node tmp = o.head,ptr = head;
		while(tmp != null)
		{
			if(tmp.data != ptr.data) return false;
			tmp = tmp.next;
			ptr = ptr.next;
		}
		return true;
	}
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of list");
		int n = sc.nextInt();
		palinlist obj = new palinlist();
		obj.create(n);
		palinlist o = new palinlist();
		o.copy(obj);
		o.reverse();
		if(o.palin(obj)) System.out.println("Palindrome");
		else System.out.println("Not Palindrome");
	}
}