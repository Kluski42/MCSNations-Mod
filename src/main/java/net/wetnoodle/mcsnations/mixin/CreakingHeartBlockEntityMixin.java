package net.wetnoodle.mcsnations.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.CreakingHeartBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(CreakingHeartBlockEntity.class)
public class CreakingHeartBlockEntityMixin {
    @ModifyExpressionValue(method = "serverTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/CreakingHeartBlock;isNaturalNight(Lnet/minecraft/world/level/Level;)Z"))
    private static boolean mcsNations$serverTick$isNaturalNight(boolean original, Level level) {
        return original || mcsNations$isNaturalNight(level);
    }

    @ModifyExpressionValue(method = "updateCreakingState", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/CreakingHeartBlock;isNaturalNight(Lnet/minecraft/world/level/Level;)Z"))
    private static boolean mcsNations$updateCreakingState$isNaturalNight(boolean original, Level level) {
        return original || mcsNations$isNaturalNight(level);
    }

    @Unique
    private static boolean mcsNations$isNaturalNight(Level level) {
        return level.dimension().equals(Level.END) || level.dimension().equals(Level.NETHER);
    }
}
