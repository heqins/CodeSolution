package array;

public class 寻找目标值二维数组 {

    /**
     * m*n 的二维数组 plants 记录了园林景观的植物排布情况，具有以下特性：
     *
     * 每行中，每棵植物的右侧相邻植物不矮于该植物；
     * 每列中，每棵植物的下侧相邻植物不矮于该植物。
     *
     *
     * 请判断 plants 中是否存在目标高度值 target。
     */
    public boolean findTargetIn2DPlants(int[][] plants, int target) {
        if (plants.length == 0) {
            return false;
        }

        int i = 0;
        int j = plants[0].length - 1;

        while (i < plants.length && j >= 0) {
            if (plants[i][j] == target) {
                return true;
            }

            if (plants[i][j] > target) {
                j--;
            }else {
                i++;
            }
        }

        return false;
    }
}
