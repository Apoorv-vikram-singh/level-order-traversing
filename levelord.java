package tree;
import java.util.*;
public class levelord
{
    static Scanner sc=null;
    public static void main(String args[])
    {
        levelord obj=new levelord();
        sc=new Scanner(System.in);
        node root=createtre();
        obj.printlevelorder(root);

        

    }
    static node createtre()
    {
        node root=null;
        System.out.println("enter the data");
        int data=sc.nextInt();
        if(data==-1)
        {
            return null;
        }
        root=new node(data);
        System.out.println("enter the left value"+ data);
        root.left=createtre();
        System.out.println("enter the right valuse" +data);
        root.right=createtre();
        return root;
    }   
    static int height(node root)
    {
        if(root==null)
        {
            return 0;
        }
        return Math.max(height(root.left),height(root.right)+1);
    }

    static void printlevel(node root,int level)
    {
        if(root==null)
        {
            return;
        }
        else if(level==1)
        {
            System.out.println(root.data+" ");
        }
        else if(level>1)
        {
            printlevel(root.left,level-1);
            printlevel(root.right, level-1);
        }
    }
    void printlevelorder(node root)
    {
        int h=height(root);
        for(int i=1;i<=h+1;i++)
        {
            printlevel(root,i);//pass the value level another  function then recursing  work in this question....
        }
    }

   
}
class node
{
    node left,right;
    int data;
    node(int data)
    {
        this.data=data;
    }
}