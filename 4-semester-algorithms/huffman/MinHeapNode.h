#pragma once
#include <vector>

#include "Code.h"

/** A Huffman tree node */
class MinHeapNode {
public:

	/**
	 * Allocates a new min heap node with given character
	 * and frequency of the character
	 */
	MinHeapNode(char data, unsigned freq);

	/** Check if node is a leaf */
	bool IsLeaf() const { return !Left && !Right; }

	std::vector<Code>* GetCodes() const;

	/** Swap two min heap nodes */
	static void Swap(MinHeapNode** a, MinHeapNode** b);

	/** One of the input characters */
	char Data;

	/** Frequency of the character */
	unsigned Freq;

	/** Left and right child of this node */
	MinHeapNode* Left, * Right;

private:
	/**
	 * Fills huffman codes from the root of Huffman Tree.
	 * NOTICE: Recurrence function!
	 */
	void FillCodes(std::vector<Code>& codes, int top, int arr[] = nullptr) const;
};