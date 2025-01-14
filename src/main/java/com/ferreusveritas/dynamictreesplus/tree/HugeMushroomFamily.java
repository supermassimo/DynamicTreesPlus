package com.ferreusveritas.dynamictreesplus.tree;

import com.ferreusveritas.dynamictrees.api.registry.TypedRegistry;
import com.ferreusveritas.dynamictrees.block.branch.BasicBranchBlock;
import com.ferreusveritas.dynamictrees.block.branch.BranchBlock;
import com.ferreusveritas.dynamictrees.block.branch.ThickBranchBlock;
import com.ferreusveritas.dynamictrees.data.DTBlockTags;
import com.ferreusveritas.dynamictrees.data.DTItemTags;
import com.ferreusveritas.dynamictrees.tree.family.Family;
import com.ferreusveritas.dynamictrees.tree.species.Species;
import com.ferreusveritas.dynamictrees.util.BlockBounds;
import com.ferreusveritas.dynamictreesplus.block.mushroom.CapProperties;
import com.ferreusveritas.dynamictreesplus.block.mushroom.MushroomBranchBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;

public class HugeMushroomFamily extends Family {

    public static final TypedRegistry.EntryType<Family> TYPE = TypedRegistry.newType(HugeMushroomFamily::new);

    protected CapProperties commonCap = CapProperties.NULL;

    public HugeMushroomFamily(ResourceLocation name) {
        super(name);
    }

    @Override
    public Family setPreReloadDefaults() {
        this.setPrimaryThickness(2);
        this.setSecondaryThickness(3);
        return this;
    }

    public CapProperties getCommonCap() {
        return this.commonCap;
    }

    public void setCommonCap(CapProperties properties) {
        this.commonCap = properties;
        properties.setFamily(this);
    }

    @Override
    public List<TagKey<Block>> defaultBranchTags() {
        return Collections.singletonList(DTBlockTags.FUNGUS_BRANCHES);
    }

    @Override
    public List<TagKey<Item>> defaultBranchItemTags() {
        return Collections.singletonList(DTItemTags.FUNGUS_BRANCHES);
    }

    @Override
    public List<TagKey<Block>> defaultStrippedBranchTags() {
        return Collections.singletonList(DTBlockTags.STRIPPED_FUNGUS_BRANCHES);
    }

    @Override
    public BlockBounds expandLeavesBlockBounds(BlockBounds bounds) {
        return bounds.expand(8);
    }

    ///////////////////////////////////////////
    // CAP GROWTH
    ///////////////////////////////////////////

    public boolean isCompatibleCap (HugeMushroomSpecies species, BlockState state, Level level, BlockPos pos){
        return species.getCapProperties().isPartOfCap(state);
    }

    @Override
    protected BranchBlock createBranchBlock(ResourceLocation name) {
        final BasicBranchBlock branch = new MushroomBranchBlock(name, this.getProperties());
        if (this.isFireProof()) {
            branch.setFireSpreadSpeed(0).setFlammability(0);
        }
        return branch;
    }
}
