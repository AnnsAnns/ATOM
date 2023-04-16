package eu.tomger.blocks.cornplant;

import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

public class CornFirst {
	public static VoxelShape makeShape() {
		VoxelShape shape = VoxelShapes.empty();
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.5, 0, 0.5, 0.5625, 0.25, 0.5625));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.5, 0.3125, 0.5, 0.5625, 0.375, 0.5625));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.5, 0.25, 0.4375, 0.5625, 0.3125, 0.625));
		shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.4375, 0.25, 0.5, 0.625, 0.3125, 0.5625));

		return shape;
	}
}