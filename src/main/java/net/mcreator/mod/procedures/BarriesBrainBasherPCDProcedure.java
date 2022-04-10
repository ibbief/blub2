package net.mcreator.mod.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

public class BarriesBrainBasherPCDProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ServerLevel _level) {
			FallingBlockEntity blockToSpawn = new FallingBlockEntity(_level, x, (y + 2), z, Blocks.SAND.defaultBlockState());
			blockToSpawn.time = 1;
			_level.addFreshEntity(blockToSpawn);
		}
		new Object() {
			private int ticks = 0;
			private float waitTicks;
			private LevelAccessor world;

			public void start(LevelAccessor world, int waitTicks) {
				this.waitTicks = waitTicks;
				MinecraftForge.EVENT_BUS.register(this);
				this.world = world;
			}

			@SubscribeEvent
			public void tick(TickEvent.ServerTickEvent event) {
				if (event.phase == TickEvent.Phase.END) {
					this.ticks += 1;
					if (this.ticks >= this.waitTicks)
						run();
				}
			}

			private void run() {
				if (Blocks.SAND.defaultBlockState().getMaterial() == net.minecraft.world.level.material.Material.SAND) {
					world.setBlock(new BlockPos((int) x, (int) (y + 2), (int) z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos((int) x, (int) (y + 1), (int) z), Blocks.AIR.defaultBlockState(), 3);
				}
				MinecraftForge.EVENT_BUS.unregister(this);
			}
		}.start(world, 60);
	}
}
