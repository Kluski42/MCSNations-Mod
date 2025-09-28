package net.wetnoodle.mcsnations.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.world.entity.animal.HappyGhast;
import net.minecraft.world.item.ItemStack;
import net.wetnoodle.mcsnations.register.MCSNItemTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(HappyGhast.class)
public class HappyGhastMixin {

    @ModifyExpressionValue(method = "method_70699", at = @At(value = "INVOKE", target = "Ljava/util/function/Predicate;test(Ljava/lang/Object;)Z"))
    private static boolean mcsNations$foodOrSnow(boolean original, ItemStack itemStack) {
        return original || itemStack.is(MCSNItemTags.HAPPY_GHAST_TRUE_TEMPT_ITEMS);
    }
}
