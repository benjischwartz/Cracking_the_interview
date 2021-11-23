class NumIslands {
    public int numIslands(char[][] grid) {
     int r=grid.length;
     int c=grid[0].length;

        if(r==0)return 0;

        int count=0;
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(grid[i][j]=='1')
                {
                    DFS(grid,i,j);
                    count++;
                }
            }
        }

        return count;
    }

    public void DFS(char[][] grid,int i,int j)
    {

        int r=grid.length;
        int c=grid[0].length;

        if(i<0 || j<0 || i>=r || j>=c || grid[i][j]=='0')return;

        grid[i][j]='0';
        DFS(grid,i+1,j);
        DFS(grid,i,j+1);
        DFS(grid,i-1,j);
        DFS(grid,i,j-1);
    }
}

