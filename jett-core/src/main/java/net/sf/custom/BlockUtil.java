package net.sf.custom;

import net.sf.jett.model.Block;
import net.sf.jett.util.SheetUtil;
import org.apache.poi.ss.usermodel.Sheet;

/**
 * block块空间工具类
 *
 * @author 李坤
 * @date 2022/3/29 16:22
 */
public final class BlockUtil {
    /**
     * 私有的构造函数（该类不支持实例化）
     */
    private BlockUtil() {
        throw new AssertionError("不支持实例化的类");
    }

    /**
     * 根据 sheet、parentBlock、direction 对象生成 block 对象
     *
     * @param sheet       sheet空间
     * @param parentBlock 上级快空间
     * @param direction   快空间方向
     *
     * @return block快空间
     */
    public static Block generateBlockBySheet(Sheet sheet, Block parentBlock, Block.Direction direction) {
        // 获取 sheet 空间最底部行索引
        int lastRowNumIndex = sheet.getLastRowNum();
        // 获取 sheet 空间最右侧列索引
        int rightColNumIndex = SheetUtil.getLastPopulatedColIndex(sheet);

        // 生成 快空间-block 对象，并返回
        return Block.builder().myParent(parentBlock).myLeftColNum(0).myRightColNum(rightColNumIndex).myTopRowNum(0)
                .myBottomRowNum(lastRowNumIndex).myDirection(direction).build();
    }
}
