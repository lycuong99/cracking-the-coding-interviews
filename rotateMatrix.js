function rotateMatrix(matrix = [1, 1, 1, 2, 2, 2, 3, 3, 3]) {
    let n = 3;
  
    printMatrix1D(matrix, n, n);
  
    let rotateMatrix = [];
  
    let edgeLength = n - 1;
  
    for (let i = 0; i < n; i++) {
      for (let j = 0; j < n; j++) {
        let item = matrix[i * n + j];
        let i1 = j;
        let j1 = i;
        i1 = edgeLength - i1;
        j1 = edgeLength - j1;
        rotateMatrix[i1 * n + j1] = item;
      }
    }
  
    printMatrix1D(rotateMatrix, n, n);
  }
  
function rotateMatrix2(matrix = [1, 1, 1, 2, 2, 2, 3, 3, 3]) {
    let n = 3;
  
    printMatrix1D(matrix, n, n);
  
    let rotateMatrix = [];
  
    let edgeLength = n - 1;
  
    const transformToXY = (j, i) => {
      return {
        x: j - edgeLength / 2,
        y: i - edgeLength / 2,
      };
    };
  
    const transformToIJ = (x, y) => {
      return {
        i: y + edgeLength / 2,
        j: x + edgeLength / 2,
      };
    };
  
    for (let i = 0; i < n; i++) {
      for (let j = 0; j < n; j++) {
        let item = matrix[i * n + j];
        let { x, y } = transformToXY(j, i);
        let { i: i1, j: j1 } = transformToIJ(-y, x);
        rotateMatrix[i1 * n + j1] = item;
      }
    }
  
    printMatrix1D(rotateMatrix, n, n);
}
  
function printMatrix1D(arr, rows, cols) {
    for (let i = 0; i < rows; i++) {
      let row = [];
      for (let j = 0; j < cols; j++) {
        row.push(arr[i * cols + j]); // Tính chỉ số trong mảng 1D
      }
      console.log(row.join(" ")); // In hàng với tab giữa các số
    }
  
    console.log("---");
}
  
  console.clear();
  // rotateMatrix();
  rotateMatrix2();
  