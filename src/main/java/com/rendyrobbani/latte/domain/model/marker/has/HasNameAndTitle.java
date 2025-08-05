package com.rendyrobbani.latte.domain.model.marker.has;

import java.util.ArrayList;

public interface HasNameAndTitle {

	String getTitlePrefix();

	String getTitleSuffix();

	String getName();

	default String getName(boolean uppercase, boolean nullable) {
		if (this.getName() == null && nullable) return null;
		if (this.getName() == null) return "";
		if (uppercase) return this.getName().toUpperCase().replace("HJ.", "Hj.");
		return this.getName();
	}

	default String getName(boolean uppercase) {
		return this.getName(uppercase, true);
	}

	default String getFullName(boolean uppercase, boolean nullable) {
		if (this.getName() == null && nullable) return null;
		if (this.getName() == null) return "";
		var fullName = new ArrayList<String>();
		if (this.getTitlePrefix() != null) fullName.add(this.getTitlePrefix() + " ");
		fullName.add(this.getName(uppercase));
		if (this.getTitleSuffix() != null) fullName.add(", " + this.getTitleSuffix());
		return String.join("", fullName);
	}

	default String getFullName(boolean uppercase) {
		return this.getFullName(uppercase, true);
	}

	default String getFullName() {
		return this.getFullName(false, true);
	}

}