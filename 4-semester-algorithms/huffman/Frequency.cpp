#include "Frequency.h"

Frequency::Frequency(const std::string& text)
{
	for (auto char_ : text)
	{
		LetterFrequency* ref = nullptr;
		for (auto item : Letters)
			if (item.Letter == char_)
				ref = &item;
		if (ref == nullptr)
		{
			LetterFrequency t{};
			t.Letter = char_;
			t.Frequency = 1;
			Letters.push_back(t);
		}
		else
			ref->Frequency++;
	}
}