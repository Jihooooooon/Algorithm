#include<iostream>

using namespace std;

void quickSort(int* arr, int start, int end) {
	int left = start;
	int right = end;
	int pivot = arr[(start + end) / 2];

	do {
		while (arr[left] < pivot) left++;
		while (arr[right] > pivot) right--;
		if (left <= right) {
			int temp = arr[right];
			arr[right] = arr[left];
			arr[left] = temp;
			left++;
			right--;
		}


	} while (left <= right);
	if (left < end) {
		quickSort(arr, left, end);
	}
	if (right > start) {
		quickSort(arr, start, right);
	}
}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(0);
	int T;
	cin >> T;
	for (int test = 1; test <= T; test++) {
		int P;
		cin >> P;
		int* arr = new int[P];
		for (int i = 0; i < P; i++) {
			cin >> arr[i];
		}
		quickSort(arr, 0, P - 1);
		int result;
		if (P == 1) {
			result = arr[0] * arr[0];
		}
		else {
			result = arr[0] * arr[P - 1];
		}
		cout << "#" << test << " " << result << endl;


		delete[] arr;
	}
	

	return 0;
}