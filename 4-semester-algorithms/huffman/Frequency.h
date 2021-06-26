#pragma once
#include <string>
#include <vector>

#include "LetterFrequency.h"

class Frequency
{
public:
	explicit Frequency(const std::string& text);
	unsigned GetSize() const { return Letters.size(); }
	std::vector<LetterFrequency> Letters;
};
