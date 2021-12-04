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
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.TreeSet;

public class SimpleHuffProcessor implements IHuffProcessor {
	
	// instance variables
    private IHuffViewer myViewer;
    private int format;
    private Map<Integer, String> map;
    private TreeSet<Integer> vals;
    private int[] freqs;
    private int bitDifference;
    private HuffmanTree tree;

    /**
     * Preprocess data so that compression is possible ---
     * count characters/create tree/store state so that
     * a subsequent call to compress will work. The InputStream
     * is <em>not</em> a BitInputStream, so wrap it int one as needed.
     * @param in is the stream which could be subsequently compressed
     * @param headerFormat a constant from IHuffProcessor that determines what kind of
     * header to use, standard count format, standard tree format, or
     * possibly some format added in the future.
     * @return number of bits saved by compression or some other measure
     * Note, to determine the number of
     * bits saved, the number of bits written includes
     * ALL bits that will be written including the
     * magic number, the header format number, the header to
     * reproduce the tree, AND the actual data.
     * @throws IOException if an error occurs while reading from the input file.
     */
    public int preprocessCompress(InputStream in, int headerFormat) throws IOException {
        format = headerFormat;
        // build frequency arr
    	freqs = new int[ALPH_SIZE + 1];
    	vals = new TreeSet<>();
        createFreqs(in);
        // build the Huffman Tree
        tree = new HuffmanTree();
    	tree.createQueue(vals, freqs);
    	tree.createTree();
    	// build map of paths and vals
    	map = tree.returnMap();
        // calculate original and compressed bits to determine saved bits
        int original = originalBits();
        int compressed = compressedBits();
        bitDifference = original - compressed;
        return bitDifference;
    }
    
    /**
     * Creates an int array of frequencies of the bits
     * @param in the InputStream
     * @throws IOException
     */
    private void createFreqs(InputStream in) throws IOException {
    	BitInputStream bits = new BitInputStream(in);
    	int temp = bits.readBits(BITS_PER_WORD);
    	while (temp != -1) {
    		// increase frequency of char in int array
    		freqs[temp]++;
    		// add char to treeset
    		vals.add(temp);
    		// read next char
    		temp = bits.readBits(BITS_PER_WORD);
    	}
    	// set frequency of psuedo eof
    	freqs[ALPH_SIZE] = 1;
    	bits.close();
    }
    
    /**
     * Calculates the number of bits in the original file
     * @return the number of bits in the original file
     */
    private int originalBits() {
    	int count = 0;
    	for (int i = 0; i < ALPH_SIZE; i++) {
    		// increase count based on frequency of a char
    		count += freqs[i] * BITS_PER_WORD;
    	}
    	return count;
    }
    
    /**
     * Calculates the number of bits in the compressed file
     * @return the number of bits in the compressed file
     */
    private int compressedBits() {
    	int count = 0;
    	// add bits for magic number and header constant
    	count += BITS_PER_INT * 2;
    	// add header bits
    	if (format == STORE_TREE) {
    		// 32 bits representing tree size plus bits for nodes
    		count += BITS_PER_INT + tree.returnBitsInTree();
    	} else if (format == STORE_COUNTS) {
    		// number of bits it takes to store the array
    		count += ALPH_SIZE * BITS_PER_INT;
    	}
    	// add actual compressed bits, including pseudo EOF
    	for (int val : map.keySet()) {
    		// add path length for each value
    		String path = map.get(val);
    		count += path.length() * freqs[val];
    	}
    	return count;
    }

