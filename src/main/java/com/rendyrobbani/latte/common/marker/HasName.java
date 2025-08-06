package com.rendyrobbani.latte.common.marker;

public interface HasName {

	String getName();

	default String getName(boolean uppercase) {
		if (this.getName() == null) return null;
		if (uppercase) return this.getName().toUpperCase();
		return this.getName();
	}

}