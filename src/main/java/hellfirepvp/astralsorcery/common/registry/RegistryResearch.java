package hellfirepvp.astralsorcery.common.registry;

import hellfirepvp.astralsorcery.AstralSorcery;
import hellfirepvp.astralsorcery.client.gui.journal.page.JournalPageAttenuationRecipe;
import hellfirepvp.astralsorcery.client.gui.journal.page.JournalPageDiscoveryRecipe;
import hellfirepvp.astralsorcery.client.gui.journal.page.JournalPageLightProximityRecipe;
import hellfirepvp.astralsorcery.client.gui.journal.page.JournalPageStructure;
import hellfirepvp.astralsorcery.client.gui.journal.page.JournalPageText;
import hellfirepvp.astralsorcery.common.block.BlockCustomOre;
import hellfirepvp.astralsorcery.common.block.BlockCustomSandOre;
import hellfirepvp.astralsorcery.common.block.BlockMarble;
import hellfirepvp.astralsorcery.common.block.network.BlockAltar;
import hellfirepvp.astralsorcery.common.data.research.ResearchNode;
import hellfirepvp.astralsorcery.common.data.research.ResearchProgression;
import hellfirepvp.astralsorcery.common.item.ItemEntityPlacer;
import hellfirepvp.astralsorcery.common.lib.BlocksAS;
import hellfirepvp.astralsorcery.common.lib.ItemsAS;
import hellfirepvp.astralsorcery.common.lib.MultiBlockArrays;
import hellfirepvp.astralsorcery.common.util.struct.BlockArray;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

/**
 * This class is part of the Astral Sorcery Mod
 * The complete source code for this mod can be found on github.
 * Class: RegistryResearch
 * Created by HellFirePvP
 * Date: 12.08.2016 / 20:47
 */
public class RegistryResearch {

    //Only non-negative numbers please :V
    public static void init() {
        initDiscovery();
        initCrafting();
        initAttenuation();

        /*ResearchProgression.Registry resDiscovery = ResearchProgression.DISCOVERY.getRegistry();

        ResearchNode test1 = new ResearchNode(new ItemStack(BlocksAS.collectorCrystal), "UnlocName", 1, 1);
        ResearchNode test2 = new ResearchNode(new ItemStack(ItemsAS.constellationPaper), "UnlocName2", 3, 3);
        ResearchNode test3 = new ResearchNode(new ItemStack(BlocksAS.blockMarble, 1, BlockMarble.MarbleBlockType.CHISELED.ordinal()), "UnlocName2", 5, 2);
        test1.addPage(new JournalPageText("astralsorcery.journal.text.test"));
        test1.addPage(new JournalPageStructure(MultiBlockArrays.patternRitualPedestal));
        test2.addPage(new JournalPageText("astralsorcery.journal.text.test2"));
        test2.addPage(new JournalPageDiscoveryRecipe(RegistryRecipes.rAltar));
        test2.addPage(new JournalPageLightProximityRecipe(RegistryRecipes.rLPRAltar));

        resDiscovery.register(test1);
        resDiscovery.register(test2);
        resDiscovery.register(test3);

        test2.addConnectionTo(test1);
        test3.addConnectionTo(test2);
        test3.addConnectionTo(test1);

        ResearchProgression.Registry resStarlight = ResearchProgression.STARLIGHT.getRegistry();

        ResearchNode test4 = new ResearchNode(new ItemStack(BlocksAS.ritualPedestal), "UnlocName3", 1, 1);

        resStarlight.register(test4);*/
    }