    /**
	 * Compresses input to output, where the same InputStream has
     * previously been pre-processed via <code>preprocessCompress</code>
     * storing state used by this call.
     * <br> pre: <code>preprocessCompress</code> must be called before this method
     * @param in is the stream being compressed (NOT a BitInputStream)
     * @param out is bound to a file/stream to which bits are written
     * for the compressed file (not a BitOutputStream)
     * @param force if this is true create the output file even if it is larger than the input file
     * If this is false do not create the output file if it is larger than the input file.
     * @return the number of bits written.
     * @throws IOException if an error occurs while reading from the input file or
     * writing to the output file.
     */
    public int compress(InputStream in, OutputStream out, boolean force) throws IOException {
    	if (!force && bitDifference < 0) {
    		// don't compress if compressed file has more bits
    		throw new IOException("Compressed file has " + (-1 * bitDifference) + " more bits "
    				+ "than uncompressed file. Select \"force compression\" option to compress.");
    	}
    	int bitCount = 0;
    	// wrap in and out as a BitInputStream & a BitOutputStream
    	BitInputStream bin = new BitInputStream(in);
    	BitOutputStream bout = new BitOutputStream(out);
    	// write the bits for the magic number and format
    	bout.writeBits(BITS_PER_INT, MAGIC_NUMBER);
    	bout.writeBits(BITS_PER_INT, format);
    	bitCount += BITS_PER_INT * 2;
    	// write different headers depending on format
    	bitCount += writeHeader(bout);
    	int temp = bin.readBits(BITS_PER_WORD);
    	while (temp != -1) {
    		// get the path for the char from the map
    		String path = map.get(temp);
    		bitCount += write(bout, path);
    		// read in next char
    		temp = bin.readBits(BITS_PER_WORD);
    	}
    	// find the bits for pseudo eof and add to bitCount
    	bitCount += write(bout, map.get(PSEUDO_EOF));
    	bin.close();
    	bout.close();
        return bitCount;
    }
    
    /**
     * Writes the given String in bits
     * @param bout the BitOutputStream to write to
     * @param str the String to write
     * @return the number of bits written
     */
    private int write(BitOutputStream bout, String str) {
    	for (int i = 0; i < str.length(); i++) {
    		String sub = str.substring(i, i + 1);
    		// write each bit at a time
    		bout.writeBits(1, Integer.parseInt(sub));
    	}
    	return str.length();
    }
    
    /**
     * Writes the header of the compressed file based on format
     * @param bout the BitOutputStream to write to
     */
    private int writeHeader(BitOutputStream bout) {
    	int count = 0;
    	if (format == STORE_COUNTS) {
        	for (int i = 0; i < ALPH_SIZE; i++) {
        		// write the frequency of each char
        	    bout.writeBits(BITS_PER_INT, freqs[i]);
        	    count += BITS_PER_INT;
        	}
    	} else {
    		// write size of tree based on number of nodes with a value
    		int size = (tree.getNodesWithVal() * (BITS_PER_WORD + 2)) + 
    				(tree.numNodes() - tree.getNodesWithVal());
    		bout.writeBits(BITS_PER_INT, size);
    		// write the bits of the tree
    		count += tree.traverseTree(bout);
    	}
    	return count;
    }

    /**
     * Uncompress a previously compressed stream in, writing the
     * uncompressed bits/data to out.
     * @param in is the previously compressed data (not a BitInputStream)
     * @param out is the uncompressed file/stream
     * @return the number of bits written to the uncompressed file/stream
     * @throws IOException if an error occurs while reading from the input file or
     * writing to the output file.
     */
    public int uncompress(InputStream in, OutputStream out) throws IOException {
		int count = 0;
		BitInputStream bin = new BitInputStream(in);
		BitOutputStream bout = new BitOutputStream(out);
		// make sure file starts with the magic number
		int magic = bin.readBits(BITS_PER_INT);
		if (magic != MAGIC_NUMBER) {
			myViewer.showError("Error reading compressed file. \n" + 
					"File did not start with the huff magic number.");
    		bin.close();
    		bout.close();
			return -1;
		}
		// determine format of header
		format = bin.readBits(BITS_PER_INT);
		// rebuild information from header
		tree = new HuffmanTree();
		if (format == STORE_COUNTS) {
			freqs = tree.rebuildCounts(bin);
		} else if (format == STORE_TREE) {
			// read in size of tree
			bin.readBits(BITS_PER_INT);
			tree = tree.rebuildTree(bin);
		}
		// uncompress the rest of the data
		count += tree.decode(bin, bout);
		bin.close();
		bout.close();
        return count;
    }

    public void setViewer(IHuffViewer viewer) {
        myViewer = viewer;
    }

    private void showString(String s){
        if(myViewer != null)
            myViewer.update(s);
    }
}
