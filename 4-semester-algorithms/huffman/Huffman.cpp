
#include "Huffman.h"
#include "MinHeap.h"

MinHeapNode* Huffman::BuildTree(const Frequency& freq)
{
	// Step 1: Create a min heap of capacity
	// equal to size. Initially, there are
	// modes equal to size.
	auto minHeap = new MinHeap(freq);

	// Iterate while size of heap doesn't become 1
	while (!(minHeap->Size == 1)) {

		// Step 2: Extract the two minimum
		// freq items from min heap
		MinHeapNode* left = minHeap->ExtractMin();
		MinHeapNode* right = minHeap->ExtractMin();

		// Step 3: Create a new internal
		// node with frequency equal to the
		// sum of the two nodes frequencies.
		// Make the two extracted node as
		// left and right children of this new node.
		// Add this node to the min heap
		const auto top = new MinHeapNode(NULL, left->Freq + right->Freq);
		top->Left = left;
		top->Right = right;
		minHeap->InsertNode(top);
	}

	// Step 4: The remaining node is the
	// root node and the tree is complete.
	return minHeap->ExtractMin();
}

std::string* Huffman::Encode(const std::vector<Code>& codes, const std::string& text)
{
	auto res = new std::string();
	for (char i : text)
	{
		const Code* ref = nullptr;
		for (const auto& code : codes)
			if (code.Letter == i)
				ref = &code;
		for (auto number : ref->Numbers)
			res->push_back('0' + number);
	}
	return res;
}

std::string* Huffman::Decode(const MinHeapNode* root, const std::string& text)
{
	auto res = new std::string();
	auto currentNode = root;
	for (char i : text)
	{
		if (i == '0')
		{
			if (currentNode->Left->Left == nullptr && currentNode->Left->Right == nullptr)
			{
				res->push_back(currentNode->Left->Letter);
				currentNode = root;
			}
			else
				currentNode = currentNode->Left;
		}
		else
		{
			if (currentNode->Right->Left == nullptr && currentNode->Right->Right == nullptr)
			{
				res->push_back(currentNode->Right->Letter);
				currentNode = root;
			}
			else
				currentNode = currentNode->Right;
		}
	}
	return res;
}

