package com.rendyrobbani.latte.domain.model.valueobject.classification.fungsi;

import com.rendyrobbani.latte.common.util.regex.RegexUtil;
import com.rendyrobbani.latte.domain.model.valueobject.classification.ClassificationImpl;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class FungsiClassificationFactory {

	private static final class FungsiClassificationImpl extends ClassificationImpl implements FungsiClassification {

		public FungsiClassificationImpl(List<String> codes) {
			super(codes);
		}

		@Override
		public String getFungsiCode() {
			return this.getCode(0);
		}

	}

	public static Optional<FungsiClassification> classify(String code) {
		if (code == null) return Optional.empty();
		var codes = RegexUtil.matches(code, FungsiClassification.REGEX);
		if (codes == null) return Optional.empty();
		return Optional.of(new FungsiClassificationImpl(codes));
	}

}