    private static void initAttenuation() {
        ResearchProgression.Registry regAttenuation = ResearchProgression.ATTENUATION.getRegistry();

        ResearchNode resWell = new ResearchNode(new ItemStack(BlocksAS.blockWell), "WELL", 0, 0);
        resWell.addPage(getTextPage("WELL.1"));
        resWell.addPage(new JournalPageAttenuationRecipe(RegistryRecipes.rLightwell));

        ResearchNode resSimpleAtt = new ResearchNode(new ItemStack(ItemsAS.rockCrystal), "ATT_SIMPLE", 0, 2);
        resSimpleAtt.addPage(getTextPage("ATT_SIMPLE.1"));
        resSimpleAtt.addPage(new JournalPageAttenuationRecipe(RegistryRecipes.rAttuneRockCrystalBasic));

        ResearchNode resRitPedestal = new ResearchNode(new ItemStack(BlocksAS.ritualPedestal), "RIT_PEDESTAL", 1, 4);
        resRitPedestal.addPage(getTextPage("RIT_PEDESTAL.1"));
        resRitPedestal.addPage(new JournalPageAttenuationRecipe(RegistryRecipes.rRitualPedestalRock));
        resRitPedestal.addPage(new JournalPageStructure(MultiBlockArrays.patternRitualPedestal));

        ResearchNode resConstellationUpgrade = new ResearchNode(new ItemStack(BlocksAS.blockAltar, 1, BlockAltar.AltarType.ALTAR_3.ordinal()), "ALTAR3", 3, 0);
        resConstellationUpgrade.addPage(getTextPage("ALTAR3.1"));
        resConstellationUpgrade.addPage(new JournalPageAttenuationRecipe(RegistryRecipes.rAltarUpgradeConstellation));
        resConstellationUpgrade.addPage(new JournalPageStructure(MultiBlockArrays.patternAltarConstellation));

        resRitPedestal.addSourceConnectionFrom(resSimpleAtt);
        resConstellationUpgrade.addSourceConnectionFrom(resSimpleAtt);

        regAttenuation.register(resWell);
        regAttenuation.register(resSimpleAtt);
        regAttenuation.register(resRitPedestal);
        regAttenuation.register(resConstellationUpgrade);
    }

    private static void initCrafting() {
        ResearchProgression.Registry regCrafting = ResearchProgression.BASIC_CRAFT.getRegistry();

        ResearchNode resTelescope = new ResearchNode(new ItemStack(ItemsAS.entityPlacer, 1, ItemEntityPlacer.PlacerType.TELESCOPE.getMeta()), "TELESCOPE", 0, 0);
        resTelescope.addPage(getTextPage("TELESCOPE.1"));
        resTelescope.addPage(new JournalPageDiscoveryRecipe(RegistryRecipes.rCCGlassLens));
        resTelescope.addPage(new JournalPageDiscoveryRecipe(RegistryRecipes.rTelescope));
        resTelescope.addPage(getTextPage("TELESCOPE.4"));

        ResearchNode resGrindstone = new ResearchNode(new ItemStack(ItemsAS.entityPlacer, 1, ItemEntityPlacer.PlacerType.GRINDSTONE.getMeta()), "GRINDSTONE", 0, 2);
        resGrindstone.addPage(getTextPage("GRINDSTONE.1"));
        resGrindstone.addPage(new JournalPageDiscoveryRecipe(RegistryRecipes.rGrindstone));

        ResearchNode resTools = new ResearchNode(
                new ItemStack[] {
                        new ItemStack(ItemsAS.crystalPickaxe), new ItemStack(ItemsAS.crystalSword),
                        new ItemStack(ItemsAS.crystalAxe), new ItemStack(ItemsAS.crystalShovel)
                }, "TOOLS", -1, 3);
        resTools.addPage(getTextPage("TOOLS.1"));
        resTools.addPage(new JournalPageDiscoveryRecipe(RegistryRecipes.rCToolRockSword));
        resTools.addPage(new JournalPageDiscoveryRecipe(RegistryRecipes.rCToolRockPick));
        resTools.addPage(new JournalPageDiscoveryRecipe(RegistryRecipes.rCToolRockAxe));
        resTools.addPage(new JournalPageDiscoveryRecipe(RegistryRecipes.rCToolRockShovel));

        ItemStack[] stacks = new ItemStack[BlockMarble.MarbleBlockType.values().length];
        BlockMarble.MarbleBlockType[] values = BlockMarble.MarbleBlockType.values();
        for (int i = 0; i < values.length; i++) {
            BlockMarble.MarbleBlockType mbt = values[i];
            stacks[i] = new ItemStack(BlocksAS.blockMarble, 1, mbt.ordinal());
        }
        ResearchNode resMarbleTypes = new ResearchNode(stacks, "MARBLETYPES", 2, 1);
        resMarbleTypes.addPage(getTextPage("MARBLETYPES.1"));
        resMarbleTypes.addPage(new JournalPageDiscoveryRecipe(RegistryRecipes.rMarbleBricks));
        resMarbleTypes.addPage(new JournalPageDiscoveryRecipe(RegistryRecipes.rMarblePillar));
        resMarbleTypes.addPage(new JournalPageDiscoveryRecipe(RegistryRecipes.rMarbleChiseled));
        resMarbleTypes.addPage(new JournalPageDiscoveryRecipe(RegistryRecipes.rMarbleArch));
        resMarbleTypes.addPage(new JournalPageDiscoveryRecipe(RegistryRecipes.rMarbleRuned));
        resMarbleTypes.addPage(new JournalPageDiscoveryRecipe(RegistryRecipes.rMarbleEngraved));

        ResearchNode resSootyMarble = new ResearchNode(new ItemStack(BlocksAS.blockBlackMarble), "SOOTYMARBLE", 3, 0);
        resSootyMarble.addPage(getTextPage("SOOTYMARBLE.1"));
        resSootyMarble.addPage(new JournalPageDiscoveryRecipe(RegistryRecipes.rBlackMarbleRaw));

        ResearchNode resAltarUpgradeAttenuation = new ResearchNode(new ItemStack(BlocksAS.blockAltar, 1, BlockAltar.AltarType.ALTAR_2.ordinal()), "ALTAR2", 4, 2);
        resAltarUpgradeAttenuation.addPage(getTextPage("ALTAR2.1"));
        resAltarUpgradeAttenuation.addPage(new JournalPageDiscoveryRecipe(RegistryRecipes.rAltarUpgradeAttenuation));
        resAltarUpgradeAttenuation.addPage(new JournalPageStructure(MultiBlockArrays.patternAltarAttenuation));

        regCrafting.register(resTelescope);
        regCrafting.register(resGrindstone);
        regCrafting.register(resTools);
        regCrafting.register(resMarbleTypes);
        regCrafting.register(resSootyMarble);
        regCrafting.register(resAltarUpgradeAttenuation);

        resGrindstone.addSourceConnectionFrom(resTools);
        resAltarUpgradeAttenuation.addSourceConnectionFrom(resMarbleTypes);
        resSootyMarble.addSourceConnectionFrom(resMarbleTypes);
    }

