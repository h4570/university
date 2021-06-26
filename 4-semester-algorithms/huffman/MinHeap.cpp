#include "MinHeap.h"
#include "MinHeapNode.h"

MinHeap::MinHeap(const unsigned capacity)
{
	Size = 0;
	Capacity = capacity;
	Array = new MinHeapNode * [Capacity];
}

MinHeap::MinHeap(const Frequency& freq)
{
	Capacity = freq.GetSize();
	Size = freq.GetSize();
	Array = new MinHeapNode * [Capacity];
	for (int i = 0; i < Size; ++i)
		Array[i] = new MinHeapNode(freq.Letters[i].Letter, freq.Letters[i].Frequency);
	Build();
}

void MinHeap::Build() const
{
	const int n = Size - 1;
	for (int i = (n - 1) / 2; i >= 0; --i)
		MinHeapify(i);
}

void MinHeap::MinHeapify(const int idx) const
{
	int smallest = idx;
	const int left = 2 * idx + 1;
	const int right = 2 * idx + 2;

	if (left < Size && Array[left]->
		Freq < Array[smallest]->Freq)
		smallest = left;

	if (right < Size && Array[right]->
		Freq < Array[smallest]->Freq)
		smallest = right;

	if (smallest != idx) {
		MinHeapNode::Swap(&Array[smallest], &Array[idx]);
		MinHeapify(smallest);
	}
}

MinHeapNode* MinHeap::ExtractMin()
{
	MinHeapNode* temp = Array[0];
	Array[0] = Array[Size - 1];
	--Size;
	MinHeapify(0);
	return temp;
}

void MinHeap::InsertNode(MinHeapNode* minHeapNode)
{
	++Size;
	unsigned int i = Size - 1;
	while (i && minHeapNode->Freq < Array[(i - 1) / 2]->Freq) {
		Array[i] = Array[(i - 1) / 2];
		i = (i - 1) / 2;
	}
	Array[i] = minHeapNode;
}
