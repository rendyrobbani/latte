package com.rendyrobbani.common.classification.urusan;

import com.rendyrobbani.common.classification.ClassificationImpl;
import com.rendyrobbani.common.util.regex.RegexUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class UrusanClassificationFactory {

	private static final class UrusanClassificationImpl extends ClassificationImpl implements UrusanClassification {

		public UrusanClassificationImpl(List<String> codes) {
			super(codes);
		}

		@Override
		public String getUrusanCode() {
			return this.getCode(0);
		}

	}

	public static Optional<UrusanClassification> classify(String code) {
		if (code == null) return Optional.empty();
		var codes = RegexUtil.matches(code, UrusanClassification.REGEX);
		if (codes == null) return Optional.empty();
		return Optional.of(new UrusanClassificationImpl(codes));
	}

}