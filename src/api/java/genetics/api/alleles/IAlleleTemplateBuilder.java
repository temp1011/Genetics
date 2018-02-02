package genetics.api.alleles;

import genetics.api.IGeneticFactory;
import genetics.api.gene.IGeneType;
import genetics.api.gene.IKaryotype;

/**
 * Can be used to create allele templates.
 * <p>
 * You can get an instance of this from the species root with
 * {@link IGeneticFactory#createTemplateBuilder(IKaryotype)} or {@link IGeneticFactory#createTemplateBuilder(IKaryotype, IAllele[])}.
 */
public interface IAlleleTemplateBuilder {

	/**
	 * Sets a allele at a position of the chromosome.
	 *
	 * @param allele  The allele that should be set at the position.
	 * @param geneKey The position at the chromosome array.
	 */
	IAlleleTemplateBuilder set(IGeneType geneKey, IAllele<?> allele);

	/**
	 * Sets a allele at a position of the chromosome.
	 *
	 * @param alleleKey The key of the allele that should be set at the position.
	 * @param geneKey   The position at the chromosome array.
	 */
	IAlleleTemplateBuilder set(IGeneType geneKey, IAlleleKey alleleKey);

	/**
	 * @return The karyotype that defines the {@link #size()} and which alleles this template can contain.
	 */
	IKaryotype getKaryotype();

	/**
	 * @return The count of genes.
	 */
	int size();

	/**
	 * @return Builds a allele template out of the data of this builder.
	 */
	IAlleleTemplate build();
}
