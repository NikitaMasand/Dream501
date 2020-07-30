package BinaryTrees;
//create binary tree

import java.util.*;

class Node {
    int data;
    Node left;
    Node right;
}

class BinaryTree{
    public Node createNewNode(int data) {
        Node node = new Node();
        node.data = data;
        node.left = null;
        node.right = null;

        return node;
    }

    public void inorder(Node root){
        if(root==null)
            return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public void preorder(Node root) {
        if(root==null)
            return;
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    public void postorder(Node root) {
        if(root==null)
            return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
    }

    public int getSumOfNodes(Node root) {
        int sum = 0;
        if(root==null)
            return sum;
        sum = root.data + getSumOfNodes(root.left) + getSumOfNodes(root.right);

        return sum;

    }

    //the - will be + when it will get another - again, try to solve it recursively
    //to understand
    //see this..
    public int getDifferenceEvenOddLevels(Node root) {
        if(root==null)
            return 0;
        return root.data - getDifferenceEvenOddLevels(root.left) - getDifferenceEvenOddLevels(root.right);
    }

    public int getNumNodes(Node root) {
        if(root==null)
            return 0;
        return 1 + getNumNodes(root.left) + getNumNodes(root.right);
    }

    public int countLeafNodes(Node root) {
        if(root==null)
            return 0;
        if(root.left==null && root.right==null)
            return 1;

        return countLeafNodes(root.left) + countLeafNodes(root.right);
    }

    public int getHeight(Node root) {
        if(root==null)
            return -1;

        if(root.left==null && root.right==null)
            return 0;

        return 1 + Math.max(getHeight(root.left), getHeight(root.right));

    }

    public void printNodesAtGivenLevel(Node root, int level) {
        if(root==null)
            return;
        if(level==1){
            System.out.print(root.data+" ");
            return;
        }
        printNodesAtGivenLevel(root.left, level-1);
        printNodesAtGivenLevel(root.right, level-1);
    }

    public void levelOrderTraversalRecursion(Node root) {
        int height = getHeight(root);
        for(int i=0; i<=height; i++){
            System.out.print("Nodes at level "+(i+1)+": ");
            printNodesAtGivenLevel(root, i+1);
            System.out.println();
        }
    }

    public void levelOrderTraversalQueue(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if(root!=null)
            queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node.data+" ");
            if(node.left!=null)
                queue.add(node.left);
            if(node.right!=null)
                queue.add(node.right);
        }
    }

    public void reverseLevelOrderTraversalRecursion(Node root) {
        int height = getHeight(root);
        for(int i=height;i>=0;i--){
            printNodesAtGivenLevel(root,i+1);
            System.out.println();
        }
    }

    public void reverseLevelOrderTraversaQueueStack(Node root) {
        Queue<Node> queue = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        if(root!=null)
            queue.add(root);
        while (!queue.isEmpty()){
            Node node = queue.poll();
            stack.push(node);
            if(node.right!=null){
                queue.add(node.right);
            }
            if(node.left!=null){
                queue.add(node.left);
            }
        }

        while (!stack.isEmpty()){
            Node node = stack.pop();
            System.out.print(node.data+" ");
        }
    }

    //see this, nice approach!
    public void levelOrderTraversalLineWiseQueue(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if(root!=null)
            queue.add(root);
        int count;
        int level = 1;
        while (true) {
            count = queue.size();
            if(count==0)
                break;
            System.out.print("Nodes at level "+level++ + ": ");
            while (count>0){
                Node node = queue.poll();
                System.out.print(node.data+" ");
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
                count--;
            }
            System.out.println();
        }
    }


