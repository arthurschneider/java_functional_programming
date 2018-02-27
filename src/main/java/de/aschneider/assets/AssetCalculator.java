package de.aschneider.assets;

import java.util.Arrays;
import java.util.List;

import de.aschneider.assets.Asset.AssetType;

public class AssetCalculator {

    public static void main(String[] args) {

        final List<Asset> assets = Arrays.asList(new Asset(AssetType.BOND, 1000),
                new Asset(AssetType.BOND, 2000), new Asset(AssetType.STOCK, 3000),
                new Asset(AssetType.STOCK, 4000));

        int sumBonds = AssetUtil.totalAssetValues(assets,
                asset -> asset.getType() == AssetType.BOND);
        System.out.println(String.format("Total of bonds = %d", sumBonds));

        int sumStocks = AssetUtil.totalAssetValues(assets,
                asset -> asset.getType() == AssetType.STOCK);
        System.out.println(String.format("Total of stocks = %d", sumStocks));

        int sumTotal = AssetUtil.totalAssetValues(assets, asset -> true);
        System.out.println(String.format("Total of all assets = %d", sumTotal));

    }

}
