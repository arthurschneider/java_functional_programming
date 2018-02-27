package de.aschneider.assets;

import java.util.List;
import java.util.function.Predicate;

public class AssetUtil {

    public static int totalAssetValues(List<Asset> list, final Predicate<Asset> assetSelector) {
        return list.stream().filter(assetSelector).mapToInt(Asset::getValue).sum();
    }
}
