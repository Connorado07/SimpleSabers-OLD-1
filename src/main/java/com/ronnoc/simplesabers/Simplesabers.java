package com.ronnoc.simplesabers;

import com.ronnoc.simplesabers.stuffs.LightsaberMaterial;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Blocks;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.*;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import com.ronnoc.simplesabers.stuffs.SSBlocks;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.heightprovider.UniformHeightProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Simplesabers implements ModInitializer{

	public static final Logger LOGGER = LogManager.getLogger("simplesabers");
	public static final ItemGroup simple_sabers = FabricItemGroupBuilder.build(
			new Identifier("simplesabers", "simplesabers"),
			() -> new ItemStack(Simplesabers.KYBER_CRYSTAL_RED));



	//Crystals
	public static final Item KYBER_CRYSTAL_RED = new Item(new FabricItemSettings().group(Simplesabers.simple_sabers).rarity(Rarity.EPIC));
	public static final Item KYBER_CRYSTAL_BLUE = new Item(new FabricItemSettings().group(Simplesabers.simple_sabers).rarity(Rarity.EPIC));
	public static final Item KYBER_CRYSTAL_GREEN = new Item(new FabricItemSettings().group(Simplesabers.simple_sabers).rarity(Rarity.EPIC));
	public static final Item KYBER_CRYSTAL_PURPLE = new Item(new FabricItemSettings().group(Simplesabers.simple_sabers).rarity(Rarity.EPIC));
	public static final Item KYBER_CRYSTAL_YELLOW = new Item(new FabricItemSettings().group(Simplesabers.simple_sabers).rarity(Rarity.EPIC));
	public static final Item KYBER_CRYSTAL_WHITE = new Item(new FabricItemSettings().group(Simplesabers.simple_sabers).rarity(Rarity.EPIC));

	public static final Item DURASTEEL_INGOT = new Item(new FabricItemSettings().group(Simplesabers.simple_sabers).rarity(Rarity.RARE));


	//Lightsabers
	public static ToolItem RED_LIGHTSABER = new SwordItem(LightsaberMaterial.INSTANCE, 4, -3F, new Item.Settings().group(Simplesabers.simple_sabers));
	public static ToolItem BLUE_LIGHTSABER = new SwordItem(LightsaberMaterial.INSTANCE, 4, -2.5F, new Item.Settings().group(Simplesabers.simple_sabers));
	public static ToolItem GREEN_LIGHTSABER = new SwordItem(LightsaberMaterial.INSTANCE, 0, -1.5F, new Item.Settings().group(Simplesabers.simple_sabers));
	public static ToolItem PURPLE_LIGHTSABER = new SwordItem(LightsaberMaterial.INSTANCE, 6, -3.5F, new Item.Settings().group(Simplesabers.simple_sabers));
	public static ToolItem YELLOW_LIGHTSABER = new SwordItem(LightsaberMaterial.INSTANCE, 2, -2F, new Item.Settings().group(Simplesabers.simple_sabers));
	public static ToolItem WHITE_LIGHTSABER = new SwordItem(LightsaberMaterial.INSTANCE, 0, -1F, new Item.Settings().group(Simplesabers.simple_sabers));



	//Block Generation
	//Overworld
	private static ConfiguredFeature<?, ?> BLUE_ORE = Feature.ORE
			.configure(new OreFeatureConfig(
					new BlockMatchRuleTest(Blocks.STONE),
					SSBlocks.BLUE_ORE.getDefaultState(),
					3))
			.range(new RangeDecoratorConfig(
					UniformHeightProvider.create(YOffset.fixed(0), YOffset.fixed(45))))
			.spreadHorizontally()
			.repeat(2);
	private static ConfiguredFeature<?, ?> GREEN_ORE = Feature.ORE
			.configure(new OreFeatureConfig(
					new BlockMatchRuleTest(Blocks.STONE),
					SSBlocks.GREEN_ORE.getDefaultState(),
					3))
			.range(new RangeDecoratorConfig(
					UniformHeightProvider.create(YOffset.fixed(0), YOffset.fixed(25))))
			.spreadHorizontally()
			.repeat(2);

	//Nether
	private static ConfiguredFeature<?, ?> RED_ORE = Feature.ORE
			.configure(new OreFeatureConfig(
					new BlockMatchRuleTest(Blocks.STONE),
					SSBlocks.RED_ORE.getDefaultState(),
					3))
			.range(new RangeDecoratorConfig(
					UniformHeightProvider.create(YOffset.fixed(0), YOffset.fixed(25))))
			.spreadHorizontally()
			.repeat(2);


	@Override
	public void onInitialize() {
		Registry.register(Registry.ITEM, new Identifier("simplesabers", "kyber_crystal_red"), KYBER_CRYSTAL_RED);
		Registry.register(Registry.ITEM, new Identifier("simplesabers", "kyber_crystal_blue"), KYBER_CRYSTAL_BLUE);
		Registry.register(Registry.ITEM, new Identifier("simplesabers", "kyber_crystal_green"), KYBER_CRYSTAL_GREEN);
		Registry.register(Registry.ITEM, new Identifier("simplesabers", "kyber_crystal_purple"), KYBER_CRYSTAL_PURPLE);
		Registry.register(Registry.ITEM, new Identifier("simplesabers", "kyber_crystal_yellow"), KYBER_CRYSTAL_YELLOW);
		Registry.register(Registry.ITEM, new Identifier("simplesabers", "kyber_crystal_white"), KYBER_CRYSTAL_WHITE);

		Registry.register(Registry.ITEM, new Identifier("simplesabers", "durasteel_ingot"), DURASTEEL_INGOT);

		Registry.register(Registry.ITEM, new Identifier("simplesabers", "red_lightsaber"), RED_LIGHTSABER);
		Registry.register(Registry.ITEM, new Identifier("simplesabers", "blue_lightsaber"), BLUE_LIGHTSABER);
		Registry.register(Registry.ITEM, new Identifier("simplesabers", "green_lightsaber"), GREEN_LIGHTSABER);
		Registry.register(Registry.ITEM, new Identifier("simplesabers", "purple_lightsaber"), PURPLE_LIGHTSABER);
		Registry.register(Registry.ITEM, new Identifier("simplesabers", "yellow_lightsaber"), YELLOW_LIGHTSABER);
		Registry.register(Registry.ITEM, new Identifier("simplesabers", "white_lightsaber"), WHITE_LIGHTSABER);





		BlockRenderLayerMap.INSTANCE.putBlock(SSBlocks.RED_ORE, RenderLayer.getCutout());
		Registry.register(Registry.BLOCK, new Identifier("simplesabers", "red_ore"), SSBlocks.RED_ORE);
		Registry.register(Registry.ITEM, new Identifier("simplesabers", "red_ore"),
				new BlockItem(SSBlocks.RED_ORE, new FabricItemSettings().group(simple_sabers)));

		BlockRenderLayerMap.INSTANCE.putBlock(SSBlocks.BLUE_ORE, RenderLayer.getCutout());
		Registry.register(Registry.BLOCK, new Identifier("simplesabers", "blue_ore"), SSBlocks.BLUE_ORE);
		Registry.register(Registry.ITEM, new Identifier("simplesabers", "blue_ore"),
				new BlockItem(SSBlocks.BLUE_ORE, new FabricItemSettings().group(simple_sabers)));

		BlockRenderLayerMap.INSTANCE.putBlock(SSBlocks.GREEN_ORE, RenderLayer.getCutout());
		Registry.register(Registry.BLOCK, new Identifier("simplesabers", "green_ore"), SSBlocks.GREEN_ORE);
		Registry.register(Registry.ITEM, new Identifier("simplesabers", "green_ore"),
				new BlockItem(SSBlocks.GREEN_ORE, new FabricItemSettings().group(simple_sabers)));

		BlockRenderLayerMap.INSTANCE.putBlock(SSBlocks.PURPLE_ORE, RenderLayer.getCutout());
		Registry.register(Registry.BLOCK, new Identifier("simplesabers", "purple_ore"), SSBlocks.PURPLE_ORE);
		Registry.register(Registry.ITEM, new Identifier("simplesabers", "purple_ore"),
				new BlockItem(SSBlocks.PURPLE_ORE, new FabricItemSettings().group(simple_sabers)));

		BlockRenderLayerMap.INSTANCE.putBlock(SSBlocks.YELLOW_ORE, RenderLayer.getCutout());
		Registry.register(Registry.BLOCK, new Identifier("simplesabers", "yellow_ore"), SSBlocks.YELLOW_ORE);
		Registry.register(Registry.ITEM, new Identifier("simplesabers", "yellow_ore"),
				new BlockItem(SSBlocks.YELLOW_ORE, new FabricItemSettings().group(simple_sabers)));

		BlockRenderLayerMap.INSTANCE.putBlock(SSBlocks.WHITE_ORE, RenderLayer.getCutout());
		Registry.register(Registry.BLOCK, new Identifier("simplesabers", "white_ore"), SSBlocks.WHITE_ORE);
		Registry.register(Registry.ITEM, new Identifier("simplesabers", "white_ore"),
				new BlockItem(SSBlocks.WHITE_ORE, new FabricItemSettings().group(simple_sabers)));



		RegistryKey<ConfiguredFeature<?, ?>> blue_ore = RegistryKey.of(net.minecraft.util.registry.Registry.CONFIGURED_FEATURE_KEY,
				new Identifier("simplesabers", "blue_ore"));
		net.minecraft.util.registry.Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, blue_ore.getValue(), BLUE_ORE);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, blue_ore);
		RegistryKey<ConfiguredFeature<?, ?>> green_ore = RegistryKey.of(net.minecraft.util.registry.Registry.CONFIGURED_FEATURE_KEY,
				new Identifier("simplesabers", "green_ore"));
		net.minecraft.util.registry.Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, green_ore.getValue(), GREEN_ORE);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, green_ore);

		RegistryKey<ConfiguredFeature<?, ?>> red_ore = RegistryKey.of(net.minecraft.util.registry.Registry.CONFIGURED_FEATURE_KEY,
				new Identifier("simplesabers", "red_ore"));
		net.minecraft.util.registry.Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, red_ore.getValue(), RED_ORE);
		BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Feature.UNDERGROUND_ORES, red_ore);

		LOGGER.info("Mod Initialization Confirmed, Captain.");
	}
}