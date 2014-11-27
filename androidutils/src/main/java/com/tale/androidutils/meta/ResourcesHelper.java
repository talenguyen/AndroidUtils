package com.tale.androidutils.meta;

import android.app.Application;
import android.content.res.Resources;


/**
 * Created by TALE on 9/25/2014.
 */
public class ResourcesHelper {
    private final Application application;
    private final Resources resources;
    private final float density;

    public ResourcesHelper(Application application) {
        this.application = application;
        resources = application.getResources();
        density = resources.getDisplayMetrics().density;
    }

    /**
     * Get color from resource.
     *
     * @param resId resource's id. <i><u>NOTE:</u></i> It should in form <b>R.color.[value]</b>
     * @return color value in resource <i>.xml</i> file.
     */
    public int getColor(int resId) {
        return resources.getColor(resId);
    }

    /**
     * Get string from resource.
     *
     * @param resId resource's id. <i><u>NOTE:</u></i> It should in form <b>R.string.[value]</b>
     * @return string value in resource <i>.xml</i> file.
     */
    public String getString(int resId) {
        return resources.getString(resId);
    }

    /**
     * Get dimen value programming from resource. Ex. in dimens.xml you declare <dimen name="value">16dp</dimen> this will return 16.
     *
     * @param resId resource's id. <i><u>NOTE:</u></i> It should in form <b>R.dimen.[value]</b>
     * @return dimen value in resource <i>.xml</i> file.
     */
    public int getDimenValue(int resId) {
        return (int) (resources.getDimension(resId) / density);
    }

}
