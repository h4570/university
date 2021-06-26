#include "MinHeapNode.h"

#include <iostream>

#include "Utils.h"

MinHeapNode::MinHeapNode(const char data, const unsigned freq)
{
	Left = Right = nullptr;
	Data = data;
	Freq = freq;
}

constexpr unsigned MAX_TREE = 100;
std::vector<Code>* MinHeapNode::GetCodes() const
{
	const auto res = new std::vector<Code>();
	const auto arr = new int[MAX_TREE]; // not proud of it
	FillCodes(*res, 0, arr);
	return res;
}

void MinHeapNode::FillCodes(std::vector<Code>& codes, const int top, int arr[]) const
{


	// Assign 0 to left edge and recur
	if (Left) {
		arr[top] = 0;
		Left->FillCodes(codes, top + 1, arr);
	}

	// Assign 1 to right edge and recur
	if (Right) {
		arr[top] = 1;
		Right->FillCodes(codes, top + 1, arr);
	}

	// If this is a leaf node, then
	// it contains one of the input
	// characters
	if (IsLeaf()) {
		Code t;
		t.Letter = Data;
		for (int i = 0; i < top; ++i)
			t.Numbers.push_back(arr[i]);
		codes.push_back(t);
	}
}

void MinHeapNode::Swap(MinHeapNode** a, MinHeapNode** b)
{
	MinHeapNode* t = *a;
	*a = *b;
	*b = t;
}
