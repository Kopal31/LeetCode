class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        res.add(firstRow);

        if(rowIndex == 0){
            return firstRow;
        }

        for(int i = 1; i <= rowIndex; i++){
            List<Integer> prevRow = res.get(i - 1);
            List<Integer> row = new ArrayList<>();
            row.add(1);  // The first element of each row is 1
            
            for (int j = 1; j < i; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            
            row.add(1);  // The last element of each row is 1
            res.add(row);

        }
        return res.get(rowIndex);
    }
}