package modulo.android;

import org.appcelerator.titanium.proxy.TiViewProxy;
import org.appcelerator.titanium.view.TiUIView;

import android.util.Log;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class IntersticialView extends TiUIView {
	private InterstitialAd interstitialAd;
	private static final String TAG = "IntersticialView";
	
	public IntersticialView(TiViewProxy proxy, IntersticialProperties intersticialProperties) {
		super(proxy);
		AdRequest adRequest = new AdRequest.Builder().build();
		
		interstitialAd = new InterstitialAd(proxy.getActivity());
	    interstitialAd.setAdUnitId(intersticialProperties.getAdUnitId());
	    interstitialAd.loadAd(adRequest);
	    
	    interstitialAd.setAdListener(new AdListener() {
	    	@Override
	    	public void onAdLoaded() {
	    		Log.d(TAG, "Interstitial loaded.");
	    		super.onAdLoaded();
	    	}
	    	
	    	@Override
	    	public void onAdFailedToLoad(int errorCode) {
	    		Log.d(TAG, "Interstitial loaded has failed.");
	    		super.onAdFailedToLoad(errorCode);
	    	}
	    	
		});
	    
	}

	public void showIntersticial() {
		proxy.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				if (interstitialAd.isLoaded()) {
					Log.d(TAG, "Interstitial displayed now.");
					interstitialAd.show();
				} else {
					Log.d(TAG, "Interstitial ad was not ready to be shown.");
				}
			}
		});
	}
}
