#pragma once
#include "Frequency.h"

class MinHeapNode;
/**
 * Collection of min-heap (or Huffman tree) nodes
 */
class MinHeap {
public:

	/** Create a min heap of given capacity */
	explicit MinHeap(unsigned capacity);

	/**
	 * Creates a min heap of capacity
	 * equal to size and inserts all character of
	 * data[] in min heap. Initially size of
	 * min heap is equal to capacity
	 */
	MinHeap(const Frequency& freq);

	/** The standard minHeapify function */
	void MinHeapify(int idx) const;

	/** Extract minimum value node from heap */
	MinHeapNode* ExtractMin();

	/** Insert a new node to min heap */
	void InsertNode(MinHeapNode* minHeapNode);

	/** Current size of min heap */
	signed Size;

	/** Capacity of min heap */
	unsigned Capacity;

	/** Array of min heap node pointers */
	MinHeapNode** Array;

private:

	/** A standard function to build min heap */
	void Build() const;

};