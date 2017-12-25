package nedelosk.crispr.api;

import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import nedelosk.crispr.api.gene.IGeneticStat;
import nedelosk.crispr.api.gene.IGenome;
import nedelosk.crispr.api.individual.IGeneticHandler;
import nedelosk.crispr.api.individual.IGeneticType;
import nedelosk.crispr.api.individual.IIndividual;
import nedelosk.crispr.api.translators.IBlockTranslator;
import nedelosk.crispr.api.translators.IGeneticTranslator;
import nedelosk.crispr.api.translators.IItemTranslator;
import nedelosk.crispr.apiimp.IGeneticTypes;

public interface IGeneticDefinitionBuilder<I extends IIndividual> {

	IGeneticDefinitionBuilder<I> registerType(IGeneticType type, IGeneticHandler<I> handler);

	/**
	 * @param translatorKey The key of the translator the block of {@link IBlockState} that you want to translate
	 *                      with the translator.
	 * @param translator    A translator that should be used to translate the data.
	 */
	IGeneticDefinitionBuilder<I> registerTranslator(Block translatorKey, IBlockTranslator<I> translator);

	/**
	 * @param translatorKey The key of the translator it is the item of the {@link ItemStack} that you want to translate
	 *                      with the translator.
	 * @param translator    A translator that should be used to translate the data.
	 */
	IGeneticDefinitionBuilder<I> registerTranslator(Item translatorKey, IItemTranslator<I> translator);

	IGeneticDefinitionBuilder<I> setTransformer(Supplier<IGeneticTransformer<I>> transformerFactory);

	IGeneticDefinitionBuilder<I> setTranslator(BiFunction<Map<Item, IItemTranslator<I>>, Map<Block, IBlockTranslator<I>>, IGeneticTranslator<I>> translatorFactory);

	IGeneticDefinitionBuilder<I> setTypes(Function<Map<IGeneticType, IGeneticHandler<I>>, IGeneticTypes<I>> typesFactory);

	IGeneticDefinitionBuilder<I> setStat(Function<IGenome, IGeneticStat> statFactory);

	IGeneticDefinition<I> build();
}
