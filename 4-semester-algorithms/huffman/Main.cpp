#include <iostream>
#include <vector>

#include "Frequency.h"
#include "Huffman.h"
#include "MinHeapNode.h"
#include "Utils.h"

int main() // NOLINT(bugprone-exception-escape)
{
	const std::string test = "testowytesttestowyw";

	const Frequency frequency(test);

	MinHeapNode* root = Huffman::BuildTree(frequency);

	const auto codes = root->GetCodes();

	// Print codes
	for (auto code : *codes)
	{
		std::cout << code.Letter << ": ";
		Utils::PrintVector(code.Numbers);
	}

	const auto encoded = Huffman::Encode(*codes, test);
	std::cout << *encoded << std::endl;

	const auto decoded = Huffman::Decode(root, *encoded);
	std::cout << *decoded << std::endl;

	// Free memory
	delete encoded;
	delete decoded;
	delete codes;

	return 0;
}