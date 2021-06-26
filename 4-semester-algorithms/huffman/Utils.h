#pragma once
#include <iostream>
#include <vector>

class Utils {

public:
	static void PrintArray(int arr[], const int n)
	{
		for (int i = 0; i < n; ++i)
			std::cout << arr[i];
		std::cout << "\n";
	}

	static void PrintVector(const std::vector<int>& numbers)
	{
		for (int i = 0; i < numbers.size(); ++i)
			std::cout << numbers[i];
		std::cout << "\n";
	}

};
