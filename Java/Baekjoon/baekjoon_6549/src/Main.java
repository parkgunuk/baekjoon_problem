import java.io.*;
import java.util.*;

public class Main
{
    // 뒤가 지수 앞x
    static double baseLog(double x, double base)
    {
        return Math.log10(x) / Math.log10(base);
    }

    static void init(int[] a, int[] tree, int node, int start, int end)
    {
        if (start == end)
        {
            tree[node] = start;
        } else
        {
            init(a, tree, node * 2, start, (start + end) / 2);
            init(a, tree, node * 2 + 1, (start + end) / 2 + 1, end);

            if (a[tree[node * 2]] <= a[tree[node * 2 + 1]])
                tree[node] = tree[node * 2];
            else
                tree[node] = tree[node * 2 + 1];
        }
    }

    static int query(int[] a, int[] tree, int node, int start, int end, int i, int j)
    {
        if (i > end || j < start)
        {
            return -1;
        }
        if (i <= start && end <= j)
        {
            return tree[node];
        }
        int m1 = query(a, tree, 2 * node, start, (start + end) / 2, i, j);
        int m2 = query(a, tree, 2 * node + 1, (start + end) / 2 + 1, end, i, j);
        if (m1 == -1)
            return m2;
        else if (m2 == -1)
            return m1;
        else
        {
            if (a[m1] <= a[m2])
                return m1;
            else
                return m2;
        }
    }

    static long largest(int[] a, int[] tree, int start, int end)
    {
        int n = a.length;
        int m = query(a, tree, 1, 0, n - 1, start, end);
        long area = (long) (end - start + 1) * (long) a[m];
        if (start <= m - 1)
        {
            long temp = largest(a, tree, start, m - 1);
            if (area < temp)
                area = temp;
        }
        if (m + 1 <= end)
        {
            long temp = largest(a, tree, m + 1, end);
            if (area < temp)
                area = temp;
        }
        return area;
    }

    public static void main(String[] args) throws IOException
    {
        // StringTokenizer 이용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        while (true)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            if (n == 0)
                break;

            int a[] = new int[n];

            for (int i = 0; i < n; i++)
            {
                a[i] = Integer.parseInt(st.nextToken());
            }
            int h = (int) (Math.ceil(baseLog((double) n, 2.0)));
            int tree_size = (1 << (h + 1));

            int tree[] = new int[tree_size];

            // System.out.println(tree_size);
            init(a, tree, 1, 0, n - 1);
            System.out.println(largest(a, tree, 0, n - 1));
        }

    }
}