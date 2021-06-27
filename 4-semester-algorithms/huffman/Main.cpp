#include <vector>

#include "Frequency.h"
#include "Haf.h"
#include "Huffman.h"
#include "MinHeapNode.h"
#include "Utils.h"

int main(const int argc, char* argv[]) // NOLINT(bugprone-exception-escape)
{
	if (argc <= 1) return 1;

	srand(static_cast<unsigned>(time(nullptr)));

	const std::string path(argv[1]);
	const auto filename = Utils::GetFilename(path);
	const auto pathWithoutExtension = Utils::GetWithoutExtension(path);

	if (Utils::IsExtension(path, "txt"))
	{
		Haf haf;
		const std::string* text = Utils::ReadFileContent(path);

		const Frequency frequency(*text);

		MinHeapNode* root = Huffman::BuildTree(frequency);

		const auto codes = root->GetCodes();
		Utils::PrintCodes(*codes);

		const auto encoded = Huffman::Encode(*codes, *text);
		haf.Save(*pathWithoutExtension + ".haf", root, *encoded);

		delete encoded;
		delete text;
		delete codes;
	}
	else if (Utils::IsExtension(path, "haf"))
	{
		const auto loaded = Haf::Load(path);
		const auto decoded = Huffman::Decode(loaded->Root, std::string(loaded->Encoded));
		Utils::SaveFileContent(*pathWithoutExtension + ".txt", *decoded);
		delete loaded;
		delete decoded;
	}

	delete filename;
	delete pathWithoutExtension;
	return 0;
}