    public void leftViewQueue(Node root){
        Queue<Node> queue = new LinkedList<>();
        int count;
        if(root!=null)
            queue.add(root);
        while (true) {
            count = queue.size();
            boolean levelStartFlag=true;
            if(count==0)
                break;

            while (count>0){
                Node node = queue.poll();
                if(levelStartFlag){
                    System.out.print(node.data+" ");
                    levelStartFlag=false;
                }
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }

                count--;
            }
        }
    }

    //nice approach, see this!
    int maxLevel;
    public void leftViewRecursion(Node root, int level){
        if(root==null)
            return;
        if(level==maxLevel){
            System.out.print(root.data+" ");
            maxLevel++;
        }
        leftViewRecursion(root.left, level+1);
        leftViewRecursion(root.right, level+1);

    }

    public void rightViewQueue(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if(root!=null){
            queue.add(root);
        }
        int count;
        while (true){
            count = queue.size();
            if(count==0){
                break;
            }
            while (count>0){
                Node node = queue.poll();
                if(count==1){
                    System.out.print(node.data+" ");
                }
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
                count--;
            }
        }
    }

    int maxLevel1;

    public void rightViewRecursion(Node root, int level){
        if(root==null)
            return;
        if(level==maxLevel1){
            System.out.print(root.data+" ");
            maxLevel1++;
        }
        rightViewRecursion(root.right, level+1);
        rightViewRecursion(root.left, level+1);
    }

    //nice approach, check this.
    public void inorderWithoutRecursion(Node node) {
        if(node==null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        while (node!=null){
            stack.push(node);
            node=node.left;
        }
        while (!stack.isEmpty()) {
            Node n = stack.pop();
            System.out.print(n.data + " ");
            if (n.right != null) {
                Node temp = n.right;
                while (temp != null) {
                    stack.push(temp);
                    temp = temp.left;
                }
            }
        }
    }

    //nice approach, check this.
    public void preorderTraversalWithoutRecursion(Node node) {
        if(node==null)
            return;
        Stack<Node> stack = new Stack<>();
        while (node!=null){
            System.out.print(node.data+" ");
            stack.push(node);
            node=node.left;
        }
        while (!stack.isEmpty()){
            Node n = stack.pop();
            if(n.right!=null){
                Node temp = n.right;
                while (temp!=null) {
                    System.out.print(temp.data + " ");
                    stack.push(temp);
                    temp = temp.left;
                }
            }
        }
    }

    //if you observe, root, left, right is preorder
    //root, right, left is also preorder with right before left
    //and post order is nothing but reverse of above sequence

    public void postOrderTraversal(Node root){
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        //root right left
        if(root!=null) {
            while (root != null) {
                s1.push(root);
                s2.push(root);
                root = root.right;
            }
        }
        while (!s1.isEmpty()){
           Node node = s1.pop();
           if(node.left!=null){
               Node temp = node.left;
               while(temp!=null){
                   s1.push(temp);
                   s2.push(temp);
                   temp=temp.right;
               }
           }
        }

        while (!s2.isEmpty()) {
            System.out.print(s2.pop().data+" ");
        }
    }

    public Node createMirror(Node root) {
        if(root==null){
            return null;
        }
        createMirror(root.left);
        createMirror(root.right);

        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;
    }

    //performing post order traversal
    public Node deleteBinaryTree(Node node) {
        if(node==null){
            return null;
        }
        deleteBinaryTree(node.left);
        deleteBinaryTree(node.right);
        node=null;

        return node;
    }

    //check if two trees are identical or not
    public boolean isIdentical(Node node1, Node node2) {
        if(node1==null && node2==null)
            return true;
        if(node1==null || node2==null)
            return false;
        return ((node1.data==node2.data) && (isIdentical(node1.left, node2.left)) && (isIdentical(node1.right, node2.right)));
    }

    public int getLevelOfGivenNode(Node root, int val) {
        int level = getLevelOfGivenNodeUtil(root, val, 1);
        if(level==Integer.MAX_VALUE){
            return -1;
        }
        return level;
    }

    public int getLevelOfGivenNodeUtil(Node root, int val, int level) {
        if(root==null){
            return Integer.MAX_VALUE;
        }
        if(root.data==val){
            return level;
        }

        return Math.min(
        getLevelOfGivenNodeUtil(root.left,val,level+1),
        getLevelOfGivenNodeUtil(root.right,val,level+1));
    }

    //vertical order traversal using queue, treemap

    class NodeAndDist {
        Node node;
        int dist;

        NodeAndDist(Node node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    //vertical order traversal using queue and tree map
    //top view of binary tree
    //bottom view of binary tree

    public void verticalOrderTraversalQueue(Node root) {
        TreeMap<Integer, List<Node>> map = new TreeMap<>();
        Queue<NodeAndDist> queue = new LinkedList<>();

        if(root==null) {
            return;
        }
        NodeAndDist n1 = new NodeAndDist(root, 0);
        queue.add(n1);

        while (!queue.isEmpty()){
            NodeAndDist nd = queue.poll();
            int dist = nd.dist;
            Node node = nd.node;
            if(!map.containsKey(dist)) {
                List<Node> l = new ArrayList<>();
                l.add(node);
                map.put(dist, l);
            }
            else {
                List l = map.get(dist);
                l.add(node);
                map.replace(dist, l);
            }

            if(node.left!=null){
                queue.add(new NodeAndDist(node.left, dist-1));
            }
            if(node.right!=null){
                queue.add(new NodeAndDist(node.right, dist+1));
            }

        }

        for(Map.Entry entry :map.entrySet()) {
            List<Node> list = (List<Node>) entry.getValue();
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i).data + " ");
            }
            System.out.println();
        }

        System.out.println("Top view of given binary tree: ");
        for(Map.Entry entry :map.entrySet()) {
            List<Node> list = (List<Node>) entry.getValue();
                System.out.print(list.get(0).data + " ");
        }
        System.out.println();
        System.out.println("Bottom view of given binary tree: ");
        for(Map.Entry entry :map.entrySet()) {
            List<Node> list = (List<Node>) entry.getValue();
            System.out.print(list.get(list.size()-1).data + " ");
        }
        System.out.println();
    }

    //diagonal traversal
    //boundary traversal
    //spiral level order traversal
    //vertical sum of binary tree


    public void diagonalTraversal(Node root) {
        Queue<NodeAndDist> queue = new LinkedList<>();
        TreeMap<Integer, List<Node>> map = new TreeMap<>();
        if(root==null)
            return;
        NodeAndDist n1 = new NodeAndDist(root, 0);
        queue.add(n1);
        while (!queue.isEmpty()){
            NodeAndDist nd = queue.poll();
            int dist = nd.dist;
            Node node = nd.node;
            if(!map.containsKey(dist)){
                List<Node> l = new ArrayList<>();
                l.add(node);
                map.put(dist, l);
            }
            else {
                List<Node> l = map.get(dist);
                l.add(node);
                map.replace(dist, l);
            }

            if(node.left!=null){
                queue.add(new NodeAndDist(node.left, dist+1));
            }
            if(node.right!=null){
                queue.add(new NodeAndDist(node.right, dist));
            }
        }

        for(Map.Entry entry : map.entrySet()) {
            List<Node> l = (List<Node>) entry.getValue();
            for(int i=0; i<l.size(); i++){
                System.out.print(l.get(i).data+" ");
            }
            System.out.println();
        }
    }

    //boundary traversal of binary tree, nice!

    public void boundaryTraversalOfBinaryTree(Node node) {
        if(node==null)
            return;
        //1. print root
        System.out.print(node.data+" ");
        //2. traverse left side in preorder way
        printLeftSideWithoutLeafNodes(node.left);
        //3. print leaf nodes
        printLeafNodes(node);
        //4. traverse right side in postorder way
        printRightSideWithoutLeafNodes(node.right);
    }

    public void printLeftSideWithoutLeafNodes(Node node) {
        if(node==null)
            return;
        if(node.left!=null){
            System.out.print(node.data+" ");
            printLeftSideWithoutLeafNodes(node.left);
        }
        else if(node.right!=null){
            System.out.println(node.data+" ");
            printLeftSideWithoutLeafNodes(node.right);
        }
    }

    public void printLeafNodes(Node node){
        if(node==null)
            return;
        if(node.left==null&&node.right==null){
            System.out.print(node.data+" ");
            return;
        }
        printLeafNodes(node.left);
        printLeafNodes(node.right);
    }

    public void printRightSideWithoutLeafNodes(Node node) {
        if (node == null)
            return;
        if(node.right!=null){
            printRightSideWithoutLeafNodes(node.right);
            System.out.print(node.data+" ");
        }
        else if(node.left!=null){
            printRightSideWithoutLeafNodes(node.left);
            System.out.print(node.data+" ");
        }

    }

    public void spiralLevelOrderTraversal(Node node) {
        if(node==null){
            return;
        }
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        stack1.push(node);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if(!stack1.isEmpty()){
                while (!stack1.isEmpty()){
                    Node n = stack1.pop();
                    System.out.print(n.data+" ");
                    if(n.left!=null)
                        stack2.push(n.left);
                    if(n.right!=null)
                        stack2.push(n.right);
                }
            }
            else {
                while (!stack2.isEmpty()){
                    Node n = stack2.pop();
                    System.out.print(n.data+" ");
                    if(n.right!=null){
                        stack1.push(n.right);
                    }
                    if(n.left!=null){
                        stack1.push(n.left);
                    }
                }

            }
        }
    }
     //without recursion
    public int getElementsSumLevelWise(Node root) {
        if(root==null)
            return 0;
        Queue<Node> queue = new LinkedList<>();
        int level = 1;
        int count;
        queue.add(root);

        while (true){
            count = queue.size();
            if(count==0)
                break;
            int sum=0;
            while (count>0){
                Node n = queue.poll();
                sum+=n.data;
                if(n.left!=null){
                    queue.add(n.left);
                }
                if(n.right!=null){
                    queue.add(n.right);
                }
                count--;

            }
            System.out.println("Sum at level "+level+": "+sum );
            level++;
        }
        return 0;
    }

    //recursion
    int sum;
    public void getElementsSumLevelWiseRecursion(Node root) {
        int height = getHeight(root);
        for(int i=0; i<=height; i++){
            sum=0;
            System.out.println("Sum at level "+(i+1)+": "+ getElementsSumLevelWiseRecursionUtil(root,i+1));
        }
    }
    public int getElementsSumLevelWiseRecursionUtil(Node root, int level) {
        if(root==null){
            return 0;
        }

        if(level==1){
            sum += root.data;
        }

        getElementsSumLevelWiseRecursionUtil(root.left,level-1);
        getElementsSumLevelWiseRecursionUtil(root.right, level-1);
        return sum;

    }
    //find max number of elements present in any level
    public int getMaxWidth(Node root) {
        if(root==null)
            return 0;
        Queue<Node> queue = new LinkedList<>();
        int count;
        int maxWidth=0;
        queue.add(root);

        while (true) {
            count = queue.size();
            maxWidth = Math.max(count, maxWidth);

            if (count == 0) {
                break;
            }
            while (count>0){
                Node n = queue.poll();
                if(n.left!=null){
                    queue.add(n.left);
                }
                if(n.right!=null){
                    queue.add(n.right);
                }
                count--;
            }

        }
        return maxWidth;
    }

    public boolean checkIfMirror(Node root1, Node root2) {
        if(root1==null && root2==null)
            return true;
        if(root1==null || root2==null)
            return false;

        return (root1.data==root2.data && checkIfMirror(root1.left,root2.right)&&checkIfMirror(root1.right,root2.left));
    }

    //the data of nodes can be anything unlike above problem
    //the structure should be mirror
    public boolean checkIfMirrorStructure(Node root1, Node root2) {
        if(root1==null && root2==null)
            return true;
        if(root1==null || root2==null)
            return false;
        return (checkIfMirrorStructure(root1.left, root2.right) && checkIfMirrorStructure(root1.right, root2.left));
    }

    //check if binary tree is foldable
    //ie check if left and right subtree of given binary tree are mirror structure

    public boolean checkIfFoldableStructure(Node root) {
        if(root==null)
            return true;
        return checkIfFoldableStructureUtil(root.left, root.right);
    }

    //exactly same as check if mirror structure
    public boolean checkIfFoldableStructureUtil(Node root1, Node root2){
        if(root1==null && root2==null){
            return true;
        }
        if(root1==null || root2==null){
            return false;
        }

        return (checkIfFoldableStructureUtil(root1.left, root2.right) &&
                checkIfFoldableStructureUtil(root1.right, root2.left));
    }

    //check if two binary trees are isomorphic
    //the data of two nodes should be same and have
    //either same structure or mirror structure
    public boolean checkIfIsomorphic(Node root1, Node root2) {
        if(root1==null && root2==null)
            return true;
        if(root1==null || root2==null)
            return false;
        if(root1.data!=root2.data)
            return false;

        return ((checkIfIsomorphic(root1.left, root2.left)&&checkIfIsomorphic(root1.right,root2.right))
                ||(checkIfIsomorphic(root1.left, root2.right)&&checkIfIsomorphic(root1.right,root2.left)));
    }

    public int getWidthOfLevel(Node root, int level) {
        if(root==null)
            return 0;
        if(level==1)
            return 1;
        return getWidthOfLevel(root.left, level-1) + getWidthOfLevel(root.right,level-1);

    }

    public Node createDoubleTree(Node root) {
        if(root==null)
            return null;
        Node tempLeft = root.left;
        Node n = createNewNode(root.data);
        root.left=n;
        root.left.left=tempLeft;
        createDoubleTree(tempLeft);
        createDoubleTree(root.right);
        return root;
    }
    int preIndex=0;
    public Node buildTreeFromPreorderInorder(int[] preorder, int[] inorder, int start, int end) {
        if(start>end)
            return null;

        Node node = createNewNode(preorder[preIndex++]);
        if(start==end)
            return node;

        int inorderIndex = getInorderIndex(inorder,node.data);
        node.left = buildTreeFromPreorderInorder(preorder,inorder,start,inorderIndex-1);
        node.right = buildTreeFromPreorderInorder(preorder,inorder,inorderIndex+1,end);

        return node;

    }

    public int getInorderIndex(int[] inorder, int value) {
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==value)
                return i;
        }
        return -1;
    }

    public int getHeightIterative(Node root) {
        if(root==null)
            return -1;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int height=-1;
        int count;
        while (true){
            count=queue.size();
            height++;
            if(count==0) {
                height--;
                break;
            }

            while (count>0){
                Node node = queue.poll();
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
                count--;
            }
        }
        return height;
    }


    //diameter of binary tree: number of nodes along longest path between two leaves
    //o(n) time complexity
    public int findDiameter(Node root, BinaryTreeApp.ResultDiameter res){
        if(root==null)
            return 0;

        int left = findDiameter(root.left, res);
        int right = findDiameter(root.right, res);

        //don't include this node in the answer
        int temp = 1+Math.max(left,right);
        //include this node in the answer
        int ans = 1+left+right;

        res.resultDiameter = Math.max(res.resultDiameter, ans);


        return temp;
    }

    //max path sum from any node to any node
    public int findMaxPathSumAnyNode(Node root, BinaryTreeApp.ResultPathSum res) {
        //base condition
        if(root==null)
            return 0;

        //hypothesis
        int leftSum = findMaxPathSumAnyNode(root.left, res);
        int rightSum = findMaxPathSumAnyNode(root.right, res);

        //induction
        //if both l and r sum are negative, return only root's data
        int temp = Math.max(root.data+Math.max(leftSum,rightSum), root.data);
        int ans = Math.max(root.data+leftSum+rightSum, temp);
        res.resultPathSum = Math.max(res.resultPathSum, ans);

        return temp;
    }