    private static void initDiscovery() {
        ResearchProgression.Registry regDiscovery = ResearchProgression.DISCOVERY.getRegistry();

        ResearchNode resShrines = new ResearchNode(new ItemStack(BlocksAS.collectorCrystal), "SHRINES", 0, 0);
        resShrines.addPage(getTextPage("SHRINES.1"));
        resShrines.addPage(getTextPage("SHRINES.2"));

        ResearchNode resConPaper = new ResearchNode(new ItemStack(ItemsAS.constellationPaper), "CPAPER", 1, -1);
        resConPaper.addPage(getTextPage("CPAPER.1"));

        ResearchNode resWand = new ResearchNode(new ItemStack(ItemsAS.wand), "WAND", 2, 1);
        resWand.addPage(getTextPage("WAND.1"));
        resWand.addPage(new JournalPageLightProximityRecipe(RegistryRecipes.rLPRWand));
        resWand.addPage(getTextPage("WAND.3"));

        ResearchNode resOres = new ResearchNode(new ItemStack[] {
                new ItemStack(BlocksAS.customOre, 1, BlockCustomOre.OreType.ROCK_CRYSTAL.ordinal()),
                new ItemStack(BlocksAS.customSandOre, 1, BlockCustomSandOre.OreType.AQUAMARINE.ordinal())
        }, "ORES", 1, 2);
        resOres.addPage(getTextPage("ORES.1"));

        ResearchNode resTable = new ResearchNode(new ItemStack(BlocksAS.blockAltar, 1, BlockAltar.AltarType.ALTAR_1.ordinal()), "ALTAR1", 4, 2);
        resTable.addPage(getTextPage("ALTAR1.1"));
        resTable.addPage(new JournalPageLightProximityRecipe(RegistryRecipes.rLPRAltar));
        resTable.addPage(getTextPage("ALTAR1.3"));
        resTable.addPage(getTextPage("ALTAR1.4"));

        regDiscovery.register(resShrines);
        regDiscovery.register(resWand);
        regDiscovery.register(resOres);
        regDiscovery.register(resConPaper);
        regDiscovery.register(resTable);

        resWand.addSourceConnectionFrom(resShrines);
        resConPaper.addSourceConnectionFrom(resShrines);
        resTable.addSourceConnectionFrom(resWand);
        resWand.addSourceConnectionFrom(resOres);
    }

    private static JournalPageText getTextPage(String identifier) {
        return new JournalPageText(AstralSorcery.MODID.toLowerCase() + ".journal." + identifier + ".text");
    }

}
