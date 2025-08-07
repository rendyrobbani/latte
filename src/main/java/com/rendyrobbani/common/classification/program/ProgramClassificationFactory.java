package com.rendyrobbani.common.classification.program;

import com.rendyrobbani.common.classification.ClassificationImpl;
import com.rendyrobbani.common.util.regex.RegexUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ProgramClassificationFactory {

	private static final class ProgramClassificationImpl extends ClassificationImpl implements ProgramClassification {

		public ProgramClassificationImpl(List<String> codes) {
			super(codes);
		}

		@Override
		public String getUrusanCode() {
			return this.getCode(0);
		}

		@Override
		public String getBidangCode() {
			return this.getCode(1);
		}

		@Override
		public String getProgramCode() {
			return this.getCode(2);
		}

	}

	public static Optional<ProgramClassification> classify(String code) {
		if (code == null) return Optional.empty();
		var codes = RegexUtil.matches(code, ProgramClassification.REGEX);
		if (codes == null) return Optional.empty();
		return Optional.of(new ProgramClassificationImpl(codes));
	}

}