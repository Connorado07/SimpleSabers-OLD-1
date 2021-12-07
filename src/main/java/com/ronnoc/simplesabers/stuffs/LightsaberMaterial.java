package com.ronnoc.simplesabers.stuffs;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class LightsaberMaterial implements ToolMaterial {

    public static final LightsaberMaterial INSTANCE = new LightsaberMaterial();


    @Override
    public int getDurability() {
        return 3500;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 0;
    }

    @Override
    public float getAttackDamage() {
        return 25.0F;
    }

    @Override
    public int getMiningLevel() {
        return 3;
    }

    @Override
    public int getEnchantability() {
        return 0;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return null;
    }
}