//    public int findMaxPathSumLeafNode(Node root, BinaryTreeApp.ResultPathSumLeaf res) {
//
//    }

}

public class BinaryTreeApp {

    static class ResultDiameter {
        int resultDiameter;

        ResultDiameter(){
            resultDiameter=Integer.MIN_VALUE;
        }
    }

    static class ResultPathSum {
        int resultPathSum;
        ResultPathSum(){
            resultPathSum=Integer.MIN_VALUE;
        }
    }

    static class ResultPathSumLeaf {
        int resultSum;
        ResultPathSumLeaf(){
            resultSum=Integer.MIN_VALUE;
        }
    }
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        Node root = binaryTree.createNewNode(2);
        root.left = binaryTree.createNewNode(7);
        root.right = binaryTree.createNewNode(5);
        root.left.left = binaryTree.createNewNode(2);
        root.left.right = binaryTree.createNewNode(6);
        root.right.right = binaryTree.createNewNode(9);
        root.left.right.left = binaryTree.createNewNode(5);
        root.left.right.right = binaryTree.createNewNode(11);
        root.right.right.left = binaryTree.createNewNode(4);

        Node root1 = binaryTree.createNewNode(2);
        root1.left = binaryTree.createNewNode(7);
        root1.right = binaryTree.createNewNode(5);
        root1.left.left = binaryTree.createNewNode(2);
        root1.left.right = binaryTree.createNewNode(6);
        root1.right.right = binaryTree.createNewNode(9);
        root1.left.right.left = binaryTree.createNewNode(5);
        root1.left.right.right = binaryTree.createNewNode(11);
        root1.right.right.left = binaryTree.createNewNode(4);

