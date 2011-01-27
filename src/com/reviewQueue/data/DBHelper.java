package com.reviewQueue.data;

import android.content.Context;

public class DBHelper {
	public static String getDbFilePathFromContext(Context ctx) {
		return ctx.getDir("data", 0) + "/" + "android.db4o";
	}


}



