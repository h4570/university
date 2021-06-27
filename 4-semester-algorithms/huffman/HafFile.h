#pragma once
#include <string>

#include "MinHeapNode.h"

struct HafFile
{
	std::string Encoded;
	MinHeapNode* Root;
};
