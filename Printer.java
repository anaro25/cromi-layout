package x;

public class Printer {
	// to print tree in indentation style, use preorder traversal
		// basically just circling the tree counter-clockwise

    public static void printTree(Node node, int depth) { // recursive
    	int indent = 8;
        // print freq
        System.out.print(" ".repeat(depth * indent));
        System.out.print(node.freq);

        if (node instanceof LeafNode) {
            LeafNode leaf = (LeafNode) node;
            System.out.print(" " + leaf.content);
        }
        
        System.out.println();

        // Recursively print children nodes
        if (node.children != null) {
            for (Node child : node.children) {
                printTree(child, depth + 1);
            }
        }
    }
}