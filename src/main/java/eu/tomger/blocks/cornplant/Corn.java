package eu.tomger.blocks.cornplant;

import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

public class Corn {
	public static VoxelShape makeShape() {
		VoxelShape shape = VoxelShapes.empty();
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.5, 0, 0.5, 0.5625, 1.125, 0.5625));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.625, 1.1875, 0.4375, 0.6875, 1.4375, 0.625));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.4375, 1.125, 0.4375, 0.625, 1.1875, 0.625));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.625, 1.4375, 0.5, 0.6875, 1.5, 0.5625));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.5, 1.4375, 0.375, 0.5625, 1.5, 0.4375));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.4375, 1.1875, 0.375, 0.625, 1.4375, 0.4375));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.375, 1.4375, 0.5, 0.4375, 1.5, 0.5625));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.375, 1.1875, 0.4375, 0.4375, 1.4375, 0.625));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.5, 1.4375, 0.625, 0.5625, 1.5, 0.6875));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.4375, 1.1875, 0.625, 0.625, 1.4375, 0.6875));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.5, 1.75, 0.5, 0.5625, 1.8125, 0.5625));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.4375, 1.1875, 0.4375, 0.625, 1.75, 0.625));

		return shape;
	}
}