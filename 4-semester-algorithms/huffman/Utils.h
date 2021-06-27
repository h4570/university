#pragma once
#include <iostream>
#include <fstream>
#include "Code.h"

class Utils {

public:
	static void PrintArray(int arr[], const int n)
	{
		for (int i = 0; i < n; ++i)
			std::cout << arr[i];
		std::cout << "\n";
	}

	static void PrintNumbers(const std::vector<int>& numbers)
	{
		for (const int& number : numbers)
			std::cout << number;
		std::cout << "\n";
	}

	static void PrintCodes(const std::vector<Code>& codes)
	{
		// Print codes
		for (const auto& code : codes)
		{
			std::cout << code.Letter << ": ";
			PrintNumbers(code.Numbers);
		}
	}

	static bool IsExtension(const std::string& path, const char* extension) {
		return path.substr(path.find_last_of('.') + 1) == extension;
	}

	static std::string* GetWithoutExtension(const std::string& path) {
		const size_t lastIndex = path.find_last_of('.');
		const auto res = path.substr(0, lastIndex);
		return new std::string(res);
	}

	static std::string* GetFilename(const std::string& path) {
		const auto res = new std::string(path);

		const size_t lastSlashIdx = res->find_last_of("\\/");
		if (std::string::npos != lastSlashIdx)
			res->erase(0, lastSlashIdx + 1);

		// Remove extension if present.
		const size_t periodIdx = res->rfind('.');
		if (std::string::npos != periodIdx)
			res->erase(periodIdx);

		return res;
	}

	static std::string* ReadFileContent(const std::string& path) {
		std::ifstream t(path);
		const auto res = new std::string((std::istreambuf_iterator<char>(t)),
			std::istreambuf_iterator<char>());
		t.close();
		return res;
	}

	static void SaveFileContent(const std::string& path, const std::string& content) {
		std::ofstream outfile;
		outfile.open(path, std::ios_base::trunc);//std::ios_base::app
		outfile << content;
		outfile.close();
	}

};