        System.out.println("Inorder traversal: ");
        binaryTree.inorder(root);
        System.out.println();

        System.out.println("Preorder traversal: ");
        binaryTree.preorder(root);
        System.out.println();

        System.out.println("Postorder traversal: ");
        binaryTree.postorder(root);
        System.out.println();

        System.out.println("Sum of nodes in given binary tree: "+binaryTree.getSumOfNodes(root));
        System.out.println();

        System.out.println("Difference of nodes at even/odd level: "+ binaryTree.getDifferenceEvenOddLevels(root));
        System.out.println();

        System.out.println("Number of nodes in given binary tree: "+binaryTree.getNumNodes(root));
        System.out.println();

        System.out.println("Number of leaf ndoes in given binary tree: "+binaryTree.countLeafNodes(root));
        System.out.println();

        System.out.println("Height of given binary tree: "+binaryTree.getHeight(root));
        System.out.println();

        System.out.println("Print nodes at (given) level 3: ");
        binaryTree.printNodesAtGivenLevel(root, 3);

        System.out.println("Level order traversal using recursion: ");
        binaryTree.levelOrderTraversalRecursion(root);

        System.out.println("Level order traversal using queue: ");
        binaryTree.levelOrderTraversalQueue(root);
        System.out.println();

        System.out.println("Reverse level order traversal using recursion: ");
        binaryTree.reverseLevelOrderTraversalRecursion(root);

