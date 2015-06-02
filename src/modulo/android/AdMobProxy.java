package modulo.android;

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.titanium.TiBaseActivity;
import org.appcelerator.titanium.TiLifecycle.OnLifecycleEvent;
import org.appcelerator.titanium.proxy.TiViewProxy;
import org.appcelerator.titanium.view.TiUIView;

import android.app.Activity;
import android.util.Log;

@Kroll.proxy(creatableInModule = ModModule.class, propertyAccessors = {"adUnitId"})
public class AdMobProxy extends TiViewProxy implements OnLifecycleEvent {
	
	private static final String TAG = "AdMobProxy";
	private AdMobProperties adModProperties;
	private TiUIView view;

	public AdMobProxy() {
		super();
		adModProperties = new AdMobProperties();
	}
	
	@Override
	public TiUIView createView(Activity activity) {
		view = new AdMobView(this, adModProperties);
		return view;
	}

	@Override
	public void handleCreationDict(KrollDict options) {
		super.handleCreationDict(options);
		if (options.containsKey("adUnitId")) {
			adModProperties.setAdUnitId((String) options.get("adUnitId"));
		}
	}
	
	@Override
	public void setActivity(Activity activity)
	{
		Log.d(TAG, "CALL ==>> setActivity(Activity activity)");
		super.setActivity(activity);
		if (activity instanceof TiBaseActivity) {
			((TiBaseActivity) activity).addOnLifecycleEventListener(this);
		}
	}

	@Override
	public void onDestroy(Activity activity) {
		Log.d(TAG, "CALL ==>> onDestroy()");
		if(view != null) {
			((AdMobView) view).onDestroy();
		}
	}

	@Override
	public void onPause(Activity activity) {
		Log.d(TAG, "CALL ==>> onPause()");
		if(view != null) {
			((AdMobView) view).onPause();
		}
	}

	@Override
	public void onResume(Activity activity) {
		Log.d(TAG, "CALL ==>> onResume()");
		if(view != null) {
			((AdMobView) view).onResume();
		}
	}

	@Override
	public void onStart(Activity activity) {
		Log.d(TAG, "CALL ==>> onStart()");
	}

	@Override
	public void onStop(Activity activity) {
		Log.d(TAG, "CALL ==>> onStop()");
	}
}
