package genetics.api.individual;

import javax.annotation.Nullable;

import genetics.api.alleles.IAllele;
import genetics.api.alleles.IAlleleValue;
import genetics.api.root.IIndividualRoot;

/**
 * Interface to be implemented by the enums representing the various chromosomes
 */
public interface IChromosomeType {
	/**
	 * @return The position of a chromosome that has this type at a chromosome array.
	 */
	int getIndex();

	/**
	 * @return The definition that contains this type in a {@link IKaryotype}.
	 * @implNote You can use {@link genetics.api.IGeneticApiInstance#getRoot(String)} to get a instance of your definition.
	 */
	IIndividualRoot getRoot();

	/**
	 * @return Short identifier.
	 */
	String getName();

	@Nullable
	Class<?> getValueClass();

	default boolean isValid(IAllele allele) {
		Class<?> valueClass = getValueClass();
		if (valueClass == null) {
			return true;
		}
		Object value;
		if(IAllele.class.isAssignableFrom(valueClass)){
			value = allele;
		}else {
			if (!(allele instanceof IAlleleValue)) {
				return false;
			}
			IAlleleValue alleleValue = (IAlleleValue) allele;
			value = alleleValue.getValue();
		}
		return valueClass.isInstance(value);
	}
}
