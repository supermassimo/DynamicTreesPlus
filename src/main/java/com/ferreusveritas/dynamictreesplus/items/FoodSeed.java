package com.ferreusveritas.dynamictreesplus.items;

import com.ferreusveritas.dynamictrees.item.Seed;
import com.ferreusveritas.dynamictrees.tree.species.Species;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

import javax.annotation.Nonnull;

public class FoodSeed extends Seed {

    public static final FoodProperties SAGUARO_FRUIT = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.2F).build();

    public FoodSeed(Species species) {
        super(species, new Item.Properties().food(SAGUARO_FRUIT));
    }

}
