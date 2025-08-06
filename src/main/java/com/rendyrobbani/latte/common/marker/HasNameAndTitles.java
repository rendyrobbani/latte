package com.rendyrobbani.latte.common.marker;

public interface HasNameAndTitles extends HasName {

	@Override
	default String getName(boolean uppercase) {
		if (this.getName() == null) return null;
		if (uppercase) return this.getName().toUpperCase().replace("HJ.", "Hj.");
		return this.getName();
	}

	String getTitlePrefix();

	String getTitleSuffix();

	default String getFullName(boolean uppercase) {
		if (this.getName() == null) return null;
		var fullName = this.getName(uppercase);
		if (this.getTitlePrefix() != null) fullName = this.getTitlePrefix() + " " + fullName;
		if (this.getTitleSuffix() != null) fullName = fullName + ", " + this.getTitleSuffix();
		return fullName;
	}

}