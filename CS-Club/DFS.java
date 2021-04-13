import java.util.Arrays;

public class DFS
{
    static char[][] grid;

    static boolean inside(int row, int col)
    {
        return (row>=0 && col>=0 && row<6 && col<5);
    }

    static void dfs(int row, int col)
    {
        char color = grid[row][col];
        grid[row][col]= '6';
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {-0, 0, -1, 1};

        for (int d = 0; d < 4; d++)
        {
            int newRow = dr[d]+row;
            int newCol = dc[d]+col;
            if (inside(newRow, newCol) && grid[newRow][newCol] == color)
            {
                dfs(newRow, newCol);
            }
        }
    }
    public static void main(String[] args)
    {
        grid = new char[][]{
            {'1', '1', '1', '1', '1'},
            {'1', '2', '3', '3', '2'},
            {'3', '3', '3', '3', '5'},
            {'5', '2', '4', '3', '4'},
            {'4', '3', '1', '3', '4'},
            {'5', '3', '5', '3', '2'},
        };

        dfs(2, 2);

        for (char[] r : grid)
        {
            System.out.println(Arrays.toString(r));
        }
    }
}