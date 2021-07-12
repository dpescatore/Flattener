# Flattener

Flattener is a Java Class to be used to flat a nested array of integers. It was developed using VS Code.

## Installation

1. Clone repo from GIT
3. Compile using provided pom.xml
4. Run tests and enjoy

## Usage

```Java
import it.example.Flattener;

//init some array of integers
Integer[] arr = { 1, 4, 6 };
Integer[] arr2 = { 1, 2, 3 };
Object[] arr3 = { arr, arr2 };

//return flattenarray result = {1,4,6,1,2,3}
Integer[] result = Flattener.FlatArray(arr3, null);
```