        System.out.println("Reverse level order traversal using queue and stack: ");
        binaryTree.reverseLevelOrderTraversaQueueStack(root);

        System.out.println("Level order traversal line wise using queue, without recursion: ");
        binaryTree.levelOrderTraversalLineWiseQueue(root);

        System.out.println("Left view of binary tree using queue: ");
        binaryTree.leftViewQueue(root);
        System.out.println();

        System.out.println("Left view of binary tree using recursion: ");
        binaryTree.leftViewRecursion(root,0);
        System.out.println();

        System.out.println("Right view of binary tree using queue: ");
        binaryTree.rightViewQueue(root);
        System.out.println();

        System.out.println("Right view of binary tree using recursion: ");
        binaryTree.rightViewRecursion(root,0);
        System.out.println();

        System.out.println("Inorder traversal without using recursion: ");
        binaryTree.inorderWithoutRecursion(root);
        System.out.println();

        System.out.println("Preorder traversal without using recursion: ");
        binaryTree.preorderTraversalWithoutRecursion(root);
        System.out.println();

        System.out.println("Postorder traversal without using recursion: ");
        binaryTree.postOrderTraversal(root);
        System.out.println();

        //having a doubt that after creating mirror, even root's inorder traversal is same as
        //it's mirror, which is correct as i am returning the reference
        //but after deleting, the root1's inorder still exists which it should not as nodes are deleted.

//        System.out.println("Creating mirror of binary tree: ");
//        Node mirror = binaryTree.createMirror(root);
//        System.out.println("inorder on mirror: ");
//        binaryTree.inorder(mirror);
////        binaryTree.inorder(root);
//        System.out.println();

//        System.out.println("deleting binary tree...");
//        Node deletedRoot = binaryTree.deleteBinaryTree(root1);
//        System.out.println("performing inorder traversal to check there are no nodes in the deleted root");
//        binaryTree.inorder(deletedRoot);
////        binaryTree.inorder(root1);
//
        System.out.println("Check if two trees are identical: ");
        System.out.println(binaryTree.isIdentical(root, root1));

