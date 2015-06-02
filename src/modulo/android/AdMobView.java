package modulo.android;

import org.appcelerator.titanium.proxy.TiViewProxy;
import org.appcelerator.titanium.view.TiUIView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

public class AdMobView extends TiUIView {
	private AdView adView;
	
	public AdMobView(TiViewProxy proxy, AdMobProperties adModProperties) {
		super(proxy);

		AdRequest adRequest = new AdRequest.Builder().build();
		
		adView = new AdView(proxy.getActivity());
		adView.setAdSize(AdSize.SMART_BANNER);
		adView.setAdUnitId(adModProperties.getAdUnitId());
		adView.loadAd(adRequest);
		
		setNativeView(adView);
	}

	public void onPause() {
		adView.pause();
	}

	public void onResume() {
		adView.resume();
	}

	public void onDestroy() {
		adView.destroy();
	}
}
