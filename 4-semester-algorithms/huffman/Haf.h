#pragma once
#include <string>
#include "HafFile.h"
#include "HafFileNode.h"
#include "MinHeapNode.h"

class Haf
{
public:
	Haf();
	void Save(const std::string& path, const MinHeapNode* root, const std::string& encoded);
	static HafFile* Load(const std::string& path);
private:
	int CurrentBit;
	unsigned char BitBuffer;
	/** Populate nodes, return id */
	static int PopulateHafNodes(std::vector<HafFileNode>& output, const MinHeapNode* node);
	void WriteBit(std::ofstream& of, const int& bit);
	void FlushBits(std::ofstream& of);
};
