package com.rendyrobbani.common.classification.fungsi;

import com.rendyrobbani.common.classification.ClassificationImpl;
import com.rendyrobbani.common.util.regex.RegexUtil;
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

	public static Optional<SubfungsiClassification> classifyFromKegiatanCode(String code) {
		if (code == null) return Optional.empty();
		if (code.matches("^[X0-8]\\.[X0-9]{2}\\.00.*")) return classify("00.00");
		if (code.matches("^[X0-8]\\.[X0-9]{2}\\.01.*")) return classify("01.01");
		if (code.matches("^1\\.01\\.02\\.2\\.03.*")) return classify("10.01");
		if (code.matches("^1\\.01\\.02\\.2\\.01.*")) return classify("10.02");
		if (code.matches("^1\\.01\\.02\\.2\\.02.*")) return classify("10.02");
		if (code.matches("^1\\.01\\.02\\.2\\.04.*")) return classify("10.04");
		if (code.matches("^4\\.01\\.02.*")) return classify("01.01");
		if (code.matches("^4\\.01\\.03.*")) return classify("01.01");
		if (code.matches("^4\\.01\\.04.*")) return classify("01.01");
		if (code.matches("^4\\.02\\.02.*")) return classify("01.01");
		if (code.matches("^5\\.02\\.02.*")) return classify("01.01");
		if (code.matches("^5\\.02\\.03.*")) return classify("01.01");
		if (code.matches("^5\\.02\\.04.*")) return classify("01.01");
		if (code.matches("^8\\.01\\.02.*")) return classify("01.01");
		if (code.matches("^8\\.01\\.03.*")) return classify("01.01");
		if (code.matches("^8\\.01\\.04.*")) return classify("01.01");
		if (code.matches("^8\\.01\\.05.*")) return classify("01.01");
		if (code.matches("^8\\.01\\.06.*")) return classify("01.01");
		if (code.matches("^2\\.12\\.02.*")) return classify("01.03");
		if (code.matches("^2\\.12\\.03.*")) return classify("01.03");
		if (code.matches("^2\\.12\\.04.*")) return classify("01.03");
		if (code.matches("^2\\.12\\.05.*")) return classify("01.03");
		if (code.matches("^2\\.20\\.02.*")) return classify("01.03");
		if (code.matches("^5\\.01\\.02.*")) return classify("01.03");
		if (code.matches("^5\\.01\\.03.*")) return classify("01.03");
		if (code.matches("^5\\.03\\.02.*")) return classify("01.03");
		if (code.matches("^5\\.05\\.02.*")) return classify("01.04");
		if (code.matches("^5\\.05\\.03.*")) return classify("01.04");
		if (code.matches("^2\\.13\\.02.*")) return classify("01.06");
		if (code.matches("^2\\.13\\.03.*")) return classify("01.06");
		if (code.matches("^2\\.13\\.04.*")) return classify("01.06");
		if (code.matches("^2\\.13\\.05.*")) return classify("01.06");
		if (code.matches("^7\\.01\\.02.*")) return classify("01.06");
		if (code.matches("^7\\.01\\.03.*")) return classify("01.06");
		if (code.matches("^7\\.01\\.04.*")) return classify("01.06");
		if (code.matches("^7\\.01\\.05.*")) return classify("01.06");
		if (code.matches("^7\\.01\\.06.*")) return classify("01.06");
		if (code.matches("^2\\.24\\.02.*")) return classify("01.90");
		if (code.matches("^2\\.24\\.03.*")) return classify("01.90");
		if (code.matches("^2\\.24\\.04.*")) return classify("01.90");
		if (code.matches("^5\\.04\\.02.*")) return classify("01.90");
		if (code.matches("^5\\.06\\.02.*")) return classify("01.90");
		if (code.matches("^6\\.01\\.02.*")) return classify("01.90");
		if (code.matches("^6\\.01\\.03.*")) return classify("01.90");
		if (code.matches("^9\\.01\\.02.*")) return classify("01.90");
		if (code.matches("^9\\.01\\.03.*")) return classify("01.90");
		if (code.matches("^9\\.01\\.04.*")) return classify("01.90");
		if (code.matches("^1\\.05\\.03.*")) return classify("03.02");
		if (code.matches("^1\\.05\\.04.*")) return classify("03.02");
		if (code.matches("^1\\.06\\.06.*")) return classify("03.02");
		if (code.matches("^1\\.05\\.02.*")) return classify("03.03");
		if (code.matches("^2\\.17\\.02.*")) return classify("04.01");
		if (code.matches("^2\\.17\\.03.*")) return classify("04.01");
		if (code.matches("^2\\.17\\.04.*")) return classify("04.01");
		if (code.matches("^2\\.17\\.05.*")) return classify("04.01");
		if (code.matches("^2\\.17\\.06.*")) return classify("04.01");
		if (code.matches("^2\\.17\\.07.*")) return classify("04.01");
		if (code.matches("^2\\.17\\.08.*")) return classify("04.01");
		if (code.matches("^3\\.30\\.02.*")) return classify("04.01");
		if (code.matches("^3\\.30\\.03.*")) return classify("04.01");
		if (code.matches("^3\\.30\\.04.*")) return classify("04.01");
		if (code.matches("^3\\.30\\.05.*")) return classify("04.01");
		if (code.matches("^3\\.30\\.06.*")) return classify("04.01");
		if (code.matches("^3\\.30\\.07.*")) return classify("04.01");
		if (code.matches("^2\\.07\\.02.*")) return classify("04.02");
		if (code.matches("^2\\.07\\.03.*")) return classify("04.02");
		if (code.matches("^2\\.07\\.04.*")) return classify("04.02");
		if (code.matches("^2\\.07\\.05.*")) return classify("04.02");
		if (code.matches("^3\\.25\\.03.*")) return classify("04.03");
		if (code.matches("^3\\.25\\.04.*")) return classify("04.03");
		if (code.matches("^3\\.25\\.05.*")) return classify("04.03");
		if (code.matches("^3\\.25\\.06.*")) return classify("04.03");
		if (code.matches("^3\\.27\\.02.*")) return classify("04.03");
		if (code.matches("^3\\.27\\.03.*")) return classify("04.03");
		if (code.matches("^3\\.27\\.04.*")) return classify("04.03");
		if (code.matches("^3\\.27\\.05.*")) return classify("04.03");
		if (code.matches("^3\\.27\\.06.*")) return classify("04.03");
		if (code.matches("^3\\.27\\.07.*")) return classify("04.03");
		if (code.matches("^1\\.03\\.02.*")) return classify("04.04");
		if (code.matches("^1\\.03\\.06.*")) return classify("04.04");
		if (code.matches("^3\\.29\\.05.*")) return classify("04.05");
		if (code.matches("^1\\.03\\.08.*")) return classify("04.07");
		if (code.matches("^1\\.03\\.09.*")) return classify("04.07");
		if (code.matches("^1\\.03\\.11.*")) return classify("04.07");
		if (code.matches("^3\\.31\\.02.*")) return classify("04.07");
		if (code.matches("^3\\.31\\.03.*")) return classify("04.07");
		if (code.matches("^3\\.31\\.04.*")) return classify("04.07");
		if (code.matches("^1\\.03\\.10.*")) return classify("04.08");
		if (code.matches("^2\\.15\\.02.*")) return classify("04.08");
		if (code.matches("^2\\.15\\.03.*")) return classify("04.08");
		if (code.matches("^2\\.15\\.04.*")) return classify("04.08");
		if (code.matches("^2\\.15\\.05.*")) return classify("04.08");
		if (code.matches("^2\\.16\\.02.*")) return classify("04.09");
		if (code.matches("^2\\.16\\.03.*")) return classify("04.09");
		if (code.matches("^2\\.21\\.02.*")) return classify("04.09");
		if (code.matches("^2\\.09\\.02.*")) return classify("04.03");
		if (code.matches("^2\\.09\\.03.*")) return classify("04.03");
		if (code.matches("^2\\.09\\.04.*")) return classify("04.03");
		if (code.matches("^2\\.09\\.05.*")) return classify("04.03");
		if (code.matches("^2\\.18\\.02.*")) return classify("04.90");
		if (code.matches("^2\\.18\\.03.*")) return classify("04.90");
		if (code.matches("^2\\.18\\.04.*")) return classify("04.90");
		if (code.matches("^2\\.18\\.05.*")) return classify("04.90");
		if (code.matches("^2\\.18\\.06.*")) return classify("04.90");
		if (code.matches("^1\\.03\\.04.*")) return classify("05.01");
		if (code.matches("^2\\.11\\.02.*")) return classify("05.01");
		if (code.matches("^2\\.11\\.04.*")) return classify("05.01");
		if (code.matches("^2\\.11\\.08.*")) return classify("05.01");
		if (code.matches("^2\\.11\\.09.*")) return classify("05.01");
		if (code.matches("^2\\.11\\.10.*")) return classify("05.01");
		if (code.matches("^2\\.11\\.11.*")) return classify("05.01");
		if (code.matches("^1\\.03\\.05.*")) return classify("05.02");
		if (code.matches("^2\\.11\\.05.*")) return classify("05.02");
		if (code.matches("^2\\.11\\.03.*")) return classify("05.03");
		if (code.matches("^2\\.11\\.06.*")) return classify("05.03");
		if (code.matches("^2\\.11\\.07.*")) return classify("05.03");
		if (code.matches("^3\\.28\\.04.*")) return classify("05.04");
		if (code.matches("^1\\.03\\.12.*")) return classify("05.05");
		if (code.matches("^1\\.03\\.13.*")) return classify("05.05");
		if (code.matches("^2\\.10\\.02.*")) return classify("05.05");
		if (code.matches("^2\\.10\\.03.*")) return classify("05.05");
		if (code.matches("^2\\.10\\.04.*")) return classify("05.05");
		if (code.matches("^2\\.10\\.05.*")) return classify("05.05");
		if (code.matches("^2\\.10\\.06.*")) return classify("05.05");
		if (code.matches("^2\\.10\\.07.*")) return classify("05.05");
		if (code.matches("^2\\.10\\.08.*")) return classify("05.05");
		if (code.matches("^2\\.10\\.09.*")) return classify("05.05");
		if (code.matches("^2\\.10\\.10.*")) return classify("05.05");
		if (code.matches("^2\\.10\\.11.*")) return classify("05.05");
		if (code.matches("^2\\.10\\.12.*")) return classify("05.05");
		if (code.matches("^2\\.10\\.13.*")) return classify("05.05");
		if (code.matches("^2\\.10\\.14.*")) return classify("05.05");
		if (code.matches("^2\\.10\\.15.*")) return classify("05.05");
		if (code.matches("^2\\.10\\.16.*")) return classify("05.05");
		if (code.matches("^2\\.10\\.17.*")) return classify("05.05");
		if (code.matches("^1\\.03\\.07.*")) return classify("06.01");
		if (code.matches("^1\\.04\\.02.*")) return classify("06.01");
		if (code.matches("^1\\.04\\.03.*")) return classify("06.01");
		if (code.matches("^1\\.04\\.04.*")) return classify("06.01");
		if (code.matches("^1\\.04\\.05.*")) return classify("06.02");
		if (code.matches("^1\\.04\\.06.*")) return classify("06.02");
		if (code.matches("^1\\.03\\.03.*")) return classify("06.03");
		if (code.matches("^1\\.02\\.04.*")) return classify("07.01");
		if (code.matches("^1\\.02\\.02.*")) return classify("07.02");
		if (code.matches("^1\\.02\\.05.*")) return classify("07.03");
		if (code.matches("^2\\.14\\.02.*")) return classify("07.04");
		if (code.matches("^2\\.14\\.03.*")) return classify("07.04");
		if (code.matches("^2\\.14\\.04.*")) return classify("07.04");
		if (code.matches("^1\\.02\\.03.*")) return classify("07.90");
		if (code.matches("^3\\.26\\.02.*")) return classify("08.01");
		if (code.matches("^3\\.26\\.03.*")) return classify("08.01");
		if (code.matches("^3\\.26\\.04.*")) return classify("08.01");
		if (code.matches("^3\\.26\\.05.*")) return classify("08.01");
		if (code.matches("^2\\.23\\.02.*")) return classify("10.04");
		if (code.matches("^2\\.23\\.03.*")) return classify("10.04");
		if (code.matches("^2\\.19\\.02.*")) return classify("10.10");
		if (code.matches("^2\\.19\\.03.*")) return classify("10.10");
		if (code.matches("^2\\.19\\.04.*")) return classify("10.10");
		if (code.matches("^2\\.22\\.02.*")) return classify("10.11");
		if (code.matches("^2\\.22\\.03.*")) return classify("10.11");
		if (code.matches("^2\\.22\\.04.*")) return classify("10.11");
		if (code.matches("^2\\.22\\.05.*")) return classify("10.11");
		if (code.matches("^2\\.22\\.06.*")) return classify("10.11");
		if (code.matches("^2\\.22\\.07.*")) return classify("10.11");
		if (code.matches("^2\\.22\\.08.*")) return classify("10.11");
		if (code.matches("^1\\.01\\.03.*")) return classify("10.90");
		if (code.matches("^1\\.01\\.04.*")) return classify("10.90");
		if (code.matches("^1\\.01\\.05.*")) return classify("10.90");
		if (code.matches("^1\\.01\\.06.*")) return classify("10.90");
		if (code.matches("^1\\.01\\.07.*")) return classify("10.90");
		if (code.matches("^1\\.01\\.08.*")) return classify("10.90");
		if (code.matches("^1\\.06\\.04.*")) return classify("11.01");
		if (code.matches("^1\\.06\\.02.*")) return classify("11.02");
		if (code.matches("^1\\.06\\.05.*")) return classify("11.04");
		if (code.matches("^2\\.08\\.02.*")) return classify("11.05");
		if (code.matches("^2\\.08\\.03.*")) return classify("11.05");
		if (code.matches("^2\\.08\\.04.*")) return classify("11.05");
		if (code.matches("^2\\.08\\.05.*")) return classify("11.05");
		if (code.matches("^2\\.08\\.06.*")) return classify("11.05");
		if (code.matches("^2\\.08\\.07.*")) return classify("11.05");
		if (code.matches("^1\\.06\\.03.*")) return classify("11.08");
		if (code.matches("^1\\.06\\.07.*")) return classify("11.90");
		if (code.matches("^3\\.32\\.02.*")) return classify("11.90");
		if (code.matches("^3\\.32\\.03.*")) return classify("11.90");
		if (code.matches("^3\\.32\\.04.*")) return classify("11.90");
		return Optional.empty();
	}

}