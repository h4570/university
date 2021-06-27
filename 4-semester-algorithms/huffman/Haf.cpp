#include "Haf.h"
#include <fstream>
#include <iostream>

Haf::Haf()
{
	CurrentBit = 0;
	BitBuffer = 0;
}

void Haf::Save(const std::string& path, const MinHeapNode* root, const std::string& encoded)
{
	CurrentBit = 0;
	BitBuffer = 0;

	std::ofstream of;
	of.open(path, std::ios::binary | std::ios::out);

	const int encodedSize = static_cast<int>((encoded.size() / 8.0F) + 0.5F); // 8 bits, 0.5F for round up
	of.write(reinterpret_cast<const char*>(&encodedSize), sizeof(encodedSize));
	for (char i : encoded)
		WriteBit(of, i == '1');
	FlushBits(of);

	std::vector<HafFileNode> nodes;
	const int rootId = PopulateHafNodes(nodes, root);
	const int nodesSize = nodes.size();
	of.write(reinterpret_cast<const char*>(&nodesSize), sizeof(nodesSize));
	of.write(reinterpret_cast<const char*>(&rootId), sizeof(rootId));
	of.write(reinterpret_cast<const char*>(nodes.data()), nodesSize * sizeof(HafFileNode));

	of.close();
}

HafFile* Haf::Load(const std::string& path)
{
	const auto res = new HafFile{};
	std::ifstream in(path, std::ios::in | std::ios::binary);

	int encodedSize;
	in.read(reinterpret_cast<char*>(&encodedSize), sizeof(encodedSize));

	const auto bytes = new uint8_t[encodedSize];
	in.read(reinterpret_cast<char*>(bytes), encodedSize * sizeof(uint8_t));
	for (int i = 0; i < encodedSize; i++)
		for (int j = 0; j < 8; j++) // Iterate through bits
			res->Encoded.push_back('0' + ((bytes[i] & (1 << j)) >> j));

	int nodesSize, rootId;
	in.read(reinterpret_cast<char*>(&nodesSize), sizeof(nodesSize));
	in.read(reinterpret_cast<char*>(&rootId), sizeof(rootId));
	const auto nodes = new HafFileNode[nodesSize];
	in.read(reinterpret_cast<char*>(nodes), nodesSize * sizeof(HafFileNode));

	res->Root = new MinHeapNode(nodes, nodesSize, rootId);

	in.close();
	delete[] bytes;
	delete[] nodes;
	return res;
}

int Haf::PopulateHafNodes(std::vector<HafFileNode>& output, const MinHeapNode* node)
{
	HafFileNode t{};
	t.Id = 1 + rand() % 999999;
	t.Letter = node->Letter;

	if (node->Left)
	{
		const auto id = PopulateHafNodes(output, node->Left);
		t.LeftId = id;
	}
	else
		t.LeftId = -1;

	if (node->Right)
	{
		const auto id = PopulateHafNodes(output, node->Right);
		t.RightId = id;
	}
	else
		t.RightId = -1;

	output.push_back(t);
	return t.Id;
}

void Haf::WriteBit(std::ofstream& of, const int& bit)
{
	if (bit)
		BitBuffer |= 1 << CurrentBit;
	CurrentBit++;
	if (CurrentBit == 8)
	{
		of.write(reinterpret_cast<const char*>(&BitBuffer), sizeof(BitBuffer));
		CurrentBit = 0;
		BitBuffer = 0;
	}
}

void Haf::FlushBits(std::ofstream& of)
{
	while (CurrentBit)
		WriteBit(of, 0);
}
