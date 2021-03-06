package genetics.api.alleles;

import com.google.common.base.MoreObjects;

import java.util.Objects;

import net.minecraft.client.resources.I18n;

import net.minecraftforge.registries.IForgeRegistryEntry;

/**
 * A default implementation of a simple allele.
 */
public abstract class Allele extends IForgeRegistryEntry.Impl<IAllele> implements IAllele {
	protected final boolean dominant;
	protected final String localisationKey;

	protected Allele(String localisationKey, boolean dominant) {
		this.localisationKey = localisationKey;
		this.dominant = dominant;
	}

	@Override
	public boolean isDominant() {
		return dominant;
	}

	@Override
	public int hashCode() {
		return getRegistryName() != null ? getRegistryName().hashCode() : Objects.hash(dominant);
	}

	@Override
	public String getLocalizedName() {
		return I18n.format(localisationKey);
	}

	@Override
	public final String getLocalisationKey() {
		return localisationKey;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof IAllele)) {
			return false;
		}
		IAllele otherAllele = (IAllele) obj;
		return getRegistryName() != null ?
			getRegistryName().equals(((IAllele) obj).getRegistryName()) :
			dominant == otherAllele.isDominant();
	}

	@Override
	public String toString() {
		return MoreObjects
			.toStringHelper(this)
			.add("name", getRegistryName())
			.add("dominant", dominant)
			.add("key", localisationKey)
			.add("loc", getLocalizedName())
			.toString();
	}
}
