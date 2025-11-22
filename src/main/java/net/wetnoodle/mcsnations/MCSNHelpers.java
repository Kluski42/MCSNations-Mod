package net.wetnoodle.mcsnations;

import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.Tag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.component.CustomModelData;
import org.spongepowered.asm.mixin.Unique;

import java.util.Objects;

public class MCSNHelpers {
    /**
     * Determines if the two items have equal data-pack components. For example, TCC's apple pie is seen as distinct from poisonous potatoes.
     *
     * @param itemStack1 stack to compare.
     * @param itemStack2 stack to compare.
     * @return if the two stacks have equal TCC and PPP components.
     */
    public static boolean equalDatapackItems(ItemStack itemStack1, ItemStack itemStack2) {
        return (
                (itemStack1.getItem()).equals(itemStack2.getItem()) &&
                        equalTCCItems(itemStack1, itemStack2) &&
                        equalPufferItems(itemStack1, itemStack2)
        );
    }

    // The Creeper's Code
    @Unique
    public static boolean equalTCCItems(ItemStack itemStack1, ItemStack itemStack2) {
        Tag tccTag;
        Tag tccTag2;

        CustomData customData = itemStack1.get(DataComponents.CUSTOM_DATA);
        CustomData customData2 = itemStack2.get(DataComponents.CUSTOM_DATA);

        if (customData != null) {
            tccTag = customData.copyTag().get("tcc");
        } else {
            tccTag = null;
        }
        if (customData2 != null) {
            tccTag2 = customData2.copyTag().get("tcc");
        } else {
            tccTag2 = null;
        }

        return Objects.equals(tccTag, tccTag2);
    }

    // MCS Puffer Praise Pack
    @Unique
    public static boolean equalPufferItems(ItemStack itemStack1, ItemStack itemStack2) {
        // The datapack only uses pufferfish. If it's not a pufferfish, then it can't differ in the data.
        if (!itemStack1.is(Items.PUFFERFISH) || !itemStack2.is(Items.PUFFERFISH)) return true;

        CustomModelData customModelData = itemStack1.get(DataComponents.CUSTOM_MODEL_DATA);
        CustomModelData customModelData2 = itemStack2.get(DataComponents.CUSTOM_MODEL_DATA);
        return Objects.equals(customModelData, customModelData2);
    }
}
