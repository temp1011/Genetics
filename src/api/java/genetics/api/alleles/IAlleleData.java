package genetics.api.alleles;

public interface IAlleleData<V> {

	V getValue();

	boolean isDominant();
}
