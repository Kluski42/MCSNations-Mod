package net.wetnoodle.mcsnations.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.world.entity.ai.behavior.TransportItemsBetweenContainers;
import net.minecraft.world.item.ItemStack;
import net.wetnoodle.mcsnations.MCSNHelpers;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(TransportItemsBetweenContainers.class)
public class TransportItemsBetweenContainersMixin {
    @WrapOperation(method = "hasItemMatchingHandItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;isSameItem(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/item/ItemStack;)Z"))
    private static boolean mcsNations$hasItemMatchingHandItem(ItemStack itemStack1, ItemStack itemStack2, Operation<Boolean> original) {
        return original.call(itemStack1, itemStack2) && MCSNHelpers.equalDatapackItems(itemStack1, itemStack2);
    }
}
