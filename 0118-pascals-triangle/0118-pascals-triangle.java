class Solution {
    public List<List<Integer>> generate(int numRows) {
                List<List<Integer>> res = new ArrayList<>();
        
        if (numRows == 0)
            return res;
        
        // Adding the first row
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        res.add(firstRow);

        if (numRows == 1) return res;

        // Generate rows from 2 to numRows
        for (int i = 1; i < numRows; i++) {
            List<Integer> prevRow = res.get(i - 1);
            List<Integer> row = new ArrayList<>();
            row.add(1);  // The first element of each row is 1
            
            for (int j = 1; j < i; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            
            row.add(1);  // The last element of each row is 1
            res.add(row);
        }

        return res;
    }
}