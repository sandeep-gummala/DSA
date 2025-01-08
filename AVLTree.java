


class AVLTree{
    public static int height(AVLNode node){
        return (node==null)?-1:node.height;
    }
    public static AVLNode rotatLNode(AVLNode k2){
        AVLNode k1=k2.left;
        k2.left=k1.right;
        k1.right=k2;
        k1.height=Math.max(height(k1.left),height(k1.right))+1;
        k2.height=Math.max(height(k2.left),height(k2.right))+1;
        return k1;
    }
    public static AVLNode rotatRNode(AVLNode k1){
        AVLNode k2=k1.right;
        k1.right=k2.left;
        k2.left=k1;
        k1.height=Math.max(height(k1.left),height(k1.right))+1;
        k2.height=Math.max(height(k2.left),height(k2.right))+1;
        return k2;
    }
    public static AVLNode doubleRotateLNode(AVLNode k3){
        k3.left=rotatRNode(k3.left);
        return rotatLNode(k3);
    }
    public static AVLNode doubleRotateRNode(AVLNode k1){
        k1.right=rotatLNode(k1.right);
        return rotatRNode(k1);
    }
    public static AVLNode insert(int key,AVLNode node){
        if(node==null)
            return new AVLNode(key);
        if(key<node.key){
            node.left=insert(key, node.left);
            if(height(node.left)-height(node.right)==2){
                if(key<node.left.key)
                    node=rotatLNode(node);
                else
                    node=doubleRotateLNode(node);
            }

        }
        else if(key>node.key){
            node.right=insert(key,node.right);
            if(height(node.right.left)-height(node.right.right)==-2){
                if(key>node.right.key)
                    node=rotatRNode(node);
                else
                    node=doubleRotateRNode(node);
            }
        }
        node.height=Math.max(height(node.left),height(node.right))+1;
        return node;
    }
    public static AVLNode findMin(AVLNode node){
        if(node==null||node.left==null){
            return node;
        }
        return findMin(node.left);
    }
    public static AVLNode delete(AVLNode node,int key){
        if(node==null)
            return null;
        else if(key<node.key)
            node.left=delete(node.left,key);
        else if(key>node.key)
            node.right=delete(node.right,key);
        else
            if(node.left!=null&&node.right!=null){
                AVLNode min=findMin(node);
                node.key=min.key;
                node.right=delete(node.right,min.key);
            }
            else{
                node=(node.left!=null)?node.left:node.right;
            }
        if(node!=null){
            node.height=Math.max(height(node.left), height(node.right))+1;
            if(height(node.left)-height(node.right)==2){
                if(height(node.left.left)>=height(node.left.right)){
                    node=rotatLNode(node);
                }
                else{
                    node=doubleRotateLNode(node);
                }
            }
            if(height(node.left)-height(node.right)==-2){
                if(height(node.right.left)>=height(node.right.right)){
                    node=rotatRNode(node);
                }
                else{
                    node=doubleRotateRNode(node);
                }
            }
        }
        return node;
    }
    public static void  inorder(AVLNode node){
        if(node!=null){
           inorder(node.left);
            System.out.println(node.key);
            inorder(node.right);
        }
    }
    
    public static void main(String args[]){
        AVLNode root=null;
        int[] array={1,2,4,6,7,9,12};
        for(int x:array){
            root=insert(x, root);
            System.out.println("the height of tree after inserting "+x+" is:"+height(root));
        }
        inorder(root);
    }
}


class AVLNode{
    int key;
    AVLNode left,right;
    int height;
    AVLNode(int key) {
        this.key=key;
        height=0;
        left=null;
        right=null;
    }

    
}