        System.out.println("Get level of given node: ");
        System.out.println(binaryTree.getLevelOfGivenNode(root,11));

        System.out.println("Vertical order traversal using queue and tree map");
        binaryTree.verticalOrderTraversalQueue(root);

        System.out.println("Diagonal traversal of binary tree: ");
        binaryTree.diagonalTraversal(root);


        System.out.println("Boundary traversal of binary tree: ");
        binaryTree.boundaryTraversalOfBinaryTree(root);

        System.out.println();
        System.out.println("Spiral level order traversal of binary tree: ");
        binaryTree.spiralLevelOrderTraversal(root);

        System.out.println();
        System.out.println("Sum of elements level wise: ");
        binaryTree.getElementsSumLevelWise(root);

        System.out.println();
        System.out.println("Sum of elements level wise using recursion: ");
        binaryTree.getElementsSumLevelWiseRecursion(root);

        System.out.println();
        System.out.println("Max width of given binary tree is: ");
        System.out.println(binaryTree.getMaxWidth(root));

        System.out.println();
        System.out.println("not calling but have implemented these: ");
        System.out.println("check if mirror...");
        System.out.println("check if mirror structure..");
        System.out.println("check if foldable..");
        System.out.println("check if isomorphic..");

        System.out.println("width of level: "+4);
        System.out.println(binaryTree.getWidthOfLevel(root,4));

//        System.out.println("Create double tree: ");
//        Node doubleTreeNode = binaryTree.createDoubleTree(root);
//        binaryTree.inorder(doubleTreeNode);

