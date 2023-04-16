package eu.tomger.items;

import eu.tomger.ExampleMod;
import eu.tomger.blocks.cornplant.Corn;
import eu.tomger.blocks.cornplant.CornFirst;
import eu.tomger.blocks.cornplant.CornSecond;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class CornPlant extends CropBlock {
    private static final VoxelShape[] AGE_TO_SHAPE = new VoxelShape[]{
            CornFirst.makeShape(),
            CornSecond.makeShape(),
            CornSecond.makeShape(),
            Corn.makeShape(),
    };

    public CornPlant(Settings settings) {
        super(settings);
    }

    public ItemConvertible getSeedsItem() {
        return ExampleMod.CORN_SEED;
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return AGE_TO_SHAPE[state.get(this.getAgeProperty())/2];
    }
}
