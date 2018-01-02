package genetics.api.definition;

import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import genetics.api.alleles.IAllele;
import genetics.api.alleles.IAlleleTemplate;
import genetics.api.alleles.IAlleleTemplateBuilder;
import genetics.api.gene.IKaryotype;
import genetics.api.individual.IGeneticHandler;
import genetics.api.individual.IGeneticType;
import genetics.api.individual.IIndividual;
import genetics.api.translators.IBlockTranslator;
import genetics.api.translators.IGeneticTranslator;
import genetics.api.translators.IItemTranslator;

public interface IGeneticDefinitionBuilder<I extends IIndividual, R extends IGeneticRoot<I, ?>> {

	IGeneticDefinitionBuilder<I, R> registerType(IGeneticType type, IGeneticHandler<I> handler);

	/**
	 * @param translatorKey The key of the translator the block of {@link IBlockState} that you want to translate
	 *                      with the translator.
	 * @param translator    A translator that should be used to translate the data.
	 */
	IGeneticDefinitionBuilder<I, R> registerTranslator(Block translatorKey, IBlockTranslator<I> translator);

	/**
	 * @param translatorKey The key of the translator it is the item of the {@link ItemStack} that you want to translate
	 *                      with the translator.
	 * @param translator    A translator that should be used to translate the data.
	 */
	IGeneticDefinitionBuilder<I, R> registerTranslator(Item translatorKey, IItemTranslator<I> translator);

	/**
	 * Registers a allele template using the UID of the first allele as identifier.
	 */
	IGeneticDefinitionBuilder<I, R> registerTemplate(IAllele[] template);

	/**
	 * Registers a allele template using the passed identifier.
	 */
	//TODO: REMOVE ?
	IGeneticDefinitionBuilder<I, R> registerTemplate(String identifier, IAllele[] template);

	/**
	 * Registers a allele template using the UID of the first allele as identifier.
	 */
	IGeneticDefinitionBuilder<I, R> registerTemplate(IAlleleTemplate template);

	/**
	 * Registers a allele template using the passed identifier.
	 */
	//TODO: REMOVE ?
	IGeneticDefinitionBuilder<I, R> registerTemplate(String identifier, IAlleleTemplate template);

	IGeneticDefinitionBuilder<I, R> setTranslator(BiFunction<Map<Item, IItemTranslator<I>>, Map<Block, IBlockTranslator<I>>, IGeneticTranslator<I>> translatorFactory);

	IGeneticDefinitionBuilder<I, R> setTypes(Function<Map<IGeneticType, IGeneticHandler<I>>, IGeneticTypes<I>> typesFactory);

	IGeneticDefinitionBuilder<I, R> setTemplateFactory(BiFunction<IKaryotype, IAllele[], IAlleleTemplateBuilder> templateFactory);

	IGeneticDefinitionBuilder<I, R> setTemplateNameFactory(BiFunction<IKaryotype, IAllele[], String> templateNameFactory);
}
