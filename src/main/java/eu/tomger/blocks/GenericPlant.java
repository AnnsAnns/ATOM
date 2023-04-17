package eu.tomger.blocks;

import eu.tomger.Atom;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemConvertible;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class GenericPlant extends CropBlock {
    private VoxelShape[] _shapes;
    private ItemConvertible _seed;

    public GenericPlant(Settings settings, ItemConvertible seed, VoxelShape[] shapes) {
        super(settings);

        _shapes = shapes;
        _seed = seed;
    }

    public ItemConvertible getSeedsItem() {
        return _seed;
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        int currentState = state.get(this.getAgeProperty());
        float stateToReceive = (_shapes.length-2)/8f;

        return _shapes[currentState >= 7 ? _shapes.length-1 : (int)stateToReceive];
    }
}
