/*  Student information for assignment:
 *
 *  On our honor, Anushka Shah and Jessica Ouyang, this programming assignment is our own work
 *  and we have not provided this code to any other student.
 *
 *  Number of slip days used: 1
 *
 *  Student 1 (Student whose turnin account is being used): Anushka Shah
 *  UTEID: aks4562
 *  email address: anushkashah654@gmail.com
 *  Grader name: Grace
 *
 *  Student 2: Jessica Ouyang
 *  UTEID: jjo889
 *  email address: jouyang99@gmail.com
 *
 */

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class HuffmanTree {

	// instance variables
	private TreeNode root;
	private PriorityQueue<TreeNode> pq;
	private int numNodesWithVal;
	private int[] freqs;
	
	/**
	 * Create a new HuffmanTree 
	 */
	public HuffmanTree() {
		this(new TreeNode(-1, 0));
	}
	
	/**
	 * Create a new HuffmanTree
	 * @param node the root of the HuffMan Tree
	 */
	public HuffmanTree(TreeNode node) {
		root = node;
		pq = new PriorityQueue<>();
		numNodesWithVal = 0;
	}
	
	/**
	 * Get the number of nodes with val of the HuffmanTree
	 * @return number of nodes with val of HuffmanTree
	 */
	public int getNodesWithVal() {
		return numNodesWithVal;
	}
	
	/**
     * Adds each value to the priority queue as a TreeNode
     */
    public void createQueue(TreeSet<Integer> vals, int[] freqs) {
    	for (int val : vals) {
    		// create a new TreeNode with char and frequency
    		TreeNode temp = new TreeNode(val, freqs[val]);
    		// add to priority queue
    		pq.enqueue(temp);
    	}
    	// add TreeNode with psuedo eof to priority queue
    	pq.enqueue(new TreeNode(IHuffConstants.PSEUDO_EOF, 1));
    }
	
	/**
     * Creates a Huffman Tree using the priority queue
     */
	public void createTree() {
		while (pq.size() > 1) {
    		// take first two elements from queue, combine into one node to enqueue
    		TreeNode t1 = pq.front();
    		pq.dequeue();
    		TreeNode t2 = pq.front();
    		pq.dequeue();
    		pq.enqueue(new TreeNode(t1, t1.getFrequency() + t2.getFrequency(), t2));
    	}
    	// root of Huffman tree will be the last node left
    	root = pq.front();
	}
	
	/**
	 * Creates a map with values and paths to the values
	 * @return a map with values and paths to the values
	 */
	public Map<Integer, String> returnMap() {
		Map<Integer, String> map = new HashMap<>();
		createMap(root, "", map);
		return map;
	}
	
	/**
     * Creates a map containing values and the paths to them
     * @param n the current TreeNode being looked at
     * @param path the path to the current node
     */
    private void createMap(TreeNode n, String path, Map<Integer, String> map) {
    	if (n.isLeaf()) {
    		// add the path into the map with value of TreeNode as key
    		map.put(n.getValue(), path);
    	} else {
    		// make recursive call with left subtree and add 0 to path
    		createMap(n.getLeft(), path + "0", map);
    		// make recursive call with right subtree and add 1 to path
    		createMap(n.getRight(), path + "1", map);
    	}
    }
    
    /**
     * Gets the number of bits in the HuffmanTree
     * @return the number of bits in the HuffmanTree
     */
    public int returnBitsInTree() {
    	return bitsInTree(root);
    }
    
    /**
     * Determines the number of bits in the tree
     * @param n the current TreeNode being looked at
     * @return the number of bits in the tree
     */
    private int bitsInTree(TreeNode n) {
    	if (n.isLeaf()) {
    		// add an extra bit due to pseudo EOF character
    		return 2 + IHuffConstants.BITS_PER_WORD;
    	}
    	// recursive call to left and right subtrees
    	return 1 + bitsInTree(n.getLeft()) + bitsInTree(n.getRight());
    }
	
    /**
     * Gets the total number of nodes in HuffmanTree
     * @return total number of nodes in HuffmanTree
     */
    public int numNodes() {
    	return countNodes(root, new int[1])[0];
    }
	
	/**
     * Counts the number of nodes in the tree
     * @param node current node in the tree
     * @param count counts how many nodes are in the tree
     * @return the array that holds the number of nodes in the tree
     */
    public int[] countNodes(TreeNode node, int[] count) {
    	if (node != null) {
    		if (!node.isLeaf()) {
    			// leaf is empty, only increase count
    			count[0]++;
    		} else {
    			count[0]++;
    			// only increases when node is a leaf
    			numNodesWithVal++;
    		}
    		// make recursive call with the left and right subtrees
    		count = countNodes(node.getLeft(), count);
    		count = countNodes(node.getRight(), count);
    	}
    	return count;
    }
    
    /**
     * Gets the number of bits written
     * @param bout the BitOutputStream to write to
     * @return the number of bits written
     */
    public int traverseTree(BitOutputStream bout) {
    	return traverseTreeHelp(bout, root, new int[1])[0];
    }
    
    /**
     * Writes the tree header and counts the number of bits written
     * @param bout the BitOutputStream to write to
     * @param node the current TreeNode being looked at
     * @param count the number of bits that have been written
     * @return an int array of size one containing the number of bits written
     */
    private int[] traverseTreeHelp(BitOutputStream bout, TreeNode node, int[] count) {
    	if (node != null) {
    		if (!node.isLeaf()) {
    			// write bit with val equal to 0
    			bout.writeBits(1, 0);
    			count[0]++;
    		} else {
    			// node is a leaf, write 1 bit and value of leaf bits
    			bout.writeBits(1, 1);
    			bout.writeBits(IHuffConstants.BITS_PER_WORD + 1, node.getValue());
    			count[0] += IHuffConstants.BITS_PER_WORD + 2;
    		}
    		// make recursive call with left and right subtrees
    		count = traverseTreeHelp(bout, node.getLeft(), count);
    		count = traverseTreeHelp(bout, node.getRight(), count);
    	}
    	return count;
    }
    
    /**
     * Re-forms all info necessary from standard count heading
     * @param bin the BitInputStream to read from
     * @throws IOException
     */
    public int[] rebuildCounts(BitInputStream bin) throws IOException {
    	freqs = new int[IHuffConstants.ALPH_SIZE + 1];
		// rebuild freq array and priority queue
		for (int i = 0; i < IHuffConstants.ALPH_SIZE; i++) {
			// read in frequency for every ascii value
			int val = bin.readBits(IHuffConstants.BITS_PER_INT);
			freqs[i] = val;
			// if ascii value appears in the file, add to priority queue
			if (val > 0) {
				pq.enqueue(new TreeNode(i, val));
			}
		}
		freqs[IHuffConstants.ALPH_SIZE] = 1;
		pq.enqueue(new TreeNode(IHuffConstants.PSEUDO_EOF, 1));
		// rebuild tree
		createTree();
		return freqs;
    }
    
    /**
     * Rebuilds the HuffmanTree
     * @param bin the BitInputStream to read from
     * @return the rebuilt HuffmanTree
     * @throws IOException
     */
    public HuffmanTree rebuildTree(BitInputStream bin) throws IOException {
    	return new HuffmanTree(rebuildTreeHelp(bin));
    }
    
    /**
     * Re-forms all info necessary from standard tree heading
     * @param bin the BitInputStream to read from
     * @param node the current TreeNode being evaluated
     * @return the root of the rebuilt tree
     * @throws IOException
     */
    private TreeNode rebuildTreeHelp(BitInputStream bin) throws IOException {
    	int bit = bin.readBits(1);
    	// reached a leaf node, create new node with the value
    	if(bit == 1) {
    		return new TreeNode(bin.readBits(IHuffConstants.BITS_PER_WORD + 1), 0);
    	} else {
    		// inner node, create node with references to children
    		TreeNode temp = new TreeNode(-1, 0);
    		temp.setLeft(rebuildTreeHelp(bin));
    		temp.setRight(rebuildTreeHelp(bin));
    		return temp;
    	}
    }
    
    /**
     * Processes the encoded data and writes it to an un-huffed stream
     * @param bin the BitInputStream to read from
     * @param bout the BitOutputStream to write to
     * @return the number of bits written
     * @throws IOException
     */
    public int decode(BitInputStream bin, BitOutputStream bout) throws IOException {
    	int count = 0;
    	boolean done = false;
    	TreeNode temp = root;
		int bit = bin.readBits(1);
		// if bit is -1, means hf file is not well formed
		if (bit == -1) {
			throw new IOException("Error reading compressed file. \n" + 
					"unexpected end of input. No PSEUDO_EOF value.");
		} else {
			// keep reading while we have not reached pseudo EOF value
			while (temp != null && !done) {
				if (temp.isLeaf()) {
    				int val = temp.getValue();
    				if (val == IHuffConstants.PSEUDO_EOF) {
    					done = true;
    				} else {
    					// if next val is not pseudo EOF, write to uncompressed file
    					bout.writeBits(IHuffConstants.BITS_PER_WORD, val);
    					count += IHuffConstants.BITS_PER_WORD;
    					// place temp node back at root
    					temp = root;
    				}
    			}
				// go left if bit is 0, right if bit is 1
    			if (bit == 0) {
    				temp = temp.getLeft();
    			} else {
    				temp = temp.getRight();
    			}
    			bit = bin.readBits(1);
			}
		}
    	return count;
    }
}
