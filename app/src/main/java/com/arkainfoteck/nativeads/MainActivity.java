package com.arkainfoteck.nativeads;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.NativeExpressAdView;
import com.google.android.gms.ads.formats.UnifiedNativeAd;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final int NUMBER_OF_ADS = 5;

    // The AdLoader used to load ads.
    private AdLoader adLoader;

    // List of MenuItems and native ads that populate the RecyclerView.
    private List<Object> mRecyclerViewItems = new ArrayList<>();

    // List of native ads that have been successfully loaded.
    private List<UnifiedNativeAd> mNativeAds = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(this, getString(R.string.admob_app_id));

        if (savedInstanceState == null) {
            // Create new fragment to display a progress spinner while the data set for the
            // RecyclerView is populated.
            Fragment loadingScreenFragment = new LoadingScreenFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.fragment_container, loadingScreenFragment);

            // Commit the transaction.
            transaction.commit();

            // Update the RecyclerView item's list with menu items.
            addMenuItemsFromJson();
            // Update the RecyclerView item's list with native ads.
            loadNativeAds();
        }

    }

    public List<Object> getRecyclerViewItems() {
        return mRecyclerViewItems;
    }
    private void insertAdsInMenuItems() {
        if (mNativeAds.size() <= 0) {
            return;
        }

        int offset = (mRecyclerViewItems.size() / mNativeAds.size()) + 1;
        int index = 0;
        for (UnifiedNativeAd ad : mNativeAds) {
            mRecyclerViewItems.add(index, ad);
            index = index + offset;
        }
        loadMenu();
    }

    private void loadNativeAds() {

        AdLoader.Builder builder = new AdLoader.Builder(this, getString(R.string.ad_unit_id));
        adLoader = builder.forUnifiedNativeAd(
                new UnifiedNativeAd.OnUnifiedNativeAdLoadedListener() {
                    @Override
                    public void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
                        // A native ad loaded successfully, check if the ad loader has finished loading
                        // and if so, insert the ads into the list.
                        mNativeAds.add(unifiedNativeAd);
                        if (!adLoader.isLoading()) {
                            insertAdsInMenuItems();
                        }
                    }
                }).withAdListener(
                new AdListener() {
                    @Override
                    public void onAdFailedToLoad(int errorCode) {
                        // A native ad failed to load, check if the ad loader has finished loading
                        // and if so, insert the ads into the list.
                        Log.e("MainActivity", "The previous native ad failed to load. Attempting to"
                                + " load another.");
                        if (!adLoader.isLoading()) {
                            insertAdsInMenuItems();
                        }
                    }
                }).build();

        // Load the Native ads.
        adLoader.loadAds(new AdRequest.Builder().build(), NUMBER_OF_ADS);
    }
    private void loadMenu() {
        // Create new fragment and transaction
        Fragment newFragment = new RecyclerViewFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack
        transaction.replace(R.id.fragment_container, newFragment);
        transaction.addToBackStack(null);

        // Commit the transaction
        transaction.commit();
    }
    private  void addMenuItemsFromJson()
    {
        mRecyclerViewItems.add(new StateBriefData("mounika",""));
        mRecyclerViewItems.add(new StateBriefData("mounika",""));
        mRecyclerViewItems.add(new StateBriefData("mounika",""));
        mRecyclerViewItems.add(new StateBriefData("mounika",""));
        mRecyclerViewItems.add(new StateBriefData("mounika",""));
        mRecyclerViewItems.add(new StateBriefData("mounika",""));
        mRecyclerViewItems.add(new StateBriefData("mounika",""));
        mRecyclerViewItems.add(new StateBriefData("mounika",""));
        mRecyclerViewItems.add(new StateBriefData("mounika",""));
        mRecyclerViewItems.add(new StateBriefData("mounika",""));
        mRecyclerViewItems.add(new StateBriefData("mounika",""));
        mRecyclerViewItems.add(new StateBriefData("mounika",""));
        mRecyclerViewItems.add(new StateBriefData("mounika",""));
        mRecyclerViewItems.add(new StateBriefData("mounika",""));
        mRecyclerViewItems.add(new StateBriefData("mounika",""));
        mRecyclerViewItems.add(new StateBriefData("mounika",""));
        mRecyclerViewItems.add(new StateBriefData("mounika",""));
        mRecyclerViewItems.add(new StateBriefData("mounika",""));
        mRecyclerViewItems.add(new StateBriefData("mounika",""));
        mRecyclerViewItems.add(new StateBriefData("mounika",""));
        mRecyclerViewItems.add(new StateBriefData("mounika",""));
        mRecyclerViewItems.add(new StateBriefData("mounika",""));
        mRecyclerViewItems.add(new StateBriefData("mounika",""));
        mRecyclerViewItems.add(new StateBriefData("mounika",""));
        mRecyclerViewItems.add(new StateBriefData("mounika",""));
        mRecyclerViewItems.add(new StateBriefData("mounika",""));
        mRecyclerViewItems.add(new StateBriefData("mounika",""));
        mRecyclerViewItems.add(new StateBriefData("mounika",""));
        mRecyclerViewItems.add(new StateBriefData("mounika",""));
        mRecyclerViewItems.add(new StateBriefData("mounika",""));
        mRecyclerViewItems.add(new StateBriefData("mounika",""));
        mRecyclerViewItems.add(new StateBriefData("mounika",""));
        mRecyclerViewItems.add(new StateBriefData("mounika",""));
        mRecyclerViewItems.add(new StateBriefData("mounika",""));
        mRecyclerViewItems.add(new StateBriefData("mounika",""));
    }


}
