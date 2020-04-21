import java.io.*;
import java.util.*;

public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}

    private static class Node {

        int row, col;
        int entrance;

        Node(int row, int col, int entrance) {

            this.row = row;
            this.col = col;
            this.entrance = entrance;
        }
    }

    private static final int BLANK = 10;
    private static final int START = 11;
    private static final int END = 12;

    private static final int BLOCK_1 = 1;
    private static final int BLOCK_2 = 2;
    private static final int BLOCK_3 = 3;
    private static final int BLOCK_4 = 4;
    private static final int BLOCK_C = 5;
    private static final int BLOCK_V = 6;
    private static final int BLOCK_H = 7;

    private static final int WEST = 0;
    private static final int NORTH = 1;
    private  static final int EAST = 2;
    private static final int SOUTH = 3;
    private static final int FALSE = 5;

    private static final int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    static final char[] pipeArr = {'.', '1', '2', '3', '4', '+', '|', '-'};

    private static int R, C;
    private static int[][] map = new int[26][26];

    public static void main(String[] args) throws IOException {

        int sRow = 0, sCol = 0;
        int eRow = 0, eCol = 0;

        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = stoi(st.nextToken());
        C = stoi(st.nextToken());

        for (int i = 0; i < R; i++) {

            String s = br.readLine();
            for (int j = 0; j < C; j++) {

                char c = s.charAt(j);

                switch (c) {

                    case '.':
                        map[i][j] = BLANK;
                        break;

                    case 'M':
                        map[i][j] = START;
                        sRow = i;
                        sCol = j;
                        break;

                    case 'Z':
                        map[i][j] = END;
                        eRow = i;
                        eCol = j;
                        break;

                    case '|':
                        map[i][j] = BLOCK_V;
                        break;

                    case '-':
                        map[i][j] = BLOCK_H;
                        break;

                    case '+':
                        map[i][j] = BLOCK_C;
                        break;

                    default:
                        map[i][j] = c - '0';
                        break;
                }

            }
        }

        // solve
        // M에서부터 삭제된 노드까지 추적한다. return 삭제된 노드, 출입구 정보
        Node M = null;
        for (int d = 0; d < 4; d++) {

            int nr = sRow + dir[d][0];
            int nc = sCol + dir[d][1];

            if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;

            // 출발점 노드와 인접한 노드들 중 유효한 노드(파이프)를 찾는다.
            if (getStartNode(nr, nc, d)) M = traceRoute(nr, nc, d);
        }

        // Z에서부터 삭제된 노드까지 추적한다. return 삭제된 노드, 출입구 정보
        Node Z = null;
        for (int d = 0; d < 4; d++) {

            int nextRow = eRow + dir[d][0];
            int nextCol = eCol + dir[d][1];

            if (nextRow < 0 || nextRow >= R || nextCol < 0 || nextCol >= C) continue;

            // 출발점 노드와 인접한 노드들 중 유효한 노드(파이프)를 찾는다.
            if (getStartNode(nextRow, nextCol, d)) Z = traceRoute(nextRow, nextCol, d);

        }

        // 찾아낸 삭제된 노드 주변에 유효햔 파이프가 몇개인지 확인, 3개 이상인 경우 + 파이프가 들어가야 한다
        int cnt = 0;
        for (int d = 0; d < 4; d++) {

            int nextRow = M.row + dir[d][0];
            int nextCol = M.col + dir[d][1];

            if (nextRow < 0 || nextRow >= R || nextCol < 0 || nextCol >= C) continue;

            if (getStartNode(nextRow, nextCol, d)) cnt++;

        }

        // 결과 출력
        if (cnt >= 3) {

            // + 파이프인 경우
            System.out.println((M.row + 1) + " " + (M.col + 1) + " " + pipeArr[BLOCK_C]);
        } else {

            // + 파이프가 아닌 경우, 출입구 정보 2개를 이용하여 파이프를 찾는다
            System.out.println((M.row + 1) + " " + (M.col + 1) + " " + getBlock(M.entrance | Z.entrance));
        }
    } // ~main

    // + 파이프가 아닌 경우, 출입구 정보 2개를 이용하여 파이프를 찾는다
    static char getBlock(int enterance) {

        if ((enterance & (1 << NORTH)) > 0
                && (enterance & (1 << SOUTH)) > 0) {

            return pipeArr[BLOCK_V];
        }

        if ((enterance & (1 << WEST)) > 0
                && (enterance & (1 << EAST)) > 0) {

            return pipeArr[BLOCK_H];
        }

        if ((enterance & (1 << EAST)) > 0
                && (enterance & (1 << SOUTH)) > 0) {

            return pipeArr[BLOCK_1];
        }

        if ((enterance & (1 << NORTH)) > 0
                && (enterance & (1 << EAST)) > 0) {

            return pipeArr[BLOCK_2];
        }

        if ((enterance & (1 << WEST)) > 0
                && (enterance & (1 << NORTH)) > 0) {

            return pipeArr[BLOCK_3];
        } else {

            return pipeArr[BLOCK_4];
        }
    }

    // (row, col) 노드가 유효한지(출발점과 연결된 파이프인지) 판단한다.
    static boolean getStartNode(int row, int col, int inlet) {

        if (map[row][col] >= BLOCK_1 && map[row][col] <= BLOCK_H) {

            inlet = (inlet + 2) % 4;

            if (getOutlet(map[row][col], inlet) != FALSE) return true;
        }

        return false;
    }

    // 경로 추적
    static Node traceRoute(int row, int col, int inlet) {

        if (map[row][col] >= BLOCK_1 && map[row][col] <= BLOCK_H) {

            inlet = (inlet + 2) % 4;

            int outlet = getOutlet(map[row][col], inlet);

            int nextRow = row + dir[outlet][0];
            int nextCol = col + dir[outlet][1];

            return traceRoute(nextRow, nextCol, outlet);
        } else if (map[row][col] == BLANK) {

            return new Node(row, col, 1 << ((inlet + 2) % 4));
        }

        return null;
    }

    // 파이프와 입구 위치를 입력받고, 출구 위치를 반환한다
    static int getOutlet(int pipe, int inlet) {

        int outlet = 0;

        switch (pipe) {

            case BLOCK_1:
                outlet = inlet == SOUTH ? EAST : inlet == EAST ? SOUTH : FALSE;
                break;

            case BLOCK_2:
                outlet = inlet == NORTH ? EAST : inlet == EAST ? NORTH : FALSE;
                break;

            case BLOCK_3:
                outlet = inlet == WEST ? NORTH : inlet == NORTH ? WEST : FALSE;
                break;

            case BLOCK_4:
                outlet = inlet == WEST ? SOUTH : inlet == SOUTH ? WEST : FALSE;
                break;

            case BLOCK_C:
                outlet = inlet == WEST ? EAST : inlet == NORTH ? SOUTH : inlet == EAST ? WEST : NORTH;
                break;

            case BLOCK_V:
                outlet = inlet == NORTH ? SOUTH : inlet == SOUTH ? NORTH : FALSE;
                break;

            case BLOCK_H:
                outlet = inlet == WEST ? EAST : inlet == EAST ? WEST : FALSE;
                break;
        }

        return outlet;
    }
}