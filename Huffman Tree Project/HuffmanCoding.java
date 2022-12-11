
import java.util.*;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.FileNotFoundException;
import java.io.*;
import java.util.stream.Collectors;
import java.lang.reflect.Array;


class HuffmanCoding {

    public Hashtable<Character, Integer> getChararacterFrequency(String aStr) {
        Hashtable<Character, Integer> results = new Hashtable<Character, Integer>();

        for (int i = 0; i < aStr.length(); i++) {
            char c = aStr.charAt(i);
            if (results.containsKey(c)) {
                results.put(c, results.get(c) + 1);
            } else {
                results.put(c, 1);
            }
        }

        return results;
    }

    public Hashtable<Character, Integer> getChararacterFrequency(File aFile) {
        Hashtable<Character, Integer> results = new Hashtable<Character, Integer>();
        try {

            Scanner fileRead = new Scanner(aFile);
            String asOneLine = "";
            while (fileRead.hasNext()) {
                asOneLine += fileRead.next();
            }
            results = getChararacterFrequency(asOneLine);
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        }
        return results;
    }


    public HuffmanTreeNode buildHuffmanTree(Hashtable<Character, Integer> ht) {
        PriorityQueue<HuffmanTreeNode> pq = new PriorityQueue<HuffmanTreeNode>();

        for (Character ch : ht.keySet()) {
            pq.add(new HuffmanTreeNode(ch, ht.get(ch)));
            // print the character and the value to check they are what you expect
        }

        for (; ; ) {
            HuffmanTreeNode left = pq.poll();

            if (pq.isEmpty()) {
                return left;
            }

            HuffmanTreeNode right = pq.poll();

            HuffmanTreeNode newInternalNode =
                    new HuffmanTreeNode('\0', left.getFrequency() + right.getFrequency());

            newInternalNode.setLeft(left);
            newInternalNode.setRight(right);

            pq.add(newInternalNode);
        }

    }

    public Hashtable<Character, String> buildCodeTable(HuffmanTreeNode huffmanTree) {
        Hashtable<Character, String> codeTable = new Hashtable<>();
        buildCodeTableImp(huffmanTree, "", codeTable);
        return codeTable;
    }

    private void buildCodeTableImp(HuffmanTreeNode huffmanTree, String path, Hashtable<Character, String> codeTable) {
        char key = huffmanTree.getKey();

        if (key != '\0')
            codeTable.put(key, path);

        HuffmanTreeNode leftChild = huffmanTree.getLeft();
        if (leftChild != null) {
            buildCodeTableImp(leftChild, path + "0", codeTable);
        }

        HuffmanTreeNode rightChild = huffmanTree.getRight();
        if (rightChild != null) {
            buildCodeTableImp(rightChild, path + "1", codeTable);
        }
    }

    public String encoding(String aStr, Hashtable<Character, String> codeTable) {
        // it takes as parameters aStr to encode
        // and codeTable which is used to encode each character in aStr,
        // then returns encoded binary String.
        // For example, with the above code table, cab will be encoded into 101001

        String txt = "";
        for (int i = 0; i < aStr.length(); i++) { //for loop for aStr
            char result = aStr.charAt(i); // gets character from aStr
            txt = txt + codeTable.get(result);
        }
        return txt;
    }

    public String decode(String binaryStr, HuffmanTreeNode huffmanTree) {
        //similar to what we did before but just the opposite
        //we have to see what txt printed from the previous method and reverse it
        //build code table from huffman tree then decode with that
        String input = "";

        // Java 8 makes life easier
        String s = Arrays.stream(input.split(""))
                .map(binary -> Integer.parseInt(binary, 2))
                .map(Character::toString)
                .collect(Collectors.joining()); // cut the space

        System.out.println(s);
        return s;
    }
}
