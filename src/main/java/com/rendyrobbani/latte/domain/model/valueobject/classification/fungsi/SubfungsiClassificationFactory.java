package com.rendyrobbani.latte.domain.model.valueobject.classification.fungsi;

import com.rendyrobbani.latte.common.util.regex.RegexUtil;
import com.rendyrobbani.latte.domain.model.valueobject.classification.ClassificationImpl;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class SubfungsiClassificationFactory {

	private static final class SubfungsiClassificationImpl extends ClassificationImpl implements SubfungsiClassification {

		public SubfungsiClassificationImpl(List<String> codes) {
			super(codes);
		}

		@Override
		public String getFungsiCode() {
			return this.getCode(0);
		}

		@Override
		public String getSubfungsiCode() {
			return this.getCode(1);
		}

	}

	public static Optional<SubfungsiClassification> classify(String code) {
		if (code == null) return Optional.empty();
		var codes = RegexUtil.matches(code, SubfungsiClassification.REGEX);
		if (codes == null) return Optional.empty();
		return Optional.of(new SubfungsiClassificationImpl(codes));
	}

}