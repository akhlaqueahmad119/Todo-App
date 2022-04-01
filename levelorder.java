import java.util.*;
public class levelorder{
    public static class pair{
        Node node;
        int state;
        pair(){}
        pair(Node node, int state){
            this.node = node;
            this.state = state;
        }
    }


    public static class Node{
        int val;
        Node left;
        Node right;

        Node(){}
        Node(int val){
            this.val = val;
        }
        
        Node(int val, Node left, Node right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void display(Node root){
        if(root == null)
            return;
        
        if(root.left != null){
            System.out.print(root.left.val);
        }
        else{
            System.out.print(".");
        }
        System.out.print(" <- " + root.val + " -> " );
        if(root.right != null){
            System.out.print(root.right.val);
        }
        else{
            System.out.print(".");
        }
        System.out.println();


        display(root.left);
        display(root.right);

    }

    public static void levelOrder(Node root){
        Queue<Node> qu = new LinkedList<>();
        qu.add(root);
        while(qu.size()>0){
            Node rem=qu.remove();
            System.out.print(rem.val+" ");
            if(rem.left!=null){
                qu.add(rem.left);
            }
            if(rem.right!=null){
                qu.add(rem.right);
            }
        }
    }

    public static void levelOrder_null(Node root){
        Queue<Node> qu = new LinkedList<>();
        qu.add(root);
        qu.add(null);
        
        while(qu.size()>0){
            if(qu.size()==1 && qu.peek()==null){
                break;
            }
            Node rem=qu.remove();
            if(rem==null){
                qu.add(rem);
            }
            else{
                System.out.print(rem.val+" ");
                if(rem.left!=null){
                    qu.add(rem.left);
                }
                if(rem.right!=null){
                    qu.add(rem.right);
                }
            }
           
        }
    }

    public static void levelOrder3(Node root){
        Queue<Node> qu = new LinkedList<>();
        qu.add(root);
        
        while(qu.size()>0){
            
            int size=qu.size();
            while(size-->0){
                Node rem=qu.remove();
                System.out.print(rem.val+" ");
                if(rem.left!=null){
                    qu.add(rem.left);
                }
                if(rem.right!=null){
                    qu.add(rem.right);
                }
                
            }
            System.out.println();
            
            }
           
        }
    
   

    public static void main(String [] args){
        Integer [] arr = {50,25,12,null,null,37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null };
        Node root = new Node(arr[0]);
        Stack<pair> st = new Stack<>();
        pair rootPair = new pair(root, 1);
        st.push(rootPair);
        int idx = 1;
        while(st.size() != 0){
            pair peekPair = st.peek();

            if(peekPair.state == 1){
                peekPair.state++;
                if(arr[idx] != null){
                    
                    Node leftChild = new Node(arr[idx]);
                    peekPair.node.left = leftChild;

                    st.push(new pair(leftChild, 1));
                    

                }
                idx++;
                
            }
            else if(peekPair.state == 2){
                peekPair.state++;
                if(arr[idx] != null){
                    
                    Node rightChild = new Node(arr[idx]);
                    peekPair.node.right = rightChild;

                    st.push(new pair(rightChild, 1));
                }
                idx++;
            }
            else{
                st.pop();
            }


        }
        

        // display(root);
        // System.out.println(height(root));
        // levelOrder(root);
        levelOrder3(root);
       // levelOrder_null(root);

    }
}