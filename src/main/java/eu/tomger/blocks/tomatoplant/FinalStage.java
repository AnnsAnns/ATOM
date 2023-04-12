package eu.tomger.blocks.tomatoplant;

import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

public class FinalStage {
	public static VoxelShape makeShape() {
		VoxelShape shape = VoxelShapes.empty();
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.5, 0, 0.5, 0.5625, 0.875, 0.5625));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.5625, 0.375, 0.5, 0.75, 0.4375, 0.5625));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.625, 0.1875, 0.4375, 0.8125, 0.375, 0.625));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.5, 0.5625, 0.3125, 0.5625, 0.625, 0.5));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.4375, 0.375, 0.25, 0.625, 0.5625, 0.4375));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.5625, 0.75, 0.5, 0.75, 0.8125, 0.5625));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.625, 0.5625, 0.4375, 0.8125, 0.75, 0.625));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.3125, 0.25, 0.5, 0.5, 0.3125, 0.5625));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.25, 0.0625, 0.4375, 0.4375, 0.25, 0.625));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.4375, 0.4375, 0.625, 0.625, 0.625, 0.8125));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.5, 0.625, 0.5625, 0.5625, 0.6875, 0.75));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.25, 0.625, 0.4375, 0.4375, 0.8125, 0.625));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.3125, 0.8125, 0.5, 0.5, 0.875, 0.5625));

		return shape;
	}
}