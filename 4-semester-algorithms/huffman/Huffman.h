#pragma once
#include <string>

#include "Frequency.h"
#include "MinHeapNode.h"

class Huffman
{
public:
	static MinHeapNode* BuildTree(const Frequency& freq);
	static std::string* Encode(const std::vector<Code>& codes, const std::string& text);
	static std::string* Decode(const MinHeapNode* root, const std::string& text);
};