        System.out.println();
        System.out.println("build tree from preorder and inorder traversals: ");
        int[] preorder = {2,4,7,3,8};
        int[] inorder = {7,4,3,2,8};
        Node buildTree = binaryTree.buildTreeFromPreorderInorder(preorder,inorder,0,inorder.length-1);
        System.out.println("performing inorder traversal on formed tree: ");
        binaryTree.inorder(buildTree);

        System.out.println();
        System.out.println("height in iterative manner: ");
        System.out.println(binaryTree.getHeightIterative(root));

        System.out.println("Diameter of given binary tree: ");
        ResultDiameter res = new ResultDiameter();
        binaryTree.findDiameter(root,res);
        System.out.println(res.resultDiameter);

        System.out.println("Maximum path sum from any node to any other node: ");
        ResultPathSum resultPathSum = new ResultPathSum();
        binaryTree.findMaxPathSumAnyNode(root, resultPathSum);
        System.out.println(resultPathSum.resultPathSum);

        System.out.println("Maximum path sum from leaf node to leaf node: ");
        ResultPathSumLeaf resultPathSumLeaf = new ResultPathSumLeaf();
//        binaryTree.findMaxPathSumLeafNode(root, resultPathSumLeaf);
        System.out.println(resultPathSumLeaf.resultSum);;

    }


}