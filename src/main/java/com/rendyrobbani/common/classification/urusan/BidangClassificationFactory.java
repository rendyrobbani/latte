package com.rendyrobbani.common.classification.urusan;

import com.rendyrobbani.common.classification.ClassificationImpl;
import com.rendyrobbani.common.util.regex.RegexUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class BidangClassificationFactory {

	private static final class BidangClassificationImpl extends ClassificationImpl implements BidangClassification {

		public BidangClassificationImpl(List<String> codes) {
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

	}

	public static Optional<BidangClassification> classify(String code) {
		if (code == null) return Optional.empty();
		var codes = RegexUtil.matches(code, BidangClassification.REGEX);
		if (codes == null) return Optional.empty();
		return Optional.of(new BidangClassificationImpl(codes));
	}

}