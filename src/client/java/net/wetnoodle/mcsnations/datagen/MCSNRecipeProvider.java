package net.wetnoodle.mcsnations.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class MCSNRecipeProvider extends FabricRecipeProvider {
    public MCSNRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
        return new RecipeProvider(provider, recipeOutput) {
            @Override
            public void buildRecipes() {
                Map<Item, Item> trims = defineTrims();
                trims.forEach((trim, material) -> armorTrimCopying(trim, material, recipeOutput));
                armorTrimCopying(Items.BOLT_ARMOR_TRIM_SMITHING_TEMPLATE, recipeOutput, Items.COPPER_BLOCK, Items.WAXED_COPPER_BLOCK);
            }

            private Map<Item, Item> defineTrims() {
                Map<Item, Item> trims = new HashMap<>();
                trims.put(Items.SENTRY_ARMOR_TRIM_SMITHING_TEMPLATE, Items.COBBLESTONE);
                trims.put(Items.COAST_ARMOR_TRIM_SMITHING_TEMPLATE, Items.COBBLESTONE);
                trims.put(Items.SHAPER_ARMOR_TRIM_SMITHING_TEMPLATE, Items.TERRACOTTA);
                trims.put(Items.TIDE_ARMOR_TRIM_SMITHING_TEMPLATE, Items.PRISMARINE);
                trims.put(Items.SPIRE_ARMOR_TRIM_SMITHING_TEMPLATE, Items.PURPUR_BLOCK);
                trims.put(Items.VEX_ARMOR_TRIM_SMITHING_TEMPLATE, Items.COBBLESTONE);
                trims.put(Items.DUNE_ARMOR_TRIM_SMITHING_TEMPLATE, Items.SANDSTONE);
                trims.put(Items.HOST_ARMOR_TRIM_SMITHING_TEMPLATE, Items.TERRACOTTA);
                trims.put(Items.SNOUT_ARMOR_TRIM_SMITHING_TEMPLATE, Items.BLACKSTONE);
                trims.put(Items.FLOW_ARMOR_TRIM_SMITHING_TEMPLATE, Items.BREEZE_ROD);
                trims.put(Items.WILD_ARMOR_TRIM_SMITHING_TEMPLATE, Items.MOSSY_COBBLESTONE);
                trims.put(Items.WAYFINDER_ARMOR_TRIM_SMITHING_TEMPLATE, Items.TERRACOTTA);
                trims.put(Items.WARD_ARMOR_TRIM_SMITHING_TEMPLATE, Items.COBBLED_DEEPSLATE);
                trims.put(Items.RIB_ARMOR_TRIM_SMITHING_TEMPLATE, Items.NETHERRACK);
//                trims.put(Items.BOLT_ARMOR_TRIM_SMITHING_TEMPLATE, ); Removed because Bolt is a special case
                trims.put(Items.RAISER_ARMOR_TRIM_SMITHING_TEMPLATE, Items.TERRACOTTA);
                trims.put(Items.SILENCE_ARMOR_TRIM_SMITHING_TEMPLATE, Items.COBBLED_DEEPSLATE);
                trims.put(Items.EYE_ARMOR_TRIM_SMITHING_TEMPLATE, Items.END_STONE);
                return trims;
            }

            private void armorTrimCopying(Item armorTrim, Item baseMaterial, RecipeOutput recipeOutput) {
                this.shaped(RecipeCategory.MISC, armorTrim, 2)
                        .define('#', Items.AMETHYST_SHARD)
                        .define('T', armorTrim)
                        .define('B', baseMaterial)
                        .pattern("#T#")
                        .pattern("#B#")
                        .pattern("###")
                        .unlockedBy(RecipeProvider.getHasName(armorTrim), this.has(armorTrim))
                        .save(recipeOutput);
            }

            private void armorTrimCopying(Item armorTrim, RecipeOutput recipeOutput, Item... materials) {
                this.shaped(RecipeCategory.MISC, armorTrim, 2)
                        .define('#', Items.AMETHYST_SHARD)
                        .define('T', armorTrim)
                        .define('B', Ingredient.of(materials))
                        .pattern("#T#")
                        .pattern("#B#")
                        .pattern("###")
                        .unlockedBy(RecipeProvider.getHasName(armorTrim), this.has(armorTrim))
                        .save(recipeOutput);
            }
        };
    }

    @Override
    public String getName() {
        return "MCS Nations Recipes";
    }
}
