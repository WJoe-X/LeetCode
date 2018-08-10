package lib.sixzeroseven;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @auther: WJoe
 * @Description: ThoughtWorks
 * @Date : 18:03 2018/7/27
 */
public class RenderGrid {

    private static final String WAll = "[W]";

    private static final String ROAD = "[R]";

    public String render(String command) {
        String[] arr = command.split("\r?\n");
        if (arr == null || arr.length != 2 || arr[0].split(" ").length != 2) {
            return "Incorrect command format.";
        }
        String[] girdString = arr[0].split(" ");
        if (!isInteger(girdString[0]) || !isInteger(girdString[1])) {
            return "Invalid number format.";
        }
        int rows = Integer.valueOf(girdString[0]) * 2 + 1;
        int columns = Integer.valueOf(girdString[1]) * 2 + 1;
        String[][] gird = new String[rows][columns];
        gird = initialGird(gird);                                          //初始化迷宫

        String[] doublePionts = arr[1].split(";");
        for (int i = 0; i < doublePionts.length; i++) {
            String[] points = doublePionts[i].split(" ");
            if (points.length != 2) {
                return "Incorrect command format.";
            }
            for (int j = 0; j < 2; j++) {
                String[] point = points[j].split(",");
                if (point.length != 2) {
                    return "Incorrect command format.";
                }
                if (!isInteger(point[0]) || !isInteger((point[1]))) {
                    return "Invalid number format.";
                }
                if (Integer.valueOf(point[0]) > Integer.valueOf(girdString[0]) || Integer.valueOf(point[1]) > Integer.valueOf(girdString[1])) {
                    return "Number out of range.";
                }
            }
            Cell c1 = new Cell(Integer.valueOf(points[0].split(",")[0]), Integer.valueOf(points[0].split(",")[1]));
            Cell c2 = new Cell(Integer.valueOf(points[1].split(",")[0]), Integer.valueOf(points[1].split(",")[1]));
            if (!isconnected(c1, c2)) {
                return "Maze format error.";
            }
            gird[c1.x * 2 + 1][c1.y * 2 + 1] = ROAD;
            gird[c2.x * 2 + 1][c2.y * 2 + 1] = ROAD;
            gird[(c1.x * 2 + 1 + c2.x * 2 + 1) / 2][(c1.y * 2 + 1 + c2.y * 2 + 1) / 2] = ROAD;  //中间值

        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < gird[0].length; i++) {
            for (int j = 0; j < gird.length; j++) {
                sb.append(gird[i][j]);
            }
            sb.append("\n");  //换行符
        }
        return sb.toString();

    }

    /**
     * 判断两个相邻的cell是否连通
     *
     * @param p1
     * @param p2
     * @return
     */
    private static Boolean isconnected(Cell p1, Cell p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y) == 1;
    }


    /**
     * 判断字符串是否是数值型的
     *
     * @param str
     * @return
     */
    private static Boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[\\d]*$");
        return pattern.matcher(str).matches();
    }

    /**
     * 将迷宫所有格子都初始化为墙
     *
     * @param gird
     * @return
     */
    private static String[][] initialGird(String[][] gird) {

        for (int i = 0; i < gird.length; i++) {
            for (int j = 0; j < gird[0].length; j++) {
                gird[i][j] = WAll;
            }
        }
        return gird;
    }

    private class Cell {
        Integer x;
        Integer y;

        private Cell(Integer x, Integer y) {
            this.x = x;
            this.y = y;

        }

    }

    public static void main(String[] args) {
        //Scanner scanner  =new Scanner(System.in);
        //String  command = scanner.next();
        String command1 = "3 3\n0,1 0,2;0,0 1,0;0,1 1,1;0,2 1,2;1,0 1,1;1,1 1,2;1,1 2,1;1,2 2,2;2,0 2,1";
        RenderGrid renderGrid = new RenderGrid();
        System.out.println(renderGrid.render(command1));
    }

}
