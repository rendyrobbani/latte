package com.rendyrobbani.common.classification.kegiatan;

import com.rendyrobbani.common.classification.ClassificationImpl;
import com.rendyrobbani.common.classification.fungsi.SubfungsiClassification;
import com.rendyrobbani.common.classification.fungsi.SubfungsiClassificationFactory;
import com.rendyrobbani.common.util.regex.RegexUtil;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class SubkegiatanClassificationFactory {

	@Getter
	private static final class SubkegiatanClassificationImpl extends ClassificationImpl implements SubkegiatanClassification {

		private final String fungsiCode;

		private final String subfungsiCode;

		public SubkegiatanClassificationImpl(List<String> codes, SubfungsiClassification subfungsiClassification) {
			super(codes);
			this.fungsiCode = subfungsiClassification.getFungsiCode();
			this.subfungsiCode = subfungsiClassification.getSubfungsiCode();
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

		@Override
		public String getKegiatanCode() {
			return this.getCode(3);
		}

		@Override
		public String getSubkegiatanCode() {
			return this.getCode(4);
		}

	}

	public static Optional<SubkegiatanClassification> classify(String code) {
		if (code == null) return Optional.empty();
		var codes = RegexUtil.matches(code, SubkegiatanClassification.REGEX);
		if (codes == null) return Optional.empty();
		return Optional.of(new SubkegiatanClassificationImpl(codes, SubfungsiClassificationFactory.classifyFromKegiatanCode(code).orElseThrow()));
	}

}