package com.example.myfragment;

import java.math.BigDecimal;

import androidx.lifecycle.LiveData;

public class StockLiveData extends LiveData<BigDecimal> {
    // private static StockLiveData sInstance;
    // private StockManager mStockManager;
    //
    // private SimplePriceListener mListener = new SimplePriceListener() {
    //     @Override
    //     public void onPriceChanged(BigDecimal price) {
    //         setValue(price);
    //     }
    // };
    //
    // @MainThread
    // public static StockLiveData get(String symbol) {
    //     if (sInstance == null) {
    //         sInstance = new StockLiveData(symbol);
    //     }
    //     return sInstance;
    // }
    //
    // private StockLiveData(String symbol) {
    //     mStockManager = new StockManager(symbol);
    // }
    //
    // @Override
    // protected void onActive() {
    //     mStockManager.requestPriceUpdates(mListener);
    // }
    //
    // @Override
    // protected void onInactive() {
    //     mStockManager.removeUpdates(mListener);
    // }
}
