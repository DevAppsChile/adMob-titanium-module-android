package modulo.android;

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.titanium.TiContext.OnLifecycleEvent;
import org.appcelerator.titanium.proxy.TiViewProxy;
import org.appcelerator.titanium.view.TiUIView;

import android.app.Activity;
import android.util.Log;

@Kroll.proxy(creatableInModule = ModModule.class, propertyAccessors = {"adUnitId"})
public class IntersticialProxy extends TiViewProxy implements OnLifecycleEvent {
	
	private static final String TAG = "IntersticialProxy";
	private IntersticialProperties intersticialProperties;
	private TiUIView view;

	public IntersticialProxy() {
		super();
		intersticialProperties = new IntersticialProperties();
	}

	@Override
	public TiUIView createView(Activity activity) {
		view = new IntersticialView(this, intersticialProperties);
		return view;
	}

	@Override
	public void handleCreationDict(KrollDict options) {
		super.handleCreationDict(options);
		if (options.containsKey("adUnitId")) {
			intersticialProperties.setAdUnitId((String) options.get("adUnitId"));
		}
	}

	@Kroll.method
	public void showIntersticial() {
		if(view != null)
			((IntersticialView) view).showIntersticial();
	}
	
	@Override
	public void onDestroy(Activity arg0) {
		Log.d(TAG, "CALL ==>> onDestroy()");
		
	}

	@Override
	public void onPause(Activity arg0) {
		Log.d(TAG, "CALL ==>> onPause()");
		
	}

	@Override
	public void onResume(Activity arg0) {
		Log.d(TAG, "CALL ==>> onResume()");
		
	}

	@Override
	public void onStart(Activity arg0) {
		Log.d(TAG, "CALL ==>> onStart()");
		
	}

	@Override
	public void onStop(Activity arg0) {
		Log.d(TAG, "CALL ==>> onStop()");
		
	}
}
