class Solution:

    def orangesRotting(self, grid: List[List[int]]) -> int:
        rows, cols = len(grid), len(grid[0])
        fresh = {(r, c) for r in range(rows) for c in range(cols) if grid[r][c] == 1}
        rotting = {(r, c) for r in range(rows) for c in range(cols) if grid[r][c] == 2}
        minutes = 0
        while fresh:
            if not rotting:
                return -1
            rotting = {(r+i, c+j) for r, c in rotting for i, j in [(0,1), (1,0), (0,-1), (-1,0)] if (r+i,c+j) in fresh}
            fresh -= rotting
            minutes += 1
        return minutes

    
        
