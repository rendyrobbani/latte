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
public final class KegiatanClassificationFactory {

	@Getter
	private static final class KegiatanClassificationImpl extends ClassificationImpl implements KegiatanClassification {

		private final String fungsiCode;

		private final String subfungsiCode;

		public KegiatanClassificationImpl(List<String> codes, SubfungsiClassification subfungsiClassification) {
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

	}

	public static Optional<KegiatanClassification> classify(String code) {
		if (code == null) return Optional.empty();
		var codes = RegexUtil.matches(code, KegiatanClassification.REGEX);
		if (codes == null) return Optional.empty();
		return Optional.of(new KegiatanClassificationImpl(codes, SubfungsiClassificationFactory.classifyFromKegiatanCode(code).orElseThrow()));
	}

}