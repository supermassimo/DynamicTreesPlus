package com.ferreusveritas.dynamictreesplus.tree;

import com.ferreusveritas.dynamictrees.api.registry.TypedRegistry;
import com.ferreusveritas.dynamictrees.block.branch.BranchBlock;
import com.ferreusveritas.dynamictrees.data.provider.BranchLoaderBuilder;
import com.ferreusveritas.dynamictrees.tree.family.Family;
import com.ferreusveritas.dynamictreesplus.block.CactusBranchBlock;
import com.ferreusveritas.dynamictreesplus.event.BakedModelEventHandler;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;

import static com.ferreusveritas.dynamictrees.util.ResourceLocationUtils.suffix;

public class CactusFamily extends Family {

    public static final TypedRegistry.EntryType<Family> TYPE = TypedRegistry.newType(CactusFamily::new);

    public CactusFamily(final ResourceLocation registryName) {
        super(registryName);
    }

    @Override
    public Material getDefaultBranchMaterial() {
        return Material.CACTUS;
    }

    @Override
    public SoundType getDefaultBranchSoundType() {
        return SoundType.WOOL;
    }

    @Override
    protected BranchBlock createBranchBlock(ResourceLocation name) {
        return new CactusBranchBlock(name, this.getProperties());
    }

    @Override
    public int getPrimaryThickness() {
        return 5;
    }

    @Override
    public int getSecondaryThickness() {
        return 4;
    }

    @Override
    public BiFunction<BlockModelBuilder, ExistingFileHelper, BranchLoaderBuilder> getBranchLoaderConstructor() {
        return (parent, existingFileHelper) -> new BranchLoaderBuilder(BakedModelEventHandler.CACTUS, parent, existingFileHelper);
    }

    public static final String BRANCH_BOTTOM = "branch_bottom";

}
