README.txt

COMPRESSION SUMMARY

CALGARY
total bytes read: 5097064
total compressed bytes 3655370
total percent compression 28.285
compression time: 5.053

WATERLOO
total bytes read: 22671586
total compressed bytes 20268639
total percent compression 10.599
compression time: 25.933

BOOKS AND HTML
total bytes read: 15616693
total compressed bytes 11575332
total percent compression 25.878
compression time: 15.183

Longer text and HTML files lead to lots of compressions, while images tend to compress very little,
if at all. This could be because image files store RGB values as 8-bit values that represent 0-255,
so it's possible that in these files all of the values could have high frequencies. 
This could result in a well-balanced huffman tree, meaning that the path lengths would all be of a
similar length. Therefore, there would be little compression.

When trying to compress a Huffman code file several times, it quickly becomes apparent that 
the effectiveness of the compression algorithm decreases after one use. 
Because it has already been organized by frequency, reading in the already compressed bits would 
not lead to much further compression, and in many cases increases the number of bits in the file. 
Because we need to store data about how the file was compressed (like the count/tree header info),
we may be adding more bits than we are saving, similar to how the algorithm reacts to small files.


